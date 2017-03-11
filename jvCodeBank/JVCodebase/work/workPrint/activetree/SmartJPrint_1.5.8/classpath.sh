#!/bin/sh
# Make sure prerequisite environment variables are set
if [ -z "$JAVA_HOME" ]; then
  echo "The JAVA_HOME environment variable is not defined"
  echo "This environment variable is needed to run this program"
  exit 1
fi
export CLASSPATH=.:./smartjcommon_1.7.jar:./smartjprint_1.5.8.jar:./smartjprint_demo.jar
