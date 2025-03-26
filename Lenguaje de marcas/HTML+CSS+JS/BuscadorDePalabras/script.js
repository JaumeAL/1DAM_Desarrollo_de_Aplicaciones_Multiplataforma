// script.js

// Referencias a los elementos
const searchInput = document.getElementById('search-input');
const wordList = document.getElementById('word-list');
const clearButton = document.getElementById('clear-btn');
const resultsCount = document.getElementById('results-count');

// Lista de palabras que se mostrarán en la lista
const words = [
    'Manzana', 'Plátano', 'Perro', 'Gato', 'Auto', 'Casa', 'Computadora',
    'Teclado', 'Monitor', 'Coche'
];

// Función para actualizar la lista según la búsqueda
function updateList(searchTerm) { // searchTerm: Término de búsqueda
    // Limpiar los elementos anteriores
    wordList.innerHTML = '';

    // Filtrar las palabras que coinciden con la búsqueda
    const filteredWords = words.filter(word => word.toLowerCase().includes(searchTerm.toLowerCase()));

    // Mostrar las palabras filtradas
    filteredWords.forEach(word => {
        const li = document.createElement('li');
        li.textContent = word;

        // Resaltar las coincidencias
        if (searchTerm) {
            const regex = new RegExp(`(${searchTerm})`, 'gi');
            li.innerHTML = word.replace(regex, '<span class="highlight">$1</span>');
        }

        wordList.appendChild(li);
    });

    // Actualizar el contador de resultados
    resultsCount.textContent = `Resultados encontrados: ${filteredWords.length}`;
}

// Función para limpiar la búsqueda
function clearSearch() {
    searchInput.value = '';
    updateList('');
}

// Eventos
searchInput.addEventListener('input', (e) => {
    updateList(e.target.value);
});

clearButton.addEventListener('click', clearSearch);

// Inicializar la lista con todas las palabras
updateList('');
