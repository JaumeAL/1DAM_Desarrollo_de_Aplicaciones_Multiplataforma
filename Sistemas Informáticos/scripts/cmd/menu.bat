@echo off
:menu
echo 1. Mostrar computer name
echo 2. Mostrar usuario
echo 3. Mostrar fecha y hora
echo 4. Salir

set /p opcion=Elige una opcion: 

if "%opcion%"=="1" goto computername
if "%opcion%"=="2" goto usuario
if "%opcion%"=="3" goto dateandtime
if "%opcion%"=="4" goto salir

echo Opcion invalida
pause
goto menu

:computername
echo Computer Name: %computername%
pause
goto menu

:usuario
echo User name: %username%
pause
goto menu

:dateandtime
echo Fecha y hora: %date% %time%
pause
goto menu

:salir
echo Saliendo del programa...
pause
exit