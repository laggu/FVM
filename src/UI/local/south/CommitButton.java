package UI.local.south;

import Command.Commit;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CommitButton extends JButton {
	public CommitButton() {
		this.setText("Commit");
		this.setFont(new Font("Times New Roman", Font.BOLD, 20));

		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {

				JTextArea ta = new JTextArea("커밋 메시지",20, 20);
				
				switch (JOptionPane.showConfirmDialog(null, new JScrollPane(ta),"",JOptionPane.YES_NO_OPTION)) {
				case JOptionPane.YES_OPTION:
					System.out.println(ta.getText());
					new Commit().execute();
					break;
				}
				
			}
		});
	}

}
