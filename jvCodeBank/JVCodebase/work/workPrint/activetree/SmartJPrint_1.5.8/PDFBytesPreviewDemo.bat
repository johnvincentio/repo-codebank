@echo off

call .\pdf_print_classpath.bat
set arg1=%1%
shift
set arg2=%1%
echo %JAVA_HOME%\bin\java  demo.activetree.pdfprint.PrintPDFfromBytes  %arg1% %arg2%
%JAVA_HOME%\bin\java demo.activetree.pdfprint.PrintPDFfromBytes  %arg1% %arg2%

@echo off