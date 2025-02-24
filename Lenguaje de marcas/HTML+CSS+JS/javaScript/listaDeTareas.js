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
        } else {
            nuevaTarea.style.textDecoration = "none";
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