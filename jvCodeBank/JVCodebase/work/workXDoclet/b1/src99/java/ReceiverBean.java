package examples;

import java.rmi.*;
import javax.ejb.*;

import org.w3c.dom.Document;

import org.xbeans.DOMEvent;
import org.xbeans.DOMSource;
import org.xbeans.DOMListener;
import org.xbeans.XbeansException;

/**
 *   This is the EJB Receiver Xbean
 *
 *   @ejb:bean type="Stateless"
 *             name="org.xbeans.communication.ejb.receiver.Receiver"
 *             jndi-name="org.xbeans.communication.ejb.receiver.Receiver"
 *             display-name="EJB Receiver Xbean"
 *
 *   @ejb:env-entry name="channelBean" type="java.lang.String" value="your.channel.bean"
 */
public class ReceiverBean implements SessionBean, DOMSource {

  // -------------------------------------------------------------------------
  //  EJB Methods
  // -------------------------------------------------------------------------
  private SessionContext sessionContext;
  public void ejbCreate() throws CreateException {  }
  public void ejbRemove() {  }
  public void ejbActivate() {  }
  public void ejbPassivate() {  }
  public void setSessionContext(SessionContext sessionContext) {
    this.sessionContext = sessionContext;
  }



  // -------------------------------------------------------------------------
  //  DomListener method
  // -------------------------------------------------------------------------

  /**
   *  The method that the sender uses to pass the Document over
   *
   *  @param Document incomingDocument
   *
   *  @throws RemoteException
   *  @throws XbeansException
   *
   *  @ejb:interface-method view-type="remote"
   */
  public void documentReady(Document incomingDocument) throws RemoteException, XbeansException {
    if (DOMListener == null) {
	  try {
		  if (channelBean == null) {
			  String cBean = (String) new javax.naming.InitialContext().lookup("java:comp/env/channelBean");
			  if (cBean == null) {
				  throw new Exception();
			  } else {
				  this.setChannelBean( cBean );
			  }
		  }
      } catch (Exception e) {
        throw new XbeansException(incomingDocument.getNodeName(), "ejb receiver", "next component not established",
                                "The component needs to be configured.");
	  }

	  try {
	    this.setDOMListener( (DOMListener) Class.forName( channelBean ).newInstance() );
	  } catch (Exception e) {
		throw new XbeansException(incomingDocument.getNodeName(), "ejb receiver", "could not create the channelBean: " + channelBean + " " + e,
                  "The component needs to be configured correctly (channelBean).");
	  }
    }

    DOMListener.documentReady(new DOMEvent(this, incomingDocument));
  }



  // -------------------------------------------------------------------------
  //  DomSource methods
  // -------------------------------------------------------------------------
  private DOMListener DOMListener;

  /**
   *  Set the DOMListener (usually worked out from the channelBean property)
   *
   *  @param newDomListener
   */
  public void setDOMListener(DOMListener newDomListener) {
    DOMListener = newDomListener;
  }

  /**
   *  Retrieve the DOMListener
   *
   *  @return DOMListener
   */
  public DOMListener getDOMListener() {
    return DOMListener;
  }



  // -------------------------------------------------------------------------
  //  Channel Bean: This is configured in the &lt;env-entry&gt;
  //                in the ejb-jar.xml deployment descriptor
  // -------------------------------------------------------------------------
  private String channelBean;

  /**
   *  Set the channel bean to keep the chain going
   *
   *  @param newChannelBean
   */
  public void setChannelBean(String newChannelBean) {
    channelBean = newChannelBean;
  }

  /**
   *  Retrieve the channel bean name
   *
   *  @return String
   */
  public String getChannelBean() {
    return channelBean;
  }

}
