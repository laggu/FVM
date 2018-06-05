package UI.Remote;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class South extends JPanel {
	JButton button1, button2, button3, button4;

	public South() {

		button1 = new JButton("Push");
		add(button1);

		button2 = new JButton("Pull");
		add(button2);

		button3 = new JButton("Path");
		add(button3);

		button4 = new JButton("Clone");
		add(button4);
	}
}
