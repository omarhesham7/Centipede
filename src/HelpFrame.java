import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelpFrame extends JFrame {
	private GameFrame gameframe;

	public HelpFrame() {
		super("Help");
		JLabel label = new JLabel();
		label.setText("<html>��: " + "Move Right" + "<br />��:" + "Move Left" + "<br />��:" + "Move Up" + "<br />��:"
				+ "Move Down" + "<br />U:" + "Increase Level" + "<br />D:" + "Decrease Level" + "<br />Space:" + "Shoot"
				+ "<br />1:" + "Laser Gun" + "<br />2:" + "Shotgun" + "<br />3:" + "AP Gun" + "</HTML>");
		this.add(label, BorderLayout.CENTER);
	}
}
