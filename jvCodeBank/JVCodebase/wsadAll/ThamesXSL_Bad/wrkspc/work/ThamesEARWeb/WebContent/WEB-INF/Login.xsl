<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">

<HTML>
<HEAD>
<TITLE><xsl:value-of select="Data/Title"/></TITLE>
<STYLE>
<!--
font.loginhead {
  font-family: Arial,Helvetica,sans-serif;
  font-size:12pt; font-weight: 600; color: #000000;
}
font.loginform {
  font-family: Arial,Helvetica,sans-serif;
  font-size:10pt; font-weight: 600; color: #ffffff;
}
table.tb1 {
	bgcolor: #990022;
}
-->
</STYLE>
</HEAD>

<BODY>

<CENTER>
<FONT CLASS="loginhead">
	<xsl:value-of select="Message/Text"/>
</FONT>
<BR/>
<BR/>

<FORM NAME="loginform" METHOD="post">
<input type="hidden" name="jvaction" value="100" />

<TABLE class="tb1">
<TR>
<TD ALIGN="right">
	<FONT CLASS="loginform"> Email Id: </FONT>
</TD>
<TD ALIGN="left">
	<FONT CLASS="loginform"> <INPUT TYPE="text" NAME="name" SIZE="30"/>
	</FONT>
</TD>
</TR>

<TR>
<TD ALIGN="right">
	<FONT CLASS="loginform"> Password: </FONT>
</TD>
<TD ALIGN="left">
	<FONT CLASS="loginform"><INPUT TYPE="password" NAME="password" SIZE="30"/>
	</FONT>
</TD>
</TR>

<TR>
	<TD COLSPAN="2" ALIGN="center">
	<FONT CLASS="loginform">
	<INPUT TYPE="SUBMIT" VALUE="Login"/>
	</FONT>
	</TD>
</TR>
</TABLE>

<BR/>
<FONT CLASS="loginhead"> Lost Password? Enter your email, check this box and Login</FONT>
	<input type="checkbox" name="lostpassword" />
</FORM>

<BR/>
<FORM METHOD="post">
	<input type="hidden" name="jvaction" value="110" />
	<FONT CLASS="loginhead"> New User? Register here: </FONT>
	<INPUT TYPE="submit" Name="register" Value="Register"/>
</FORM>

</CENTER>

</BODY>
</HTML>

</xsl:template>
</xsl:stylesheet>
