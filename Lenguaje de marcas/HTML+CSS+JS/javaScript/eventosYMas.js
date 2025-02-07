//onchange: evento que se dispara cuando el valor de un elemento cambia
//onclick: evento que se dispara cuando se hace clic en un elemento
//onmouseover: evento que se dispara cuando el puntero del ratón se sitúa sobre un elemento
//onmouseout: evento que se dispara cuando el puntero del ratón sale de un elemento
//onkeydown: evento que se dispara cuando se pulsa una tecla
//onload: evento que se dispara cuando un objeto ha sido cargado
//onsubmit: evento que se dispara cuando se envía un formulario
//onfocus: evento que se dispara cuando un elemento recibe el foco
//...

//<button onclick="saludar()">Saludar</button>
//<button onclick="alert('Hola des html')">Saludar desde html</button>

// ejemplos maneras selecionar elementos
const parrafoByID = document.getElementById('parrafo'); //por id
const parrafoByTag = document.getElementsByTagName('p'); //por etiqueta
const parrafoByClass = document.getElementsByClassName('colorBlue'); //por clase
const querySelector = document.querySelector('p'); //por selector
const querySelectorAll = document.querySelectorAll('.parrafo'); //por selector

//acceso a elementos del DOM
var element = document.getElementById('parrafo'); //elemento con id parrafo
var padre = element.parentNode; //padre del elemento
var hijos = padre.childNodes; //todos los hijos del padre
var primerHijo = padre.firstChild; //primer hijo del padre
var ultimoHijo = padre.lastChild; //último hijo del padre
var siguiente = element.nextSibling; //siguiente hermano del elemento
var anterior = element.previousSibling; //hermano anterior del elemento

var lista = document.createElement('ul'); //crea un elemento ul
var item1 = document.createElement('li'); //crea un elemento li
var item2 = document.createElement('li'); //crea un elemento li
var item3 = document.createElement('li'); //crea un elemento li

item1.innerHTML = '<b>Elemento 1</b>'; //añade texto al elemento li
lista.appendChild(item1); //añade el elemento li a la lista ul
item2.innerHTML = '<b>Elemento 2</b>'; //añade texto al elemento li
lista.appendChild(item2); //añade el elemento li a la lista ul
item3.innerHTML = '<b>Elemento 3</b>'; //añade texto al elemento li
lista.appendChild(item3); //añade el elemento li a la lista ul

document.body.appendChild(lista); //añade la lista al body
