// script.js

// Referencias a los elementos del DOM
const dateInput = document.getElementById('date-input');
const startButton = document.getElementById('start-btn');
const countdownDisplay = document.getElementById('time-left');
const message = document.getElementById('message');

// Función para iniciar la cuenta regresiva
function startCountdown() {
    const targetDate = new Date(dateInput.value).getTime();

    if (isNaN(targetDate)) {
        message.textContent = 'Por favor, ingresa una fecha válida.';
        message.style.color = 'red';
        return;
    }

    // Actualizar la cuenta regresiva cada segundo
    const interval = setInterval(function() {
        const currentTime = new Date().getTime();
        const timeLeft = targetDate - currentTime;

        if (timeLeft <= 0) {
            clearInterval(interval);
            countdownDisplay.textContent = '00d 00h 00m 00s';
            message.textContent = '¡La cuenta regresiva ha terminado!';
            message.style.color = 'green';
        } else {
            const days = Math.floor(timeLeft / (1000 * 60 * 60 * 24));
            const hours = Math.floor((timeLeft % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
            const minutes = Math.floor((timeLeft % (1000 * 60 * 60)) / (1000 * 60));
            const seconds = Math.floor((timeLeft % (1000 * 60)) / 1000);

            countdownDisplay.textContent = `${days}d ${hours}h ${minutes}m ${seconds}s`;
        }
    }, 1000);
}

// Evento para iniciar la cuenta regresiva
startButton.addEventListener('click', startCountdown);
