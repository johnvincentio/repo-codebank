<%--
 
  Copyright 2001 Sun Microsystems, Inc. All Rights Reserved.
  
  This software is the proprietary information of Sun Microsystems, Inc.  
  Use is subject to license terms.
  
--%>

<%@ page import="jvejb1.Converter, jvejb1.ConverterHome, javax.ejb.*, java.math.*, javax.naming.*, javax.rmi.PortableRemoteObject, java.rmi.RemoteException" %>
<%!
   private Converter converter = null;

   public void jspInit() { 
      try {
         InitialContext ic = new InitialContext();
         Object objRef = ic.lookup("java:comp/env/ejb/TheConverter");
         ConverterHome home = (ConverterHome)PortableRemoteObject.narrow(objRef, ConverterHome.class);
         converter = home.create();
      } catch (RemoteException ex) {
            System.out.println("Couldn't create converter bean."+ ex.getMessage());
      } catch (CreateException ex) {
            System.out.println("Couldn't create converter bean."+ ex.getMessage());
      } catch (NamingException ex) {
            System.out.println("Unable to lookup home: "+ "TheConverter "+ ex.getMessage());
      } 
   }

   public void jspDestroy() {    
         converter = null;
   }
%>
<html>
<head>
    <title>Converter</title>
</head>

<body bgcolor="white">
<h1><b><center>Converter</center></b></h1>
<hr>
<p>Enter an amount to convert:</p>
<form method="get">
<input type="text" name="amount" size="25">
<br>
<p>
<input type="submit" value="Submit">
<input type="reset" value="Reset">
</form>

<%
    String amount = request.getParameter("amount");
    if ( amount != null && amount.length() > 0 ) {
       BigDecimal d = new BigDecimal (amount);
%>
   <p>
   <%= amount %> dollars are  <%= converter.dollarToYen(d) %>  Yen.
   <p>
   <%= amount %> Yen are <%= converter.yenToEuro(d) %>  Euro.
<%
    }
%>

</body>
</html>
