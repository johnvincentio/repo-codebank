
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c" %>
<%@ taglib uri="/WEB-INF/fmt.tld" prefix="fmt" %>

<body bgcolor="white">
<center>
<h1><fmt:message key="catalogs.header"/></h1>
<html:errors/>

<table>
	<tr>
		<th bgcolor=AAAAAA align=center>
			<fmt:message key="catalogs.catalog"/></th>
		<th bgcolor=AAAAAA align=center>
			<fmt:message key="catalogs.option"/></th>
	</tr>

	<c:forEach var="item" items="${CatalogNames.items}">
	<tr>
		<html:form action="/SelectCatalog">
			<html:hidden property="catalogid" value="${item.catalogid}" />
			<td>${item.ds}</td>
			<td><html:submit>
				<fmt:message key="catalogs.submit"/>
			</html:submit></td>	
		</html:form>
	</tr>
	</c:forEach>

</table>

</center>
</body>

