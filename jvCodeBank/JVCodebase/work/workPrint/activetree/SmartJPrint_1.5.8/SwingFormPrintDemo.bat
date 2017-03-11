@echo off

call .\classpath.bat
echo %JAVA_HOME%\bin\java  demo.activetree.print.component.SwingFormPrintDemo  %1%
%JAVA_HOME%\bin\java  demo.activetree.print.component.SwingFormPrintDemo  %1%

@echo off