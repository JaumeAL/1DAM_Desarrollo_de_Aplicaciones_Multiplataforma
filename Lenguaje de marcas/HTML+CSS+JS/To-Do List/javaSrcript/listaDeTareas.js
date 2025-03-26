//AGREGAR TAREAS
function agregar() {
  var tarea = document.getElementById("inputTarea").value;
  var lista = document.getElementById("lista");
  var nuevaTarea = document.createElement("li");

  if (tarea === "") {
    alert("No puedes agregar una tarea vacía");
  } else {
    var textoTarea = document.createElement("span");
    textoTarea.className = "texto-tarea";
    textoTarea.textContent = tarea;
    nuevaTarea.appendChild(textoTarea); // Agrega el texto de la tarea

    var botonCompletar = document.createElement("button");
    botonCompletar.className = "boton-completar";
    botonCompletar.textContent = "✓";
    nuevaTarea.appendChild(botonCompletar); // Agrega el botón de completar
    botonCompletar.onclick = function () { // Función para completar la tarea
      if (nuevaTarea.style.textDecoration === "line-through") {
        nuevaTarea.style.textDecoration = "none";
        nuevaTarea.style.color = "black";
        botonCompletar.style.backgroundColor = "#34a80a";
        botonEliminar.style.backgroundColor = "#e33131";
      } else {
        nuevaTarea.style.textDecoration = "line-through";
        nuevaTarea.style.color = "gray";
        botonCompletar.style.backgroundColor = "gray";
        botonEliminar.style.backgroundColor = "gray";
      }
    };

    var botonEliminar = document.createElement("button");
    botonEliminar.className = "boton-eliminar";
    botonEliminar.style.backgroundColor = "#e33131";
    botonEliminar.textContent = "X";
    nuevaTarea.appendChild(botonEliminar); // Agrega el botón de eliminar
    botonEliminar.onclick = function () {
      lista.removeChild(nuevaTarea);
    };

    lista.appendChild(nuevaTarea); // Agrega la tarea a la lista
    tarea = document.getElementById("inputTarea").value = "";
  }
}

// ELIMINAR TAREAS COMPLETADAS
function eliminarCompletadas() {
  var lista = document.getElementById("lista"); // Obtiene la lista de tareas
  var tareas = Array.from(lista.children); // Convierte el HTMLCollection en un array
  tareas.forEach(function (tarea) { // Recorre el array de tareas
    if (tarea.style.textDecoration === "line-through") { // Si la tarea está completada
      lista.removeChild(tarea); // Elimina la tarea
    }
  });
}

// FILTRAR TODAS LAS TAREAS
function filtrarTodas() {
  var tareas = document.querySelectorAll("#lista li"); 
  tareas.forEach(function (tarea) { 
    tarea.style.display = "block"; 
  });
}

// FILTRAR TAREAS COMPLETADAS
function filtrarCompletadas() {
  var lista = document.getElementById("lista");
  var tareas = Array.from(lista.children);
  tareas.forEach(function (tarea) {
    if (tarea.style.textDecoration !== "line-through") {
      tarea.style.display = "none";
    } else {
      tarea.style.display = "block";
    }
  });
}

// FILTRAR TAREAS SIN COMPLETAR
function filtrarSinCompletar() {
  var lista = document.getElementById("lista");
  var tareas = Array.from(lista.children);
  tareas.forEach(function (tarea) {
    if (tarea.style.textDecoration === "line-through") {
      tarea.style.display = "none";
    } else {
      tarea.style.display = "block";
    }
  });
}
