let numeroAleatorio;
let maxNumero;
var contador = 0;

function jugar() {
  const niveles = document.getElementsByName("nivel");
  let nivelSeleccionado = null;

  for (const nivel of niveles) {
    if (nivel.checked) {
      nivelSeleccionado = nivel.value;
      break;
    }
  }

  if (nivelSeleccionado) {
    document.getElementById("inicial").style.display = "none";
    document.getElementById("juego").style.display = "block";

    switch (nivelSeleccionado) {
      case "facil":
        maxNumero = 10;
        break;
      case "medio":
        maxNumero = 50;
        break;
      case "dificil":
        maxNumero = 100;
        break;
    }

    numeroAleatorio = Math.floor(Math.random() * maxNumero) + 1; 

    document.getElementById("subtitulo").innerText = `Nivel: ${nivelSeleccionado} - Adivina el número entre 1 y ${maxNumero}`;
  } else {
    alert("selecciona un nivel para jugar.");
  }
}

function comprobar() {
  const numJugador = parseInt(document.getElementById("inputNumero").value);

    if (numJugador < 1 || numJugador > maxNumero) { // Comprobar si el numero esta entre 1 y maxNumero
        document.getElementById("mensaje").innerText = "El número debe estar entre 1 y "+maxNumero;
        document.getElementById("mensaje").style.color = "#c60909";
    return;
    }
    if (isNaN(numJugador)) { // Comprobar si es un numero
        document.getElementById("mensaje").innerText = "Introduce un número valido";
        document.getElementById("mensaje").style.color = "#c60909";
    return;
    }

    if (numJugador === numeroAleatorio) { 
        document.getElementById("mensaje").innerText = "¡Has acertado en "+(contador+1)+" intentos!";
        document.getElementById("mensaje").style.color = "green";
        document.getElementById("inputNumero").value = "";
    } else if (numJugador < numeroAleatorio) {
        document.getElementById("mensaje").innerText = "El número es mayor que "+numJugador+" ↑";
        document.getElementById("mensaje").style.color = "#c60909";
        document.getElementById("inputNumero").value = "";
        contador++;
    } else {
        document.getElementById("mensaje").innerText = "El número es menor que "+numJugador+" ↓";
        document.getElementById("mensaje").style.color = "#c60909";
        document.getElementById("inputNumero").value = "";
        contador++;
    }
}

function reiniciar() { // Reiniciar los valores necesarios
  document.getElementById("juego").style.display = "none";
  document.getElementById("inicial").style.display = "block";
  document.getElementById("mensaje").innerText = "";
  document.getElementById("inputNumero").value = "";
    contador = 0;
}