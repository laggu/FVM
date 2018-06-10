package UI.local.south;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Command.Merge;
import UI.local.LocalUI;

public class MergeButton extends JButton {
	private LocalUI localUI;
	public MergeButton(LocalUI localUI){
		this.localUI = localUI;
		this.setText("Merge");
		this.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// init 실행
				String name =  JOptionPane.showInputDialog(null, "프로젝트 이름을 입력하시오.");

				Merge merge = new Merge(name, localUI);

				merge.execute();

			}
		});
	}
}
