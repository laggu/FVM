package UI.local;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class North extends JPanel {
	JToolBar toolbar;
	JLabel l1,l2;
	JTextField location;
	JComboBox cbox;
	JButton bu;
	
	North(){
		setLayout(new GridLayout(1,5,3,3));
		
		toolbar = new JToolBar();
		l1=new JLabel("현재 위치: ");
		location=new JTextField(50);
		
		l2=new JLabel("프로젝트: ");
		cbox=new JComboBox();
		cbox.addItem("project1");
		
		bu = new JButton("프로젝트 변경");
		bu.setBackground(Color.lightGray);
		
		toolbar.add(l1);
		toolbar.add(location);
		toolbar.add(l2);
		toolbar.add(cbox);
		toolbar.add(bu);
		
		add(toolbar);
		setBackground(Color.PINK);
		
	}

}
