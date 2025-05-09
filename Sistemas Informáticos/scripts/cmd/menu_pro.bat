@echo off
:MENU
cls
echo === MENU ===
echo 1. Create LOGS folder if not exists
echo 2. Generate 5 log files (overwrite)
echo 3. Append to all .log files
echo 4. Exit
set /p option=Choose an option:

if "%option%"=="1" (
    if not exist LOGS (
        mkdir LOGS
        echo Folder LOGS created.
    ) else (
        echo LOGS already exists.
    )
    pause
    goto MENU
)

if "%option%"=="2" (
    for /L %%i in (0,1,4) do (
        echo %USERNAME% - %DATE% %TIME% > LOGS\log_%%i.log
    )
    echo Files created and overwritten.
    pause
    goto MENU
)

if "%option%"=="3" (
    for %%f in (LOGS\*.log) do (
        echo %USERNAME% - %DATE% %TIME% >> %%f
    )
    echo Appended to all log files.
    pause
    goto MENU
)

if "%option%"=="4" (
    exit
)

echo Invalid option.
pause
goto MENU
