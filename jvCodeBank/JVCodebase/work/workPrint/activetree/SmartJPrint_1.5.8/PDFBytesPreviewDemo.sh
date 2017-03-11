#!/bin/sh
. ./pdf_print_classpath.sh
export arg1=$1
shift
export arg2=$1
echo ${JAVA_HOME}/bin/java demo.activetree.pdfprint.PrintPDFfromBytes $arg1 $arg2
${JAVA_HOME}/bin/java demo.activetree.pdfprint.PrintPDFfromBytes $arg1 $arg2
