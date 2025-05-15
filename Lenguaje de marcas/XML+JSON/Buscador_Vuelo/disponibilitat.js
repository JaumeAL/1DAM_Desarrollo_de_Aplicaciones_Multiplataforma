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

  // Validació bàsica
  if (!origen || !desti || !adults || !infants || !dataInici || !dataFi) {
    alert("Tots els camps són obligatoris.");
    return;
  }

  // Crear XML amb DOMParser
  const xmlString = `
  <disponibilitat>
    <origen>${origen}</origen>
    <desti>${desti}</desti>
    <adults>${adults}</adults>
    <infants>${infants}</infants>
    <dataInici>${dataInici}</dataInici>
    <dataFi>${dataFi}</dataFi>
  </disponibilitat>
  `.trim();

  const parser = new DOMParser();
  disponibilitatXML = parser.parseFromString(xmlString, "application/xml");

  // Mostrar XML
  document.getElementById("disponibilitat").textContent = formatXML(xmlString);

  // Llegir hotels.xml i filtrar per destí
  fetch("hotels.xml")
    .then(res => res.text())
    .then(xmlText => {
      const xml = parser.parseFromString(xmlText, "application/xml");
      const hotels = xml.getElementsByTagName("hotel");
      let resultats = "";

      for (let hotel of hotels) {
        let hotelDesti = hotel.getElementsByTagName("desti")[0].textContent;
        if (hotelDesti === desti) {
          let nom = hotel.getElementsByTagName("nom")[0].textContent;
          let preu = hotel.getElementsByTagName("preu")[0].textContent;
          resultats += `Nom: ${nom}, Preu: ${preu}€\n`;
        }
      }

      document.getElementById("resultatsHotels").textContent = resultats || "No s'han trobat hotels.";
    });

  // Llegir vols.json i filtrar per origen i destí
  fetch("vols.json")
    .then(res => res.json())
    .then(vols => {
      let resultats = vols.filter(v => v.origen === origen && v.desti === desti);
      let text = resultats.map(v => `Origen: ${v.origen}, Destí: ${v.desti}, Preu: ${v.preu}€`).join("\n");
      document.getElementById("resultatsVols").textContent = text || "No s'han trobat vols.";
    });
}

function convertir() {
  const output = document.getElementById("conversio");

  if (!disponibilitatXML) {
    output.textContent = "No hi ha cap disponibilitat.xml creat...";
    return;
  }

  if (!jsonConvertit) {
    // Convertim de XML a JSON
    const root = disponibilitatXML.documentElement;
    const obj = {};
    for (let i = 0; i < root.children.length; i++) {
      const etiqueta = root.children[i].tagName;
      const valor = root.children[i].textContent;
      obj[etiqueta] = valor;
    }
    jsonConvertit = obj;
    output.textContent = JSON.stringify(obj, null, 2);
  } else {
    // Convertim de JSON a XML
    let xml = "<disponibilitat>\n";
    for (let clau in jsonConvertit) {
      xml += `  <${clau}>${jsonConvertit[clau]}</${clau}>\n`;
    }
    xml += "</disponibilitat>";
    output.textContent = formatXML(xml);
    jsonConvertit = null;
  }
}

function formatXML(xmlStr) {
  const CON = "  ";
  const reg = /(>)(<)(\/*)/g;
  let sin = "";
  let pad = 0;

  xmlStr = xmlStr.replace(reg, "$1\r\n$2$3");
  xmlStr.split("\r\n").forEach(node => {
    let indent = 0;
    if (node.match(/^<\/\w/)) pad -= 1;
    indent = CON.repeat(pad);
    sin += indent + node + "\r\n";
    if (node.match(/^<\w[^>]*[^/]>/)) pad += 1;
  });

  return sin.trim();
}