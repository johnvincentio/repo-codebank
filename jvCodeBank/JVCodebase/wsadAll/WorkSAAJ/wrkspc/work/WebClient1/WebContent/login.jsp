
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html:html>
<HEAD>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<LINK href="theme/Master.css" rel="stylesheet"
	type="text/css">
<TITLE></TITLE>
</HEAD>

<BODY>
<center>

<h1>Logon</h1>
<html:errors/>

<html:form action="/Logon" focus="user">

<table border="0">
<tr>
	<th bgcolor=AAAAAA align="right">User Name</th>
	<td align="left"><html:text property="user"/></td>
</tr>
<tr>
	<th bgcolor=AAAAAA align="right">Password</th>
	<td align="left"><html:password property="password"/></td>
</tr>
</table>

<p>
<html:submit>Submit</html:submit>
<html:reset>Reset</html:reset>
</p>

</html:form>

</center>
</body>
</html:html>
