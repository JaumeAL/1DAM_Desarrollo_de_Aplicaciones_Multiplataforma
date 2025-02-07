// Objetos literales
const persona = {
    nombre: "Juan",
    apellido: "García",
    edad: 25,
    saludar: function(){
        console.log("Hola, soy " + this.nombre + " " + this.apellido + " y tengo " + this.edad + " años.");
    }
};

// Crear objetos con la función constructora Object
const persona2 = new Object();
persona2.nombre = "Ana";
persona2.apellido = "Martínez";
persona2.edad = 30;
persona2.saludar = function(){
    console.log("Hola, soy " + this.nombre + " " + this.apellido + " y tengo " + this.edad + " años.");
};

