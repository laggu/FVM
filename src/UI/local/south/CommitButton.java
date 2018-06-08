package UI.local.south;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Command.Add;
import Command.Commit;

public class CommitButton extends JButton {
	public CommitButton(){
		this.setText("Commit");
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
		String name = JOptionPane.showInputDialog(null, "저장할 메시지를 입력하시요.");

		if (name == null)
			return;

		Commit init = new Commit();

		init.execute();
	}
}
