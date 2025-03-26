// script.js
document.addEventListener("DOMContentLoaded", function() {
    // Referencias a elementos del DOM
    const board = document.getElementById("memory-board"); // Tablero del juego
    const message = document.getElementById("message"); // Mensaje para mostrar al usuario

    // Valores de las cartas (pares de letras)
    const cardValues = ["A", "B", "C", "D", "E", "F", "G", "H", "A", "B", "C", "D", "E", "F", "G", "H"];
    let flippedCards = []; // Almacena las cartas volteadas temporalmente
    let matchedPairs = 0; // Contador de parejas encontradas
    let lockBoard = false; // Bloquea el tablero mientras se verifica un par

    // Función para mezclar las cartas (algoritmo Fisher-Yates)
    function shuffle(array) {
        for (let i = array.length - 1; i > 0; i--) {
            const j = Math.floor(Math.random() * (i + 1)); // Índice aleatorio
            [array[i], array[j]] = [array[j], array[i]]; // Intercambia elementos
        }
    }

    // Función para crear una carta
    function createCard(value) {
        const card = document.createElement("div"); // Crea un elemento div para la carta
        card.classList.add("card"); // Agrega la clase "card"
        card.dataset.value = value; // Asigna el valor de la carta como un atributo de datos
        card.addEventListener("click", flipCard); // Agrega el evento de clic para voltear la carta
        return card; // Devuelve la carta creada
    }

    // Función para voltear una carta
    function flipCard() {
        // Evita que se voltee si el tablero está bloqueado o si la carta ya está volteada o emparejada
        if (lockBoard || this.classList.contains("flipped") || this.classList.contains("matched")) return;

        this.classList.add("flipped"); // Agrega la clase "flipped" para mostrar la carta
        this.textContent = this.dataset.value; // Muestra el valor de la carta

        flippedCards.push(this); // Agrega la carta volteada al array de cartas volteadas

        // Si hay dos cartas volteadas, verifica si son un par
        if (flippedCards.length === 2) {
            checkMatch();
        }
    }

    // Función para verificar si las cartas volteadas son un par
    function checkMatch() {
        lockBoard = true; // Bloquea el tablero mientras se verifica el par

        const [card1, card2] = flippedCards; // Obtiene las dos cartas volteadas

        if (card1.dataset.value === card2.dataset.value) {
            // Si las cartas coinciden
            card1.classList.add("matched"); // Marca la primera carta como emparejada
            card2.classList.add("matched"); // Marca la segunda carta como emparejada
            matchedPairs++; // Incrementa el contador de parejas encontradas

            // Si se han encontrado todas las parejas, muestra un mensaje de felicitación
            if (matchedPairs === cardValues.length / 2) {
                message.textContent = "¡Felicidades, has encontrado todas las parejas!";
            }

            flippedCards = []; // Vacía el array de cartas volteadas
            lockBoard = false; // Desbloquea el tablero
        } else {
            // Si las cartas no coinciden
            setTimeout(() => {
                card1.classList.remove("flipped"); // Voltea la primera carta hacia atrás
                card2.classList.remove("flipped"); // Voltea la segunda carta hacia atrás
                flippedCards = []; // Vacía el array de cartas volteadas
                lockBoard = false; // Desbloquea el tablero
            }, 1000); // Espera 1 segundo antes de voltear las cartas
        }
    }

    // Función para configurar el juego
    function setupGame() {
        shuffle(cardValues); // Mezcla las cartas
        board.innerHTML = ""; // Limpia el tablero
        cardValues.forEach(value => {
            board.appendChild(createCard(value)); // Crea y agrega cada carta al tablero
        });
    }

    // Inicializa el juego
    setupGame();
});