function agregar() {
  var imagen = document.getElementById("inputImagen").value;
  var galeria = document.getElementById("galeria");
  var nuevaFoto = document.createElement("span");
  nuevaFoto.className = "contenedor-foto"; 
  galeria.style.display = "block"; 

  var foto = document.createElement("img");
  foto.src = imagen;
  foto.style.margin = "10px";
  nuevaFoto.appendChild(foto);
  galeria.appendChild(nuevaFoto);
  //BOTON BORRAR
  var boton = document.createElement("button");
  boton.innerHTML = "X";
  boton.className = "boton-borrar"; 
  boton.onclick = function() {
    galeria.removeChild(nuevaFoto);
  }
  nuevaFoto.appendChild(boton);
//BOTON BORDE
  var botonBorde = document.createElement("button");
  botonBorde.innerHTML = "Borde";
  botonBorde.className = "boton-borde"; 
  botonBorde.onclick = function() {
    var colores = ["red", "blue", "green", "yellow", "purple", "pink", "orange"];
    var color = colores[Math.floor(Math.random() * colores.length)];
    foto.style.border = "5px solid " + color;
  }
  nuevaFoto.appendChild(botonBorde);
}