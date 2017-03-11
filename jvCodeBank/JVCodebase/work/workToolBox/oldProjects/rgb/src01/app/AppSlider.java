
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class AppSlider implements ActionListener, ChangeListener {

	private App m_app;
	private String m_strColor;
	private int m_nNumber;
	private JSlider m_slider;
	private JTextField m_valueText;

	public AppSlider(App app, String strColor, int nNumber) {
		m_app = app;
		m_strColor = strColor;
		m_nNumber = nNumber;
	}
	public Container makeContentPane() {
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());

		JLabel lbl = new JLabel(m_strColor);
		pane.add(lbl,BorderLayout.NORTH);

		m_slider = new JSlider(JSlider.HORIZONTAL,0,255,0);
		m_slider.addChangeListener(this);
		m_slider.setMajorTickSpacing(50);
		m_slider.setMinorTickSpacing(10);
		m_slider.setPaintTicks(true);
		m_slider.setPaintLabels(true);
		pane.add(m_slider,BorderLayout.CENTER);

		JPanel pane1c = new JPanel();
		pane1c.setLayout(new FlowLayout());
		m_valueText = new JTextField(3);
		m_valueText.addActionListener(this);
		pane1c.add(m_valueText);
		pane.add(pane1c,BorderLayout.SOUTH);
		return (pane);
	}
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider)e.getSource();
		int fps = (int)source.getValue();
		if (!source.getValueIsAdjusting()) { //done adjusting
			m_app.setMyRGB(m_nNumber, m_slider.getValue());
		}
		else { //value is adjusting; just set the text
			m_valueText.setText(String.valueOf(fps));
		}
	}
	public void actionPerformed (ActionEvent e) {
		Object source = e.getSource();
		if (source instanceof JTextField) {
			int value = Integer.parseInt(m_valueText.getText());
			m_slider.setValue(value);
		}
	}
}

