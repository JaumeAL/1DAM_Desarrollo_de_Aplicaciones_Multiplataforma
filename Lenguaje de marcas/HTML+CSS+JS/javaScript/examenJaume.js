
var contador = 0;
const final = 10;
function Contar() {
    if (contador < 10) {
        contador ++;
        document.getElementById("parrafo").textContent = contador;
        
    }else{
        document.getElementById("reiniciar").style.display ="flex";
        document.getElementById("contar").style.display ="none";
    }
    
}

function Reiniciar() {
    document.getElementById("parrafo").textContent = "0";
    contador = 0;
    document.getElementById("reiniciar").style.display ="none";
    document.getElementById("contar").style.display ="flex";    

}
