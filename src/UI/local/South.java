package UI.local;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import UI.local.south.*;

public class South extends JPanel {	
	private JButton b1,b2,b3,b4,b5,b6;
	private LocalUI localUI;
	
	South(LocalUI localUI) {
		this.localUI = localUI;
		setLayout(new GridLayout(1,6,3,3));
		
		b1=new InitButton(localUI);
		b2=new AddButton(localUI);
		b3=new CommitButton(localUI);
		b4=new BranchButton(localUI);
		b5=new MergeButton(localUI);
		b6=new CheckOutButton(localUI);
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		
		setBackground(Color.lightGray);
		
	}
}
