
import jvcommon.*;
import jvejb2.Abcd;
import jvejb2.AbcdHome;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.RemoveException;
import javax.naming.NamingException;

public class AbcdClient {

    public static void main(String[] args) {
		Abcd m_bean;
		int nReturn = -1;	// default to not found
		String strReturn = "";	// default to not found

		Debug.setFile("/tmp/jv2.txt",false);
		try {
			Debug.println("stage 1");
			Context ic = new InitialContext();
			Debug.println("stage 2");
			Object objref = ic.lookup("java:comp/env/ejb/SimpleSupplier");
			Debug.println("stage 3");
			AbcdHome home = (AbcdHome) PortableRemoteObject.narrow(
				objref,AbcdHome.class);
			Debug.println("stage 4");
			m_bean = home.create();
			Debug.println("stage 5");

			nReturn = m_bean.getUserid ("jv2351@hotpop.com", "password3");
			Debug.println("stage 6");
			Debug.println("UserId "+nReturn);
/*
			strReturn = m_bean.getUserPassword ("jv2351@hotpop.com");
			Debug.println("stage 7");
			Debug.println("password :"+strReturn+":");
*/

			m_bean.remove();		// container can delete the bean.....
			Debug.println("stage 9");
		}
		catch (RemoteException rex) {
			Debug.println("remoteexception "+rex.getMessage());
		}
		catch (CreateException cex) {
			Debug.println("createexception "+cex.getMessage());
		}
		catch (NamingException nex) {
			Debug.println("namingexception "+nex.getMessage());
		}
		catch (RemoveException vex) {
			Debug.println("removeexception "+vex.getMessage());
		}
		catch (Exception ex) {
			Debug.println("exception "+ex.getMessage());
			ex.printStackTrace();
		}
	}
}

