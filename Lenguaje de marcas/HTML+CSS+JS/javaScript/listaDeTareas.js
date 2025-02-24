/* Afegir tasques: Els usuaris han de poder introduir tasques mitjançant un camp de text i un botó per afegir-les a la llista. Cada tasca afegida ha d'aparèixer a la llista de tasques.
Marcar tasques com a completades: Cada tasca a la llista hauria de tenir un checkbox o algun altre mecanisme per marcar-la com a completada. Quan una tasca està marcada com a completada, ha de mostrar-se de manera diferent (p. ex., ratllada o amb un color diferent).
Eliminar tasques: Ha d'haver-hi una opció per eliminar tasques individuals de la llista. També una funció per eliminar totes les tasques completades amb un sol clic.
Filtrar tasques: Creeu botons per filtrar les tasques mostrades: totes, actives (no completades), o completades. */
function agregar() { 
    var tarea = document.getElementById("tarea").value;
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
//BOTON PARA ELIMINAR TAREAS COMPLETADAS
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
//BOTONES PARA FILTRAR TODAS LAS TAREAS
function filtrarTodas() {
    var lista = document.getElementById("lista");
    var tareas = lista.children;
    for (var i = 0; i < tareas.length; i++) {
        tareas[i].style.display = "block";
    }
}
//BOTON PARA FILTRAR TAREAS COMPLETADAS
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
