@echo off
setlocal
set NG_SCRIPT=%~dp0node_modules\angular-cli\bin\ng
if not exist %NG_SCRIPT% (
  echo Angular c not found! Run gradle build first!
) else (
  nodew.cmd %NG_SCRIPT% %*
)
@echo on
