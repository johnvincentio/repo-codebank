Buildfile: build.xml

clean:
     [echo] Remove build and distributables...
   [delete] Deleting 1 files from /home/jv/workCapstone/Common4/src99/common/build
   [delete] Deleted 3 directories from /home/jv/workCapstone/Common4/src99/common/build
   [delete] Deleting 3 files from /home/jv/workCapstone/Common4/src99/common/dist
   [delete] Deleted 4 directories from /home/jv/workCapstone/Common4/src99/common/dist

mkdirs:
     [echo] Create directories...
    [mkdir] Created dir: /home/jv/workCapstone/Common4/src99/common/dist
    [mkdir] Created dir: /home/jv/workCapstone/Common4/src99/common/dist/contents
    [mkdir] Created dir: /home/jv/workCapstone/Common4/src99/common/build
    [mkdir] Created dir: /home/jv/workCapstone/Common4/src99/common/build/META-INF

compile:
     [echo] Compiling java...
    [javac] Compiling 1 source file to /home/jv/workCapstone/Common4/src99/common/build

build:
     [echo] Copying files from lib...

dist:
     [echo] Creating JAR file....
      [jar] Building jar: /home/jv/workCapstone/Common4/src99/common/dist/jar-common.jar
    [unjar] Expanding: /home/jv/workCapstone/Common4/src99/common/dist/jar-common.jar into /home/jv/workCapstone/Common4/src99/common/dist/contents

BUILD SUCCESSFUL
Total time: 5 seconds
build:
total 16
drwxrwxr-x    4 jv       jv           4096 Feb 23 22:19 .
drwxr-xr-x    6 jv       jv           4096 Feb 23 22:19 ..
drwxrwxr-x    2 jv       jv           4096 Feb 23 22:19 jvdebug
drwxrwxr-x    2 jv       jv           4096 Feb 23 22:19 META-INF

build/jvdebug:
total 12
drwxrwxr-x    2 jv       jv           4096 Feb 23 22:19 .
drwxrwxr-x    4 jv       jv           4096 Feb 23 22:19 ..
-rw-rw-r--    1 jv       jv           1990 Feb 23 22:19 Debug.class

build/META-INF:
total 8
drwxrwxr-x    2 jv       jv           4096 Feb 23 22:19 .
drwxrwxr-x    4 jv       jv           4096 Feb 23 22:19 ..

dist:
total 16
drwxrwxr-x    3 jv       jv           4096 Feb 23 22:19 .
drwxr-xr-x    6 jv       jv           4096 Feb 23 22:19 ..
drwxrwxr-x    4 jv       jv           4096 Feb 23 22:19 contents
-rw-rw-r--    1 jv       jv           1590 Feb 23 22:19 jar-common.jar

dist/contents:
total 16
drwxrwxr-x    4 jv       jv           4096 Feb 23 22:19 .
drwxrwxr-x    3 jv       jv           4096 Feb 23 22:19 ..
drwxrwxr-x    2 jv       jv           4096 Feb 23 22:19 jvdebug
drwxrwxr-x    2 jv       jv           4096 Feb 23 22:19 META-INF

dist/contents/jvdebug:
total 12
drwxrwxr-x    2 jv       jv           4096 Feb 23 22:19 .
drwxrwxr-x    4 jv       jv           4096 Feb 23 22:19 ..
-rw-rw-r--    1 jv       jv           1990 Feb 23 22:19 Debug.class

dist/contents/META-INF:
total 12
drwxrwxr-x    2 jv       jv           4096 Feb 23 22:19 .
drwxrwxr-x    4 jv       jv           4096 Feb 23 22:19 ..
-rw-rw-r--    1 jv       jv            134 Feb 23 22:19 MANIFEST.MF
