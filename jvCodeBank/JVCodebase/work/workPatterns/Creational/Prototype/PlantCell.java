
public class PlantCell implements Cloneable {
	public Object split() {
		try {
			return super.clone();
		}catch(Exception e) {
			System.out.println("Exception occured: "+e.getMessage());
			return null;
		}
	}
}

