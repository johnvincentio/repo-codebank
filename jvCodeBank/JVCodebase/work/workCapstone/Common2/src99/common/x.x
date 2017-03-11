Buildfile: build.xml

clean:
     [echo] Remove build and distributables...
   [delete] Deleted 2 directories from /home/jv/workCapstone/Common2/src99/common/build
   [delete] Deleting 2 files from /home/jv/workCapstone/Common2/src99/common/dist
   [delete] Deleted 3 directories from /home/jv/workCapstone/Common2/src99/common/dist

mkdirs:
     [echo] Create directories...
    [mkdir] Created dir: /home/jv/workCapstone/Common2/src99/common/dist
    [mkdir] Created dir: /home/jv/workCapstone/Common2/src99/common/dist/contents
    [mkdir] Created dir: /home/jv/workCapstone/Common2/src99/common/build
    [mkdir] Created dir: /home/jv/workCapstone/Common2/src99/common/build/META-INF

compile:
     [echo] Compiling java...

build:
     [echo] Copying files from lib...

dist:
     [echo] Creating JAR file....
      [jar] Building jar: /home/jv/workCapstone/Common2/src99/common/dist/jar-common.jar
    [unjar] Expanding: /home/jv/workCapstone/Common2/src99/common/dist/jar-common.jar into /home/jv/workCapstone/Common2/src99/common/dist/contents

BUILD SUCCESSFUL
Total time: 3 seconds
build:
total 12
drwxrwxr-x    3 jv       jv           4096 Feb 23 22:17 .
drwxr-xr-x    6 jv       jv           4096 Feb 23 22:17 ..
drwxrwxr-x    2 jv       jv           4096 Feb 23 22:17 META-INF

build/META-INF:
total 8
drwxrwxr-x    2 jv       jv           4096 Feb 23 22:17 .
drwxrwxr-x    3 jv       jv           4096 Feb 23 22:17 ..

dist:
total 16
drwxrwxr-x    3 jv       jv           4096 Feb 23 22:17 .
drwxr-xr-x    6 jv       jv           4096 Feb 23 22:17 ..
drwxrwxr-x    3 jv       jv           4096 Feb 23 22:17 contents
-rw-rw-r--    1 jv       jv            348 Feb 23 22:17 jar-common.jar

dist/contents:
total 12
drwxrwxr-x    3 jv       jv           4096 Feb 23 22:17 .
drwxrwxr-x    3 jv       jv           4096 Feb 23 22:17 ..
drwxrwxr-x    2 jv       jv           4096 Feb 23  2005 META-INF

dist/contents/META-INF:
total 12
drwxrwxr-x    2 jv       jv           4096 Feb 23  2005 .
drwxrwxr-x    3 jv       jv           4096 Feb 23 22:17 ..
-rw-rw-r--    1 jv       jv            134 Feb 23 22:17 MANIFEST.MF
