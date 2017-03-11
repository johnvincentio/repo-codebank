
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<body bgcolor="white">
<center>
<h1><bean:message key="catalogitems.header"/></h1>
<html:errors/>

<bean:define id="jvCatalog" name="<%= jvapp.Constants.CATALOG_KEY %>"
		scope="request"/>
<table>
<TR>
	<TD BGCOLOR=AAAAAA><bean:message key="catalogitems.hd1"/></TD>
	<TD BGCOLOR=AAAAAA><bean:message key="catalogitems.hd2"/></TD>
	<TD BGCOLOR=AAAAAA><bean:message key="catalogitems.hd3"/></TD>
	<TD BGCOLOR=AAAAAA align=center><bean:message key="catalogitems.hd4"/></TD>
	<TD BGCOLOR=AAAAAA><bean:message key="catalogitems.hd5"/></TD>
	<TD BGCOLOR=AAAAAA><bean:message key="catalogitems.hd6"/></TD>
</TR>

<logic:iterate id="item" type="jvcart.JVCatalogItem"
			name="jvCatalog" property="items">
	<bean:define id="id" name="item" property="itemid"/>
	<tr>
		<html:form action="/CatalogItemsAdd">
		<html:hidden property="itemid" value="<%= String.valueOf(id) %>" />
		<td><bean:write name="item" property="itemid"/></td>
		<td><bean:write name="item" property="sds" filter="false"/></td>
		<td><bean:write name="item" property="lds" filter="false"/></td>
		<td><bean:write name="item" property="price"/></td>
		<td><html:text property="quantity" size="3"/></td>
		<td>
			<html:submit>
				<bean:message key="catalogitems.add"/>
			</html:submit>
		</td>	
		</html:form>
	</tr>
</logic:iterate>
</TABLE>

</center>
</body>
 
