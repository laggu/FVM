package ui.Remote;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;

public class RemoteUI extends JPanel {

	public RemoteUI(JFrame frame) {
		this.init();
		frame.setResizable(false);
		this.start();
		frame.setSize(950, 450);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension di = tk.getScreenSize();
		Dimension di1 = this.getSize();
		
		frame.setLocation((int) (di.getHeight() / 2 - di1.getHeight() / 2),
				(int) (di.getWidth() / 2 - di1.getWidth() / 2));

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void init() {

		this.setLayout(new BorderLayout(5, 5));

		JPanel jp = new JPanel(new BorderLayout(5, 5));
		JPanel jp1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp1.setBorder(new TitledBorder(new SoftBevelBorder(SoftBevelBorder.RAISED), "정보 창"));

		DefaultMutableTreeNode node;
		node = new DefaultMutableTreeNode("메인노드");
		node.add(new DefaultMutableTreeNode("Hi~"));
		node.add(new DefaultMutableTreeNode("Hello~"));
		node.add(new DefaultMutableTreeNode("Nice to meet you~"));
		JTree xTree = new JTree(node);
		jp1.add(xTree);

		DefaultMutableTreeNode node2;
		node2 = new DefaultMutableTreeNode("메인노드�");
		node2.add(new DefaultMutableTreeNode("Hi~"));
		node2.add(new DefaultMutableTreeNode("Hello~"));
		node2.add(new DefaultMutableTreeNode("Nice to meet you~"));
		JTree xTree2 = new JTree(node2);

		jp1.add(xTree2);

		jp.add("Center", jp1);
		// �ϴ� �г�
		JPanel jp2 = new JPanel(new GridLayout(1, 4, 1, 1));

		// �ϴ� ��ư��
		JButton button1 = new JButton("Push");
		JButton button2 = new JButton("pull");
		JButton button3 = new JButton("push");
		JButton button4 = new JButton("clone");

		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// new PushView();

			}
		});

		jp2.add(button1);
		jp2.add(button2);
		jp2.add(button3);
		jp2.add(button4);
		// jp.add(jp2,BorderLayout.SOUTH);
		jp.add("South", jp2); 

		JPanel jp3 = new JPanel(new GridLayout(6, 1, 1, 1));
		
		JButton button3_1 = new JButton("로그인");

		button3_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new LoginView();
			}
		});

		JButton button3_2 = new JButton("회원가입");

		button3_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new membershipView();
			}
		});

		String combos[] = { "1", "2", "3" };
		JComboBox<String> cobo = new JComboBox<String>(combos);

		String combos2[] = { "1", "2", "3" };
		JComboBox<String> cobo2 = new JComboBox<String>(combos);

		JPanel jp3_1 = new JPanel(new GridLayout(1, 2, 1, 1));
		jp3_1.setBorder(new TitledBorder(new SoftBevelBorder(SoftBevelBorder.RAISED), "회원"));
		jp3_1.add(button3_1);
		jp3_1.add(button3_2);
		jp3.add(jp3_1);

		JPanel jp3_2 = new JPanel(new GridLayout(2, 2, 1, 1));
		jp3_2.setBorder(new TitledBorder(new SoftBevelBorder(SoftBevelBorder.RAISED), "리포지터리"));
		jp3_2.add(cobo);
		jp3.add(jp3_2);

		JPanel jp3_3 = new JPanel(new GridLayout(2, 2, 1, 1));
		jp3_3.setBorder(new TitledBorder(new SoftBevelBorder(SoftBevelBorder.RAISED), "브런치"));
		jp3_3.add(cobo2);
		jp3.add(jp3_3);

		JPanel jp3_4 = new JPanel(new GridLayout(1, 2, 1, 1));
		jp3_4.setBorder(new TitledBorder(new SoftBevelBorder(SoftBevelBorder.RAISED), "메시지"));
		JLabel la = new JLabel("aaaaaaaaaaaa" + '\n' + "aaaaaaaaaaaaa");
		jp3_4.add(la);
		jp3.add(jp3_4);

		this.add(jp); 
		this.add("East", jp3);

		JPanel jp4 = new JPanel(new BorderLayout());
		JPanel jp5 = new JPanel(new GridLayout(4, 1));

		JPanel jp6 = new JPanel(new GridLayout(4, 1));

	}

	public void start() {
		

	}

}
