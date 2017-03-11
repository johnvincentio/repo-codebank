package jvejb2;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessAbcdHomeBean_d7cd89da
 */
public class EJSStatelessAbcdHomeBean_d7cd89da extends EJSHome {
	/**
	 * EJSStatelessAbcdHomeBean_d7cd89da
	 */
	public EJSStatelessAbcdHomeBean_d7cd89da() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public jvejb2.Abcd create() throws java.rmi.RemoteException, javax.ejb.CreateException {
BeanO beanO = null;
jvejb2.Abcd result = null;
boolean createFailed = false;
try {
	result = (jvejb2.Abcd) super.createWrapper(null);
}
catch (javax.ejb.CreateException ex) {
	createFailed = true;
	throw ex;
} catch (java.rmi.RemoteException ex) {
	createFailed = true;
	throw ex;
} catch (Throwable ex) {
	createFailed = true;
	throw new CreateFailureException(ex);
} finally {
	if (createFailed) {
		super.createFailure(beanO);
	}
}
return result;	}
}
