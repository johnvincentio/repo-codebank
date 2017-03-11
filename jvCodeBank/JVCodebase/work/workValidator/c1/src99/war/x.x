Buildfile: build.xml
     [echo] Initializing...
     [echo] /opt/SUNWappserver/jdk/bin:/opt/SUNWappserver/bin:/opt/apache-ant-1.6.0/bin:/home/jv/dbin:/usr/local/bin:/bin:/usr/bin:/usr/bin/X11:/usr/X11R6/bin
     [echo] .:/opt/SUNWappserver/lib/j2ee.jar

clean:
     [echo] Remove build and distributables...
   [delete] Deleting 38 files from /home/jv/workValidator/c1/src99/war/build
   [delete] Deleted 10 directories from /home/jv/workValidator/c1/src99/war/build
   [delete] Deleting 40 files from /home/jv/workValidator/c1/src99/war/dist
   [delete] Deleted 12 directories from /home/jv/workValidator/c1/src99/war/dist
   [delete] Deleting 15 files from /home/jv/workValidator/c1/src99/war/JSPtest
   [delete] Deleted 10 directories from /home/jv/workValidator/c1/src99/war/JSPtest

mkdirs:
     [echo] Create directories...
    [mkdir] Created dir: /home/jv/workValidator/c1/src99/war/dist
    [mkdir] Created dir: /home/jv/workValidator/c1/src99/war/dist/contents
    [mkdir] Created dir: /home/jv/workValidator/c1/src99/war/build
    [mkdir] Created dir: /home/jv/workValidator/c1/src99/war/build/WEB-INF
    [mkdir] Created dir: /home/jv/workValidator/c1/src99/war/build/WEB-INF/classes
    [mkdir] Created dir: /home/jv/workValidator/c1/src99/war/build/WEB-INF/lib

compile:
     [echo] Compiling java...
    [javac] Compiling 7 source files to /home/jv/workValidator/c1/src99/war/build/WEB-INF/classes

copyStrutsLibs:
     [echo] Copying Libs...
     [copy] Copying 10 files to /home/jv/workValidator/c1/src99/war/build/WEB-INF/lib
     [echo] Copying Tlds...
     [copy] Copying 6 files to /home/jv/workValidator/c1/src99/war/build/WEB-INF

copyLibs:

