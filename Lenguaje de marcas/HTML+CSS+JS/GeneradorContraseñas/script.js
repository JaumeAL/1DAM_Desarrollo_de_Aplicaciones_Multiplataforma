// script.js

// Agrega un evento al botón "generate" para generar una contraseña cuando se haga clic
document.getElementById("generate").addEventListener("click", function() {
    // Obtiene los valores de los inputs del formulario
    const length = document.getElementById("length").value; // Longitud de la contraseña
    const includeUppercase = document.getElementById("uppercase").checked; // Incluir mayúsculas
    const includeNumbers = document.getElementById("numbers").checked; // Incluir números
    const includeSymbols = document.getElementById("symbols").checked; // Incluir símbolos

    // Genera la contraseña utilizando los parámetros seleccionados
    const password = generatePassword(length, includeUppercase, includeNumbers, includeSymbols);

    // Muestra la contraseña generada en el campo de texto
    document.getElementById("password").value = password;
});

// Función para generar una contraseña
function generatePassword(length, includeUppercase, includeNumbers, includeSymbols) {
    // Define los caracteres disponibles para la contraseña
    const lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz"; // Letras minúsculas
    const upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // Letras mayúsculas
    const numbers = "0123456789"; // Números
    const symbols = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/"; // Símbolos

    // Comienza con las letras minúsculas como base
    let characters = lowerCaseLetters;

    // Agrega caracteres adicionales según las opciones seleccionadas
    if (includeUppercase) characters += upperCaseLetters; // Agrega mayúsculas si está seleccionado
    if (includeNumbers) characters += numbers; // Agrega números si está seleccionado
    if (includeSymbols) characters += symbols; // Agrega símbolos si está seleccionado

    // Genera la contraseña aleatoria
    let password = "";
    for (let i = 0; i < length; i++) {
        // Selecciona un carácter aleatorio de la lista de caracteres disponibles
        password += characters.charAt(Math.floor(Math.random() * characters.length));
    }

    // Devuelve la contraseña generada
    return password;
}