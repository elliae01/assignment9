package assignment9;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class HealthScreening {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HealthScreening window = new HealthScreening();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application..
	 */
	public HealthScreening() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 431, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(172, 54, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(172, 85, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(172, 116, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(172, 147, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(172, 178, 86, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblPatientName = new JLabel("Name");
		lblPatientName.setBounds(135, 57, 27, 14);
		frame.getContentPane().add(lblPatientName);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(135, 88, 27, 14);
		frame.getContentPane().add(lblDate);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(135, 119, 27, 14);
		frame.getContentPane().add(lblAge);
		
		JLabel lblTotalCholesteral = new JLabel("Total Cholesteral");
		lblTotalCholesteral.setBounds(76, 150, 86, 14);
		frame.getContentPane().add(lblTotalCholesteral);
		
		JLabel lblBodyMassIndex = new JLabel("Body Mass Index");
		lblBodyMassIndex.setBounds(76, 181, 86, 14);
		frame.getContentPane().add(lblBodyMassIndex);
		
		textField_5 = new JTextField();
		textField_5.setBounds(172, 209, 86, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblBloodPressure = new JLabel("Blood Pressure");
		lblBloodPressure.setBounds(91, 212, 71, 14);
		frame.getContentPane().add(lblBloodPressure);
		
		JLabel lblPatientHealthScreening = new JLabel("Patient Health Screening");
		lblPatientHealthScreening.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPatientHealthScreening.setBounds(10, 11, 176, 20);
		frame.getContentPane().add(lblPatientHealthScreening);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSubmit.setBounds(305, 227, 89, 23);
		frame.getContentPane().add(btnSubmit);
	}
}
