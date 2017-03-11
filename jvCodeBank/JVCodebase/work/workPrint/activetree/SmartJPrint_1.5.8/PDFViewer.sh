#!/bin/sh
. ./pdf_print_classpath.sh
echo ${JAVA_HOME}/bin/java demo.activetree.pdfprint.PdfViewer $1
${JAVA_HOME}/bin/java demo.activetree.pdfprint.PdfViewer $1
