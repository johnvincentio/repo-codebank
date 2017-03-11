@echo off

call .\classpath.bat
echo %JAVA_HOME%\bin\java  demo.activetree.print.generic.SmartJPrint_ToPDFDemo2  %1%
%JAVA_HOME%\bin\java  demo.activetree.print.generic.SmartJPrint_ToPDFDemo2   %1%

@echo off
