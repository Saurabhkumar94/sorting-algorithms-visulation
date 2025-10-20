@echo off
echo Compiling Java sources...
if exist bin rmdir /s /q bin
mkdir bin
javac -d bin src\core\*.java src\algorithms\*.java src\gui\*.java src\input\*.java src\theme\*.java src\utils\*.java
if errorlevel 1 (
  echo Compilation failed.
  pause
  exit /b 1
)
echo Copying resources...
xcopy /E /I "resources" "bin\resources" >nul
echo Running...
java -cp bin core.AppLauncher
pause
