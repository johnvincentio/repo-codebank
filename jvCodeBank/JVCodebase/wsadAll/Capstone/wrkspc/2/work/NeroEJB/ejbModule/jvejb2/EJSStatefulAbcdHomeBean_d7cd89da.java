package jvejb2;

import com.ibm.ejs.container.*;

/**
 * EJSStatefulAbcdHomeBean_d7cd89da
 */
public class EJSStatefulAbcdHomeBean_d7cd89da extends EJSHome {
	/**
	 * EJSStatefulAbcdHomeBean_d7cd89da
	 */
	public EJSStatefulAbcdHomeBean_d7cd89da() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public jvejb2.Abcd create() throws java.rmi.RemoteException, javax.ejb.CreateException {
BeanO beanO = null;
jvejb2.Abcd result = null;
boolean createFailed = false;
boolean preCreateFlag = false;
try {
	beanO = super.createBeanO();
	jvejb2.AbcdBean bean = (jvejb2.AbcdBean) beanO.getEnterpriseBean();
preCreateFlag = super.preEjbCreate(beanO);
	bean.ejbCreate();
	result = (jvejb2.Abcd) super.postCreate(beanO);
}
catch (java.rmi.RemoteException ex) {
	createFailed = true;
	throw ex;
} catch (javax.ejb.CreateException ex) {
	createFailed = true;
	throw ex;
} catch (Throwable ex) {
	createFailed = true;
	throw new CreateFailureException(ex);
} finally {
	if(preCreateFlag && !createFailed)
		super.afterPostCreateCompletion(beanO);
	if (createFailed) {
		super.createFailure(beanO);
	}
}
return result;	}
}
