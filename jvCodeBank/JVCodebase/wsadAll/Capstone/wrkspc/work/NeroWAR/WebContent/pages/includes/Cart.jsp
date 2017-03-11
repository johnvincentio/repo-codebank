
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%@ page import="jvdebug.*" %>

<body bgcolor="white">
<center>
<h1><bean:message key="cart.header"/></h1>
<html:errors/>

<bean:define id="jvShoppingCart" name="<%= jvapp.Constants.SHOPPING_CART %>"
		scope="request"/>

<table>
<TR>
	<TD BGCOLOR=AAAAAA><bean:message key="cart.hd1"/></TD>
	<TD BGCOLOR=AAAAAA ALIGN=CENTER><bean:message key="cart.hd2"/></TD>
    <TD BGCOLOR=AAAAAA><bean:message key="cart.hd3"/></TD>
	<TD BGCOLOR=AAAAAA><bean:message key="cart.hd4"/></TD>			
    <TD BGCOLOR=AAAAAA ALIGN=CENTER><bean:message key="cart.hd5"/></TD>
    <TD BGCOLOR=AAAAAA ALIGN=CENTER><bean:message key="cart.hd6"/></TD>	
	<TD BGCOLOR=AAAAAA><bean:message key="cart.hd7"/></TD>
	<TD BGCOLOR=AAAAAA><bean:message key="cart.hd8"/></TD>
</TR>

<logic:iterate id="item" type="jvcart.JVItem"
			name="jvShoppingCart" property="items">
	<bean:define id="id" name="item" property="cartid"/>
	<tr>
		<html:form action="/Cart">
		<html:hidden property="item" value="<%= String.valueOf(id) %>" />
		<td><bean:write name="item" property="itemid"/></td>
		<td><bean:write name="item" property="catalog"/></td>
		<td><bean:write name="item" property="sds" filter="false"/></td>
		<td><bean:write name="item" property="quantity"/></td>
		<td><bean:write name="item" property="price"/></td>
		<td><bean:write name="item" property="total"/></td>
		<td>
			<html:submit property="REMOVE">
				<bean:message key="cart.submit.remove"/>
			</html:submit>
		</td>	
		<td>
			<html:submit property="UPDATE">
				<bean:message key="cart.submit.update"/>
			</html:submit>
		</td>	
		</html:form>
	</tr>
</logic:iterate>

     <TR>
		<TD>&nbsp;</TD>
		<TD>&nbsp;</TD>
		<TD>&nbsp;</TD>
		<TD>&nbsp;</TD>
		<TD BGCOLOR="DDDDDD"><bean:message key="cart.tot1"/></TD>
		<TD BGCOLOR=DDDDDD ALIGN=RIGHT>
			<bean:write name="jvShoppingCart" property="computeTotal"/>
		</TD>
	</TR>
</table>

</center>

</body>

