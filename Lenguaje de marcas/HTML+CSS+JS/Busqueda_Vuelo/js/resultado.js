document.addEventListener("DOMContentLoaded", function () {
    const origen = sessionStorage.getItem("origen");
    const destino = sessionStorage.getItem("destino");
    const fechaInicio = sessionStorage.getItem("fechaInicio");
    const fechaFin = sessionStorage.getItem("fechaFin");
    const numAdultos = sessionStorage.getItem("numAdultos");
    const numNinos = sessionStorage.getItem("numNinos");

    if (origen && destino && fechaInicio && fechaFin && numAdultos && numNinos) { // Si hay datos en sessionStorage
        const parrafos = document.querySelectorAll(".fila p");
        parrafos[0].textContent = origen;
        parrafos[1].textContent = destino;
        parrafos[2].textContent = fechaInicio;
        parrafos[3].textContent = fechaFin;
        parrafos[4].textContent = numAdultos;
        parrafos[5].textContent = numNinos;
    }
    // Limpiar sessionStorage
    localStorage.removeItem("origen");
    localStorage.removeItem("destino");
    localStorage.removeItem("fechaInicio");
    localStorage.removeItem("fechaFin");
    localStorage.removeItem("numAdultos");
    localStorage.removeItem("numNinos");

});