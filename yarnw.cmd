@echo off
setlocal
set YARN_SCRIPT=%~dp0build\yarn\node_modules\yarn\bin\yarn.js
if not exist %YARN_SCRIPT% (
  echo Node not found! Run gradle build first!
) else (
  nodew.cmd %YARN_SCRIPT% %*
)
@echo on
