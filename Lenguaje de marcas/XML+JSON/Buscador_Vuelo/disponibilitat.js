var disponibilitatXML = null;
var jsonConvertit = null;

function netejarResultats() {
  document.getElementById("disponibilitat").textContent = "";
  document.getElementById("resultatsHotels").textContent = "";
  document.getElementById("resultatsVols").textContent = "";
  document.getElementById("conversio").textContent = "";
  disponibilitatXML = null;
  jsonConvertit = null;
}

function cercarDisponibilitat() {
  netejarResultats();

  const origen = document.getElementById("origen").value;
  const desti = document.getElementById("desti").value;
  const adults = document.getElementById("adults").value;
  const infants = document.getElementById("infants").value;
  const dataInici = document.getElementById("dataInici").value;
  const dataFi = document.getElementById("dataFi").value;

  // Camps obligatoris
  if (!origen || !desti || !adults || !infants || !dataInici || !dataFi) {
    alert("Tots els camps son obligatoris");
    return;
  }

  // XML
  const miParser = new DOMParser();
  const xmlString = `
    <disponibilitat>
      <origen>${origen}</origen>
      <desti>${desti}</desti>
      <adults>${adults}</adults>
      <infants>${infants}</infants>
      <dataInici>${dataInici}</dataInici>
      <dataFi>${dataFi}</dataFi>
    </disponibilitat>
  `;
  disponibilitatXML = miParser.parseFromString(xmlString, "application/xml");

  document.getElementById("disponibilitat").textContent = formatXML(xmlString);

  // Carregar i filtrar hotels.xml
  fetch("hotels.xml")
    .then(response => response.text())
    .then(str => {
      const xml = new window.DOMParser().parseFromString(str, "application/xml");
      const hotels = Array.from(xml.getElementsByTagName("hotel"));
      const resultats = hotels.filter(h => h.getElementsByTagName("desti")[0].textContent === desti);
      const text = resultats.map(hotel => {
        return `Nom: ${hotel.getElementsByTagName("nom")[0].textContent}, Preu: ${hotel.getElementsByTagName("preu")[0].textContent}`;
      }).join("\n");

      document.getElementById("resultatsHotels").textContent = text || "No s'han trobat hotels.";
    });

  // Carregar i filtrar vols.json
  fetch("vols.json")
    .then(response => response.json())
    .then(vols => {
      const resultats = vols.filter(v => v.origen === origen && v.desti === desti);
      const text = resultats.map(v => `Origen: ${v.origen}, Destí: ${v.desti}, Preu: ${v.preu}`).join("\n");
      document.getElementById("resultatsVols").textContent = text || "No s'han trobat vols.";
    });
}

function convertir() {
  const conversio = document.getElementById("conversio");

  if (!disponibilitatXML) {
    conversio.textContent = "No hi ha cap disponibilitat.xml creat...";
    return;
  }

  // Si no hem convertit a jsom:
  if (!jsonConvertit) {
    const obj = {};
    const root = disponibilitatXML.documentElement;
    Array.from(root.children).forEach(node => {
      obj[node.tagName] = node.textContent;
    });
    jsonConvertit = obj;
    conversio.textContent = JSON.stringify(jsonConvertit, null, 2);
  } else {
    // De JSON a XML
    var xml = "<disponibilitat>\n";
    for (const clau in jsonConvertit) {
      xml += `  <${clau}>${jsonConvertit[clau]}</${clau}>\n`;
    }
    xml += "</disponibilitat>";
    conversio.textContent = formatXML(xml);
    jsonConvertit = null;
  }
}

// Format XML amb indentacio
function formatXML(xmlStr) {
  const CON = "  ";
  const reg = /(>)(<)(\/*)/g;
  var sin = "";
  var pad = 0;

  xmlStr = xmlStr.replace(reg, "$1\r\n$2$3");
  xmlStr.split("\r\n").forEach(node => {
    var indent = 0;
    if (node.match(/^<\/\w/)) pad -= 1;
    indent = CON.repeat(pad);
    sin += indent + node + "\r\n";
    if (node.match(/^<\w[^>]*[^/]>/)) pad += 1;
  });

  return sin.trim();
}
