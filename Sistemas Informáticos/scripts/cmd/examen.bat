@echo off
:menu
echo 1. Creates a folder called LOGS if not exists.
echo 2. Generates 5 “.log” files named “log_0.log” to “log_4.log” writing the current username, date and time inside each file. If the files exists, it overwrites the content.
echo 3. Reads all “.log” files in the directory and add a new line to the file with the current username, date and time inside each file.
echo 4. Exit

set /p opt=Choose:
if %opt%==1 goto createF
if %opt%==2 goto generate
if %opt%==3 goto reads
if %opt%==4 exit slir

echo Opcion invalida
pause
goto menu

:createF
if exist LOGS (
    echo El directorio ya existe
) else (
    echo Creando directorio...
    mkdir LOGS
)
pause
goto menu

:createF
if exist log_*.log (
    echo Sobreescribiendo...
    echo "%username%, %date%, %time%" >> log_0.log
    echo "%username%, %date%, %time%" >> log_1.log
    echo "%username%, %date%, %time%" >> log_2.log
    echo "%username%, %date%, %time%" >> log_3.log
    echo "%username%, %date%, %time%" >> log_4.log
) else (
    echo Creando directorios...
    echo "%username%, %date%, %time%" > log_0.log
    echo "%username%, %date%, %time%" > log_1.log
    echo "%username%, %date%, %time%" > log_2.log
    echo "%username%, %date%, %time%" > log_3.log
    echo "%username%, %date%, %time%" > log_4.log
)
pause
goto menu



:reads
if exist *.log (
    echo Reads...
    echo "%username%, %date%, %time%" >> log_0.log
    echo "%username%, %date%, %time%" >> log_1.log
    echo "%username%, %date%, %time%" >> log_2.log
    echo "%username%, %date%, %time%" >> log_3.log
    echo "%username%, %date%, %time%" >> log_4.log
) 
pause

:salir
echo Saliendo del programa...
pause
exit

