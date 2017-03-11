#!/bin/sh
. ./classpath.sh
echo ${JAVA_HOME}/bin/java  demo.activetree.print.html.HTMLBrowser $1
${JAVA_HOME}/bin/java  demo.activetree.print.html.HTMLBrowser $1
