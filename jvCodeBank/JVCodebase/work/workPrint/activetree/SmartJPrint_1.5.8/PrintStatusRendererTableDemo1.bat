@echo off

call .\classpath.bat
echo %JAVA_HOME%\bin\java  demo.activetree.print.table.PrintStatusRendererTable  %1%
%JAVA_HOME%\bin\java  demo.activetree.print.table.PrintStatusRendererTable   %1%

@echo off