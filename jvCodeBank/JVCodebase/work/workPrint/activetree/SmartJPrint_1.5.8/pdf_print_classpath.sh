#!/bin/sh
# Make sure prerequisite environment variables are set
if [ -z "$JAVA_HOME" ]; then
  echo "The JAVA_HOME environment variable is not defined"
  echo "This environment variable is needed to run this program"
  exit 1
fi
export CLASSPATH=.:./smartjcommon_1.7.jar:./bcprov-jdk14-125.jar:./jai_codec.jar:./jai_core.jar:./smartjpdf_1.0.1.jar:./smartjpdf_demo.jar
