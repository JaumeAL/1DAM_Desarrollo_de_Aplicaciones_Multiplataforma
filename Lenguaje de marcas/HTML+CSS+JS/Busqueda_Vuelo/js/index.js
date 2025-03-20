document.addEventListener("DOMContentLoaded", function () {
    const formulario = document.querySelector("form");
    const fechaInicioInput = document.getElementById("FechaInicio");
    const fechaFinInput = document.getElementById("FechaFin");
    const numAdultosInput = document.getElementById("NumAdultos");
    const numNinosInput = document.getElementById("NumNiños");
    const origenInput = document.getElementById("Origen");
    const destinoInput = document.getElementById("Destino");

    if (formulario) {
        // Establecer la fecha mínima en el campo de fecha de inicio
        const hoy = new Date().toISOString().split("T")[0]; // Obtiene la fecha de hoy en formato YYYY-MM-DD

        formulario.addEventListener("submit", (event) => {
            event.preventDefault(); // Evita el envío del formulario por defecto

            // Obtener valores del formulario
            const fechaInicio = fechaInicioInput.value;
            const fechaFin = fechaFinInput.value;
            const numAdultos = numAdultosInput.value;
            const numNinos = numNinosInput.value;
            const origen = origenInput.value;
            const destino = destinoInput.value;
            
            // Validacion fecha de inicio
            if (fechaInicio < hoy) {
                alert("La fecha de inicio ya pasó");
                return;
            }
            // Validacion fecha fin
            if (fechaFin < hoy) {
                alert("La fecha de fin ya pasó");
                return;
            }
            if (fechaFin < fechaInicio) {
                alert("La fecha de fin tiene que ser mayor a la fecha de inicio");
                return;
            }
            // Validacion numero Adultos (aunque se podria usar "min" en el html)
            if (numAdultos < 1) {
                alert("Debe haber al menos 1 adulto ");
                return;
            }

            // Guardar en localStorage
            localStorage.setItem("origen", origen);
            localStorage.setItem("destino", destino);
            localStorage.setItem("fechaInicio", fechaInicio);
            localStorage.setItem("fechaFin", fechaFin);
            localStorage.setItem("numAdultos", numAdultos);
            localStorage.setItem("numNinos", numNinos);

            // Guardar en sessionStorage
            sessionStorage.setItem("origen", origen);
            sessionStorage.setItem("destino", destino);
            sessionStorage.setItem("fechaInicio", fechaInicio);
            sessionStorage.setItem("fechaFin", fechaFin);
            sessionStorage.setItem("numAdultos", numAdultos);
            sessionStorage.setItem("numNinos", numNinos);

            // Redirigir a resultado.html
            window.location.href = "resultado.html";
        });
    }
});