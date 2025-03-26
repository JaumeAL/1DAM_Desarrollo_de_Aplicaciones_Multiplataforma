// script.js

// Función para validar el nombre
function validateName(name) {
    const nameRegex = /^[A-Za-zÀ-ÿ\s]+$/;
    return nameRegex.test(name);
}

// Función para validar el correo electrónico
function validateEmail(email) {
    const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
    return emailRegex.test(email);
}

// Función para validar el teléfono
function validatePhone(phone) {
    const phoneRegex = /^\d{9}$/;
    return phoneRegex.test(phone);
}

// Función para validar la contraseña
function validatePassword(password) {
    return password.length >= 6;
}

// Función para validar si las contraseñas coinciden
function validatePasswordConfirmation(password, confirmPassword) {
    return password === confirmPassword;
}

// Función para validar que el usuario acepte los términos
function validateTerms(terms) {
    return terms.checked;
}

// Función para mostrar un mensaje de error
function showError(elementId, message) {
    const errorElement = document.getElementById(elementId);
    errorElement.textContent = message;
}

// Función para borrar los mensajes de error
function clearErrorMessages() {
    const errorMessages = document.querySelectorAll('.error-message');
    errorMessages.forEach((message) => message.textContent = '');
}

// Función principal para manejar la validación del formulario
function validateForm(event) {
    event.preventDefault();  // Evitar el envío del formulario

    clearErrorMessages();  // Limpiar mensajes de error

    let isValid = true;

    const firstName = document.getElementById('first-name').value;
    const lastName = document.getElementById('last-name').value;
    const email = document.getElementById('email').value;
    const phone = document.getElementById('phone').value;
    const birthdate = document.getElementById('birthdate').value;
    const password = document.getElementById('password').value;
    const confirmPassword = document.getElementById('confirm-password').value;
    const gender = document.getElementById('gender').value;
    const terms = document.getElementById('terms');

    // Validar nombre
    if (!validateName(firstName)) {
        showError('first-name-error', 'El nombre solo puede contener letras y espacios');
        isValid = false;
    }

    // Validar apellido
    if (!validateName(lastName)) {
        showError('last-name-error', 'El apellido solo puede contener letras y espacios');
        isValid = false;
    }

    // Validar correo electrónico
    if (!validateEmail(email)) {
        showError('email-error', 'El correo electrónico no es válido');
        isValid = false;
    }

    // Validar teléfono
    if (!validatePhone(phone)) {
        showError('phone-error', 'El teléfono debe tener 9 dígitos');
        isValid = false;
    }

    // Validar fecha de nacimiento
    if (!birthdate) {
        showError('birthdate-error', 'La fecha de nacimiento es obligatoria');
        isValid = false;
    }

    // Validar contraseña
    if (!validatePassword(password)) {
        showError('password-error', 'La contraseña debe tener al menos 6 caracteres');
        isValid = false;
    }

    // Validar confirmación de contraseña
    if (!validatePasswordConfirmation(password, confirmPassword)) {
        showError('confirm-password-error', 'Las contraseñas no coinciden');
        isValid = false;
    }

    // Validar género
    if (!gender) {
        showError('gender-error', 'Por favor, selecciona un género');
        isValid = false;
    }

    // Validar términos y condiciones
    if (!validateTerms(terms)) {
        showError('terms-error', 'Debes aceptar los términos y condiciones');
        isValid = false;
    }

    // Si todo es válido, enviar el formulario (en este caso solo mostramos un mensaje)
    if (isValid) {
        alert('Formulario enviado correctamente');
    }
}

// Asignar el evento al formulario
document.getElementById('registration-form').addEventListener('submit', validateForm);
