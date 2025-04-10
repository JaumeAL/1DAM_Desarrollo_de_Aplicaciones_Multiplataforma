#3.Create a script that asks for a number and says if it is even or odd.

    $numero = Read-Host "Introduce un numero"

    if ([int]$numero % 2 -eq 0) {
        Write-Host "$numero es par"
    } else {
        Write-Host "$numero es impar"
    }

Pause