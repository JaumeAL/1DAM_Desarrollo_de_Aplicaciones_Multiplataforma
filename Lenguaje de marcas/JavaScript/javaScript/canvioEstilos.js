//Boton agrandar letra
function lletraGran() {
    let parrafo = document.getElementById("parrafo");
    let estilo = window.getComputedStyle(parrafo, null).getPropertyValue("font-size");
    let tamanio = parseInt(estilo) + 1;
    parrafo.style.fontSize = tamanio + "px";
}
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