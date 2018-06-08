package ui.Remote;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class West extends JPanel {

	public West() {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("��Ʈ����");

		DefaultMutableTreeNode child1 = new DefaultMutableTreeNode("1��°�ڽ�");

		DefaultMutableTreeNode child2 = new DefaultMutableTreeNode("2��° �ڽ�");

		root.add(child1);
		root.add(child2);

		JTree myTree = new JTree(root);
		add(myTree);
	}

}
