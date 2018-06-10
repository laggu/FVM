package UI.local.south;

import Command.Branch;
import UI.local.LocalUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BranchButton extends JButton {
	private LocalUI localUI;
	public BranchButton(LocalUI localUI){
		this.localUI = localUI;
		this.setText("Branch");
		this.setFont(new Font("Times New Roman", Font.BOLD, 20));

		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				String name = JOptionPane.showInputDialog(null, "생성할 Branch 이름을 입력하시오 ");

				if (name == null)
					return;

				System.out.print("branchbutton get branchname : ");
				System.out.println(name);

				new Branch(name).execute();
			}
		});

		localUI.setCenterPanelText();
	}
}
