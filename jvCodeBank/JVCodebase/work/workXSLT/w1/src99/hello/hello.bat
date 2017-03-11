REM	Use xalan XSLT Processor
@echo off
set JBIN=C:\JAVA\jdk1.3\bin
set JLIB=C:\JAVA\jdk1.3\lib

rem set XERCES=C:\XML\APACHE\xerces-1_2_1
set XALAN=C:\XML\APACHE\xalan-j_1_2_1

set XSLT_CLASS=org.apache.xalan.xslt.Process

set XSLT=%XALAN%\xalan.jar
set PARSER=%XALAN%\xerces.jar
REM set SAMPLES=%XALAN%\samples\xalansamples.jar

REM set classpath=%JLIB%;%PARSER%;%XSLT%;%SAMPLES%
set classpath=%JLIB%;%PARSER%;%XSLT%

rem Compile program
rem %JBIN%\javac %1.java 

rem Run xalan
rem Note that output is expected to be XML, not HTML
@echo on
 %JBIN%\java %XSLT_CLASS% -IN hello.xml -XSL %1.xsl -OUT %1.xml 


@echo off

