
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/fmt.tld" prefix="fmt" %>

<center>
<h1><fmt:message key="logon.title"/></h1>
<html:errors/>

<html:form action="/LogonSubmit" focus="username">

<table border="0">
<tr>
	<th bgcolor=AAAAAA align="right">
		<fmt:message key="logon.username"/></th>
	<td align="left"><html:text property="username"/></td>
</tr>
<tr>
	<th bgcolor=AAAAAA align="right">
		<fmt:message key="logon.password"/></th>
	<td align="left"><html:password property="password"/></td>
</tr>
</table>

<p>
<html:submit><fmt:message key="logon.submit"/></html:submit>
<html:reset><fmt:message key="logon.reset"/></html:reset>
</p>

</html:form>

</center>

