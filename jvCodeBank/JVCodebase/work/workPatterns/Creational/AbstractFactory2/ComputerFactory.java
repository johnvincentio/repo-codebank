
public class ComputerFactory {
	private static ComputerFactory instance;
	private ComputerFactory () {}
	public static ComputerFactory getComputerFactory() {
		if (instance == null)
			instance = new ComputerFactory();
		return instance;
	}
/**
* Returns a computer for a type
*
* @param computerType String, PC / Workstation / Server
* @return Computer
*/
	public Computer getComputer(String computerType) {
		Computer comp = null;
		if (computerType.equals("PC"))
			comp = new PC();
		else if(computerType.equals("Workstation"))
			comp = new Workstation();
		else if(computerType.equals("Server"))
			comp = new Server();
		return comp;
  	} 	 
}

