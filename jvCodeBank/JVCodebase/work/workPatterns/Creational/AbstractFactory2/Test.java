public class Test {
  	public static void main(String args[]) {
		ComputerFactory factory = ComputerFactory.getComputerFactory();
		showme (factory.getComputer("Server"));
		showme (factory.getComputer("Workstation"));
		showme (factory.getComputer("PC"));
	}
	private static void showme (Computer cp) {
		System.out.println("Monitor: "+cp.getMonitor().getSpecification());
		System.out.println("RAM: "+cp.getRAM().getSpecification());
		System.out.println("Processor: "+cp.getProcessor().getSpecification());
	}
}

