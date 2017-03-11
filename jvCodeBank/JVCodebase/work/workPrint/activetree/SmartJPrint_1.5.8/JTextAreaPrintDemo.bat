@echo off

call .\classpath.bat
echo %JAVA_HOME%\bin\java  demo.activetree.print.textarea.JTextAreaPrintDemo  %1%
%JAVA_HOME%\bin\java  demo.activetree.print.textarea.JTextAreaPrintDemo  %1%

@echo off