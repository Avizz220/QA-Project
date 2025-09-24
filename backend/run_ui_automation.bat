@echo off
echo Running UI Automation Demo
cd %~dp0
call mvn clean compile
set CLASSPATH=%~dp0target\classes;%~dp0target\test-classes;%USERPROFILE%\.m2\repository\org\seleniumhq\selenium\selenium-api\4.16.1\selenium-api-4.16.1.jar;%USERPROFILE%\.m2\repository\org\seleniumhq\selenium\selenium-chrome-driver\4.16.1\selenium-chrome-driver-4.16.1.jar;%USERPROFILE%\.m2\repository\org\seleniumhq\selenium\selenium-chromium-driver\4.16.1\selenium-chromium-driver-4.16.1.jar;%USERPROFILE%\.m2\repository\org\seleniumhq\selenium\selenium-json\4.16.1\selenium-json-4.16.1.jar;%USERPROFILE%\.m2\repository\org\seleniumhq\selenium\selenium-manager\4.16.1\selenium-manager-4.16.1.jar;%USERPROFILE%\.m2\repository\org\seleniumhq\selenium\selenium-support\4.16.1\selenium-support-4.16.1.jar;%USERPROFILE%\.m2\repository\org\seleniumhq\selenium\selenium-remote-driver\4.16.1\selenium-remote-driver-4.16.1.jar;%USERPROFILE%\.m2\repository\io\github\bonigarcia\webdrivermanager\5.6.2\webdrivermanager-5.6.2.jar;%USERPROFILE%\.m2\repository\com\google\guava\guava\32.1.2-jre\guava-32.1.2-jre.jar
echo Starting UI Automation...
java com.taskmanager.ui.StandaloneUIAutomation
pause