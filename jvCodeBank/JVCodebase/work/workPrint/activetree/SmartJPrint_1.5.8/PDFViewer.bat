@echo off

call .\pdf_print_classpath.bat
echo %JAVA_HOME%\bin\java  demo.activetree.pdfprint.PdfViewer  %1%
%JAVA_HOME%\bin\java demo.activetree.pdfprint.PdfViewer  %1%

@echo off
