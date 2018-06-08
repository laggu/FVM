package UI.local.south;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Command.Add;
import Command.Branch;

public class BranchButton extends JButton {
	public BranchButton() {
		this.setText("Branch");
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
		String name = JOptionPane.showInputDialog(null, "생성할 Branch 이름을 입력하시오 ");

		if (name == null)
			return;

		Branch init = new Branch(name);

		init.execute();
	}
}
