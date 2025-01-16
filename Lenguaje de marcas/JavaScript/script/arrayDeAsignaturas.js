var primero = ["Lenguajes", "Sistemas", "Programación", "Entornos", "Base de Datos"];
var segundo = ["Sistemas de gestión", "Interficies", "Programación multimedia", "Programación de servicios", "Acceso de Datos"];

var todo = [primero,segundo];

console.log(todo);

var user = prompt("Introduce una nueva asignatura de primero.")
primero.push(user);
console.log(primero);