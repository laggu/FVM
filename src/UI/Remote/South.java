package UI.Remote;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class South extends JPanel {

	public South() {
		setLayout(new GridLayout(1, 4, 3, 3));


		JButton button1 = new JButton("Push");
		JButton button2 = new JButton("pull");
		JButton button3 = new JButton("push");
		JButton button4 = new JButton("clone");

		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// new PushView();

			}
		});

		button1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		button2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		button3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		button4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		
		add(button1);
		add(button2);
		add(button3);
		add(button4);
	}

}
