#2.Declare two numbers and calculate sum, product, and remainder.

$number1 = Read-Host "Introduce el primer numero"
$number2 = Read-Host "Introduce el segundo numero"

$sum = [int]$number1 + [int]$number2
$mult = [int]$number1 * [int]$number2
$resto = [int]$number1 % [int]$number2

Write-Host "Sum: $sum, Multiplicación: $mult, Remainder: $resto"

Pause
