function addNota(){
    var inputTareas = document.getElementById('tarea').value;
    var listaTareas = document.getElementById('lista');
    var li = document.createElement('li');
    li.innerHTML = inputTareas;
    listaTareas.appendChild(li);
    document.getElementById('tarea').value = '';
    

} 