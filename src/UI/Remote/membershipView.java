package UI.Remote;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class membershipView extends JDialog {

	
	private JTextField userText;
	
	public membershipView() {
		// setting
		setTitle("membership");
		setSize(280, 150);
		setResizable(false);
		//setLocation(800, 450);
		RemoteUI.centreWindow(this);
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
		
		userText = new JTextField(20);
		userText.setBounds(100, 40, 160, 25);
		panel.add(userText);
		
		JButton button = new JButton("확인");
		button.setBounds(60, 70, 80, 25);
		panel.add(button);
		
		button.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
		
		JButton button2 = new JButton("취소");
		button2.setBounds(140, 70, 80, 25);
		panel.add(button2);
		
		button2.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});

	}
}
