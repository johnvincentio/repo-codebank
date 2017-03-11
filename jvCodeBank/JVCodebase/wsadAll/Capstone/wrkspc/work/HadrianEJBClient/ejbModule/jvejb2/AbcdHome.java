package jvejb2;
/**
 * Home interface for Enterprise Bean: Abcd
 */
public interface AbcdHome extends javax.ejb.EJBHome {
	/**
	 * Creates a default instance of Session Bean: Abcd
	 */
	public jvejb2.Abcd create()
		throws javax.ejb.CreateException,
		java.rmi.RemoteException;
}
