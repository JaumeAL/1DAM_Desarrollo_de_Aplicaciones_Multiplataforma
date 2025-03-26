document.addEventListener("DOMContentLoaded", () => {
    // Elementos del DOM
    const taskInput = document.getElementById("taskInput");
    const addTaskButton = document.getElementById("addTask");
    const clearTasksButton = document.getElementById("clearTasks");
    const taskList = document.getElementById("taskList");
    const fetchDataButton = document.getElementById("fetchData");
    const apiDataDiv = document.getElementById("apiData");
    const createCarButton = document.getElementById("createCar");
    const carInfo = document.getElementById("carInfo");

    let tasks = JSON.parse(localStorage.getItem("tasks")) || [];

    function saveTasks() {
        localStorage.setItem("tasks", JSON.stringify(tasks));
    }

    function renderTasks() {
        taskList.innerHTML = "";
        tasks.forEach((task, index) => {
            const li = document.createElement("li");
            li.classList.toggle("completed", task.completed);
            li.innerHTML = `
                <span>${task.text}</span>
                <div>
                    <button onclick="toggleTask(${index})">${task.completed ? "Desmarcar" : "Completar"}</button>
                    <button onclick="deleteTask(${index})" style="background: red;">Eliminar</button>
                </div>
            `;
            taskList.appendChild(li);
        });
    }

    window.toggleTask = (index) => { 
        tasks[index].completed = !tasks[index].completed; 
        saveTasks();
        renderTasks();
    };

    window.deleteTask = (index) => { //
        tasks.splice(index, 1);
        saveTasks();
        renderTasks();
    };

    addTaskButton.addEventListener("click", () => {
        if (taskInput.value.trim() === "") return;
        tasks.push({ text: taskInput.value, completed: false });
        saveTasks();
        taskInput.value = "";
        renderTasks();
    });

    clearTasksButton.addEventListener("click", () => {
        tasks = [];
        saveTasks();
        renderTasks();
    });

    fetchDataButton.addEventListener("click", async () => {
        apiDataDiv.innerHTML = "Cargando datos...";
        try {
            const response = await fetch("https://jsonplaceholder.typicode.com/posts/1");
            const data = await response.json();
            apiDataDiv.innerHTML = `<strong>${data.title}</strong><p>${data.body}</p>`;
        } catch (error) {
            apiDataDiv.innerHTML = "Error al obtener datos.";
        }
    });

    class Car {
        constructor(brand, model, year) {
            this.brand = brand;
            this.model = model;
            this.year = year;
        }

        getInfo() {
            return `Coche: ${this.brand} ${this.model}, Año: ${this.year}`;
        }
    }

    createCarButton.addEventListener("click", () => {
        const myCar = new Car("Toyota", "Corolla", 2023);
        carInfo.textContent = myCar.getInfo();
    });

    renderTasks();
});
