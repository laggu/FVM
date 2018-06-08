package UI.local.south;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Command.Add;

public class MergeButton extends JButton {
	public MergeButton(){
		this.setText("Merge");
		this.setFont(new Font("Times New Roman", Font.BOLD, 20));
		ActionListener add = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddButtonPrees();
			}
		};

		this.addActionListener(add);
	}

	void AddButtonPrees() {
		String name = JOptionPane.showInputDialog(null, "Merge");

		if (name == null)
			return;


		//init.execute();
	}
}
