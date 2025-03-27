// Función para validar el correo electrónico
function validarEmail(email) {
  const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
  return emailRegex.test(email);
}
// Función para validar el CP
function validarCP(codigoPostal) {
  const codigoPostalRegex = /^\d{5}$/;
  return codigoPostalRegex.test(codigoPostal);
}
// Función para validar que el usuario acepte el newsletter
function ValidarNewsletter(newsletter) {
  return newsletter.checked;
}

// Función principal para manejar la validación del formulario
function validateForm(event) {
  event.preventDefault(); // Evitar el envío del formulario

  let isValid = true;

  const nombre = document.getElementById("nombre").value;
  const fechaNacimiento = document.getElementById("fechaNacimiento").value;
  const email = document.getElementById("email").value;
  const ciudad = document.getElementById("ciudad").value;
  const codigoPostal = document.getElementById("codigoPostal").value;
  const categoria = document.getElementById("categoria").value;
  const newsletter = document.getElementById("newsletter");

  // Establecer la fecha mínima en el campo de fecha de inicio
  const hoy = new Date().toISOString().split("T")[0]; // Obtiene la fecha de hoy en formato YYYY-MM-DD

  // Validar nombre
  if (!nombre) {
    alert("nombre-error,El nombre no existe");
    isValid = false;
  }
  // Validar correo electrónico
  if (!validarEmail(email)) {
    alert("email-error ,El correo electrónico no es válido");
    isValid = false;
  }
  // Validar ciudad
  if (!ciudad) {
    alert("ciudad-error,La ciudad no existe");
    isValid = false;
  }
  // Validar Codigo postal
  if (!validarCP(codigoPostal)) {
    alert("codigoPostal-error ,El Codigo Postal debe tener 5 números");
    isValid = false;
  }
  // Validar categoria
  if (!categoria) {
    alert("categoria-error,La categoria no existe");
    isValid = false;
  }
  // Validacion fecha de inicio
  if (fechaNacimiento < hoy) {
    alert("fechaNacimiento-error ,La fecha de nacimiento ya pasó");
    isValid = false;
  }
  // Validar términos y condiciones
  if (!ValidarNewsletter(newsletter)) {
    alert("newsletter,Debes suscribirte");
    isValid = false;
  }

  // Si todo es válido, enviar el formulario (en este caso solo mostramos un mensaje)
  if (isValid) {
    // Guardar en sessionStorage
    sessionStorage.setItem("nombre", nombre);
    sessionStorage.setItem("fechaNacimiento", fechaNacimiento);
    sessionStorage.setItem("email", email);
    sessionStorage.setItem("ciudad", ciudad);
    sessionStorage.setItem("codigoPostal", codigoPostal);
    sessionStorage.setItem("categoria", categoria);
    sessionStorage.setItem("newsletter", newsletter);

    // Redirigir a perfil.html
    window.location.href = "perfil.html";
  }
}

// Asignar el evento al formulario
document.getElementById("registroForm").addEventListener("submit", validateForm);
