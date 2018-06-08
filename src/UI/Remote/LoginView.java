package UI.Remote;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Network.Network;

public class LoginView extends JDialog {

	private JPasswordField passText;
	private JTextField userText;
	private boolean bLoginCheck;
	private JButton logButton;
	
	
	public LoginView(JButton button) {
		// setting
		setTitle("login");
		setSize(280, 150);
		setResizable(false);
		RemoteUI.centreWindow(this);
		logButton = button;
		// panel
		JPanel panel = new JPanel();
		placeLoginPanel(panel);

		// add
		add(panel);

		// visiible
		setVisible(true);
	}

	private void placeLoginPanel(JPanel panel) {
		panel.setLayout(null);
		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);

		JLabel passLabel = new JLabel("Pass");
		passLabel.setBounds(10, 40, 80, 25);
		panel.add(passLabel);

		userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		passText = new JPasswordField(20);
		passText.setBounds(100, 40, 160, 25);
		panel.add(passText);

		JButton button = new JButton("확인");

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				logButton.setText("로그아웃");
				dispose();
				
				/*
				boolean isLogin = login(userLabel.getInputContext().toString(), passLabel.getInputContext().toString());

				if (isLogin)
				{
					logButton.setText("로그아웃");
				}
				*/
				
				
			}
		});

		button.setBounds(60, 70, 80, 25);
		panel.add(button);

		JButton button2 = new JButton("취소");
		button2.setBounds(140, 70, 80, 25);

		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		panel.add(button2);
	}

	boolean login(String id, String pw) {

		Network netIns = Network.getInstance();
		return netIns.login(id, pw);
	}

}
