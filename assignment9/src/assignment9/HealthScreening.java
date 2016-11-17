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
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Color;

public class HealthScreening {

	private JFrame frame;
	private JTextField name;
	private JTextField date;
	private JTextField age;
	private JTextField totalC;
	private JTextField BMI;
	private JTextField BP;
	private JTextField textField;
	private JTextField textField_1;

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
		frame.getContentPane().setBackground(new Color(175, 238, 238));
		frame.setBounds(100, 100, 385, 352);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		name = new JTextField();
		name.setBounds(116, 79, 86, 20);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		date = new JTextField();
		date.setBounds(116, 51, 86, 20);
		frame.getContentPane().add(date);
		date.setColumns(10);
		
		age = new JTextField();
		age.setBounds(116, 110, 86, 20);
		frame.getContentPane().add(age);
		age.setColumns(10);
		
		totalC = new JTextField();
		totalC.setBounds(116, 200, 86, 20);
		frame.getContentPane().add(totalC);
		totalC.setColumns(10);
		
		BMI = new JTextField();
		BMI.setBounds(116, 141, 86, 20);
		frame.getContentPane().add(BMI);
		BMI.setColumns(10);
		
		JLabel lblPatientName = new JLabel("Name");
		lblPatientName.setBounds(72, 82, 34, 14);
		frame.getContentPane().add(lblPatientName);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(79, 54, 27, 14);
		frame.getContentPane().add(lblDate);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(79, 113, 27, 14);
		frame.getContentPane().add(lblAge);
		
		JLabel lbCholesteral = new JLabel("Cholesteral");
		lbCholesteral.setBounds(39, 203, 67, 14);
		frame.getContentPane().add(lbCholesteral);
		
		JLabel lblBodyMassIndex = new JLabel("Weight");
		lblBodyMassIndex.setBounds(64, 144, 42, 14);
		frame.getContentPane().add(lblBodyMassIndex);
		
		BP = new JTextField();
		BP.setBounds(116, 228, 86, 20);
		frame.getContentPane().add(BP);
		BP.setColumns(10);
		
		JLabel lblBloodPressure = new JLabel("Blood Pressure");
		lblBloodPressure.setBounds(21, 231, 96, 14);
		frame.getContentPane().add(lblBloodPressure);
		
		JLabel lblPatientHealthScreening = new JLabel("Patient Health Screening");
		lblPatientHealthScreening.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPatientHealthScreening.setBounds(10, 11, 176, 20);
		frame.getContentPane().add(lblPatientHealthScreening);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSubmit.setBounds(21, 279, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		textField = new JTextField();
		textField.setBounds(116, 169, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblHeight = new JLabel("Height");
		lblHeight.setBounds(64, 169, 42, 14);
		frame.getContentPane().add(lblHeight);
		
		JButton btnPrintSummary = new JButton("Print Summary");
		btnPrintSummary.setBounds(116, 280, 134, 23);
		frame.getContentPane().add(btnPrintSummary);
		
		textField_1 = new JTextField();
		textField_1.setBounds(212, 228, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblSystolic = new JLabel("systolic");
		lblSystolic.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblSystolic.setBounds(140, 245, 46, 14);
		frame.getContentPane().add(lblSystolic);
		
		JLabel lblNewLabel = new JLabel("diastolic");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel.setBounds(234, 245, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnExport = new JButton("Export");
		btnExport.setBounds(260, 280, 89, 23);
		frame.getContentPane().add(btnExport);
		
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
