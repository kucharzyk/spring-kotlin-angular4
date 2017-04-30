@echo off
setlocal

set BUILD_DIR=%~dp0build
set YARN_SCRIPT=""

for /r %BUILD_DIR% %%x in (*yarn.js) do (
  set YARN_SCRIPT=%%x
) 

if not exist %YARN_SCRIPT% (
  echo Yarn not found! Run gradle build first!
) else (
  nodew.cmd %YARN_SCRIPT% %*
)
@echo on

