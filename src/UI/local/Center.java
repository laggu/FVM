package ui.local;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class Center extends JPanel {
	JTree tree;
	JLabel l1,cb,ms;
	JPanel center,east,cm;
	
	Center() {
		
		setLayout(new BorderLayout(5,5));
		
		center = new JPanel();
		east = new JPanel();
		
		center.setLayout(new BorderLayout());
		center.setBorder(new TitledBorder(new SoftBevelBorder(SoftBevelBorder.RAISED),"파일 목록"));
		setTree();
		center.add(new JScrollPane(tree));
		add("Center",center);
		
		east.setLayout(new GridLayout(2, 2));
		east.setBorder(new TitledBorder(new SoftBevelBorder(SoftBevelBorder.RAISED),"Status"));
		l1 = new JLabel("Current Branch:");
		cb = new JLabel("");
		
		cm = new JPanel();
		cm.setLayout(new BorderLayout());
		cm.setBorder(new TitledBorder(new SoftBevelBorder(SoftBevelBorder.RAISED),"Commit Message"));
		ms = new JLabel("update DB");
		east.add(l1);
		east.add(cb);
		east.add(cm);
		cm.add(ms);
		add("East",east);
	}

	void setTree() {
		North path = new North();
		String rootPath = path.location.getText();
		System.out.println(rootPath);
		File rootDir = new File(rootPath);
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode();
		tree = new JTree(root);
		
		try {
			addTreeNode(root, rootDir.listFiles());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		tree.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getSource() == path.location)
		        {
		            path.location.selectAll();
		        }
			}
		});
	}
	
	private void addTreeNode(DefaultMutableTreeNode root, File[] list) {
		DefaultMutableTreeNode rootnode = new DefaultMutableTreeNode("..");
		root.add(rootnode);
		for(int i = 0 ; i < list.length; ++i) {
//			if(list[i].isFile()) {
//				DefaultMutableTreeNode node = new DefaultMutableTreeNode(list[i].getName());
//				root.add(node);
//			}
//			else if(list[i].isDirectory()) {
//				DefaultMutableTreeNode node = new DefaultMutableTreeNode(list[i].getName());
//				if(list[i].listFiles() != null)
//					addTreeNode(node, list[i].listFiles());
//			}
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(list[i].getName());
			root.add(node);
		}
	}
	

}
