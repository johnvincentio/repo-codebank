#!/bin/sh

. ./classpath.sh
echo ${JAVA_HOME}/bin/java  demo.activetree.print.generic.PDFgenImageTextPagebreak  $1
${JAVA_HOME}/bin/java  demo.activetree.print.generic.PDFgenImageTextPagebreak  $1
