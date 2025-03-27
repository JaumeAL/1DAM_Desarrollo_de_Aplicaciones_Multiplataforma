document.addEventListener("DOMContentLoaded", () => { // Espera a que el documento esté cargado
    const unitType = document.getElementById("unitType"); // Obtiene el elemento con id "unitType"
    const inputValue = document.getElementById("inputValue"); // Obtiene el elemento con id "inputValue"
    const convertButton = document.getElementById("convert"); // Obtiene el elemento con id "convert"
    const result = document.getElementById("result"); // Obtiene el elemento con id "result"

    convertButton.addEventListener("click", () => { // Agrega un evento al hacer click en el botón
        const value = parseFloat(inputValue.value); // Obtiene el valor del input y lo convierte a número
        if (isNaN(value)) {
            result.textContent = "Ingrese un número válido.";
            return;
        }

        let convertedValue = "";
        switch (unitType.value) {
            case "temp":
                convertedValue = `${value}°C = ${(value * 9/5 + 32).toFixed(2)}°F | ${value}°F = ${((value - 32) * 5/9).toFixed(2)}°C`;
                break;
            case "length":
                convertedValue = `${value} metros = ${(value / 1000).toFixed(3)} kilómetros | ${value} kilómetros = ${(value * 1000).toFixed(3)} metros`;
                break;
            case "currency":
                const conversionRate = 1.08; // Ejemplo fijo EUR a USD
                convertedValue = `${value} EUR = ${(value * conversionRate).toFixed(2)} USD | ${value} USD = ${(value / conversionRate).toFixed(2)} EUR`;
                break;
            default:
                convertedValue = "Selección no válida.";
        }

        result.textContent = convertedValue;
    });
});
