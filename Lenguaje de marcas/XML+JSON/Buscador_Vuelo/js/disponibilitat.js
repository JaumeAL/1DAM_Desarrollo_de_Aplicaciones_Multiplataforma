let disponibilitatXML = null; // Variable para almacenar el XML creado
let disponibilitatJSON = null; // Variable para almacenar el JSON convertido

function cercarDisponibilitat() {
    // Limpiar los campos de resultados
    document.getElementById("disponibilitat").textContent = "";
    document.getElementById("resultatsHotels").textContent = "";
    document.getElementById("resultatsVols").textContent = "";
    document.getElementById("conversio").textContent = "";

    // Recoger los valores de los campos
    const origen = document.getElementById("origen").value;
    const desti = document.getElementById("desti").value;
    const adults = document.getElementById("adults").value;
    const infants = document.getElementById("infants").value;
    const dataInici = document.getElementById("dataInici").value;
    const dataFi = document.getElementById("dataFi").value;

    // Comprobar que todos los campos son obligatorios
    if (!origen || !desti || !adults || !infants || !dataInici || !dataFi) {
        alert("Tots els camps són obligatoris.");
        return;
    }

    // Crear el XML con la información introducida
    disponibilitatXML = `
<disponibilitat>
    <origen>${origen}</origen>
    <desti>${desti}</desti>
    <adults>${adults}</adults>
    <infants>${infants}</infants>
    <dataInici>${dataInici}</dataInici>
    <dataFi>${dataFi}</dataFi>
</disponibilitat>`;

    // Mostrar el XML en el elemento con id "disponibilitat"
    document.getElementById("disponibilitat").textContent = disponibilitatXML;

    // Leer y buscar en hotels.xml
    fetch("hotels.xml")
        .then((response) => response.text())
        .then((data) => {
            const parser = new DOMParser();
            const xmlDoc = parser.parseFromString(data, "application/xml");
            const hotels = xmlDoc.getElementsByTagName("hotel");
            let resultatsHotels = "";

            for (let hotel of hotels) {
                const hotelDesti = hotel.getElementsByTagName("desti")[0].textContent;
                if (hotelDesti === desti) {
                    resultatsHotels += `
Hotel: ${hotel.getElementsByTagName("nom")[0].textContent}
Preu: ${hotel.getElementsByTagName("preu")[0].textContent}
---
`;
                }
            }

            document.getElementById("resultatsHotels").textContent = resultatsHotels || "No s'han trobat hotels.";
        });

    // Leer y buscar en vols.json
    fetch("vols.json")
        .then((response) => response.json())
        .then((data) => {
            let resultatsVols = "";

            for (let vol of data) {
                if (vol.origen === origen && vol.desti === desti) {
                    resultatsVols += `
Vol: Origen - ${vol.origen}, Destí - ${vol.desti}
Preu: ${vol.preu}
---
`;
                }
            }

            document.getElementById("resultatsVols").textContent = resultatsVols || "No s'han trobat vols.";
        });
}

function convertir() {
    const conversioElement = document.getElementById("conversio");

    // Comprobar si el XML existe
    if (!disponibilitatXML) {
        conversioElement.textContent = "No existeix cap arxiu disponibilitat.xml.";
        return;
    }

    // Convertir entre XML y JSON
    if (!disponibilitatJSON) {
        // Convertir XML a JSON
        const parser = new DOMParser();
        const xmlDoc = parser.parseFromString(disponibilitatXML, "application/xml");
        disponibilitatJSON = {
            origen: xmlDoc.getElementsByTagName("origen")[0].textContent,
            desti: xmlDoc.getElementsByTagName("desti")[0].textContent,
            adults: xmlDoc.getElementsByTagName("adults")[0].textContent,
            infants: xmlDoc.getElementsByTagName("infants")[0].textContent,
            dataInici: xmlDoc.getElementsByTagName("dataInici")[0].textContent,
            dataFi: xmlDoc.getElementsByTagName("dataFi")[0].textContent,
        };

        conversioElement.textContent = JSON.stringify(disponibilitatJSON, null, 2);
    } else {
        // Convertir JSON a XML
        disponibilitatXML = `
<disponibilitat>
    <origen>${disponibilitatJSON.origen}</origen>
    <desti>${disponibilitatJSON.desti}</desti>
    <adults>${disponibilitatJSON.adults}</adults>
    <infants>${disponibilitatJSON.infants}</infants>
    <dataInici>${disponibilitatJSON.dataInici}</dataInici>
    <dataFi>${disponibilitatJSON.dataFi}</dataFi>
</disponibilitat>`;

        conversioElement.textContent = disponibilitatXML;
        disponibilitatJSON = null; // Restablecer para la próxima conversión
    }
}