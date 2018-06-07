package ui.local;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class LocalUI extends JPanel {
	
	LocalUI() {
		
		setLayout(new BorderLayout());
		
		add(new North(),BorderLayout.NORTH);
		add(new Center(),BorderLayout.CENTER);
		add(new South(),BorderLayout.SOUTH);
	}

}
