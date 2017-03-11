<HEAD>
<TITLE>Error Page</TITLE>
</HEAD>

<BODY>

<jsp:useBean id="jvMsg" type="com.idc.thames.xsl.JVMessage" scope="request"/>

<center>
<b>Error occured</b>
<br>
<b> <jsp:getProperty name="jvMsg" property="header" /> </b> <br>
<b> <jsp:getProperty name="jvMsg" property="text" /> </b> <br>
</center>


</BODY>
</HTML>
