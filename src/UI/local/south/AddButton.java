package UI.local.south;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Command.Add;
import Command.Init;

public class AddButton extends JButton {
	public AddButton() {
		this.setText("Add");
		this.setFont(new Font("Times New Roman", Font.BOLD, 20));
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddButtonPrees();
			}
		};

		this.addActionListener(listener);
	}

	void AddButtonPrees() {
		String name = JOptionPane.showInputDialog(null, "추가할 파일이름을 입력하시오");

		if (name == null)
			return;

		Add init = new Add(name);

		init.execute();
	}

}
