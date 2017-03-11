REM	Using Apache's Xalan-Java XSLT Processor
@echo off
REM Adjust JBIN, JLIB, and XALAN as per your configuration.

set JBIN=C:\JAVA\jdk1.3\bin
set JLIB=C:\JAVA\jdk1.3\lib

set XALAN=C:\XML\APACHE\xalan-j_2_0_1\bin
set XSLT_CLASS=org.apache.xalan.xslt.Process

set XSLT=%XALAN%\xalan.jar
set PARSER=%XALAN%\xerces.jar

REM Samples only needed to experiment with Xalan.
REM set SAMPLES=%XALAN%\xalansamples.jar
REM set classpath=%JLIB%;%SAMPLES%;%PARSER%;%XSLT%

REM Classpath without Samples
set classpath=%JLIB%;%PARSER%;%XSLT%

REM Run xalan. 
REM -DIAG option is useful to see how long the transformation takes.
@echo on
  %JBIN%\java %XSLT_CLASS% -IN %1 -XSL %2 -OUT %3 -DIAG
@echo off
REM To Use Samples
REM %JBIN%\java  %1 %2 %3 

