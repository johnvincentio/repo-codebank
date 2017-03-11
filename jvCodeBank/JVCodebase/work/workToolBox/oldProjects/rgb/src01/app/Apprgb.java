
import javax.swing.*;
import java.awt.*;

public class Apprgb extends JPanel {
	private int m_red;
	private int m_green;
	private int m_blue;

	public Apprgb (int r, int g, int b) {
		m_red = r;
		m_green = g;
		m_blue = b;
		setBorder(BorderFactory.createLoweredBevelBorder());
		setMyRGB();
	}
	public void setMyRed(int r) {m_red = r; setMyRGB();}
	public void setMyGreen(int g) {m_green = g; setMyRGB();}
	public void setMyBlue(int b) {m_blue = b; setMyRGB();}
	private void setMyRGB() {
		setBackground(new Color(m_red, m_green, m_blue));
	}
	public Dimension getPreferredSize() {return new Dimension(300, 300);}
	public Dimension getMinimumSize() {return getPreferredSize();}
}

