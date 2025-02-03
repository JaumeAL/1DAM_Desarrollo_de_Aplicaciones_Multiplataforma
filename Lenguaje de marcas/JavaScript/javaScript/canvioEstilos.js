//Boton agrandar letra
function lletraGran() {
    var parrafo = document.getElementById("parrafo");
    var estilo = window.getComputedStyle(parrafo, null).getPropertyValue("font-size");
    var tamanio = parseInt(estilo) + 1;
    parrafo.style.fontSize = tamanio + "px";
}

//Boton disminuir letra
function lletraPetita() {
    var parrafo = document.getElementById("parrafo");
    var estilo = window.getComputedStyle(parrafo, null).getPropertyValue("font-size");
    var tamanio = parseInt(estilo) - 1;
    parrafo.style.fontSize = tamanio + "px";
}

//Boton cambiar color de letra de manera aleatoria
function canviarColor() {
    var parrafo = document.getElementById("parrafo");
    var color = Math.floor(Math.random() * 16777215).toString(16);
    parrafo.style.color = "#" + color;
}