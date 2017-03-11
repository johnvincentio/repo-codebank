
//
// AbstractFactory Pattern example
//

public class ComputerType {
	public static void main(String[] args) {
  	  	ComputerType type = new ComputerType();
		Computer computer = type.getComputer("Server");
		System.out.println("Monitor: "+computer.getMonitor().getSpecification());
		System.out.println("RAM: "+computer.getRAM().getSpecification());
		System.out.println("Processor: "+computer.getProcessor().getSpecification());
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

