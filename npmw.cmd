@echo off
setlocal

set BUILD_DIR=%~dp0build
set NPM_SCRIPT=""

for /r %BUILD_DIR% %%x in (*npm-cli.js) do (
  Echo.%%x | findstr /C:"build\npm">nul && ( set NPM_SCRIPT=%%x ) 
)

if not exist %NPM_SCRIPT% (
  echo Npm not found! Run gradle build first!
) else (
  nodew.cmd %NPM_SCRIPT% %*
)
@echo on
