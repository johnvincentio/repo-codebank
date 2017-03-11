@echo off

call .\classpath.bat
echo %JAVA_HOME%\bin\java  demo.activetree.print.rtf.WordProcessor   %1%
%JAVA_HOME%\bin\java  demo.activetree.print.rtf.WordProcessor  %1%

@echo off