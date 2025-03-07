//Boton Contar
var contador = 0;
function Contar() {
    if (contador < 10) {
        contador ++;
        document.getElementById("parrafo").textContent = contador;
        
    }else{
        document.getElementById("reiniciar").style.display ="flex";
        document.getElementById("contar").style.display ="none";
    }
    
}

//Boton Reiniciar contador
function Reiniciar() {
    document.getElementById("parrafo").textContent = "0";
    contador = 0;
    document.getElementById("reiniciar").style.display ="none";
    document.getElementById("contar").style.display ="flex";    

}
// Para manejar el evento submit del formulario y que no se resetee la página
document.getElementById("formComentarios").addEventListener("submit", function(event) {
    event.preventDefault();
});

// Boton añadir comentario
function Añadir(){
    var inputComentario = document.getElementById("comentario").value;
    if (inputComentario === "") {
        alert("Campo vacio :(")
    }else{
    var lista = document.getElementById("lista")
    var nuevoComentario = document.createElement("li");
    var textoComentario = document.createElement("span");

    textoComentario.textContent=inputComentario;
    nuevoComentario.appendChild(textoComentario);

    lista.appendChild(nuevoComentario);
    inputComentario = document.getElementById("comentario").value = "";
    }
}
// Boton Eliminar comentario
function Eliminar(){
    var lista = document.getElementById("lista");
    lista.removeChild(lista.lastChild);
}
