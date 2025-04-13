#Create a script that checks if a file called log.txt exists. If not, it creates it.

$filePath = "C:\log.txt"
if (Test-Path $filePath) {
    Write-Host "El archivo log.txt ya existe."
} else {
    New-Item -Path $filePath -ItemType File
    Write-Host "El archivo log.txt ha sido creado."
}