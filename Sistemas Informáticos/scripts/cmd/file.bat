@echo off 
set /p fileName=Introduce el nombre de la carpeta:
if exist "%fileName%" (
    echo El archivo %fileName% ya existe.
)else(
    echo El archivo %fileName% no existe.
)
pause