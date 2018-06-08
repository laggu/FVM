package UI.local;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;

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
		center.add(tree);
		add("Center",center);
		
		east.setLayout(new GridLayout(2, 1));
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
		// 트리
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(".");
		DefaultMutableTreeNode fvm = new DefaultMutableTreeNode("FVM");
		DefaultMutableTreeNode a = new DefaultMutableTreeNode("a.txt");
		fvm.add(a);
		
		root.add(fvm);
		tree = new JTree(root);
		
		tree.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				
			}
		});
		
		
	}

}
