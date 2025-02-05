//Boton agrandar letra
function lletraGran() {
    let parrafo = document.getElementById("parrafo");
    let estilo = window.getComputedStyle(parrafo, null).getPropertyValue("font-size");
    let tamanio = parseInt(estilo) + 1;
    parrafo.style.fontSize = tamanio + "px";
}
//Boton disminuir letra
function lletraPetita() {
    let parrafo = document.getElementById("parrafo");
    let estilo = window.getComputedStyle(parrafo, null).getPropertyValue("font-size");
    let tamanio = parseInt(estilo) - 1;
    parrafo.style.fontSize = tamanio + "px";
}
// Boton cambiar color
function canviarColor() {
    let parrafo = document.getElementById("parrafo");
    let colores = ["#FF5733", "#33FF57", "#3357FF", "#F3FF33", "#FF33F3"];
    let color = colores[Math.floor(Math.random() * colores.length)];
    parrafo.style.color = color;
}

//Boton añadir texto
function afegirParagraf() {
    var text = prompt("Introduce un texto");
    let nuevo = document.createElement("p");
    nuevo.innerHTML = text;
    nuevo.appendChild(text);
    document.body.appendChild(nuevo);
}