// script.js

// Obtener los elementos del DOM
const cartItemsContainer = document.getElementById('cart-items');
const totalPriceContainer = document.getElementById('total-price');
const clearCartButton = document.getElementById('clear-cart');

// Inicializar el carrito de compras
let cart = [];

// Función para actualizar la vista del carrito
function updateCart() {
    // Limpiar el contenedor del carrito
    cartItemsContainer.innerHTML = '';

    // Si el carrito está vacío, mostrar mensaje
    if (cart.length === 0) {
        cartItemsContainer.innerHTML = '<p>El carrito está vacío</p>';
        totalPriceContainer.textContent = 'Total: $0';
    } else {
        // Si el carrito tiene productos, mostrar los productos y el total
        let total = 0;
        cart.forEach(item => {
            const itemElement = document.createElement('div');
            itemElement.textContent = `${item.product} - $${item.price}`;
            cartItemsContainer.appendChild(itemElement);
            total += item.price;
        });
        totalPriceContainer.textContent = `Total: $${total}`;
    }
}

// Función para agregar un producto al carrito
function addToCart(product, price) {
    // Crear un objeto para el producto
    const cartItem = { product, price };
    // Agregar el producto al carrito
    cart.push(cartItem);
    // Actualizar la vista del carrito
    updateCart();
}

// Función para vaciar el carrito
function clearCart() {
    // Vaciar el array del carrito
    cart = [];
    // Actualizar la vista del carrito
    updateCart();
}

// Agregar eventos a los botones de "Agregar al carrito"
document.querySelectorAll('.add-to-cart').forEach(button => {
    button.addEventListener('click', (e) => {
        // Obtener el nombre del producto y el precio desde los atributos del botón
        const product = e.target.getAttribute('data-product');
        const price = parseFloat(e.target.getAttribute('data-price'));
        // Llamar a la función para agregar el producto al carrito
        addToCart(product, price);
    });
});

// Agregar evento al botón de "Vaciar carrito"
clearCartButton.addEventListener('click', () => {
    // Llamar a la función para vaciar el carrito
    clearCart();
});

// Inicializar el carrito al cargar la página
updateCart();
