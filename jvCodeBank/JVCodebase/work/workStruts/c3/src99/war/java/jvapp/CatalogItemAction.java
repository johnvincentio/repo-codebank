
package jvapp;

import jvcommon.Debug;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionServlet;

public final class CatalogItemAction extends Action {

    public ActionForward perform(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
        throws IOException, ServletException {

		Debug.println (">>> CatalogItemAction:perform");
		JVParameters params = new JVParameters(request.getParameterMap());
		params.showParams ("CatalogItemAction");
		JVAttributes attribs = new JVAttributes(request.getAttributeNames());
		attribs.showParams ("CatalogItemAction");

		HttpSession session = request.getSession();
		UserInfo userinfo = 
			(UserInfo) session.getAttribute(Constants.USER_INFO_KEY);
		if (userinfo == null) {
			Debug.println("could not find UserInfo");
			ActionErrors errors = new ActionErrors();
			errors.add(ActionErrors.GLOBAL_ERROR,
				new ActionError("general.error.no.userinfo"));
			saveErrors(request,errors);
        	return (mapping.findForward(Constants.FAILURE));
		}

        int nItemId = ((CatalogItemForm) form).getItemid();
        int nQty = ((CatalogItemForm) form).getQuantity();
		Debug.println("item number "+nItemId);
		Debug.println("quantity "+nQty);
		userinfo.doAddCartItem (nItemId, nQty);
		Debug.println ("<<< CatalogItemAction:perform");
        return (mapping.findForward(Constants.SUCCESS));
    }
}


