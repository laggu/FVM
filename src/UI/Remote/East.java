package UI.Remote;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

import Network.Network;

public class East extends JPanel {

	public East() {
		
		setLayout(new GridLayout(6, 1, 1, 1));
		
		JButton button3_1 = new JButton("로그인");

		button3_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(button3_1.getText().equals("로그인"))
				{
					new LoginView(button3_1);
				}
				else 
				{
					Network netIns = Network.getInstance();
					netIns.logout();
					button3_1.setText("로그인");
				}
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
		add(jp3_1);

		JPanel jp3_2 = new JPanel(new GridLayout(2, 2, 1, 1));
		jp3_2.setBorder(new TitledBorder(new SoftBevelBorder(SoftBevelBorder.RAISED), "리포지터리"));
		jp3_2.add(cobo);
		add(jp3_2);

		JPanel jp3_3 = new JPanel(new GridLayout(2, 2, 1, 1));
		jp3_3.setBorder(new TitledBorder(new SoftBevelBorder(SoftBevelBorder.RAISED), "브런치"));
		jp3_3.add(cobo2);
		add(jp3_3);

		JPanel jp3_4 = new JPanel(new GridLayout(1, 2, 1, 1));
		jp3_4.setBorder(new TitledBorder(new SoftBevelBorder(SoftBevelBorder.RAISED), "메시지"));
		JLabel la = new JLabel("aaaaaaaaaaaa" + '\n' + "aaaaaaaaaaaaa");
		jp3_4.add(la);
		add(jp3_4);

	}

}
