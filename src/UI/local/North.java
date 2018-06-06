package UI.local;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JToolBar;

public class North extends JPanel {
	North(){
		JToolBar toolbar = new JToolBar();
		
		setLayout(new FlowLayout());
		
		add(toolbar);
		
	}

}
