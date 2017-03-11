
package jvapp;

import jvdebug.*;
import jvtemplate.*;

import java.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public final class PreLogonAction extends Action {

    public ActionForward perform(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
        throws IOException, ServletException {

		Debug.println (">>> PreLogonAction:perform");
		JVParameters params = new JVParameters(request.getParameterMap());
		params.showParams ("PreLogonAction");

		JVAttributes attribs = new JVAttributes(request.getAttributeNames());
		attribs.showParams ("PreLogonAction");

		Debug.println("before get resource bundle");
		ResourceBundle rb = ResourceBundle.getBundle
				(Constants.RESOURCE_BUNDLE,request.getLocale());
		Debug.println("after get resource bundle");

		JVTemplate tpt = new JVTemplate();
		tpt.setComment ("Main page; MainAction");
		tpt.setTitle (rb.getString ("main.title"));
		tpt.getHeader().setFile ("/pages/includes/Header.jsp");
		tpt.getMenu().setFile ("/templates/MainMenu.jsp");
		tpt.getBody().setFile ("/pages/includes/LogonBody.jsp");
		tpt.getFooter().setFile ("/pages/includes/Footer.jsp");

		Debug.println("Creating sub-menus");
		JVurl jvurl = new JVurl (request);
		JVSubMenu sbm = new JVSubMenu ("Options");
		sbm.addPair (new JVPair (jvurl.getURL("/Main.do"),"Home"));
		sbm.addPair (new JVPair (jvurl.getURL("/Logon.do"),"Logon"));
		tpt.getMenu().addSubMenu (sbm);
		Debug.println("Sub-menus created");

		request.setAttribute(Constants.TEMPLATE_INFO_KEY, tpt);
		Debug.println ("<<< PreLogonAction:perform");
        return (mapping.findForward(Constants.SUCCESS));
    }
}

