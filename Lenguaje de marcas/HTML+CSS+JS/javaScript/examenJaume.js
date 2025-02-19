//Boton Contar clics
const contador = 0;
const final = 10;
function Contar() {
    contador ++;
 document.getElementById("parrafo").textContent = contador;
    


}

//Boton añadir texto
function afegirParagraf() {
    var text = InputDeviceInfo;
    let nuevo = document.createElement("p");
    nuevo.textContent = text;
    document.getElementById("contenedor").appendChild(nuevo);
}

//Boton borrar texto nuevo
function Eliminar() {
    let borrar = document.getElementById("contenedor");
    borrar.removeChild(contenedor.lastChild);
}