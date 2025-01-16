//calcular la media de 3 examenes
var nota1 = parseFloat(prompt("Introduce la nota del primer examen: "));
var nota2 = parseFloat(prompt("Introduce la segunda nota: "));
var nota3 = parseFloat(prompt("Introduce la tercera nota: "));

var media = (nota1 + nota2 + nota3) / 3;
alert("La media de las tres notas es: " + media); //por alerta
console.log("La media de las tres notas es: " + media); // por consola

const parrafo = document.getElementById('parrafo');
parrafo.textContent = media; // por pantalla

if (media < 5) {
    parrafo.textContent = media + " Suspendido";
    console.log("Suspendido");
} else if (media >= 5 && media < 7) {
    parrafo.textContent = media + " Aprobado";
    console.log("Aprobado");
} else if (media >= 7 && media < 9) {
    parrafo.textContent = media + " Notable";
    console.log("Notable");
} else {
    parrafo.textContent = media + " Sobresaliente";
    console.log("Sobresaliente");
}
