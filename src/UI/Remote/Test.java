package ui.Remote;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Test extends JFrame {

	public Test() {
		setLayout(new BorderLayout());
		setSize(1000, 600);
		setVisible(true);

		add(new East(), BorderLayout.EAST);
		add(new South(), BorderLayout.SOUTH);
		add(new West(), BorderLayout.WEST);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		Test test = new Test();

	}
}
