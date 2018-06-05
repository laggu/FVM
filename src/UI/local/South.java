package ui.local;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class South extends JPanel {	
	South() {
		JButton b1,b2,b3,b4,b5,b6;
		
		b1=new JButton("Init");
		b3=new JButton("Add");
		b2=new JButton("Commit");
		b4=new JButton("Branch");
		b5=new JButton("Merge");
		b6=new JButton("Check Out");
		
		b1.setSize(30, 30);
		b2.setSize(20, 20);
		b3.setSize(20, 20);
		b4.setSize(20, 20);
		b5.setSize(20, 20);
		b6.setSize(20, 20);
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		
	}
}
