package UI.local;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Iterator;

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

import DB.Commit_DAO;
import DB.Project_DAO;
import DB.Vo_Project;
import Main.CommitTree;
import Main.Status;

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
		
		ArrayList<Vo_Project> projectNames = Project_DAO.projectSelect();
		Iterator it = projectNames.iterator();
		while(it.hasNext()) {
			Vo_Project temp = (Vo_Project)it.next();
			cbox.addItem(temp.getPName());
		}
		
		cbox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED) {
			          String item = (String)e.getItem();
			          makeTree(item);
			       }
			}
			
		});

		
		l1=new JLabel("현재 위치: ");
		location=new JTextField(homePath,50);
		

		if(!projectNames.isEmpty())
			makeTree(projectNames.get(0).getPName());
		
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
	
	private void makeTree(String projectName) {
		ArrayList<Status> statusList = Commit_DAO.CommitSelect(projectName);
        CommitTree tree = CommitTree.newInstance();
        Iterator it = statusList.iterator();
        while(it.hasNext()) {
      	  Status s = (Status)it.next();
      	  System.out.println(s);
      	  tree.addCommitNode(s);
        }
        Status status = Status.newInstance("master");
        System.out.println(status.getRootPath());
        location.setText(status.getRootPath());
        localPanel.updateCenterPanel();
	}
}
