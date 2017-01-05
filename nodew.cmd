@echo off
setlocal
set NODE_EXE=""
for /r %%x in (*node.exe) do set NODE_EXE=%%x
set NODE_HOME=%NODE_EXE:node.exe=%
set PATH=%NODE_HOME%;%PATH%
if not exist %NODE_EXE% (
  echo Node not found! Run gradle build first!
) else (
  %NODE_EXE% %*
)
@echo on
