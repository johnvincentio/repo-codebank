#!/bin/sh
. ./classpath.sh
echo ${JAVA_HOME}/bin/java -classpath ./jai_codec.jar:./jai_core.jar:${CLASSPATH}  demo.activetree.print.saveas.SaveAsTIFFDemo1 $1
${JAVA_HOME}/bin/java -classpath ./jai_codec.jar:./jai_core.jar:${CLASSPATH}  demo.activetree.print.saveas.SaveAsTIFFDemo1 $1
