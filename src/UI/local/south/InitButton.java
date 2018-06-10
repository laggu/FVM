package UI.local.south;

import Command.Init;
import UI.local.LocalUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class InitButton extends JButton {
	private LocalUI localUI;
	public InitButton(LocalUI localUI) {
		this.localUI = localUI;
		this.setText("Init");
		this.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// init 실행
				String path = localUI.getNorthPanel().getLocationTextField().getText();
				String name =  JOptionPane.showInputDialog(null, "프로젝트 이름을 입력하시오.");

				if(name == null) return;

				Init init = new Init(name, path);

				init.execute();

			}
		});
		
		
	}

}
