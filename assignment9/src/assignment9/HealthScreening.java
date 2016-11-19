package assignment9;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
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
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Color;

public class HealthScreening {

	private JFrame frmGlenview;
	private JTextField name;
	private JTextField date;
	private JTextField age;
	private JTextField cholesterol;
	private JTextField weight;
	private JTextField systolic;
	private JTextField height;
	private JTextField diastolic;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HealthScreening window = new HealthScreening();
					window.frmGlenview.setVisible(true);
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
		frmGlenview = new JFrame();
		frmGlenview.setResizable(false);
		frmGlenview.setTitle("Glenview                   "
				+ "                           ");
		frmGlenview.getContentPane().setBackground(new Color(255, 255, 255));
		frmGlenview.setBounds(100, 100, 372, 399);
		frmGlenview.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGlenview.getContentPane().setLayout(null);
		
		JLabel b2 = new JLabel(new ImageIcon("glenview2.png"));
		b2.setBounds(0, 0, 196, 61);
		frmGlenview.getContentPane().add(b2);

		name = new JTextField();
		name.setBounds(137, 104, 86, 20);
		frmGlenview.getContentPane().add(name);
		name.setColumns(10);
		
		date = new JTextField();
		date.setEditable(false);
		date.setBounds(137, 76, 86, 20);
		frmGlenview.getContentPane().add(date);
		date.setColumns(10);
		
		age = new JTextField();
		age.setBounds(137, 135, 86, 20);
		frmGlenview.getContentPane().add(age);
		age.setColumns(10);
		
		cholesterol = new JTextField();
		cholesterol.setBounds(137, 225, 86, 20);
		frmGlenview.getContentPane().add(cholesterol);
		cholesterol.setColumns(10);
		
		weight = new JTextField();
		weight.setBounds(137, 166, 86, 20);
		frmGlenview.getContentPane().add(weight);
		weight.setColumns(10);
		
		JLabel lblPatientName = new JLabel("Name");
		lblPatientName.setForeground(new Color(0, 102, 204));
		lblPatientName.setBounds(91, 110, 34, 14);
		frmGlenview.getContentPane().add(lblPatientName);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(new Color(0, 102, 204));
		lblDate.setBounds(98, 82, 27, 14);
		frmGlenview.getContentPane().add(lblDate);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setForeground(new Color(0, 102, 204));
		lblAge.setBounds(101, 141, 27, 14);
		frmGlenview.getContentPane().add(lblAge);
		
		JLabel lbCholesteral = new JLabel("Cholesteral");
		lbCholesteral.setForeground(new Color(0, 102, 204));
		lbCholesteral.setBounds(58, 231, 67, 14);
		frmGlenview.getContentPane().add(lbCholesteral);
		
		JLabel lblBodyMassIndex = new JLabel("Weight");
		lblBodyMassIndex.setForeground(new Color(0, 102, 204));
		lblBodyMassIndex.setBounds(83, 172, 42, 14);
		frmGlenview.getContentPane().add(lblBodyMassIndex);
		
		systolic = new JTextField();
		systolic.setBounds(137, 253, 86, 20);
		frmGlenview.getContentPane().add(systolic);
		systolic.setColumns(10);
		
		JLabel lblBloodPressure = new JLabel("Blood Pressure");
		lblBloodPressure.setForeground(new Color(0, 102, 204));
		lblBloodPressure.setBounds(34, 256, 96, 14);
		frmGlenview.getContentPane().add(lblBloodPressure);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSubmit.setBounds(20, 304, 89, 23);
		frmGlenview.getContentPane().add(btnSubmit);
		
		height = new JTextField();
		height.setBounds(137, 194, 86, 20);
		frmGlenview.getContentPane().add(height);
		height.setColumns(10);
		
		JLabel lblHeight = new JLabel("Height");
		lblHeight.setForeground(new Color(0, 102, 204));
		lblHeight.setBounds(86, 200, 42, 14);
		frmGlenview.getContentPane().add(lblHeight);
		
		JButton btnPrintSummary = new JButton("Print Summary");
		btnPrintSummary.setBounds(115, 305, 134, 23);
		frmGlenview.getContentPane().add(btnPrintSummary);
		
		diastolic = new JTextField();
		diastolic.setBounds(233, 253, 86, 20);
		frmGlenview.getContentPane().add(diastolic);
		diastolic.setColumns(10);
		
		JLabel lblSystolic = new JLabel("systolic");
		lblSystolic.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblSystolic.setBounds(161, 270, 46, 14);
		frmGlenview.getContentPane().add(lblSystolic);
		
		JLabel lblNewLabel = new JLabel("diastolic");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setBounds(255, 270, 46, 14);
		frmGlenview.getContentPane().add(lblNewLabel);
		
		JButton btnExport = new JButton("Export");
		btnExport.setBounds(255, 305, 89, 23);
		frmGlenview.getContentPane().add(btnExport);
		
	       DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
	       Calendar calobj = Calendar.getInstance();
	       //System.out.println(df.format(calobj.getTime()));
	       date.setText(df.format(calobj.getTime()));
	       
	       JLabel lblLbs = new JLabel("lbs.");
	       lblLbs.setFont(new Font("Tahoma", Font.PLAIN, 10));
	       lblLbs.setBounds(225, 169, 46, 14);
	       frmGlenview.getContentPane().add(lblLbs);
	       
	       JLabel lblIn = new JLabel("inches");
	       lblIn.setFont(new Font("Tahoma", Font.PLAIN, 10));
	       lblIn.setBounds(225, 197, 46, 14);
	       frmGlenview.getContentPane().add(lblIn);
	       
	       JButton btnClearAll = new JButton("Clear All");
	       btnClearAll.setBounds(134, 339, 89, 23);
	       frmGlenview.getContentPane().add(btnClearAll);
		
		btnSubmit.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				
				BmiCalculator bmi = new BmiCalculator();
				PatientClassification classification = new PatientClassification();
				
				double bmiCalc = bmi.calculateBmi(Double.parseDouble(weight.getText())
						,Double.parseDouble(height.getText()),true);
				System.out.println(bmiCalc);
				
				String bloodPressureClassification = classification.bloodPressure(Integer.parseInt(systolic.getText()),Integer.parseInt(diastolic.getText()));
				
				String cholesterolClassification = classification.Cholesterol(Integer.parseInt(cholesterol.getText()));
				
				String bmiClassification = classification.BMI(bmiCalc);
				
				String []data={name.getText(),age.getText(),bmiClassification,
						cholesterolClassification,bloodPressureClassification};
				try {
					Writer fileWriter = new FileWriter(".//bin//"+date.getText()+"_out.txt",true);
					
					for(int i=0; i < data.length; i++){
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
				
				 //getting current date and time using Date class

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
				    //System.exit(0);
				    
				}
				else if(selectedFile==null){
					System.out.println("no file selected");
					//System.exit(0);
				}
			
				
				try {
					BufferedReader br = new BufferedReader(new FileReader(selectedFile));
				  
				    String line;
	
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
		btnClearAll.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				name.setText("");
				age.setText("");
				cholesterol.setText("");
				weight.setText("");
				systolic.setText("");
				height.setText("");
				diastolic.setText("");
				
			}
		});
	}
}
