package UI.local.south;

import Command.Add;
import UI.local.LocalUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AddButton extends JButton {
	private LocalUI localUI;
	public AddButton(LocalUI localUI) {
		this.localUI = localUI;
		this.setText("Add");
		this.setFont(new Font("Times New Roman", Font.BOLD, 20));

		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = localUI.getSelectedFileName();

				Add init = new Add(name);

				init.execute();
			}
		};

		this.addActionListener(listener);
	}

}
