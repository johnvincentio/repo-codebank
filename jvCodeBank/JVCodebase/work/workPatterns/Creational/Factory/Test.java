public class Test {
  	public static void main(String args[]) {
		SalutationFactory factory = SalutationFactory.getSalutationFactory();
		factory.getPerson(args[0], args[1]);
	}
}

