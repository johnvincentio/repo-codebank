package webclient1.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import webclient1.forms.LogonForm;
import webclient1.saaj.JVSendMessageSAAJ;
import webclient1.saaj.JVBarcodes;
import webclient1.saaj.JVBarcode;

public class LogonAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ActionErrors errors = new ActionErrors();
        ActionForward forward = new ActionForward(); // return value
        LogonForm logonForm = (LogonForm) form;
    	int barcodeid;
    	int itemid;
    	String company;
    	String imageurl;
    	String name;
    	String ds;
        try {
        	if (! logonForm.getUser().equals("abc")) {
        		errors.add (ActionErrors.GLOBAL_ERROR, new ActionError ("logon.error.logon.invalid"));
        	}
        	System.out.println("get barcodes");
    		JVBarcodes barcodes = new JVBarcodes();
    		barcodes.addBarcode(new JVBarcode (1,1,"Apple","http://www.soccernet.com/design05/i/headers/main.jpg","name1","ds 1"));
    		barcodes.addBarcode(new JVBarcode (2,2,"Pear","http://www.soccernet.com/design05/i/headers/main.jpg","name2","ds 2"));
    		System.out.println("got barcodes");

			JVSendMessageSAAJ jvSaaj = new JVSendMessageSAAJ();
			System.out.println("create connection");
			if (jvSaaj.createConnection()) {

				jvSaaj.sendMessage (barcodes);	// overload - allow barcode (above)
				System.out.println("sent the SAAJ");

				jvSaaj.removeConnection();
				System.out.println("removeConnection done");
			}
			else
				System.out.println ("Send to WS as SAAJ failed");
			System.out.println("Send to WS as SAAJ complete");

        } catch (Exception e) {
            // Report the error using the appropriate name and ID.
            errors.add("name", new ActionError("id"));
        }

        // If a message is required, save the specified key(s)
        // into the request for use by the <struts:errors> tag.

        if (! errors.isEmpty()) {
            saveErrors(request, errors);
            forward = mapping.findForward("failure");
//        	return (new ActionForward(mapping.getInput()));
        }
        else
        	forward = mapping.findForward("success");
        return (forward);
    }
}

