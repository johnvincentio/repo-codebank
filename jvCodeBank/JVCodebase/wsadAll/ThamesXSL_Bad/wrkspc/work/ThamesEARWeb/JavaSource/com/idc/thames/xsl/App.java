
package com.idc.thames.xsl;

import java.io.InputStream;

import com.idc.xml.XMLTransform;
import com.idc.trace.Debug;

import javax.servlet.ServletContext;
import javax.servlet.http.*;

public class App {
	private ServletContext m_context;
	private SendMail m_sendMail;
	private JVDatabase m_database;
	private int m_nUserid;			// table users.userid
	public App (ServletContext context, SendMail mail, String DBurl, String user, String pwd) {
		Debug.println(">>> App (constructor)");
		m_context = context;
		m_sendMail = mail;
		m_database = new JVDatabase (DBurl, user, pwd);
		m_nUserid = -1;		// not logged in
		Debug.println("<<< App (constructor)");
	}

	public void doError(HttpServletRequest req, HttpServletResponse resp, 
					String strHeader, String strText) {
		try {
			XMLTransform xmlTransform = new XMLTransform();
			InputStream xslInput = m_context.getResourceAsStream("/WEB-INF/Error.xsl");
			resp.setContentType("text/html");
			xmlTransform.doTransform(xslInput, (new JVxml()).makeError(strHeader, strText),
			resp.getWriter());
		}
		catch (Exception ex) {
			Debug.println("Exception: "+ex.getMessage());
		}
	}

	public void doLogin(HttpServletRequest req, HttpServletResponse resp) {
		Debug.println(">>> doLogin");
		try {
			XMLTransform xmlTransform = new XMLTransform();
			InputStream xslInput = m_context.getResourceAsStream("/WEB-INF/login.xsl");
			InputStream xmlInput = m_context.getResourceAsStream("/WEB-INF/login.xml");
			resp.setContentType("text/html");
			xmlTransform.doTransform(xslInput, xmlInput, resp.getWriter());
		}
		catch (Exception ex) {
			Debug.println("Exception: "+ex.getMessage());
		}
		Debug.println("<<< doLogin");
	}
	public void doCatalogNames(HttpServletRequest req, HttpServletResponse resp, 
							JVParameters params) {
		Debug.println(">>> doCatalogNames");
		JVCatalogNames catalog = m_database.getCatalogNames();
		Debug.println("xml:"+catalog.toXML()+":");
		try {
			XMLTransform xmlTransform = new XMLTransform();
			InputStream xslInput = m_context.getResourceAsStream("/WEB-INF/CatalogNames.xsl");
			resp.setContentType("text/html");
			xmlTransform.doTransform(xslInput, catalog.toXML(), resp.getWriter());
		}
		catch (Exception ex) {
			Debug.println("Exception: "+ex.getMessage());
		}
		Debug.println("<<< doCatalogNames");
	}
	public void doLogout(HttpServletRequest req, HttpServletResponse resp) {
		Debug.println(">>> doLogout");
		m_nUserid = -1;
		doLogin(req, resp);
//m_strFunction = "Login";
//m_strJSPurl = "Login.jsp";
//req.setAttribute("jvMsg",
//new JVMessage ("Thames Books","Please Login"));	// bean
		Debug.println("<<< doLogout");
	}
	private void doLostPassword(HttpServletRequest req, HttpServletResponse resp, 
							JVParameters params) {
		Debug.println(">>> doLostPassword");

		boolean bError = false;
		String strHeader = "Please Login";
		String strText = "";
		String strUser = params.getKeyValue("NAME","");
		String strReturn;
		if (strUser.equals("")) {
			strText += "You must enter an Email Id. ";
			bError = true;
		}
		if (! bError) {
			strReturn = m_database.getUserPassword(strUser);
			if (strReturn.equals("")) {
				strText += "Your Email Id is incorrect";
				bError = true;
			}
			if (! bError) {
				doSendPassword (strUser, strReturn);
				strText = "Your password has been sent to your email address";
			}
		}
		req.setAttribute("jvMsg", new JVMessage (strHeader,strText));	// bean
		Debug.println("<<< doLostPassword");
	}
	private void doSendPassword (String strUser, String strPwd) {
		Debug.println(">>> doSendPassword; User :"+strUser+": pwd :"+strPwd+":");
		String strSubject = "Thames Books sends your password";
		String strText = "Email "+strUser+". Your password is "+strPwd;
		m_sendMail.sendMessage(strUser, strSubject, strText);
		Debug.println("<<< doSendPassword");
	}
	public void doCheckLogin(HttpServletRequest req, HttpServletResponse resp, JVParameters params) {
		Debug.println(">>> doCheckLogin");
		String strLostPwd = params.getKeyValue("LOSTPASSWORD","");
		if (! strLostPwd.equals("")) {
			doLostPassword(req,resp,params);
			return;
		}

		boolean bError = false;
		String strHeader = "Login Error";		// assume trouble
		String strText = "";
		String strUser = params.getKeyValue("NAME","");
		String strPassword = params.getKeyValue("PASSWORD","");
		int nReturn;
		if (strUser.equals("")) {
			strText += "You must enter an Email Id. ";
			bError = true;
		}
		if (strPassword.equals("")) {
			strText += "You must enter your Password. ";
			bError = true;
		}
		if (! bError) {
			nReturn = m_database.getUserid(strUser,strPassword);
			if (nReturn < 0) {
				strText += "Your Email Id and/or your Password is incorrect. ";
				bError = true;
			}
//			if (! bError) {
			m_nUserid = nReturn;	// remember this user
			doCatalogNames(req,resp,params);	// carry on
			return;
//			}
		}
		doError (req, resp, strHeader, strText);
		Debug.println("<<< doCheckLogin");
	}
	public void doCart(HttpServletRequest req, HttpServletResponse resp, JVParameters params) {
		Debug.println(">>> doCart");
		if (m_nUserid > -1) {
			JVCart cart = m_database.getUserCart(m_nUserid);	// needs users.userid
			try {
				XMLTransform xmlTransform = new XMLTransform();
				InputStream xslInput = m_context.getResourceAsStream("/WEB-INF/Cart.xsl");
				resp.setContentType("text/html");
				xmlTransform.doTransform(xslInput, (new JVxml()).makeCart(cart), resp.getWriter());
			}
			catch (Exception ex) {
				Debug.println("Exception: "+ex.getMessage());
			}
		}
		else {
			doError (req, resp, "Cart Error", "Unable to update your cart. Please Try Again");
//			m_strFunction = "Error";
//			m_strJSPurl = "Error.jsp";
//			req.setAttribute("jvMsg", 
//				new JVMessage ("Cart Error",
//					"Unable to update your cart. Please Try Again"));	// bean
		}
		Debug.println("<<< doCart");
	}

