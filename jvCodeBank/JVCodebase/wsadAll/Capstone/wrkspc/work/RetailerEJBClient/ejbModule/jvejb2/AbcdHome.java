package jvejb2;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface AbcdHome extends EJBHome {

    Abcd create() throws RemoteException, CreateException;
}
