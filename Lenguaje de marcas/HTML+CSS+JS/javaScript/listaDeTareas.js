//AGREGAR TAREAS
function agregar() { 
    var tarea = document.getElementById("inputTarea").value;
    var lista = document.getElementById("lista");
    var nuevaTarea = document.createElement("li");

    nuevaTarea.textContent = tarea;
    lista.appendChild(nuevaTarea);

    var check = document.createElement("input");
    check.type = "checkbox";
    nuevaTarea.appendChild(check);
    check.onclick = function() {
        if (check.checked) {
            nuevaTarea.style.textDecoration = "line-through";
            nuevaTarea.style.color = "gray";
        } else {
            nuevaTarea.style.textDecoration = "none";
            nuevaTarea.style.color = "black";
        }
    }
    var boton = document.createElement("button");
    boton.style.backgroundColor = "#e33131";
    boton.textContent = "X";
    nuevaTarea.appendChild(boton);
    boton.onclick = function() {
        lista.removeChild(nuevaTarea);
    }
    
}
//ELIMINAR TAREAS COMPLETADAS
function eliminarCompletadas() {
    var lista = document.getElementById("lista");
    var tareas = lista.children;
    for (var i = 0; i < tareas.length; i++) {
        if (tareas[i].children[0].checked) {
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
        if (!tareas[i].children[0].checked) {
            tareas[i].style.display = "none";
        } else {
            tareas[i].style.display = "block";
        }
    }
}
//FINLTRAR TAREAS SIN COMPLETAR
function filtrarSinCompletar() {
    var lista = document.getElementById("lista");
    var tareas = lista.children;
    for (var i = 0; i < tareas.length; i++) {
        if (tareas[i].children[0].checked) {
            tareas[i].style.display = "none";
        } else {
            tareas[i].style.display = "block";
        }
    }
}
