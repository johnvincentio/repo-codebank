@echo off

call .\classpath.bat
echo %JAVA_HOME%\bin\java -classpath ./jai_codec.jar;./jai_core.jar;%CLASSPATH%  demo.activetree.print.saveas.SaveAsTIFFDemo2  %1%
%JAVA_HOME%\bin\java -classpath ./jai_codec.jar;./jai_core.jar;%CLASSPATH%  demo.activetree.print.saveas.SaveAsTIFFDemo2 %1%

@echo off
