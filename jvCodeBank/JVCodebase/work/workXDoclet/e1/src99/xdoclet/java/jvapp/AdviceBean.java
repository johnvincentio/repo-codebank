package jvapp;

import javax.ejb.*;

/**
 *   This is the EJB Advice Bean
 *
 * @ejb.bean name="Advice"
 *				type="Stateless"
 *             jndi-name="ejb/AdviceBean"
 *             local-jndi-name="ejb/localAdviceBean"
 *				view-type="both"
 *    generate="true"
 *
 * @ejb.interface
 *    generate="local, remote"
 *
 * @ejb.home
 *    generate="local, remote"
 *
 */

public class AdviceBean implements SessionBean {

	private String adviceString[] = {"one","two","three","four","five"};

 /**
  * @ejb.create-method
  * @throws CreateException
  */
  public void ejbCreate() throws CreateException {
	System.out.println("ejbCreate");
  }

	public void ejbActivate() {System.out.println("ejbActivate");}
	public void ejbPassivate() {System.out.println("ejbPassivate");}
	public void ejbRemove() {System.out.println("ejbRemove");}
	public void setSessionContext(SessionContext ctx)
		{System.out.println("setSessionContext");}

  /**
   *  The method that the sender uses to get an answer
   *
   *  @param String getAdvice
   *
   *  @ejb.interface-method
   */

	public String getAdvice() {
		System.out.println("getAdvice");
		int random = (int) (Math.random() * adviceString.length);
		return adviceString[random];
	}
}

