
package jvapp;

import jvdebug.*;

import javax.servlet.*;

public class JVListener implements ServletContextListener {

	public void contextInitialized (ServletContextEvent evt) {
		Debug.setFile("/tmp/hadrian_war.txt",false);
		Debug.println("---init()");

		boolean bError = false;
		ServletContext ctx = evt.getServletContext();

		JVSetup jvsetup = JVSetup.getInstance();
		jvsetup.setSmtphost(ctx.getInitParameter("Smtphost"));
		jvsetup.setMessagefrom(ctx.getInitParameter("Messagefrom"));
		jvsetup.setFromuser(ctx.getInitParameter("Fromuser"));
		jvsetup.setFrompwd(ctx.getInitParameter("Frompwd"));
		jvsetup.setError (bError);
	}

	public void contextDestroyed (ServletContextEvent evt) {
		Debug.println("--contextDestroyed()");
	}

}
