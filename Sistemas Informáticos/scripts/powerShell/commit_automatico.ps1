# Cambia al directorio del repositorio
Set-Location -Path "C:\Users\JaumeAlbertSalasPast\OneDrive - Barcelo Hotel Group\Documentos\1DAM_Desarrollo_de_Aplicaciones_Multiplataforma"

# Verifica si el archivo existe, si no, lo crea
if (-Not (Test-Path "actividad_diaria.txt")) {
    New-Item -ItemType File -Path "actividad_diaria.txt" -Value "Archivo creado automáticamente el $(Get-Date)"
}

# Modifica el archivo
Add-Content "actividad_diaria.txt" (Get-Date)

# Realiza el commit y el push
git add actividad_diaria.txt
git commit -m "Commit diario automático: $(Get-Date)"
git push origin main