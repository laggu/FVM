package ui.local.south;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class InitButton extends JButton {
	public InitButton() {
		this.setText("Init");
		this.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		ActionListener init = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		
		
	}

}
