
import java.awt.*;
import javax.swing.*;

public class App extends JFrame {
	private Apprgb m_apprgb;
	public App(String msg) {
		super(msg);
		Debug.setFile("CONSOLE",false);
		Debug.println("App()");
		setContentPane(makeMyContentPane());
		setSize(500,900);
		pack();
		setVisible(true);
	}
	public static void main (String args[]) {
		JFrame frame = new App ("RGB");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private Container makeMyContentPane() {
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());

		JPanel topPane = new JPanel();	// top Pane
		topPane.setLayout(new GridLayout(3, 1, 0, 0));

		AppSlider appSlider = new AppSlider (this, "Red", 1);
		topPane.add(appSlider.makeContentPane());
		appSlider = new AppSlider (this, "Green", 2);
		topPane.add(appSlider.makeContentPane());
		appSlider = new AppSlider (this, "Blue", 3);
		topPane.add(appSlider.makeContentPane());

		JPanel midPane = new JPanel();	// panel for a color area
		m_apprgb = new Apprgb (0,0,0);
		midPane.add(m_apprgb);

		pane.add(topPane,BorderLayout.NORTH);	// put it together
		pane.add(midPane,BorderLayout.CENTER);
		return (pane);
	}
	public void setMyRGB (int nNumber, int nValue) {
		switch (nNumber) {
			case 1:	// red
				m_apprgb.setMyRed(nValue);
				break;
			case 2:	// green
				m_apprgb.setMyGreen(nValue);
				break;
			case 3:	// blue
				m_apprgb.setMyBlue(nValue);
				break;
		}
	}
}


