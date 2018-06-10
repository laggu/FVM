package UI.local.south;

import Command.Checkout;
import UI.local.LocalUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CheckOutButton extends JButton {
	private LocalUI localUI;
	public CheckOutButton(LocalUI localUI){
		this.localUI = localUI;
		this.setText("CheckOut");
		this.setFont(new Font("Times New Roman", Font.BOLD, 20));

		ActionListener add = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog(null, "CheckOut할 Branch 이름을 입력하시오.");

				if (name == null)
					return;

				Checkout init = new Checkout(name);

				init.execute();
			}
		};

		this.addActionListener(add);
		localUI.setCenterPanelText();
	}

}
