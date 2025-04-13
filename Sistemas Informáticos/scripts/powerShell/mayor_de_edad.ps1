#6.Ask for age and print a message based on whether they are under 18 or not.

$edad = Read-Host "¿Cuál es tu edad?"
if ([int]$edad -lt 18) {
    Write-Host "Eres menor de edad."
} else {
    Write-Host "Eres mayor de edad."
}
Pause