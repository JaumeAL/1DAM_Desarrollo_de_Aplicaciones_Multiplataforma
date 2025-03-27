// Resumen de conceptos y ejemplos de JavaScript

// 1. Manipulación del DOM
// Seleccionar elementos del DOM
const element = document.getElementById("id"); // Selecciona un elemento por su ID
const elements = document.querySelectorAll(".class"); // Selecciona todos los elementos con una clase

// Modificar contenido
element.textContent = "Nuevo texto"; // Cambia el texto de un elemento
element.innerHTML = "<strong>Texto en negrita</strong>"; // Cambia el contenido HTML de un elemento

// Modificar estilos
element.style.backgroundColor = "red"; // Cambia el color de fondo

// Agregar y quitar clases
element.classList.add("nueva-clase"); // Agrega una clase
element.classList.remove("clase-existente"); // Elimina una clase
element.classList.toggle("clase"); // Alterna una clase

// 2. Eventos
// Agregar eventos a elementos
element.addEventListener("click", function() {
    console.log("Elemento clickeado");
});

// Prevenir el comportamiento por defecto
document.getElementById("form").addEventListener("submit", function(event) {
    event.preventDefault(); // Evita que el formulario se envíe
});

// 3. Funciones
// Declaración de funciones
function sumar(a, b) {
    return a + b;
}

// Funciones flecha
const restar = (a, b) => a - b;

// 4. Arrays
// Crear y manipular arrays
const array = ["A", "B", "C"];
array.push("D"); // Agrega un elemento al final
array.pop(); // Elimina el último elemento
array.forEach(item => console.log(item)); // Itera sobre los elementos

// Mezclar un array (algoritmo Fisher-Yates)
function shuffle(array) {
    for (let i = array.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        [array[i], array[j]] = [array[j], array[i]];
    }
}

// 5. Condicionales
// Estructura básica
if (condition) {
    // Código si la condición es verdadera
} else {
    // Código si la condición es falsa
}

// 6. Bucles
// Bucle for
for (let i = 0; i < 10; i++) {
    console.log(i);
}

// Bucle forEach
array.forEach(item => console.log(item)); // Itera sobre los elementos de un array

// Bucle while
let i = 0;
while (i < 10) {
    console.log(i);
    i++;
}

// switch case
const day = "Lunes";
switch (day) {
    case "Lunes":
        console.log("Hoy es Lunes");
        break;
    case "Martes":
        console.log("Hoy es Martes");
        break;
    default:
        console.log("Hoy es otro día");
}

// 7. Objetos y clases
// Crear un objeto
const car = {
    brand: "Toyota",
    model: "Corolla",
    year: 2023,
    getInfo: function() {
        return `${this.brand} ${this.model}, Año: ${this.year}`;
    }
};

// Crear una clase
class Car {
    constructor(brand, model, year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    getInfo() {
        return `${this.brand} ${this.model}, Año: ${this.year}`;
    }
}

// 8. LocalStorage
// Guardar y recuperar datos
localStorage.setItem("key", "value"); // Guarda un valor
const value = localStorage.getItem("key"); // Recupera un valor
localStorage.removeItem("key"); // Elimina un valor

// 9. Temporizadores
// Ejecutar código después de un tiempo
setTimeout(() => {
    console.log("Esto se ejecuta después de 1 segundo");
}, 1000);

// Ejecutar código repetidamente
const interval = setInterval(() => {
    console.log("Esto se ejecuta cada 1 segundo");
}, 1000);

// Detener un intervalo
clearInterval(interval);

// 10. Manejo de errores
// Try-catch para manejar errores
try {
    // Código que puede generar un error
    throw new Error("Algo salió mal");
} catch (error) {
    console.error(error.message);
}

// 11. Juegos y lógica
// Tres en raya: Verificar ganador
function checkWinner(gameBoard, currentPlayer) {
    const winningCombinations = [
        [0, 1, 2],
        [3, 4, 5],
        [6, 7, 8],
        [0, 3, 6],
        [1, 4, 7],
        [2, 5, 8],
        [0, 4, 8],
        [2, 4, 6],
    ];

    return winningCombinations.some(combination => {
        const [a, b, c] = combination;
        return gameBoard[a] === currentPlayer && gameBoard[a] === gameBoard[b] && gameBoard[a] === gameBoard[c];
    });
}

// Juego de memoria: Verificar pares
function checkMatch(card1, card2) {
    return card1.dataset.value === card2.dataset.value;
}

// 12. Buenas prácticas
// - Usa nombres descriptivos para variables y funciones.
// - Divide el código en funciones reutilizables.
// - Comenta el código para explicar su propósito.
// - Usa `const` y `let` en lugar de `var`.
// - Prueba tu código regularmente para encontrar errores.
