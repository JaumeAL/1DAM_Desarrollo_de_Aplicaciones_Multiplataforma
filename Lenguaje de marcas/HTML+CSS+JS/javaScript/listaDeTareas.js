//AGREGAR TAREAS
function agregar() { 
    var tarea = document.getElementById("inputTarea").value;
    var lista = document.getElementById("lista");
    var nuevaTarea = document.createElement("li");

    var textoTarea = document.createElement("span");
    textoTarea.className = "texto-tarea";
    textoTarea.textContent = tarea;
    nuevaTarea.appendChild(textoTarea);

    var botonCompletar = document.createElement("button");
    botonCompletar.className = "boton-completar";
    botonCompletar.textContent = "✓";
    nuevaTarea.appendChild(botonCompletar);
    botonCompletar.onclick = function() {
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
    }

    var botonEliminar = document.createElement("button");
    botonEliminar.className = "boton-eliminar";
    botonEliminar.style.backgroundColor = "#e33131";
    botonEliminar.textContent = "X";
    nuevaTarea.appendChild(botonEliminar);
    botonEliminar.onclick = function() {
        lista.removeChild(nuevaTarea);
    }

    lista.appendChild(nuevaTarea);
}

//ELIMINAR TAREAS COMPLETADAS
function eliminarCompletadas() {
    var lista = document.getElementById("lista");
    var tareas = lista.children;
    for (var i = 0; i < tareas.length; i++) {
        if (tareas[i].style.textDecoration === "line-through") {
            lista.removeChild(tareas[i]);
            i--;
        }
    }
}

//ILTRAR TODAS LAS TAREAS
function filtrarTodas() {
    var lista = document.getElementById("lista");
    var tareas = lista.children;
    for (var i = 0; i < tareas.length; i++) {
        tareas[i].style.display = "block";
    }
}

//FILTRAR TAREAS COMPLETADAS
function filtrarCompletadas() {
    var lista = document.getElementById("lista");
    var tareas = lista.children;
    for (var i = 0; i < tareas.length; i++) {
        if (tareas[i].style.textDecoration !== "line-through") {
            tareas[i].style.display = "none";
        } else {
            tareas[i].style.display = "block";
        }
    }
}

//FILTRAR TAREAS SIN COMPLETAR
function filtrarSinCompletar() {
    var lista = document.getElementById("lista");
    var tareas = lista.children;
    for (var i = 0; i < tareas.length; i++) {
        if (tareas[i].style.textDecoration === "line-through") {
            tareas[i].style.display = "none";
        } else {
            tareas[i].style.display = "block";
        }
    }
}