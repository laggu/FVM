package UI.Remote;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class West extends JPanel {

	public West() {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("루트노드요");

		DefaultMutableTreeNode child1 = new DefaultMutableTreeNode("1번째자식");

		DefaultMutableTreeNode child2 = new DefaultMutableTreeNode("2번째 자식");

		root.add(child1);
		root.add(child2);

		JTree myTree = new JTree(root);
		add(myTree);
	}

}
