package UI.local.south;

import Command.Commit;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CommitButton extends JButton {
	public CommitButton(){
		this.setText("Commit");
		this.setFont(new Font("Times New Roman", Font.BOLD, 20));

		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				new Commit().execute();
			}
		});
	}

}
