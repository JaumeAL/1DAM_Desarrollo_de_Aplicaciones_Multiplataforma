function sumar(){
    let num1 = parseFloat(document.forms["form1"]["num1"].value);
    let num2 = parseFloat(document.forms["form1"]["num2"].value);
    if (num1 == 0 || num2 == 0){
    alert("Introduïu dos números diferents de 0");
    return false;
    } else {
    alert("Resultat: " + parseFloat(num1 + num2));
    return true;
    }
    }