package com.idc.thames.xsl;

import com.idc.trace.Debug;
import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JVServlet extends HttpServlet {
	private String m_strURL;	// oracle
	private String m_strUser;
	private String m_strPwd;
	private String m_strSmtphost;	// email
	private String m_strMessagefrom;
	private String m_strFromuser;
	private String m_strFrompwd;
	private boolean m_bError;
	private SendMail m_sendMail;

	public void doProcess(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
		Debug.println(">>> doProcess()");
		JVParameters jvparams = new JVParameters(req.getParameterMap());
		jvparams.showParams("all params");
		int nActionValue = jvparams.getKeyValue("JVACTION",50);
		Debug.println("nActionValue "+nActionValue);

		ServletContext context = getServletConfig().getServletContext();
Debug.println("stage 1");
		HttpSession session = req.getSession();
Debug.println("stage 2");
		App app = (App) session.getAttribute("app");
Debug.println("stage 3");
		if (app == null) {
Debug.println("stage 4");
			app = new App(context, m_sendMail, m_strURL, m_strUser, m_strPwd);
Debug.println("stage 5");
			session.setAttribute("app",app);
		}

//		String strForwardURL;
		Debug.println("stage 10");
		try {
			switch (nActionValue) {
				case 50:		// from none, thus Login
					app.doLogin(req, resp);
					break;
				case 100:		// from Login, thus check login
					app.doCheckLogin(req, resp, jvparams);
					break;
				case 110:		// from Login, New User to Register
					app.doRegister(req, resp, jvparams);
					break;
				case 170:		// from Register, check OK
					app.doCheckRegister(req, resp, jvparams);
					break;
				case 200:		// View Catalog Names
					app.doCatalogNames(req, resp, jvparams);
					break;
				case 210:		// View a Named Catalog
					app.doCatalog(req, resp, jvparams);
					break;
				case 240:		// An Item to Cart
					app.doAddCartItem(req, resp, jvparams);
					break;
				case 300:		// View Cart
					app.doCart(req, resp, jvparams);
					break;
				case 320:		// Remove from Cart
					app.doRemoveFromCart(req, resp, jvparams);
					break;
				case 350:		// Update Cart Item
					app.doUpdateCartItem(req, resp, jvparams);
					break;
				case 400:		// View Checkout
					app.doViewCheckout(req, resp, jvparams);
					break;
				case 450:		// Logout
					app.doLogout(req, resp);
					break;
				case 0:			// general no use
				default:
					app.doError(req, resp, "General Error",
						"Error has been found. Please try your request later");
					break;
			}
		}
		catch (Exception ex) {
			app.doError(req, resp, "General Exception", ex.getMessage());
		}
		Debug.println("<<< doProcess()");
	}

	public void init() {
		m_bError = false;
		try {
			Debug.setFile("/tmp/cart.txt",false);
			Debug.println("---init()");
			String path = getServletContext().getRealPath("app.properties");
			JVProperties props = new JVProperties(path);

/*	from SendMail.java; this fails here too - Security Manager issue
			Debug.println("*** before System.getProperties()");
		Properties tmpprops = System.getProperties(); // Get properties object
			Debug.println("*** after System.getProperties()");
*/

			m_strSmtphost = props.getSmtpHost();	// setup email system
			m_strMessagefrom = props.getMessagefrom();
			m_strFromuser = props.getFromuser();
			m_strFrompwd = props.getFrompwd();
			Debug.println("Load Email System");
			m_sendMail = new SendMail (m_strSmtphost, "", m_strMessagefrom,
							m_strFromuser, m_strFrompwd);

			m_strURL = props.getURL();		// setup Oracle database
			m_strUser = props.getUser();
			m_strPwd = props.getPassword();
			Debug.println("Load Database Driver");
			try {
				Class.forName(props.getDriver());
			} catch (java.lang.ClassNotFoundException e) {
				Debug.println("--- ClassNotFoundException ---:");
				Debug.println(e.getMessage());
				m_bError = true;
			}
		}
		catch (Exception ex) {
			Debug.println("--- Exception ---:");
			Debug.println(ex.getMessage());
			m_bError = true;
		}
	}
	public void destroy() {
		Debug.println("---destroy()");
	}

	public void doGet(HttpServletRequest req,
		HttpServletResponse resp)
			throws ServletException, IOException {
		doProcess(req, resp);
	}
	public void doPost(HttpServletRequest req,
		HttpServletResponse resp)
			throws ServletException, IOException {
		doProcess(req, resp);
	}
}
