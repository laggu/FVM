package UI.local;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class East extends JPanel {
	private JLabel l1,l2;
	private JTextField cbr;
	private JTextArea cm;
	
	public East(){
		
		GridLayout grid = new GridLayout(5, 2);
		
		grid.setVgap(2);
		setLayout(grid);
		
		l1=new JLabel("Current Branch: ");
		cbr=new JTextField("");
		l2=new JLabel("Commit Message: ");
		cm = new JTextArea("");

		
		add(l1);
		add(cbr);
		add(l2);
		add(cm);
		
		
	}

}