	public void doAddCartItem(HttpServletRequest req, HttpServletResponse resp, JVParameters params) {
		Debug.println(">>> doAddCartItem");
		int nItemid = params.getKeyValue("ITEM",-1);	// items.itemid
		int nQty = params.getKeyValue("QUANTITY",-1);
		Debug.println("nItemid :"+nItemid+":");
		Debug.println("nQty :"+nQty+":");
		Debug.println("UserID :"+m_nUserid+":");
		if ((nItemid > -1) && (nQty > 0))
			m_database.addCartItem(m_nUserid, nItemid, nQty);
		doCatalogNames(req,resp,params);
		Debug.println("<<< doAddCartItem");
	}

	public void doRemoveFromCart(HttpServletRequest req, HttpServletResponse resp, JVParameters params) {
		Debug.println(">>> doRemoveFromCart");
		String strUpdate = params.getKeyValue("UPDATE","NULL");
		Debug.println("Update :"+strUpdate+":");
		if (! strUpdate.equals("NULL")) {
			doUpdateCart(req,resp,params);
			return;
		}
		String strRemove = params.getKeyValue("REMOVE","NULL");
		Debug.println("Remove :"+strRemove+":");
		int nItemid = params.getKeyValue("ITEM",-1);
		Debug.println("nItemid :"+nItemid+":");
		Debug.println("UserID :"+m_nUserid+":");
		if (! strRemove.equals("NULL"))
			m_database.removeCartItem(nItemid);		// needs cart.cartid
		if (m_nUserid > -1) {
			JVCart cart = m_database.getUserCart(m_nUserid);	// needs users.userid
//			m_strFunction = "Cart";
//			m_strJSPurl = "Cart.jsp";
			req.setAttribute("jvShoppingCart",cart);	// bean
		}
		else {
//			m_strFunction = "Error";
//			m_strJSPurl = "Error.jsp";
			req.setAttribute("jvMsg", 
				new JVMessage ("Cart Error",
					"Unable to update your cart. Please Try Again"));	// bean
		}
		Debug.println("<<< doRemoveFromCart");
	}
	private void doUpdateCart(HttpServletRequest req, HttpServletResponse resp, JVParameters params) {
		Debug.println(">>> doUpdateCart");
		int nItemid = params.getKeyValue("ITEM",-1);
		Debug.println("nItemid :"+nItemid+":");
//		m_strFunction = "CartUpdate";
//		m_strJSPurl = "CartUpdate.jsp";
		JVItem item = m_database.getCartItem(nItemid);	// needs cart.cartid
		req.setAttribute("jvItem",item);		// bean
		Debug.println("<<< doUpdateCart");
	}
	public void doUpdateCartItem(HttpServletRequest req, HttpServletResponse resp, JVParameters params) {
		Debug.println(">>> doUpdateCartItem");
		int nItemid = params.getKeyValue("ITEM",-1);
		int nQty = params.getKeyValue("QUANTITY",-1);
		Debug.println("nItemid :"+nItemid+":");
		Debug.println("nQty :"+nQty+":");
		if ((nItemid > -1) && (nQty > 0)) {
			m_database.updateCartItem(nItemid, nQty);	// cart.cartid
		}
		Debug.println("UserID :"+m_nUserid+":");
		JVCart cart = m_database.getUserCart(m_nUserid);	// needs users.userid
//		m_strFunction = "Cart";
//		m_strJSPurl = "Cart.jsp";
		req.setAttribute("jvShoppingCart",cart);	// bean
		Debug.println("<<< doUpdateCartItem");
	}
	public void doRegister(HttpServletRequest req, HttpServletResponse resp, JVParameters params) {
		Debug.println(">>> doRegister");
//		m_strFunction = "Register";
//		m_strJSPurl = "Register.jsp";
		JVRegister reg = new JVRegister();
		req.setAttribute("jvRegister",reg);		// bean
		Debug.println("<<< doRegister");
	}
	public void doCheckRegister(HttpServletRequest req, HttpServletResponse resp, JVParameters params) {
		Debug.println(">>> doCheckRegister");
		String strEmail = params.getKeyValue("EMAIL","");
		String strFirstname = params.getKeyValue("FIRSTNAME","");
		String strMiddlename = params.getKeyValue("MIDDLENAME","");
		String strLastname = params.getKeyValue("LASTNAME","");
		String strAddress1 = params.getKeyValue("ADDRESS1","");
		String strAddress2 = params.getKeyValue("ADDRESS2","");
		String strCity = params.getKeyValue("CITY","");
		String strState = params.getKeyValue("STATE","");
		String strZipcode = params.getKeyValue("ZIPCODE","");
		String strPhone = params.getKeyValue("PHONE","");

		boolean bError = false;
		if (strEmail.equals("")) bError = true;
		if (strFirstname.equals("")) bError = true;
		if (strMiddlename.equals("")) bError = true;
		if (strLastname.equals("")) bError = true;
		if (strAddress1.equals("")) bError = true;
		if (strAddress2.equals("")) bError = true;
		if (strCity.equals("")) bError = true;
		if (strState.equals("")) bError = true;
		if (strZipcode.equals("")) bError = true;
		if (strPhone.equals("")) bError = true;

		if (bError) {
			JVRegister reg = new JVRegister();
			reg.setEmail (strEmail);
			reg.setFirstname (strFirstname);
			reg.setMiddle (strMiddlename);
			reg.setLastname (strLastname);
			reg.setFaddress (strAddress1);
			reg.setLaddress (strAddress2);
			reg.setCity (strCity);
			reg.setState (strState);
			reg.setZip (strZipcode);
			reg.setPhone (strPhone);
//			m_strFunction = "Register";
//			m_strJSPurl = "Register.jsp";
			req.setAttribute("jvRegister",reg);		// bean
		}
//		else
//			doLogin(req);
		Debug.println("<<< doCheckRegister");
	}
	public void doCatalog(HttpServletRequest req, HttpServletResponse resp, JVParameters params) {
		Debug.println(">>> doCatalog");
		int nItemid = params.getKeyValue("ITEM",-1);	// catalog.catalog.id
		Debug.println("nItemid :"+nItemid+":");
		JVCatalog catalog = m_database.getCatalogItems(nItemid);
		try {
			XMLTransform xmlTransform = new XMLTransform();
			InputStream xslInput = m_context.getResourceAsStream("/WEB-INF/CatalogItems.xsl");
			resp.setContentType("text/html");
			xmlTransform.doTransform(xslInput, (new JVxml()).makeCatalog(catalog), resp.getWriter());
		}
		catch (Exception ex) {
			Debug.println("Exception: "+ex.getMessage());
		}
		Debug.println("<<< doCatalogs");
	}
	public void doViewCheckout(HttpServletRequest req, HttpServletResponse resp, JVParameters params) {
		Debug.println(">>> doViewCheckout");
		JVCart cart = m_database.getUserCart(m_nUserid);	// needs users.userid
//		m_strFunction = "Checkout";
//		m_strJSPurl = "Checkout.jsp";
		req.setAttribute("jvShoppingCart",cart);	// bean
		Debug.println("<<< doViewCheckout");
	}
}
