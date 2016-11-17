package assignment9;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;

public class HealthScreening {

	private JFrame frame;
	private JTextField name;
	private JTextField date;
	private JTextField age;
	private JTextField totalC;
	private JTextField BMI;
	private JTextField BP;
	private JTextField textField;

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
		frame.setBounds(100, 100, 431, 352);
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
		
		JLabel lblBodyMassIndex = new JLabel("Weight");
		lblBodyMassIndex.setBounds(113, 181, 49, 14);
		frame.getContentPane().add(lblBodyMassIndex);
		
		BP = new JTextField();
		BP.setBounds(172, 240, 86, 20);
		frame.getContentPane().add(BP);
		BP.setColumns(10);
		
		JLabel lblBloodPressure = new JLabel("Blood Pressure");
		lblBloodPressure.setBounds(63, 243, 89, 14);
		frame.getContentPane().add(lblBloodPressure);
		
		JLabel lblPatientHealthScreening = new JLabel("Patient Health Screening");
		lblPatientHealthScreening.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPatientHealthScreening.setBounds(10, 11, 176, 20);
		frame.getContentPane().add(lblPatientHealthScreening);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSubmit.setBounds(172, 279, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		textField = new JTextField();
		textField.setBounds(172, 209, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblHeight = new JLabel("Height");
		lblHeight.setBounds(113, 212, 49, 14);
		frame.getContentPane().add(lblHeight);
		
		JButton btnPrintSummary = new JButton("Print Summary");
		btnPrintSummary.setBounds(271, 280, 134, 23);
		frame.getContentPane().add(btnPrintSummary);
		
		btnSubmit.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				
				String []data={name.getText(),age.getText(),totalC.getText(),BP.getText()};
				try {
					Writer fileWriter = new FileWriter(".//bin//"+date.getText()+"out.txt",true);
					for(int i=0; i < data.length; i++)
					{
					fileWriter.append(data[i]+"\r\n");
					}
					fileWriter.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		});
		btnPrintSummary.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new java.io.File(".//bin"));
				int result = fileChooser.showOpenDialog(null);
				File selectedFile = null;
				if (result == JFileChooser.APPROVE_OPTION) {
				    selectedFile = fileChooser.getSelectedFile();
				    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
				}
				else if (result == JFileChooser.CANCEL_OPTION) {
				    System.out.println("Cancel was selected");
				    System.exit(0);
				}
				else if(selectedFile ==null){
					System.out.println("no file selected");
					System.exit(0);
				}
				String[]data = null;
				
				try {
					BufferedReader br = new BufferedReader(new FileReader(selectedFile));
				    //StringBuilder sb = new StringBuilder();
				    String line;
				    int i=0;
				    List<String> list = new ArrayList<String>();
				    while((line = br.readLine()) != null){
				        list.add(line);
				        System.out.println(line);
				    }

				    String[] stringArr = list.toArray(new String[0]);
				    System.out.println(stringArr[1]);
				    br.close();
		
				} catch (IOException e1) {
				
					e1.printStackTrace();
				}	
				
			}
		});
	}
}
