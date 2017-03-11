Buildfile: build.xml

clean:
     [echo] Remove build and distributables...
   [delete] Deleting 11 files from /home/jv/workCapstone/Common3/src99/common/build
   [delete] Deleted 3 directories from /home/jv/workCapstone/Common3/src99/common/build
   [delete] Deleting 13 files from /home/jv/workCapstone/Common3/src99/common/dist
   [delete] Deleted 4 directories from /home/jv/workCapstone/Common3/src99/common/dist

mkdirs:
     [echo] Create directories...
    [mkdir] Created dir: /home/jv/workCapstone/Common3/src99/common/dist
    [mkdir] Created dir: /home/jv/workCapstone/Common3/src99/common/dist/contents
    [mkdir] Created dir: /home/jv/workCapstone/Common3/src99/common/build
    [mkdir] Created dir: /home/jv/workCapstone/Common3/src99/common/build/META-INF

compile:
     [echo] Compiling java...
    [javac] Compiling 11 source files to /home/jv/workCapstone/Common3/src99/common/build

build:
     [echo] Copying files from lib...

dist:
     [echo] Creating JAR file....
      [jar] Building jar: /home/jv/workCapstone/Common3/src99/common/dist/jar-common.jar
    [unjar] Expanding: /home/jv/workCapstone/Common3/src99/common/dist/jar-common.jar into /home/jv/workCapstone/Common3/src99/common/dist/contents

BUILD SUCCESSFUL
Total time: 6 seconds
build:
total 16
drwxrwxr-x    4 jv       jv           4096 Feb 23 22:18 .
drwxr-xr-x    6 jv       jv           4096 Feb 23 22:17 ..
drwxrwxr-x    2 jv       jv           4096 Feb 23 22:18 jvtemplate
drwxrwxr-x    2 jv       jv           4096 Feb 23 22:17 META-INF

build/jvtemplate:
total 52
drwxrwxr-x    2 jv       jv           4096 Feb 23 22:18 .
drwxrwxr-x    4 jv       jv           4096 Feb 23 22:18 ..
-rw-rw-r--    1 jv       jv            694 Feb 23 22:18 JVBody.class
-rw-rw-r--    1 jv       jv            283 Feb 23 22:18 JVColumn.class
-rw-rw-r--    1 jv       jv            320 Feb 23 22:18 JVFooter.class
-rw-rw-r--    1 jv       jv            320 Feb 23 22:18 JVHeader.class
-rw-rw-r--    1 jv       jv            692 Feb 23 22:18 JVMenu.class
-rw-rw-r--    1 jv       jv            370 Feb 23 22:18 JVPair.class
-rw-rw-r--    1 jv       jv            505 Feb 23 22:18 JVSubBody.class
-rw-rw-r--    1 jv       jv            641 Feb 23 22:18 JVSubMenu.class
-rw-rw-r--    1 jv       jv           1031 Feb 23 22:18 JVTabs.class
-rw-rw-r--    1 jv       jv            637 Feb 23 22:18 JVTabsItems.class
-rw-rw-r--    1 jv       jv           1094 Feb 23 22:18 JVTemplate.class

build/META-INF:
total 8
drwxrwxr-x    2 jv       jv           4096 Feb 23 22:17 .
drwxrwxr-x    4 jv       jv           4096 Feb 23 22:18 ..

dist:
total 20
drwxrwxr-x    3 jv       jv           4096 Feb 23 22:18 .
drwxr-xr-x    6 jv       jv           4096 Feb 23 22:17 ..
drwxrwxr-x    4 jv       jv           4096 Feb 23 22:18 contents
-rw-rw-r--    1 jv       jv           5604 Feb 23 22:18 jar-common.jar

dist/contents:
total 16
drwxrwxr-x    4 jv       jv           4096 Feb 23 22:18 .
drwxrwxr-x    3 jv       jv           4096 Feb 23 22:18 ..
drwxrwxr-x    2 jv       jv           4096 Feb 23 22:18 jvtemplate
drwxrwxr-x    2 jv       jv           4096 Feb 23 22:18 META-INF

dist/contents/jvtemplate:
total 52
drwxrwxr-x    2 jv       jv           4096 Feb 23 22:18 .
drwxrwxr-x    4 jv       jv           4096 Feb 23 22:18 ..
-rw-rw-r--    1 jv       jv            694 Feb 23  2005 JVBody.class
-rw-rw-r--    1 jv       jv            283 Feb 23  2005 JVColumn.class
-rw-rw-r--    1 jv       jv            320 Feb 23  2005 JVFooter.class
-rw-rw-r--    1 jv       jv            320 Feb 23  2005 JVHeader.class
-rw-rw-r--    1 jv       jv            692 Feb 23  2005 JVMenu.class
-rw-rw-r--    1 jv       jv            370 Feb 23  2005 JVPair.class
-rw-rw-r--    1 jv       jv            505 Feb 23  2005 JVSubBody.class
-rw-rw-r--    1 jv       jv            641 Feb 23  2005 JVSubMenu.class
-rw-rw-r--    1 jv       jv           1031 Feb 23  2005 JVTabs.class
-rw-rw-r--    1 jv       jv            637 Feb 23  2005 JVTabsItems.class
-rw-rw-r--    1 jv       jv           1094 Feb 23  2005 JVTemplate.class

dist/contents/META-INF:
total 12
drwxrwxr-x    2 jv       jv           4096 Feb 23 22:18 .
drwxrwxr-x    4 jv       jv           4096 Feb 23 22:18 ..
-rw-rw-r--    1 jv       jv            134 Feb 23 22:18 MANIFEST.MF
