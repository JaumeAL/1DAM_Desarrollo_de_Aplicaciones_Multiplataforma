//Manipulacion de estilos

document.getElementById('parrafo').style.color = 'red'; //cambia el color del texto a rojo
var element = document.getElementById('parrafo'); //elemento con id parrafo

function canviarColorVerde(id) {
    element.style.color = 'green'; //cambia el color del texto a verde
}

function canviarColorRojo(id) {
    var titol = document.getElementById('titol');
    titol.style.color = 'red'; //cambia el color del texto a rojo

    //document.getElementById('parrafo').style.color = 'red'; //cambia el color del texto a rojo
}

function canviarEstilos() {
    var element = document.getElementById('segundoParrafo'); //elemento con id segundoParrafo
    element.style.color = 'blue'; //cambia el color del texto a azul
    element.style.backgroundColor = 'yellow'; //cambia el color de fondo a amarillo
}