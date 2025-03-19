document.addEventListener("DOMContentLoaded", function () {
    const datosVuelo = JSON.parse(localStorage.getItem("datosVuelo"));

    if (datosVuelo) {
        const parrafos = document.querySelectorAll(".fila p");
        parrafos[0].textContent = datosVuelo.origen;
        parrafos[1].textContent = datosVuelo.destino;
        parrafos[2].textContent = datosVuelo.fechaInicio;
        parrafos[3].textContent = datosVuelo.fechaFin;
        parrafos[4].textContent = datosVuelo.numAdultos;
        parrafos[5].textContent = datosVuelo.numNiños;
    }
});
