// Espera a que el DOM esté completamente cargado antes de ejecutar el código
document.addEventListener("DOMContentLoaded", () => {

    // Obtiene el formulario de tareas por su ID
    const taskForm = document.getElementById("task-form");

    // Obtiene el campo de entrada de texto para las tareas por su ID
    const taskInput = document.getElementById("task-input");

    // Obtiene la lista de tareas (ul) por su ID
    const taskList = document.getElementById("task-list");

    // Obtiene todos los botones de filtro (completadas, pendientes, todas) por su clase
    const filterButtons = document.querySelectorAll(".filters button");

    // Obtiene el botón para ver los resultados por su ID
    const viewResultsButton = document.getElementById("view-results");

    // Recupera las tareas almacenadas en localStorage o inicializa un array vacío si no hay tareas guardadas
    let tasks = JSON.parse(localStorage.getItem("tasks")) || [];

    // Función para guardar las tareas en localStorage
    function saveTasks() {
        localStorage.setItem("tasks", JSON.stringify(tasks));
    }

    // Función para renderizar las tareas en la lista según el filtro seleccionado
    function renderTasks(filter = "all") {
        // Limpia la lista de tareas antes de renderizar
        taskList.innerHTML = "";

        // Recorre todas las tareas
        tasks.forEach((task, index) => {
            // Si el filtro es "completadas" y la tarea no está completada, no la muestra
            if (filter === "completed" && !task.completed) return;

            // Si el filtro es "pendientes" y la tarea está completada, no la muestra
            if (filter === "pending" && task.completed) return;

            // Crea un elemento <li> para cada tarea
            const li = document.createElement("li");

            // Añade la clase "completed" al <li> si la tarea está completada
            li.classList.toggle("completed", task.completed);

            // Define el contenido HTML del <li>, incluyendo el texto de la tarea y los botones
            li.innerHTML = `
                <span>${task.text}</span>
                <div>
                    <button onclick="toggleTask(${index})">${task.completed ? "Desmarcar" : "Completar"}</button>
                    <button onclick="deleteTask(${index})" style="background: red;">Eliminar</button>
                </div>
            `;

            // Añade el <li> a la lista de tareas
            taskList.appendChild(li);
        });
    }

    // Función global para alternar el estado de completado de una tarea
    window.toggleTask = (index) => {
        // Cambia el estado de completado de la tarea
        tasks[index].completed = !tasks[index].completed;

        // Guarda las tareas actualizadas en localStorage
        saveTasks();

        // Vuelve a renderizar las tareas
        renderTasks();
    };

    // Función global para eliminar una tarea
    window.deleteTask = (index) => {
        // Elimina la tarea del array según su índice
        tasks.splice(index, 1);

        // Guarda las tareas actualizadas en localStorage
        saveTasks();

        // Vuelve a renderizar las tareas
        renderTasks();
    };

    // Evento que se ejecuta cuando se envía el formulario de tareas
    taskForm.addEventListener("submit", (e) => {
        // Previene el comportamiento por defecto del formulario (recargar la página)
        e.preventDefault();

        // Crea un nuevo objeto de tarea con el texto ingresado y estado "no completado"
        const newTask = { text: taskInput.value, completed: false };

        // Añade la nueva tarea al array de tareas
        tasks.push(newTask);

        // Guarda las tareas actualizadas en localStorage
        saveTasks();

        // Limpia el campo de entrada de texto
        taskInput.value = "";

        // Vuelve a renderizar las tareas
        renderTasks();
    });

    // Añade un evento de clic a cada botón de filtro
    filterButtons.forEach(button => {
        button.addEventListener("click", () => {
            // Renderiza las tareas según el filtro seleccionado (atributo data-filter del botón)
            renderTasks(button.dataset.filter);
        });
    });

    // Evento que se ejecuta al hacer clic en el botón "Ver resultados"
    viewResultsButton.addEventListener("click", () => {
        // Guarda las tareas en localStorage (por si hubo cambios)
        localStorage.setItem("tasks", JSON.stringify(tasks));

        // Redirige al usuario a la página "view.html"
        window.location.href = "view.html";
    });

    // Renderiza las tareas al cargar la página
    renderTasks();
});