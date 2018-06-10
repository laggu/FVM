package UI.local;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class North extends JPanel {
	private JToolBar toolbar;
	private JLabel l1,l2;
	JTextField location;
	private JComboBox cbox;
	private JButton bu;
	private String homePath = System.getProperty("user.home");

	private LocalUI localPanel;
	
	North(LocalUI localPanel){
		this.localPanel = localPanel;
		setLayout(new GridLayout(1,5,3,3));
		
		toolbar = new JToolBar();
		
		l2=new JLabel("프로젝트: ");
		cbox=new JComboBox();
		cbox.addItem("project1");
		
		l1=new JLabel("현재 위치: ");
		location=new JTextField(homePath,50);
		
		bu = new JButton("위치 변경");
		bu.setBackground(Color.lightGray);
		
		
		toolbar.add(l2);
		toolbar.add(cbox);
		toolbar.add(l1);
		toolbar.add(location);
		toolbar.add(bu);
		
		bu.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()!=null) {
					localPanel.updateCenterPanel();
				}

			}
		});

		
		add(toolbar);
		setBackground(Color.PINK);
		
		
	}


	public JTextField getLocationTextField(){
		return location;
	}
}
