package UI.Remote;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;

public class Center  extends JPanel{

	public Center() {
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setBorder(new TitledBorder(new SoftBevelBorder(SoftBevelBorder.RAISED), "정보 창"));

		DefaultMutableTreeNode node;
		node = new DefaultMutableTreeNode("메인노드");
		node.add(new DefaultMutableTreeNode("Hi~"));
		node.add(new DefaultMutableTreeNode("Hello~"));
		node.add(new DefaultMutableTreeNode("Nice to meet you~"));
		JTree xTree = new JTree(node);
		add(xTree);

		setVisible(true);
	}
}
