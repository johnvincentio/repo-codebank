@echo off

call .\classpath.bat
echo %JAVA_HOME%\bin\java  demo.activetree.print.postscript.Java2PostScriptPrinterDemo1  %1%
%JAVA_HOME%\bin\java  demo.activetree.print.postscript.Java2PostScriptPrinterDemo1  %1%

@echo off
