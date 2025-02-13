const hamburguesa = document.querySelector('#hamburguesa');
const enlaces = document.querySelector('#links');
const buscador = document.querySelector('#buscador');
const productos = document.querySelectorAll('.producto');

hamburguesa.addEventListener('click', () => {
    enlaces.classList.toggle('show');
});

buscador.addEventListener('input', () => {
    const filtro = buscador.value.toLowerCase();
    productos.forEach(producto => {
        const texto = producto.textContent.toLowerCase();
        if (texto.includes(filtro)) {
            producto.style.display = 'block';
        } else {
            producto.style.display = 'none';
        }
    });
});