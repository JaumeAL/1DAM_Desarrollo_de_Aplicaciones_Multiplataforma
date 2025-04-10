@echo off
set /a contador=1
:loop
echo contador: %contador%
set /a contador=%contador%+1
if %contador% LEQ 10 goto loop
echo Loop completado!
pause

