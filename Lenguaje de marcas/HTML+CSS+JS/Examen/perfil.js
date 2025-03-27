document.addEventListener("DOMContentLoaded", function () {
    const nombre = sessionStorage.getItem("nombre");
    const fechaNacimiento = sessionStorage.getItem("fechaNacimiento");
    const email = sessionStorage.getItem("email");
    const ciudad = sessionStorage.getItem("ciudad");
    const codigoPostal = sessionStorage.getItem("codigoPostal");
    const categoria = sessionStorage.getItem("categoria");
    const newsletter = sessionStorage.getItem("newsletter");


    if (nombre || fechaNacimiento || email || ciudad || codigoPostal || categoria || newsletter) { // Si hay datos en localStorage
        const primero = document.getElementById("nombrePerfil");
        primero.value = nombre; 
        const segundo = document.getElementById("fechaNacimientoPerfil");
        segundo.value = fechaNacimiento; 
        const tercero = document.getElementById("emailPerfil");
        tercero.value = email; 
        const cuarto = document.getElementById("ciudadPerfil");
        cuarto.value = ciudad; 
        const quinto = document.getElementById("codigoPostalPerfil");
        quinto.value = codigoPostal; 
        const sexto = document.getElementById("categoriaPerfil");
        sexto.value = categoria; 
        const septimo = document.getElementById("suscripcionPerfil");
        septimo.value = newsletter; 

    }

});

function CerrarSesion() {
    // Limpiar localStorage
    localStorage.removeItem("nombre");
    localStorage.removeItem("fechaNacimiento");
    localStorage.removeItem("email");
    localStorage.removeItem("ciudad");
    localStorage.removeItem("codigoPostal");
    localStorage.removeItem("categoria");
    localStorage.removeItem("categoria");
    localStorage.removeItem("newsletter");

    // Redirigir a registro.html
    window.location.href = "registro.html";
    
}

//AGREGAR autorS
function agregar() {
    var autor = document.getElementById("autorInput").value;
    var lista = document.getElementById("listaAutores");
    var nuevaautor = document.createElement("li");
  
    if (autor === "") {
      alert("No puedes agregar una autor vacía");
    } else {
      var textoautor = document.createElement("span");
      textoautor.className = "texto-autor";
      textoautor.textContent = autor;
      nuevaautor.appendChild(textoautor); // Agrega el texto de la autor
      };
  
      var botonEliminar = document.createElement("button");
      botonEliminar.className = "boton-eliminar";
      botonEliminar.style.backgroundColor = "#e33131";
      botonEliminar.style.marginLeft = "30px";
      botonEliminar.textContent = "X";
      nuevaautor.appendChild(botonEliminar); // Agrega el botón de eliminar
      botonEliminar.onclick = function () {
        lista.removeChild(nuevaautor);
      };
  
      lista.appendChild(nuevaautor); // Agrega la autor a la lista

}

// ELIMINAR TAREAS COMPLETADAS
function eliminarTodas() {
    var lista = document.getElementById("listaAutores"); // Obtiene la lista de tareas
    var tareas = Array.from(lista.children); // Convierte el HTMLCollection en un array
    tareas.forEach(function (tarea) { // Recorre el array de tareas
        lista.removeChild(tarea); // Elimina la tarea
      
    });
  }
  