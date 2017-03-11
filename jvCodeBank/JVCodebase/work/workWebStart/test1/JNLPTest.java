
import java.awt.*;
import javax.swing.*;

public class JNLPTest {
	public static void main (String args[]) {
		JFrame frame = new JFrame("JNLP Rocks");
		Container content = frame.getContentPane();
		JLabel label = new JLabel("Hello");
		content.add(label, BorderLayout.CENTER);
		frame.setSize(200,200);
		frame.show();
		try {
			Thread.sleep(50000);
		}
		catch (InterruptedException ignored) {
		}
		finally {
			System.exit(0);
		}
	}
}

