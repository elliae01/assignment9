package assignment9;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class HealthScreening {

	private JFrame frame;
	private JTextField name;
	private JTextField date;
	private JTextField age;
	private JTextField totalC;
	private JTextField BMI;
	private JTextField BP;

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
		
		name = new JTextField();
		name.setBounds(172, 54, 86, 20);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		date = new JTextField();
		date.setBounds(172, 85, 86, 20);
		frame.getContentPane().add(date);
		date.setColumns(10);
		
		age = new JTextField();
		age.setBounds(172, 116, 86, 20);
		frame.getContentPane().add(age);
		age.setColumns(10);
		
		totalC = new JTextField();
		totalC.setBounds(172, 147, 86, 20);
		frame.getContentPane().add(totalC);
		totalC.setColumns(10);
		
		BMI = new JTextField();
		BMI.setBounds(172, 178, 86, 20);
		frame.getContentPane().add(BMI);
		BMI.setColumns(10);
		
		JLabel lblPatientName = new JLabel("Name");
		lblPatientName.setBounds(128, 57, 34, 14);
		frame.getContentPane().add(lblPatientName);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(135, 88, 27, 14);
		frame.getContentPane().add(lblDate);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(135, 119, 27, 14);
		frame.getContentPane().add(lblAge);
		
		JLabel lblTotalCholesteral = new JLabel("Total Cholesteral");
		lblTotalCholesteral.setBounds(63, 150, 97, 14);
		frame.getContentPane().add(lblTotalCholesteral);
		
		JLabel lblBodyMassIndex = new JLabel("Body Mass Index");
		lblBodyMassIndex.setBounds(63, 181, 97, 14);
		frame.getContentPane().add(lblBodyMassIndex);
		
		BP = new JTextField();
		BP.setBounds(172, 209, 86, 20);
		frame.getContentPane().add(BP);
		BP.setColumns(10);
		
		JLabel lblBloodPressure = new JLabel("Blood Pressure");
		lblBloodPressure.setBounds(73, 212, 89, 14);
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
