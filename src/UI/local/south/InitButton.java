package UI.local.south;

import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Command.Init;

public class InitButton extends JButton {
	public InitButton() {
		this.setText("Init");
		this.setFont(new Font("Times New Roman", Font.BOLD, 20));

		ActionListener init = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				//확인 취소 확인 
				InitButtonPrees();
			}
		};
		
		this.addActionListener(init);
	}
	
	
	void InitButtonPrees()
	{
		
		String name =  JOptionPane.showInputDialog(null, "프로젝트 이름을 입력하시오.");
		
		if(name == null) return;
		
		Init init = new Init(name);
		
		init.execute();
	}
	

}
