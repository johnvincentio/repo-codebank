REM	Using Apache's Xalan-Java XSLT Processor
@echo off 

REM Xalan includes its own version of Xerces parser.
REM This file assumes %XALAN_JARS% has been defined in xmlsetup as:
REM  set XALAN_JARS=%XALAN_HOME%\bin\xalan.jar;%XALAN_HOME%\bin\xml-apis.jar;%XALAN_HOME%\bin\xerces.jar
REM Could set Java classpath.
REM    set classpath=%JLIB%;%XALAN_JARS%
REM    set XSLT_CLASS=org.apache.xalan.xslt.Process
REM Run xalan. 
REM   %JBIN%\java -classpath %JLIB%;%XALAN_JARS% org.apache.xalan.xslt.Process -IN %1 -XSL %2 -OUT %3

@echo on
  %JBIN%\java -classpath %XALAN_JARS% org.apache.xalan.xslt.Process -IN %1 -XSL %2 -OUT %3  -PARAM sortLinks "no" -PARAM chapNum "10" -PARAM chapTitle "Displaying XML with CSS"
@echo off
REM   Append one of these choices to the end of the above java command line.
REM   -PARAM sortLinks "yes" -PARAM chapNum "10" -PARAM chapTitle "Displaying XML with CSS"
REM -PARAM sortLinks "yes" -PARAM chapNum "11" -PARAM chapTitle "Transforming XML Using XSLT and XPath"
REM -PARAM sortLinks "yes" -PARAM chapNum "9" -PARAM chapTitle "Parsing with JDOM and JAXP"
REM -PARAM sortLinks "no" -PARAM chapNum "11" -PARAM chapTitle "Transforming XML Using XSLT and XPath"
REM -PARAM sortLinks "yes" -PARAM chapNum "10" -PARAM chapTitle "Displaying XML with CSS"
REM -PARAM chapNum "10" -PARAM chapTitle "Displaying XML with CSS"


