package UI.local;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class LocalUI extends JPanel {
	
	public LocalUI() {
		
		setLayout(new BorderLayout());
		
		add(new North(),BorderLayout.NORTH);
		add(new Center(),BorderLayout.CENTER);
		add(new East(),BorderLayout.EAST);
		add(new South(),BorderLayout.SOUTH);
	}

}
