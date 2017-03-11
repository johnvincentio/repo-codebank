@echo off
if ""%JAVA_HOME%"" == """" goto SET_JAVA_HOME
goto start

:SET_JAVA_HOME
echo Set JAVA_HOME to point to a JVM installation, e.g. set JAVA_HOME=c:\j2sdk1.4.2
goto end

:end
exit 0

:start
set CLASSPATH=.;.\smartjcommon_1.7.jar;.\bcprov-jdk14-125.jar;.\jai_codec.jar;.\jai_core.jar;.\smartjpdf_1.0.1.jar;.\smartjpdf_demo.jar
echo Starting the demo...
