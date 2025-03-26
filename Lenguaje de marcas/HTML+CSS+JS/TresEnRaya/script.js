// script.js

// Referencias a los elementos del DOM
const board = document.getElementById('board');
const cells = Array.from(board.getElementsByClassName('cell'));
const status = document.getElementById('status');
const resetButton = document.getElementById('reset-btn');

// Variables para el juego
let currentPlayer = 'X';
let gameBoard = ['', '', '', '', '', '', '', '', ''];  // El tablero (vacío al inicio)
let gameOver = false;

// Función para manejar un movimiento
function makeMove(index) {
    if (gameOver || gameBoard[index] !== '') return;

    // Colocar el símbolo del jugador actual en la celda seleccionada
    gameBoard[index] = currentPlayer;
    cells[index].textContent = currentPlayer;

    // Comprobar si el jugador ha ganado
    if (checkWinner()) {
        status.textContent = `¡${currentPlayer} ha ganado!`;
        gameOver = true;
        // Colorear las casillas de la combinación ganadora
        const winningCombination = [
            [0, 1, 2],
            [3, 4, 5],
            [6, 7, 8],
            [0, 3, 6],
            [1, 4, 7],
            [2, 5, 8],
            [0, 4, 8],
            [2, 4, 6],
        ].find(combination => {
            const [a, b, c] = combination;
            return gameBoard[a] === currentPlayer && gameBoard[a] === gameBoard[b] && gameBoard[a] === gameBoard[c];
        });
        if (winningCombination) {
            winningCombination.forEach(index => {
            cells[index].style.backgroundColor = 'lightgreen';
            });
        }
    } else if (gameBoard.every(cell => cell !== '')) {
        // Si el tablero está lleno y no hay ganador, es empate
        status.textContent = '¡Empate!';
        gameOver = true;
    } else {
        // Cambiar al siguiente jugador
        currentPlayer = (currentPlayer === 'X') ? 'O' : 'X';
        status.textContent = `Turno de: ${currentPlayer}`;
    }
}

// Función para verificar si hay un ganador
function checkWinner() {
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

// Función para reiniciar el juego
function resetGame() {
    gameBoard = ['', '', '', '', '', '', '', '', ''];
    cells.forEach(cell => cell.textContent = '');
    gameOver = false;
    currentPlayer = 'X';
    status.textContent = `Turno de: ${currentPlayer}`;
    cells.forEach(cell => cell.style.backgroundColor = '');
}

// Evento de clic en las celdas
cells.forEach((cell, index) => {
    cell.addEventListener('click', () => makeMove(index));
});

// Evento de reiniciar el juego
resetButton.addEventListener('click', resetGame);
