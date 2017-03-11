@echo off

call .\classpath.bat
echo %JAVA_HOME%\bin\java  demo.activetree.print.table.PrintSimpleTableDemo  %1%
%JAVA_HOME%\bin\java  demo.activetree.print.table.PrintSimpleTableDemo   %1%

@echo off