Buildfile: build.xml

clean:
     [echo] Remove build and distributables...
   [delete] Deleting 12 files from /home/jv/workCapstone/Common1/src99/common/build
   [delete] Deleted 3 directories from /home/jv/workCapstone/Common1/src99/common/build
   [delete] Deleting 14 files from /home/jv/workCapstone/Common1/src99/common/dist
   [delete] Deleted 4 directories from /home/jv/workCapstone/Common1/src99/common/dist

mkdirs:
     [echo] Create directories...
    [mkdir] Created dir: /home/jv/workCapstone/Common1/src99/common/dist
    [mkdir] Created dir: /home/jv/workCapstone/Common1/src99/common/dist/contents
    [mkdir] Created dir: /home/jv/workCapstone/Common1/src99/common/build
    [mkdir] Created dir: /home/jv/workCapstone/Common1/src99/common/build/META-INF

compile:
     [echo] Compiling java...
    [javac] Compiling 12 source files to /home/jv/workCapstone/Common1/src99/common/build

build:
     [echo] Copying files from lib...

dist:
     [echo] Creating JAR file....
      [jar] Building jar: /home/jv/workCapstone/Common1/src99/common/dist/jar-common.jar
    [unjar] Expanding: /home/jv/workCapstone/Common1/src99/common/dist/jar-common.jar into /home/jv/workCapstone/Common1/src99/common/dist/contents

BUILD SUCCESSFUL
Total time: 5 seconds
build:
total 16
drwxrwxr-x    4 jv       jv           4096 Feb 23 22:16 .
drwxr-xr-x    6 jv       jv           4096 Feb 23 22:16 ..
drwxrwxr-x    2 jv       jv           4096 Feb 23 22:16 jvcommon
drwxrwxr-x    2 jv       jv           4096 Feb 23 22:16 META-INF

build/jvcommon:
total 56
drwxrwxr-x    2 jv       jv           4096 Feb 23 22:16 .
drwxrwxr-x    4 jv       jv           4096 Feb 23 22:16 ..
-rw-rw-r--    1 jv       jv            499 Feb 23 22:16 AppConstants.class
-rw-rw-r--    1 jv       jv           1991 Feb 23 22:16 Debug.class
-rw-rw-r--    1 jv       jv           1000 Feb 23 22:16 JVAlert.class
-rw-rw-r--    1 jv       jv            542 Feb 23 22:16 JVAlerts.class
-rw-rw-r--    1 jv       jv            748 Feb 23 22:16 JVBarcode.class
-rw-rw-r--    1 jv       jv            552 Feb 23 22:16 JVBarcodes.class
-rw-rw-r--    1 jv       jv            505 Feb 23 22:16 JVCharacteristic.class
-rw-rw-r--    1 jv       jv            915 Feb 23 22:16 JVCharacteristics.class
-rw-rw-r--    1 jv       jv            688 Feb 23 22:16 JVCollection.class
-rw-rw-r--    1 jv       jv            668 Feb 23 22:16 JVCollections.class
-rw-rw-r--    1 jv       jv            748 Feb 23 22:16 JVRole.class
-rw-rw-r--    1 jv       jv           1110 Feb 23 22:16 JVRoles.class

build/META-INF:
total 8
drwxrwxr-x    2 jv       jv           4096 Feb 23 22:16 .
drwxrwxr-x    4 jv       jv           4096 Feb 23 22:16 ..

dist:
total 20
drwxrwxr-x    3 jv       jv           4096 Feb 23 22:16 .
drwxr-xr-x    6 jv       jv           4096 Feb 23 22:16 ..
drwxrwxr-x    4 jv       jv           4096 Feb 23 22:16 contents
-rw-rw-r--    1 jv       jv           7569 Feb 23 22:16 jar-common.jar

dist/contents:
total 16
drwxrwxr-x    4 jv       jv           4096 Feb 23 22:16 .
drwxrwxr-x    3 jv       jv           4096 Feb 23 22:16 ..
drwxrwxr-x    2 jv       jv           4096 Feb 23 22:16 jvcommon
drwxrwxr-x    2 jv       jv           4096 Feb 23 22:16 META-INF

dist/contents/jvcommon:
total 56
drwxrwxr-x    2 jv       jv           4096 Feb 23 22:16 .
drwxrwxr-x    4 jv       jv           4096 Feb 23 22:16 ..
-rw-rw-r--    1 jv       jv            499 Feb 23 22:16 AppConstants.class
-rw-rw-r--    1 jv       jv           1991 Feb 23 22:16 Debug.class
-rw-rw-r--    1 jv       jv           1000 Feb 23 22:16 JVAlert.class
-rw-rw-r--    1 jv       jv            542 Feb 23 22:16 JVAlerts.class
-rw-rw-r--    1 jv       jv            748 Feb 23 22:16 JVBarcode.class
-rw-rw-r--    1 jv       jv            552 Feb 23 22:16 JVBarcodes.class
-rw-rw-r--    1 jv       jv            505 Feb 23 22:16 JVCharacteristic.class
-rw-rw-r--    1 jv       jv            915 Feb 23 22:16 JVCharacteristics.class
-rw-rw-r--    1 jv       jv            688 Feb 23 22:16 JVCollection.class
-rw-rw-r--    1 jv       jv            668 Feb 23 22:16 JVCollections.class
-rw-rw-r--    1 jv       jv            748 Feb 23 22:16 JVRole.class
-rw-rw-r--    1 jv       jv           1110 Feb 23 22:16 JVRoles.class

dist/contents/META-INF:
total 12
drwxrwxr-x    2 jv       jv           4096 Feb 23 22:16 .
drwxrwxr-x    4 jv       jv           4096 Feb 23 22:16 ..
-rw-rw-r--    1 jv       jv            134 Feb 23 22:16 MANIFEST.MF
