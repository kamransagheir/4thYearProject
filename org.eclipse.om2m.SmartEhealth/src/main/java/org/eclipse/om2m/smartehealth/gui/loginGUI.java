package org.eclipse.om2m.smartehealth.gui;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;

public class loginGUI {

	private JFrame frame;
	private JTextField username;
	private JPasswordField password_field;

	/**
	 * Launch the application.
	 */
	public static void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					selectionGUI window = new selectionGUI();
					window.init();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public loginGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 480, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(76, 97, 97, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(81, 142, 70, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		username = new JTextField();
		username.setBounds(191, 95, 182, 19);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		JButton btnNewButton = new JButton("login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usr = username.getText();
				String psw = password_field.getText();
				if(usr.equals("admin") && psw.equals("admin")) {
					selectionGUI regFrom = new selectionGUI();
					regFrom.init();
					
				}else {
					JOptionPane.showMessageDialog(frame, "Invalid username or password");
					
				}
			}
		});
		btnNewButton.setBounds(203, 187, 117, 25);
		frame.getContentPane().add(btnNewButton);
		
		password_field = new JPasswordField();
		password_field.setBounds(191, 140, 182, 19);
		frame.getContentPane().add(password_field);
		
		JLabel lblNewLabel_2 = new JLabel("SMART E-health Login System");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(139, 28, 221, 25);
		frame.getContentPane().add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(56, 173, 391, 4);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(50, 81, 397, 4);
		frame.getContentPane().add(separator_1);
	}
}
