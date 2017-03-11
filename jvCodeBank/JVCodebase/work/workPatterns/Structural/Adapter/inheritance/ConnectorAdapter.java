package structural.adapter.inheritance;

public class ConnectorAdapter implements Socket {
	public String getOutput() {
		Plug plug = new Plug();
		String output = plug.getInput();
		return output;
	}
	public static void main(String[] args) {
		ConnectorAdapter adapter = new ConnectorAdapter();
		String str = adapter.getOutput();
		System.out.println("str :"+str);
	}
}

