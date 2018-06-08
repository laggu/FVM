package UI.local.south;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Command.Add;
import Command.Checkout;

public class CheckOutButton extends JButton {
	public CheckOutButton(){
		this.setText("CheckOut");
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
		String name = JOptionPane.showInputDialog(null, "CheckOut할 Branch 이름을 입력하시오.");

		if (name == null)
			return;

		Checkout init = new Checkout(name);

		init.execute();
	}
}
