var disponibilitatXML = null;
var jsonConvertit = null;

function reset() {
  document.getElementById("disponibilitat").textContent = "";
  document.getElementById("resultatsHotels").textContent = "";
  document.getElementById("resultatsVols").textContent = "";
  document.getElementById("conversio").textContent = "";
  disponibilitatXML = null;
  jsonConvertit = null;
}

function cercarDisponibilitat() {
  reset();

  const origen = document.getElementById("origen").value;
  const desti = document.getElementById("desti").value;
  const adults = document.getElementById("adults").value;
  const infants = document.getElementById("infants").value;
  const dataInici = document.getElementById("dataInici").value;
  const dataFi = document.getElementById("dataFi").value;

  // Validacions
  if (!origen || !desti || !adults || !infants || !dataInici || !dataFi) {
    alert("Tots els camps són obligatoris");
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
  document.getElementById("disponibilitat").textContent = xmlString;

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

  // Llegir vols.json i filtrar per origen i destino
  fetch("vols.json")
    .then(res => res.json())
    .then(vols => {
      let resultats = vols.filter(v => v.origen === origen && v.desti === desti);
      let text = resultats.map(v => `Origen: ${v.origen}, Destí: ${v.desti}, Preu: ${v.preu}€`).join("\n");
      document.getElementById("resultatsVols").textContent = text || "No s'han trobat vols.";
    });
}

function convertir() {
  const conversio = document.getElementById("conversio");

  if (!disponibilitatXML) {
    conversio.textContent = "No hi ha cap disponibilitat.xml creat...";
    return;
  }

  if (!jsonConvertit) {
    // XML a JSON
    const root = disponibilitatXML.documentElement;
    const obj = {};
    for (let i = 0; i < root.children.length; i++) {
      const etiqueta = root.children[i].tagName;
      const valor = root.children[i].textContent;
      obj[etiqueta] = valor;
    }
    jsonConvertit = obj;
    conversio.textContent = JSON.stringify(obj, null, 2);
  } else {
    // JSON a XML
    let xml = "<disponibilitat>\n";
    for (let clau in jsonConvertit) {
      xml += `  <${clau}>${jsonConvertit[clau]}</${clau}>\n`;
    }
    xml += "</disponibilitat>";
    conversio.textContent = xml;
    jsonConvertit = null;
  }
}