build:
     [echo] Copying WEB-INF/*.xml files...
     [copy] Copying 5 files to /home/jv/workValidator/c1/src99/war/build/WEB-INF
     [echo] Copying files from lib...
     [echo] Copying files from tags...
     [echo] Copying html, jsp, css, jpg etc files...
     [copy] Copying 8 files to /home/jv/workValidator/c1/src99/war/build
     [echo] Copying resources files...
     [copy] Copying 2 files to /home/jv/workValidator/c1/src99/war/build/WEB-INF/classes/resources

dist:
     [echo] Creating WAR file....
      [jar] Building jar: /home/jv/workValidator/c1/src99/war/dist/c1validator.war
    [unwar] Expanding: /home/jv/workValidator/c1/src99/war/dist/c1validator.war into /home/jv/workValidator/c1/src99/war/dist/contents

sun-webXML-2-4:
     [echo] Checking sun-web.xml for version 2.4
     [echo] Initializing...
     [echo] /opt/SUNWappserver/jdk/bin:/opt/SUNWappserver/bin:/opt/apache-ant-1.6.0/bin:/home/jv/dbin:/usr/local/bin:/bin:/usr/bin:/usr/bin/X11:/usr/X11R6/bin
     [echo] .:/opt/SUNWappserver/lib/j2ee.jar

XMLinit:

XMLExist:
     [echo] Checking /home/jv/workValidator/c1/src99/war/etc/sun-web.xml
     [java] start parsing a grammar.
     [java] validating /home/jv/workValidator/c1/src99/war/etc/sun-web.xml
     [java] the document is valid.



XMLNoExist:

XMLValidate:

webXML-2-4:
     [echo] Checking web.xml for version 2.4
     [echo] Initializing...
     [echo] /opt/SUNWappserver/jdk/bin:/opt/SUNWappserver/bin:/opt/apache-ant-1.6.0/bin:/home/jv/dbin:/usr/local/bin:/bin:/usr/bin:/usr/bin/X11:/usr/X11R6/bin
     [echo] .:/opt/SUNWappserver/lib/j2ee.jar

XMLinit:

XMLExist:
     [echo] Checking /home/jv/workValidator/c1/src99/war/etc/web.xml
     [java] start parsing a grammar.
     [java] validating /home/jv/workValidator/c1/src99/war/etc/web.xml
     [java] the document is valid.



XMLNoExist:

XMLValidate:

checkStrutsXML:
     [echo] Checking struts-config.xml
     [echo] Initializing...
     [echo] /opt/SUNWappserver/jdk/bin:/opt/SUNWappserver/bin:/opt/apache-ant-1.6.0/bin:/home/jv/dbin:/usr/local/bin:/bin:/usr/bin:/usr/bin/X11:/usr/X11R6/bin
     [echo] .:/opt/SUNWappserver/lib/j2ee.jar

XMLinit:

XMLExist:
     [echo] Checking /home/jv/workValidator/c1/src99/war/etc/struts-config.xml
     [java] start parsing a grammar.
     [java] validating /home/jv/workValidator/c1/src99/war/etc/struts-config.xml
     [java] the document is valid.



XMLNoExist:

XMLValidate:
     [echo] Checking tiles-defs.xml
     [echo] Initializing...
     [echo] /opt/SUNWappserver/jdk/bin:/opt/SUNWappserver/bin:/opt/apache-ant-1.6.0/bin:/home/jv/dbin:/usr/local/bin:/bin:/usr/bin:/usr/bin/X11:/usr/X11R6/bin
     [echo] .:/opt/SUNWappserver/lib/j2ee.jar

XMLinit:

XMLExist:

XMLNoExist:
     [echo] WARNING: /home/jv/workValidator/c1/src99/war/etc/tiles-defs.xml does not exist.

XMLValidate:
     [echo] Checking validation.xml
     [echo] Initializing...
     [echo] /opt/SUNWappserver/jdk/bin:/opt/SUNWappserver/bin:/opt/apache-ant-1.6.0/bin:/home/jv/dbin:/usr/local/bin:/bin:/usr/bin:/usr/bin/X11:/usr/X11R6/bin
     [echo] .:/opt/SUNWappserver/lib/j2ee.jar

XMLinit:

XMLExist:
     [echo] Checking /home/jv/workValidator/c1/src99/war/etc/validation.xml
     [java] start parsing a grammar.
     [java] validating /home/jv/workValidator/c1/src99/war/etc/validation.xml
     [java] the document is valid.



XMLNoExist:

XMLValidate:
     [echo] Checking validator-rules.xml
     [echo] Initializing...
     [echo] /opt/SUNWappserver/jdk/bin:/opt/SUNWappserver/bin:/opt/apache-ant-1.6.0/bin:/home/jv/dbin:/usr/local/bin:/bin:/usr/bin:/usr/bin/X11:/usr/X11R6/bin
     [echo] .:/opt/SUNWappserver/lib/j2ee.jar

XMLinit:

XMLExist:
     [echo] Checking /home/jv/workValidator/c1/src99/war/etc/validator-rules.xml
     [java] start parsing a grammar.
     [java] validating /home/jv/workValidator/c1/src99/war/etc/validator-rules.xml
     [java] the document is valid.



XMLNoExist:

XMLValidate:

checkXML:

precompileJSP_clean:
     [echo] Cleaning JSP Validate....

precompileJSP:
     [echo] Precompiling JSP to Java code...
    [mkdir] Created dir: /home/jv/workValidator/c1/src99/war/JSPtest
    [mkdir] Created dir: /home/jv/workValidator/c1/src99/war/JSPtest/java
    [mkdir] Created dir: /home/jv/workValidator/c1/src99/war/JSPtest/classes
    [mkdir] Created dir: /home/jv/workValidator/c1/src99/war/JSPtest/generated
     [java] Sep 1, 2004 8:47:51 PM org.apache.jasper.JspC processFile
     [java] INFO: Built File: /registration.jsp
     [java] Sep 1, 2004 8:47:52 PM org.apache.jasper.JspC processFile
     [java] INFO: Built File: /multiRegistration2.jsp
     [java] Sep 1, 2004 8:47:52 PM org.apache.jasper.JspC processFile
     [java] INFO: Built File: /index.jsp
     [java] Sep 1, 2004 8:47:53 PM org.apache.jasper.JspC processFile
     [java] INFO: Built File: /type.jsp
     [java] Sep 1, 2004 8:47:53 PM org.apache.jasper.JspC processFile
     [java] INFO: Built File: /multiRegistration1.jsp
     [java] Sep 1, 2004 8:47:53 PM org.apache.jasper.JspC processFile
     [java] INFO: Built File: /jsRegistration.jsp
     [java] Sep 1, 2004 8:47:54 PM org.apache.jasper.JspC processFile
     [java] INFO: Built File: /jsType.jsp



CompileJSP:
     [echo] Compiling translated JSP code...
    [javac] Compiling 7 source files to /home/jv/workValidator/c1/src99/war/JSPtest/classes

all:

BUILD SUCCESSFUL
Total time: 32 seconds
build:
total 48
drwxrwxr-x    3 jv       jv           4096 Sep  1 20:47 .
drwxrwxr-x   10 jv       jv           4096 Sep  1 20:47 ..
-rw-rw-r--    1 jv       jv           2480 Sep  1 20:47 index.jsp
-rw-rw-r--    1 jv       jv           3125 Sep  1 20:47 jsRegistration.jsp
-rw-rw-r--    1 jv       jv           3094 Sep  1 20:47 jsType.jsp
-rw-rw-r--    1 jv       jv           2146 Sep  1 20:47 multiRegistration1.jsp
-rw-rw-r--    1 jv       jv           2336 Sep  1 20:47 multiRegistration2.jsp
-rw-rw-r--    1 jv       jv           2818 Sep  1 20:47 registration.jsp
-rw-rw-r--    1 jv       jv           1798 Sep  1 20:47 struts-power.gif
-rw-rw-r--    1 jv       jv           4637 Sep  1 20:47 type.jsp
drwxrwxr-x    4 jv       jv           4096 Sep  1 20:47 WEB-INF

build/WEB-INF:
total 276
drwxrwxr-x    4 jv       jv           4096 Sep  1 20:47 .
drwxrwxr-x    3 jv       jv           4096 Sep  1 20:47 ..
drwxrwxr-x    4 jv       jv           4096 Sep  1 20:47 classes
drwxrwxr-x    2 jv       jv           4096 Sep  1 20:47 lib
-rw-rw-r--    1 jv       jv           8868 Sep  1 20:47 struts-bean.tld
-rw-rw-r--    1 jv       jv           4621 Sep  1 20:47 struts-config.xml
-rw-rw-r--    1 jv       jv          66192 Sep  1 20:47 struts-html.tld
-rw-rw-r--    1 jv       jv          14511 Sep  1 20:47 struts-logic.tld
-rw-rw-r--    1 jv       jv          64659 Sep  1 20:47 struts-nested.tld
-rw-rw-r--    1 jv       jv           1631 Sep  1 20:47 struts-template.tld
-rw-rw-r--    1 jv       jv           7850 Sep  1 20:47 struts-tiles.tld
-rw-rw-r--    1 jv       jv            283 Sep  1 20:47 sun-web.xml
-rw-rw-r--    1 jv       jv          17601 Sep  1 20:47 validation.xml
-rw-rw-r--    1 jv       jv          42268 Sep  1 20:47 validator-rules.xml
-rw-rw-r--    1 jv       jv           2140 Sep  1 20:47 web.xml

build/WEB-INF/classes:
total 16
drwxrwxr-x    4 jv       jv           4096 Sep  1 20:47 .
drwxrwxr-x    4 jv       jv           4096 Sep  1 20:47 ..
drwxrwxr-x    3 jv       jv           4096 Sep  1 20:47 org
drwxrwxr-x    2 jv       jv           4096 Sep  1 20:47 resources

build/WEB-INF/classes/org:
total 12
drwxrwxr-x    3 jv       jv           4096 Sep  1 20:47 .
drwxrwxr-x    4 jv       jv           4096 Sep  1 20:47 ..
drwxrwxr-x    3 jv       jv           4096 Sep  1 20:47 apache

build/WEB-INF/classes/org/apache:
total 12
drwxrwxr-x    3 jv       jv           4096 Sep  1 20:47 .
drwxrwxr-x    3 jv       jv           4096 Sep  1 20:47 ..
drwxrwxr-x    3 jv       jv           4096 Sep  1 20:47 struts

build/WEB-INF/classes/org/apache/struts:
total 12
drwxrwxr-x    3 jv       jv           4096 Sep  1 20:47 .
drwxrwxr-x    3 jv       jv           4096 Sep  1 20:47 ..
drwxrwxr-x    3 jv       jv           4096 Sep  1 20:47 webapp

build/WEB-INF/classes/org/apache/struts/webapp:
total 12
drwxrwxr-x    3 jv       jv           4096 Sep  1 20:47 .
drwxrwxr-x    3 jv       jv           4096 Sep  1 20:47 ..
drwxrwxr-x    2 jv       jv           4096 Sep  1 20:47 validator

build/WEB-INF/classes/org/apache/struts/webapp/validator:
total 36
drwxrwxr-x    2 jv       jv           4096 Sep  1 20:47 .
drwxrwxr-x    3 jv       jv           4096 Sep  1 20:47 ..
-rw-rw-r--    1 jv       jv            730 Sep  1 20:47 CityStateZip.class
-rw-rw-r--    1 jv       jv           1898 Sep  1 20:47 LocaleAction.class
-rw-rw-r--    1 jv       jv           2864 Sep  1 20:47 MultiRegistrationAction.class
-rw-rw-r--    1 jv       jv           2309 Sep  1 20:47 RegistrationAction.class
-rw-rw-r--    1 jv       jv           1523 Sep  1 20:47 RegistrationForm.class
-rw-rw-r--    1 jv       jv           2285 Sep  1 20:47 TypeAction.class
-rw-rw-r--    1 jv       jv           2110 Sep  1 20:47 TypeForm.class

build/WEB-INF/classes/resources:
total 16
drwxrwxr-x    2 jv       jv           4096 Sep  1 20:47 .
drwxrwxr-x    4 jv       jv           4096 Sep  1 20:47 ..
-rw-rw-r--    1 jv       jv           4005 Sep  1 20:47 ApplicationResources_fr.properties
-rw-rw-r--    1 jv       jv           3330 Sep  1 20:47 ApplicationResources.properties

build/WEB-INF/lib:
total 1152
drwxrwxr-x    2 jv       jv           4096 Sep  1 20:47 .
drwxrwxr-x    4 jv       jv           4096 Sep  1 20:47 ..
-rw-rw-r--    1 jv       jv         118726 Sep  1 20:47 commons-beanutils.jar
-rw-rw-r--    1 jv       jv         165119 Sep  1 20:47 commons-collections.jar
-rw-rw-r--    1 jv       jv         109096 Sep  1 20:47 commons-digester.jar
-rw-rw-r--    1 jv       jv          22379 Sep  1 20:47 commons-fileupload.jar
-rw-rw-r--    1 jv       jv          63980 Sep  1 20:47 commons-lang.jar
-rw-rw-r--    1 jv       jv          31605 Sep  1 20:47 commons-logging.jar
-rw-rw-r--    1 jv       jv          46865 Sep  1 20:47 commons-validator.jar
-rw-rw-r--    1 jv       jv          65368 Sep  1 20:47 jakarta-oro.jar
-rw-rw-r--    1 jv       jv         498051 Sep  1 20:47 struts.jar
-rw-rw-r--    1 jv       jv          10518 Sep  1 20:47 struts-legacy.jar
dist:
total 1036
drwxrwxr-x    3 jv       jv           4096 Sep  1 20:47 .
drwxrwxr-x   10 jv       jv           4096 Sep  1 20:47 ..
-rw-rw-r--    1 jv       jv        1041396 Sep  1 20:47 c1validator.war
drwxrwxr-x    4 jv       jv           4096 Sep  1 20:47 contents

dist/contents:
total 52
drwxrwxr-x    4 jv       jv           4096 Sep  1 20:47 .
drwxrwxr-x    3 jv       jv           4096 Sep  1 20:47 ..
-rw-rw-r--    1 jv       jv           2480 Sep  1 20:47 index.jsp
-rw-rw-r--    1 jv       jv           3125 Sep  1 20:47 jsRegistration.jsp
-rw-rw-r--    1 jv       jv           3094 Sep  1 20:47 jsType.jsp
drwxrwxr-x    2 jv       jv           4096 Sep  1 20:47 META-INF
-rw-rw-r--    1 jv       jv           2146 Sep  1 20:47 multiRegistration1.jsp
-rw-rw-r--    1 jv       jv           2336 Sep  1 20:47 multiRegistration2.jsp
-rw-rw-r--    1 jv       jv           2818 Sep  1 20:47 registration.jsp
-rw-rw-r--    1 jv       jv           1798 Sep  1 20:47 struts-power.gif
-rw-rw-r--    1 jv       jv           4637 Sep  1 20:47 type.jsp
drwxrwxr-x    4 jv       jv           4096 Sep  1 20:47 WEB-INF

dist/contents/META-INF:
total 12
drwxrwxr-x    2 jv       jv           4096 Sep  1 20:47 .
drwxrwxr-x    4 jv       jv           4096 Sep  1 20:47 ..
-rw-rw-r--    1 jv       jv            106 Sep  1 20:47 MANIFEST.MF

dist/contents/WEB-INF:
total 276
drwxrwxr-x    4 jv       jv           4096 Sep  1 20:47 .
drwxrwxr-x    4 jv       jv           4096 Sep  1 20:47 ..
drwxrwxr-x    4 jv       jv           4096 Sep  1 20:47 classes
drwxrwxr-x    2 jv       jv           4096 Sep  1 20:47 lib
-rw-rw-r--    1 jv       jv           8868 Sep  1 20:47 struts-bean.tld
-rw-rw-r--    1 jv       jv           4621 Sep  1 20:47 struts-config.xml
-rw-rw-r--    1 jv       jv          66192 Sep  1 20:47 struts-html.tld
-rw-rw-r--    1 jv       jv          14511 Sep  1 20:47 struts-logic.tld
-rw-rw-r--    1 jv       jv          64659 Sep  1 20:47 struts-nested.tld
-rw-rw-r--    1 jv       jv           1631 Sep  1 20:47 struts-template.tld
-rw-rw-r--    1 jv       jv           7850 Sep  1 20:47 struts-tiles.tld
-rw-rw-r--    1 jv       jv            283 Sep  1 20:47 sun-web.xml
-rw-rw-r--    1 jv       jv          17601 Sep  1 20:47 validation.xml
-rw-rw-r--    1 jv       jv          42268 Sep  1 20:47 validator-rules.xml
-rw-rw-r--    1 jv       jv           2140 Sep  1 20:47 web.xml

dist/contents/WEB-INF/classes:
total 16
drwxrwxr-x    4 jv       jv           4096 Sep  1 20:47 .
drwxrwxr-x    4 jv       jv           4096 Sep  1 20:47 ..
drwxrwxr-x    3 jv       jv           4096 Sep  1 20:47 org
drwxrwxr-x    2 jv       jv           4096 Sep  1 20:47 resources

dist/contents/WEB-INF/classes/org:
total 12
drwxrwxr-x    3 jv       jv           4096 Sep  1 20:47 .
drwxrwxr-x    4 jv       jv           4096 Sep  1 20:47 ..
drwxrwxr-x    3 jv       jv           4096 Sep  1 20:47 apache

dist/contents/WEB-INF/classes/org/apache:
total 12
drwxrwxr-x    3 jv       jv           4096 Sep  1 20:47 .
drwxrwxr-x    3 jv       jv           4096 Sep  1 20:47 ..
drwxrwxr-x    3 jv       jv           4096 Sep  1 20:47 struts

dist/contents/WEB-INF/classes/org/apache/struts:
total 12
drwxrwxr-x    3 jv       jv           4096 Sep  1 20:47 .
drwxrwxr-x    3 jv       jv           4096 Sep  1 20:47 ..
drwxrwxr-x    3 jv       jv           4096 Sep  1 20:47 webapp

dist/contents/WEB-INF/classes/org/apache/struts/webapp:
total 12
drwxrwxr-x    3 jv       jv           4096 Sep  1 20:47 .
drwxrwxr-x    3 jv       jv           4096 Sep  1 20:47 ..
drwxrwxr-x    2 jv       jv           4096 Sep  1 20:47 validator

dist/contents/WEB-INF/classes/org/apache/struts/webapp/validator:
total 36
drwxrwxr-x    2 jv       jv           4096 Sep  1 20:47 .
drwxrwxr-x    3 jv       jv           4096 Sep  1 20:47 ..
-rw-rw-r--    1 jv       jv            730 Sep  1 20:47 CityStateZip.class
-rw-rw-r--    1 jv       jv           1898 Sep  1 20:47 LocaleAction.class
-rw-rw-r--    1 jv       jv           2864 Sep  1 20:47 MultiRegistrationAction.class
-rw-rw-r--    1 jv       jv           2309 Sep  1 20:47 RegistrationAction.class
-rw-rw-r--    1 jv       jv           1523 Sep  1 20:47 RegistrationForm.class
-rw-rw-r--    1 jv       jv           2285 Sep  1 20:47 TypeAction.class
-rw-rw-r--    1 jv       jv           2110 Sep  1 20:47 TypeForm.class

dist/contents/WEB-INF/classes/resources:
total 16
drwxrwxr-x    2 jv       jv           4096 Sep  1 20:47 .
drwxrwxr-x    4 jv       jv           4096 Sep  1 20:47 ..
-rw-rw-r--    1 jv       jv           4005 Sep  1 20:47 ApplicationResources_fr.properties
-rw-rw-r--    1 jv       jv           3330 Sep  1 20:47 ApplicationResources.properties

dist/contents/WEB-INF/lib:
total 1152
drwxrwxr-x    2 jv       jv           4096 Sep  1 20:47 .
drwxrwxr-x    4 jv       jv           4096 Sep  1 20:47 ..
-rw-rw-r--    1 jv       jv         118726 Sep  1 20:47 commons-beanutils.jar
-rw-rw-r--    1 jv       jv         165119 Sep  1 20:47 commons-collections.jar
-rw-rw-r--    1 jv       jv         109096 Sep  1 20:47 commons-digester.jar
-rw-rw-r--    1 jv       jv          22379 Sep  1 20:47 commons-fileupload.jar
-rw-rw-r--    1 jv       jv          63980 Sep  1 20:47 commons-lang.jar
-rw-rw-r--    1 jv       jv          31605 Sep  1 20:47 commons-logging.jar
-rw-rw-r--    1 jv       jv          46865 Sep  1 20:47 commons-validator.jar
-rw-rw-r--    1 jv       jv          65368 Sep  1 20:47 jakarta-oro.jar
-rw-rw-r--    1 jv       jv         498051 Sep  1 20:47 struts.jar
-rw-rw-r--    1 jv       jv          10518 Sep  1 20:47 struts-legacy.jar
