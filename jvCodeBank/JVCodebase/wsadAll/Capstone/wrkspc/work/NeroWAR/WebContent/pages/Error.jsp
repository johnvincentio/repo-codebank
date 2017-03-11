
<%-- Error.jsp --%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<html:html>
<head>
<title><bean:message key="errors.error.title"/></title>
<html:base/>
</head>

<body bgcolor="white">
<center>

<h3><bean:message key="errors.error.header"/></h3>
<html:errors/>

<br/>
<h3><bean:message key="errors.error.body"/></h3>

</center>
</body>
</html:html>

