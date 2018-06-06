package UI.local;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainUI extends JFrame {
	private JTabbedPane tab = new JTabbedPane();
	private JPanel local = new LocalUI();
	private JPanel remote = new JPanel();
	
	public MainUI() {
		setTitle("File Version Management Program");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tab.add("LOCAL",local);
		tab.add("REMOTE",remote);
		
		add(tab);
		
		
		setSize(1000,600);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		// local ui test
		new MainUI();
	}
	
	

}
