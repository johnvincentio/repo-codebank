
                                   README

                                Smart JPrint
                                Version x.y.z


CONTENTS

SmartJPrintDemo_x.y.z.zip - this archive contains all that you need to develop, deploy
and run demo programs. Unzip this file into a directory that will create a sub directory
SmartJPrintDemo_x.y.z with the following contents:

- smartjcommon_x.y.jar, smartjprint_x.y.z.jar
[used for your development and deployment and running the demo programs with this archive]

- smartjprint_demo.jar
[archive contains all demo program class files]

[Optional Library jars]
 smartjpdf_x.y.z.jar,
 smartjpdf_demo.jar,
 bcprov-java14-125.jar,
 jai_codec.jar,
 jai_core.jar

 These are PDF printing and viewing libray. Therefore use them if they are included
 in the archive. Otherwise contact Activetree Inc. for details.

- *.bat, *.sh
[script files to run the demo programs]

- .java demo programs under "SmartJPrintDemo_x.y.z/src"
[will help you to follow the examples]

- smartjprint_x.y.z_javadoc.zip
[The javadoc for the released Smart JPrint classes. You must unzip this archive for viewing.]

- smartjprint_license.txt
[general license information]

- README.TXT
[will help you understand the installation, how to, etc.]


JVM REQUIREMENT

1. J2SE/JRE 1.4.0 or higher and

2. JAI 1.1.2 Plug-In (a extension APIs for Image processing) from
http://java.sun.com/products/java-media/jai/

[You need this Plug-In if you intent to generate multipage TIFF document as the output
from Smart JPrint. If you are NOT generating TIFF documents, then you do not need to instll
this plug-in. However, we recommend you install this in case you generate TIFF docs.]

What is JAI Plug-In?

For generating TIFF (FAX sending/viewing) documents from the Smart JPrint output you must
install the JAI (Java Advanced Imaging) Plug-In into the Java Virtual Machine used for
running the JPrint library. Follow the link below to download the JAI Plug-In from
Sun's website and install JAI 1.1.2 or higher into your already installed J2SE or
JRE (1.4 or higher) environment. JAI is Java virtual machine extension APIs not
included as part of the J2SE or JRE installation. Except TIFF creation, you should
be able to successfully generate the other form of outputs such as Printing, PDF,
JPEG, PNG, Preview etc. from the Smart JPrint APIs]

HOW TO RUN THE DEMO PROGRAMS?

To run the demo programs type the script file name and then pass the license key as the
argument to the batch file. For example, in order to run the example program about how
to print, PDF, Preview a JTable issue the following command line:

c:/> PrintSimpleJTableDemo.bat <licenseKey>

Note: Incorrent license key will cause the JPrint to throw exception with some message.

HOW TO USE SmartJPrint IN YOUR PROGRAM?

When you got the SmartJPrintDemo_x.y.z.zip in your email, you also got a LICENSE KEY
along with this .ZIP file. You must set the LICENSE KEY using the following Java statement
usually at the very beginning in your program.

SmartJPrint.setLicenseKey("YourLicenseKey");

HOW TO TEST THE WEB SAMPLES?

The downloaded archive contains the SmartJPrint_x.y.z/smartjprint_webdemo.war file ready
for web deployment. You have to do couple of changes in the .WAR file before you try to
test the web demo programs. Use any J2EE web server such as Tomcat, BEA Weblogic, IBM
WebSphere etc.

. Change the license key in the index.jsp with the license key you have received. This
  file is at the root level in the WAR archive.
. Check if smartjprint_x.y.z.jar is made available in the WEB-INF/lib directory. If this
  jar is not there then after deployment copy this file from SmartJPrint_x.y.z into here
  and then restart your web server.

To test the JSP and Servlets from a web rowser type the following and then click on the
Servlet and JSP links. You can also see the source programs from the web page and is also
made available into the smartjprint_webdemo.war archive.

http://host:port//smartjprint_webdemo/index.jsp

THANKS

For continous improvements, please drop your feedback and suggestions to us because that
is the only way we can enhance out API in order to fix the problem and enhance it fit
with your requirement. We will deliver a patch very quickly if the fix is a minor one.

------------------------------------------------------------------------
Copyright © 2003-2004, ActiveTree. CA, USA
All rights reserved.
