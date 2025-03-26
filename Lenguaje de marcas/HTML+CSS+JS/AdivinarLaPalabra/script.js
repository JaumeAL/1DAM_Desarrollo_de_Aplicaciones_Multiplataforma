// script.js

// Lista de palabras para adivinar
const words = ['manzana', 'plátano', 'perro', 'gato', 'computadora', 'coche'];
let selectedWord = '';
let guessedWord = [];
let attempts = 6;

// Referencias a los elementos del DOM
const wordDisplay = document.getElementById('word-display');
const guessInput = document.getElementById('guess-input');
const guessButton = document.getElementById('guess-btn');
const message = document.getElementById('message');
const attemptsLeft = document.getElementById('attempts-left');
const restartButton = document.getElementById('restart-btn');

// Función para iniciar un nuevo juego
function startGame() {
    selectedWord = words[Math.floor(Math.random() * words.length)];
    guessedWord = Array(selectedWord.length).fill('_');
    attempts = 10;
    updateGameState();
}

// Función para actualizar el estado del juego
function updateGameState() {
    wordDisplay.textContent = guessedWord.join(' ');
    attemptsLeft.textContent = attempts;
    message.textContent = '';

    if (attempts === 0) {
        message.textContent = '¡Has perdido! La palabra era: ' + selectedWord;
        guessButton.disabled = true;
        restartButton.style.display = 'block';
    }

    if (!guessedWord.includes('_')) {
        message.textContent = '¡Has ganado! La palabra es: ' + selectedWord;
        guessButton.disabled = true;
        restartButton.style.display = 'block';
    }
}

// Función para adivinar una letra
function guessLetter() {
    const guess = guessInput.value.toLowerCase();

    if (guess && guess.length === 1 && /^[a-z]$/.test(guess)) {
        let correctGuess = false;

        // Recorremos la palabra para ver si la letra adivinada está presente
        for (let i = 0; i < selectedWord.length; i++) {
            if (selectedWord[i] === guess) {
                guessedWord[i] = guess;
                correctGuess = true;
            }
        }

        if (!correctGuess) {
            attempts--;
        }

        // Actualizar el juego con el nuevo estado
        updateGameState();
    } else {
        message.textContent = 'Por favor, ingresa una letra válida.';
    }

    guessInput.value = '';
    guessInput.focus();
}

// Reiniciar el juego
function restartGame() {
    startGame();
    restartButton.style.display = 'none';
    guessButton.disabled = false;
}

// Eventos
guessButton.addEventListener('click', guessLetter);
restartButton.addEventListener('click', restartGame);

// Iniciar el juego al cargar
startGame();
