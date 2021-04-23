package org.eclipse.om2m.smartehealth.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.eclipse.om2m.smartehealth.SmartConstants;
import org.eclipse.om2m.smartehealth.SmartController;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField name_field;
	private JTextField pre_field;
	private JTextField healthcard_field;
	private JTextField age_field;
	private JTextField treat_field;
	private JTextField phy_name_field;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;

	/**
	 * Launch the application.
	 */
	public static void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setTitle("Smart E-Health System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-500)/2, (screenSize.height-570)/2, 497, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		name_field = new JTextField();
		name_field.setBounds(169, 23, 203, 19);
		contentPane.add(name_field);
		name_field.setColumns(10);
		
		pre_field = new JTextField();
		pre_field.setBounds(169, 116, 203, 19);
		contentPane.add(pre_field);
		pre_field.setColumns(10);
		
		healthcard_field = new JTextField();
		healthcard_field.setColumns(10);
		healthcard_field.setBounds(169, 54, 203, 19);
		contentPane.add(healthcard_field);
		
		age_field = new JTextField();
		age_field.setColumns(10);
		age_field.setBounds(169, 85, 203, 19);
		contentPane.add(age_field);
		
		treat_field = new JTextField();
		treat_field.setColumns(10);
		treat_field.setBounds(169, 147, 203, 19);
		contentPane.add(treat_field);
		
		phy_name_field = new JTextField();
		phy_name_field.setColumns(10);
		phy_name_field.setBounds(169, 178, 203, 19);
		contentPane.add(phy_name_field);
		
		JLabel lblNewLabel = new JLabel("Patient name");
		lblNewLabel.setBounds(22, 24, 139, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Patient Health Card");
		lblNewLabel_1.setBounds(22, 54, 152, 19);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Date of Birth");
		lblNewLabel_2.setBounds(22, 87, 100, 15);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Prescription");
		lblNewLabel_3.setBounds(22, 118, 100, 15);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Type of Treatment");
		lblNewLabel_4.setBounds(22, 149, 139, 15);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Physician Name");
		lblNewLabel_5.setBounds(22, 188, 139, 15);
		contentPane.add(lblNewLabel_5);
		
		JTextArea out_Put = new JTextArea();
		out_Put.setBounds(68, 252, 335, 215);
		contentPane.add(out_Put);
		
		JButton button = new JButton("Submit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String namePatient = name_field.getText();
				String hcard =healthcard_field.getText();
				String preOrder = pre_field.getText();
				String birthOfDate = age_field.getText();
				String phyName = phy_name_field.getText();
				String treatType =treat_field.getText();
				SmartController.addData(hcard,namePatient,birthOfDate, treatType, preOrder, phyName );
				out_Put.setText(SmartController.getData(SmartConstants.AE_NAME,hcard));
				
				//JOptionPane.showMessageDialog(null, "Submit successful");
				
			}
		});
		button.setBounds(216, 215, 117, 25);
		contentPane.add(button);
		
		
	}
}
