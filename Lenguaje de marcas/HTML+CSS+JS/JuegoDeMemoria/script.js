// script.js
document.addEventListener("DOMContentLoaded", function() {
    const board = document.getElementById("memory-board");
    const message = document.getElementById("message");

    const cardValues = ["A", "B", "C", "D", "E", "F", "G", "H", "A", "B", "C", "D", "E", "F", "G", "H"];
    let flippedCards = [];
    let matchedPairs = 0;
    let lockBoard = false;

    function shuffle(array) {
        for (let i = array.length - 1; i > 0; i--) {
            const j = Math.floor(Math.random() * (i + 1));
            [array[i], array[j]] = [array[j], array[i]];
        }
    }

    function createCard(value) {
        const card = document.createElement("div");
        card.classList.add("card");
        card.dataset.value = value;
        card.addEventListener("click", flipCard);
        return card;
    }

    function flipCard() {
        if (lockBoard || this.classList.contains("flipped") || this.classList.contains("matched")) return;

        this.classList.add("flipped");
        this.textContent = this.dataset.value;

        flippedCards.push(this);

        if (flippedCards.length === 2) {
            checkMatch();
        }
    }

    function checkMatch() {
        lockBoard = true;

        const [card1, card2] = flippedCards;

        if (card1.dataset.value === card2.dataset.value) {
            card1.classList.add("matched");
            card2.classList.add("matched");
            matchedPairs++;

            if (matchedPairs === cardValues.length / 2) {
                message.textContent = "¡Felicidades, has encontrado todas las parejas!";
            }

            flippedCards = [];
            lockBoard = false;
        } else {
            setTimeout(() => {
                card1.classList.remove("flipped");
                card2.classList.remove("flipped");
                flippedCards = [];
                lockBoard = false;
            }, 1000);
        }
    }

    function setupGame() {
        shuffle(cardValues);
        board.innerHTML = ""; // Limpiar el tablero
        cardValues.forEach(value => {
            board.appendChild(createCard(value));
        });
    }

    setupGame();
});
