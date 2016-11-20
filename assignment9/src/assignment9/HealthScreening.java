package assignment9;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
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
		
		   //getting current date and time using Date class
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
				
				if(name.getText().equals("")||age.getText().equals("")||cholesterol.getText().equals("")
						||weight.getText().equals("")||systolic.getText().equals("")
						||height.getText().equals("")||diastolic.getText().equals("")){
					name.setText("0");
					age.setText("0");
					cholesterol.setText("0");
					weight.setText("0");
					systolic.setText("0");
					height.setText("0");
					diastolic.setText("0");
				}
				

				BmiCalculator bmi = new BmiCalculator();
				PatientClassification classification = new PatientClassification();
				
				DecimalFormat df = new DecimalFormat("0.0");
				DecimalFormat df2 = new DecimalFormat("0.#");
				double bmiCalc = bmi.calculateBmi(Double.parseDouble(weight.getText())
						,Double.parseDouble(height.getText()),true);
			
				String bmiCalcFormatted = df.format(bmiCalc);
				
				String bloodPressureClassification = classification.bloodPressure(Integer.parseInt(systolic.getText()),Integer.parseInt(diastolic.getText()));
				
				String cholesterolClassification = classification.Cholesterol(Integer.parseInt(cholesterol.getText()));
				
				String bmiClassification = classification.BMI(bmiCalc);
				
				String h = height.getText();
				double heightFeet = Double.parseDouble(h);
				heightFeet=heightFeet/12;
				h=df2.format(heightFeet);

				String []data={"Health Screening for "+name.getText(), "\nDate: "+date.getText(),"Age: "+age.getText()+"     "+"Height: "
				+h+" feet"+"     "+"Weight: "+weight.getText(),"\nBody Mass Index: "+bmiCalcFormatted+" "
				+bmiClassification,"Total Cholesterol: "+cholesterol.getText()+" "+cholesterolClassification,"Blood Pressure: "
				+systolic.getText()+"/"+diastolic.getText()+" "+bloodPressureClassification};
				
				PatientFile patientfile = new PatientFile();
				patientfile.outFile(data,date.getText());
				
				PatientReport pr = new PatientReport();
				pr.displayPatientReport(data);

			}
		});
		btnPrintSummary.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				//JOptionPane.INFORMATION_MESSAGE("great\nnouse", "bird", 1);
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new java.io.File(".//PatientHealthScreenData"));
				int result = fileChooser.showOpenDialog(null);
				File selectedFile = null;
				
				if (result == JFileChooser.APPROVE_OPTION) {
				    selectedFile = fileChooser.getSelectedFile();
				    //System.out.println("Selected file: " + selectedFile.getAbsolutePath());
				}
				else if (result == JFileChooser.CANCEL_OPTION) {
				    System.out.println("Cancel was selected");
				    //System.exit(0);
				    
				}
				else if(selectedFile==null){
					System.out.println("no file selected");
					//System.exit(0);
				}
				PatientFile patientfile = new PatientFile();
				String[]inFile=patientfile.inFile(selectedFile);
				
				PatientSummary sum = new PatientSummary();
				sum.summary(inFile,date.getText());


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
