package UI.local;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import Main.Status;

public class Center extends JPanel {
	private JTree tree;
	private JLabel l1,cb,ms;
	private JPanel center,east,cm;
	private LocalUI localPanel;
	
	Center(LocalUI localUI) {
	    localPanel = localUI;

		setLayout(new BorderLayout(5,5));
		
		center = new JPanel();
		east = new JPanel();
		
		center.setLayout(new BorderLayout());
		center.setBorder(new TitledBorder(new SoftBevelBorder(SoftBevelBorder.RAISED),"파일 목록"));
		setTree();

		add("Center",center);
		
		east.setLayout(new GridLayout(4, 1));
		//east.setBorder(new TitledBorder(new SoftBevelBorder(SoftBevelBorder.RAISED),"Current Branch:"));
		
		//JLabel east_1 = new JLabel();
		//east_1.setLayout(new GridLayout(4, 1));
		
		l1 = new JLabel("현재 브런치 정보 표시 창");
		l1.setBorder(new TitledBorder(new SoftBevelBorder(SoftBevelBorder.RAISED),"Current Branch:"));
		
		cm = new JPanel();
		cm.setLayout(new BorderLayout());
		cm.setBorder(new TitledBorder(new SoftBevelBorder(SoftBevelBorder.RAISED),"Commit Message"));

		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 0.1f;
		c.fill = GridBagConstraints.VERTICAL;
		ms = new JLabel("현재 commit 메시지 표시창");
		east.add(l1);
		east.add(cm,c);
		
		cm.add(ms);
		add("East",east);
	}

	public void setL1(String text) {
		this.l1.setText(text);
	}

	public void setMs(String text) {
		this.ms.setText(text);
	}

	void setTree() {
		North path = localPanel.getNorthPanel();
		String rootPath = path.location.getText();
        System.out.print("rootPath : ");
		System.out.println(rootPath);
		File rootDir = new File(rootPath);

		if(tree != null) {
            tree.removeAll();
            tree.updateUI();
        }

		DefaultMutableTreeNode root = new DefaultMutableTreeNode(rootPath);
		tree = new JTree(root);

		try {
			addTreeNode(root, rootDir.listFiles());
			
		}catch(Exception e) {
			e.printStackTrace();
		}

        MouseListener ml = new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int selRow = tree.getRowForLocation(e.getX(), e.getY());
                TreePath selPath = tree.getPathForLocation(e.getX(), e.getY());
                if(selRow != -1) {
                    if(e.getClickCount() == 2) {
                        String fName = tree.getLastSelectedPathComponent().toString();
                        System.out.println(fName);
                        if(fName.equals("..")){
                            path.location.setText(rootPath.substring(0,rootPath.lastIndexOf(Status.getFileDelimiter())));
                        }else{
                            path.location.setText(rootPath+ Status.getFileDelimiter() +fName);
                        }
                        System.out.print("after setText  ");
                        System.out.println(path.location.getText());
                        repaint();
                    }
                }
            }
        };
        tree.addMouseListener(ml);

        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent treeSelectionEvent) {
                System.out.print("treeselection listener  ");
                System.out.println(tree.getLastSelectedPathComponent().toString());
                localPanel.setSelectedFileName(tree.getLastSelectedPathComponent().toString());
            }
        });

        System.out.print("tree row count");
        System.out.println(tree.getRowCount());

        center.add(new JScrollPane(tree));
        add(center);

        tree.expandRow(0);
        tree.updateUI();
        revalidate();
//        repaint();
	}
	
	private void addTreeNode(DefaultMutableTreeNode root, File[] list) {
		DefaultMutableTreeNode rootnode = new DefaultMutableTreeNode("..");
		root.add(rootnode);
		System.out.println("addTreeNode");
		int i;
		for(i = 0 ; i < list.length; ++i) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(list[i].getName());
			if(list[i].isDirectory()) {
                node.add(new DefaultMutableTreeNode(".."));
			}
            root.add(node);
		}
		System.out.println(i);
	}
}
