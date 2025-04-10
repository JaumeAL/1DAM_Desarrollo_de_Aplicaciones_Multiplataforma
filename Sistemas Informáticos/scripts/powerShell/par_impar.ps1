#3.Create a script that asks for a number and says if it is even or odd.


for ($i = 1; $i -le 10; $i++) {
    $numero = Read-Host "Introduce un numero"

    if ([int]$numero % 2 -eq 0) {
        Write-Host "$numero es par"
    } else {
        Write-Host "$numero es impar"
    }

}

Pause