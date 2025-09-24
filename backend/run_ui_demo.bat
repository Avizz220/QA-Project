@echo off
echo Running UI Automation Demo
cd /d "%~dp0"
call mvn clean test-compile
echo.
echo Starting UI Automation...
call mvn exec:java
echo Demo completed!
pause