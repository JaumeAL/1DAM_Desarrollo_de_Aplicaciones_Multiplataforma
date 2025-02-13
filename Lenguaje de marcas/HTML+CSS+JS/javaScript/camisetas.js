const hamburguesa = document.querySelector('#hamburguesa');
const enlaces = document.querySelector('#links');

hamburguesa.addEventListener('click', () => {
    enlaces.classList.toggle('show');
});