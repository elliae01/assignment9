package Controller;
import Model.BmiCalculator;

import Model.PatientFile;
import Model.PatientClassification;
import View.PiechartUIinterface;
import View.PiechartWebServiceManager;
import View.PatientReport;
import View.PatientSummary;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
	private JTextField lastName;
	private JTextField date;
	private JTextField age;
	private JTextField cholesterol;
	private JTextField weight;
	private JTextField systolic;
	private JTextField feet;
	private JTextField diastolic;
	private JTextField firstName;
	private JTextField inches;


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
				new File("C:\\Patient_Health_Screen\\").mkdir();
				new File("C:\\Patient_Health_Screen\\Chart\\").mkdir();
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
		frmGlenview.setBounds(100, 100, 372, 439);
		frmGlenview.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGlenview.getContentPane().setLayout(null);
		
		JLabel b2 = new JLabel(new ImageIcon(HealthScreening.class.getResource("/images/glenview2.PNG")));
		b2.setBounds(0, 0, 196, 61);
		frmGlenview.getContentPane().add(b2);

		lastName = new JTextField();
		lastName.setBounds(137, 104, 86, 20);
		frmGlenview.getContentPane().add(lastName);
		lastName.setColumns(10);
		
		date = new JTextField();
		date.setEditable(false);
		date.setBounds(137, 76, 86, 20);
		frmGlenview.getContentPane().add(date);
		date.setColumns(10);
		
		age = new JTextField();
		age.setBounds(137, 160, 86, 20);
		frmGlenview.getContentPane().add(age);
		age.setColumns(10);
		
		cholesterol = new JTextField();
		cholesterol.setBounds(137, 250, 86, 20);
		frmGlenview.getContentPane().add(cholesterol);
		cholesterol.setColumns(10);
		
		weight = new JTextField();
		weight.setBounds(137, 191, 86, 20);
		frmGlenview.getContentPane().add(weight);
		weight.setColumns(10);
		
		JLabel lblPatientName = new JLabel("Last Name");
		lblPatientName.setForeground(new Color(0, 102, 204));
		lblPatientName.setBounds(63, 110, 67, 14);
		frmGlenview.getContentPane().add(lblPatientName);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(new Color(0, 102, 204));
		lblDate.setBounds(98, 82, 27, 14);
		frmGlenview.getContentPane().add(lblDate);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setForeground(new Color(0, 102, 204));
		lblAge.setBounds(101, 166, 27, 14);
		frmGlenview.getContentPane().add(lblAge);
		
		JLabel lbCholesterol = new JLabel("Cholesterol");
		lbCholesterol.setForeground(new Color(0, 102, 204));
		lbCholesterol.setBounds(58, 256, 67, 14);
		frmGlenview.getContentPane().add(lbCholesterol);
		
		JLabel lblBodyMassIndex = new JLabel("Weight");
		lblBodyMassIndex.setForeground(new Color(0, 102, 204));
		lblBodyMassIndex.setBounds(83, 197, 42, 14);
		frmGlenview.getContentPane().add(lblBodyMassIndex);
		
		systolic = new JTextField();
		systolic.setBounds(137, 278, 86, 20);
		frmGlenview.getContentPane().add(systolic);
		systolic.setColumns(10);
		
		JLabel lblBloodPressure = new JLabel("Blood Pressure");
		lblBloodPressure.setForeground(new Color(0, 102, 204));
		lblBloodPressure.setBounds(34, 281, 96, 14);
		frmGlenview.getContentPane().add(lblBloodPressure);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSubmit.setBounds(20, 329, 89, 23);
		frmGlenview.getContentPane().add(btnSubmit);
		
		feet = new JTextField();
		feet.setBounds(137, 219, 46, 20);
		frmGlenview.getContentPane().add(feet);
		feet.setColumns(10);
		
		JLabel lblHeight = new JLabel("Height");
		lblHeight.setForeground(new Color(0, 102, 204));
		lblHeight.setBounds(86, 225, 42, 14);
		frmGlenview.getContentPane().add(lblHeight);
		
		JButton btnPrintSummary = new JButton("Print Summary");
		btnPrintSummary.setBounds(115, 330, 134, 23);
		frmGlenview.getContentPane().add(btnPrintSummary);
		
		diastolic = new JTextField();
		diastolic.setBounds(233, 278, 86, 20);
		frmGlenview.getContentPane().add(diastolic);
		diastolic.setColumns(10);
		
		JLabel lblSystolic = new JLabel("systolic");
		lblSystolic.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblSystolic.setBounds(161, 295, 46, 14);
		frmGlenview.getContentPane().add(lblSystolic);
		
		JLabel lblNewLabel = new JLabel("diastolic");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setBounds(255, 295, 46, 14);
		frmGlenview.getContentPane().add(lblNewLabel);
		
		JButton btnExport = new JButton("Export");
		btnExport.setBounds(255, 330, 89, 23);
		frmGlenview.getContentPane().add(btnExport);
		
		   //getting current date and time using Date class
	       DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
	       Calendar calobj = Calendar.getInstance();
	       //System.out.println(df.format(calobj.getTime()));
	       date.setText(df.format(calobj.getTime()));
	       
	       JLabel lblLbs = new JLabel("lbs.");
	       lblLbs.setFont(new Font("Tahoma", Font.PLAIN, 10));
	       lblLbs.setBounds(225, 194, 46, 14);
	       frmGlenview.getContentPane().add(lblLbs);
	       
	       JLabel lblIn = new JLabel("feet");
	       lblIn.setFont(new Font("Tahoma", Font.PLAIN, 10));
	       lblIn.setBounds(187, 222, 20, 14);
	       frmGlenview.getContentPane().add(lblIn);
	       
	       JButton btnClearAll = new JButton("Clear All");
	       btnClearAll.setBounds(134, 364, 89, 23);
	       frmGlenview.getContentPane().add(btnClearAll);
	       
	       firstName = new JTextField();
	       firstName.setBounds(137, 132, 86, 20);
	       frmGlenview.getContentPane().add(firstName);
	       firstName.setColumns(10);
	       
	       JLabel lblFirstName = new JLabel("First Name");
	       lblFirstName.setForeground(new Color(0, 102, 204));
	       lblFirstName.setBounds(63, 135, 67, 14);
	       frmGlenview.getContentPane().add(lblFirstName);
	       
	       inches = new JTextField();
	       inches.setBounds(215, 219, 42, 20);
	       frmGlenview.getContentPane().add(inches);
	       inches.setColumns(10);
	       
	       JLabel lblInches = new JLabel("inches");
	       lblInches.setFont(new Font("Tahoma", Font.PLAIN, 10));
	       lblInches.setBounds(259, 222, 42, 14);
	       frmGlenview.getContentPane().add(lblInches);
	       

		/**
		 * When the user submits patient data, the data will be appended
		 * to an output file. The patient report will subsequently be 
		 * displayed...
		 */
		btnSubmit.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				
				if(lastName.getText().equals("")){
					lastName.setText("n/a");
				}
				if(firstName.getText().equals("")){
					firstName.setText("n/a");
				}
				if(age.getText().equals("")){
					age.setText("0");
				}
				if(cholesterol.getText().equals("")){
					cholesterol.setText("0");
				}
				if(weight.getText().equals("")){
					weight.setText("0");
				}
				if(systolic.getText().equals("")){
					systolic.setText("0");
				}
				if(feet.getText().equals("")){
					feet.setText("0");
				}
				if(inches.getText().equals("")){
					inches.setText("0");
				}
				if(diastolic.getText().equals("")){
					diastolic.setText("0");
				}
				if(Integer.parseInt(age.getText())>=1&&Integer.parseInt(age.getText())<=110){
					if(Integer.parseInt(inches.getText())<12){
						
				BmiCalculator bmi = new BmiCalculator();
				PatientClassification classification = new PatientClassification();
				
				DecimalFormat df = new DecimalFormat("0.0");
				
				String f = feet.getText();
				double heightFeet = Double.parseDouble(f);
				heightFeet=heightFeet*12;
				
				String i = inches.getText();
				double heightInches = Double.parseDouble(i);
				heightFeet=heightFeet+heightInches;
				
				double bmiCalc = 0;
				if(heightFeet>0||Double.parseDouble(weight.getText())>0){
				 bmiCalc= bmi.calculateBmi(Double.parseDouble(weight.getText())
						,heightFeet,true);
				}
			
				String bmiCalcFormatted = df.format(bmiCalc);
				String bmiClassification = classification.BMI(Double.parseDouble(bmiCalcFormatted));
				String bloodPressureClassification = classification.bloodPressure(Integer.parseInt(systolic.getText()),Integer.parseInt(diastolic.getText()));
				String cholesterolClassification = classification.Cholesterol(Integer.parseInt(cholesterol.getText()));
				
				String []data={"Health Screening for "+firstName.getText()+" "+lastName.getText(), "\nDate: "+date.getText(),"Age: "+age.getText()+"     "+"Height: "
				+f+"' "+i+"\"     "+"Weight: "+weight.getText(),"\nBody Mass Index: "+bmiCalcFormatted+" "
				+bmiClassification+"","Total Cholesterol: "+cholesterol.getText()+" "+cholesterolClassification,"Blood Pressure: "
				+systolic.getText()+"/"+diastolic.getText()+" "+bloodPressureClassification+""};
				
				PatientReport pr = new PatientReport();
				pr.displayPatientReport(data);
				
				String []data2={"Health Screening for "+firstName.getText()+" "+lastName.getText(), "\nDate: "+date.getText(),"Age: "+age.getText()+"     "+"Height: "
				+f+"' "+i+"\"     "+"Weight: "+weight.getText(),"\nBody Mass Index: "+bmiCalcFormatted+"% "
				+bmiClassification+"","Total Cholesterol: "+cholesterol.getText()+" "+cholesterolClassification,"Blood Pressure: "
				+systolic.getText()+"/"+diastolic.getText()+" *"+bloodPressureClassification};

				
				PatientFile patientfile = new PatientFile();
				patientfile.outFile(data2,date.getText());
				

				
				}else{
					JOptionPane.showMessageDialog(frmGlenview, "Invalid entry. Ensure number of inches are less than 12", "information",
							JOptionPane.INFORMATION_MESSAGE);
				}
				}else{
					JOptionPane.showMessageDialog(frmGlenview, "Invalid entry. Enter age between 1 and 110.", "information",
							JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		/**
		 * Add button function to display the totals of patient and classifications
		 */
		btnPrintSummary.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new java.io.File("C:\\Patient_Health_Screen"));
				int result = fileChooser.showOpenDialog(null);
				File selectedFile = null;
				
				if (result == JFileChooser.APPROVE_OPTION) {
				    selectedFile = fileChooser.getSelectedFile();
				    //System.out.println("Selected file: " + selectedFile.getAbsolutePath());
				}
				else if (result == JFileChooser.CANCEL_OPTION) {
				    System.out.println("Cancel was selected");
				    
				}
				else if(selectedFile==null){
					System.out.println("no file selected");
					//System.exit(0);
				}
				PatientFile patientfile = new PatientFile();
				String[]inFile=patientfile.inFile(selectedFile);
				
				
				PatientSummary sum = new PatientSummary();
				sum.summary(inFile);

			}
		});
		btnExport.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new java.io.File("C:\\Patient_Health_Screen"));
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
				
				PiechartUIinterface pi = new PiechartUIinterface();
				String[]url=pi.chartExport(inFile);
				
				PiechartWebServiceManager ws = new PiechartWebServiceManager();
				ws.createHTMLFileWithPieCharts(url);
				ws.launchPiechartWebPage();
				
				
				
			}
		});
		btnClearAll.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				lastName.setText("");
				firstName.setText("");
				age.setText("");
				weight.setText("");
				feet.setText("");
				inches.setText("");
				cholesterol.setText("");
				systolic.setText("");
				diastolic.setText("");
				
			}
		});
		
		lastName.addKeyListener(new KeyAdapter(){
			
			public void keyTyped(KeyEvent e){
				if (e.getKeyChar()==KeyEvent.VK_ENTER){
					firstName.requestFocus();
					firstName.selectAll();
				}
			}
		});
		firstName.addKeyListener(new KeyAdapter(){
			
			public void keyTyped(KeyEvent e){
				if (e.getKeyChar()==KeyEvent.VK_ENTER){
					age.requestFocus();
					age.selectAll();
				}
			}
		});
		age.addKeyListener(new KeyAdapter(){
			
			public void keyTyped(KeyEvent e){
				if (e.getKeyChar()=='.'){
					JOptionPane.showMessageDialog(frmGlenview, "Decimal Not Allowed","Information"
							,JOptionPane.INFORMATION_MESSAGE);
				}else if (e.getKeyChar()==KeyEvent.VK_BACK_SPACE){
				}else if (e.getKeyChar()==KeyEvent.VK_DELETE){
				}else if (e.getKeyChar()==KeyEvent.VK_ENTER){
					weight.requestFocus();
					weight.selectAll();
				}else if (e.getKeyChar()>'9'|e.getKeyChar()<'0'){
					JOptionPane.showMessageDialog(frmGlenview, "Need to enter a number.","Information"
							,JOptionPane.INFORMATION_MESSAGE);
					e.setKeyChar('\0');
				}
			}
		});
		weight.addKeyListener(new KeyAdapter(){
			
			public void keyTyped(KeyEvent e){
				if (e.getKeyChar()=='.'){
					JOptionPane.showMessageDialog(frmGlenview, "Decimal Not Allowed","Information"
							,JOptionPane.INFORMATION_MESSAGE);
				}else if (e.getKeyChar()==KeyEvent.VK_BACK_SPACE){
				}else if (e.getKeyChar()==KeyEvent.VK_DELETE){
				}else if (e.getKeyChar()==KeyEvent.VK_ENTER){
					feet.requestFocus();
					feet.selectAll();
				}else if (e.getKeyChar()>'9'|e.getKeyChar()<'0'){
					JOptionPane.showMessageDialog(frmGlenview, "Need to enter a number.","Information"
							,JOptionPane.INFORMATION_MESSAGE);
					e.setKeyChar('\0');
				}
			}
		});
		feet.addKeyListener(new KeyAdapter(){
			
			public void keyTyped(KeyEvent e){
				if (e.getKeyChar()=='.'){
					JOptionPane.showMessageDialog(frmGlenview, "Decimal Not Allowed","Information"
							,JOptionPane.INFORMATION_MESSAGE);
				}else if (e.getKeyChar()==KeyEvent.VK_BACK_SPACE){
				}else if (e.getKeyChar()==KeyEvent.VK_DELETE){
				}else if (e.getKeyChar()==KeyEvent.VK_ENTER){
					inches.requestFocus();
					inches.selectAll();
				}else if (e.getKeyChar()>'9'|e.getKeyChar()<'0'){
					JOptionPane.showMessageDialog(frmGlenview, "Need to enter a number.","Information"
							,JOptionPane.INFORMATION_MESSAGE);
					e.setKeyChar('\0');
				}
			}
		});
		inches.addKeyListener(new KeyAdapter(){
			
			public void keyTyped(KeyEvent e){
				if (e.getKeyChar()=='.'){
					JOptionPane.showMessageDialog(frmGlenview, "Decimal Not Allowed","Information"
							,JOptionPane.INFORMATION_MESSAGE);
				}else if (e.getKeyChar()==KeyEvent.VK_BACK_SPACE){
				}else if (e.getKeyChar()==KeyEvent.VK_DELETE){
				}else if (e.getKeyChar()==KeyEvent.VK_ENTER){
					cholesterol.requestFocus();
					cholesterol.selectAll();
				}else if (e.getKeyChar()>'9'|e.getKeyChar()<'0'){
					JOptionPane.showMessageDialog(frmGlenview, "Need to enter a number.","Information"
							,JOptionPane.INFORMATION_MESSAGE);
					e.setKeyChar('\0');
				}
			}
		});
		cholesterol.addKeyListener(new KeyAdapter(){
			
			public void keyTyped(KeyEvent e){
				if (e.getKeyChar()=='.'){
					JOptionPane.showMessageDialog(frmGlenview, "Decimal Not Allowed","Information"
							,JOptionPane.INFORMATION_MESSAGE);
				}else if (e.getKeyChar()==KeyEvent.VK_BACK_SPACE){
				}else if (e.getKeyChar()==KeyEvent.VK_DELETE){
				}else if (e.getKeyChar()==KeyEvent.VK_ENTER){
					systolic.requestFocus();
					systolic.selectAll();
				}else if (e.getKeyChar()>'9'|e.getKeyChar()<'0'){
					JOptionPane.showMessageDialog(frmGlenview, "Need to enter a number.","Information"
							,JOptionPane.INFORMATION_MESSAGE);
					e.setKeyChar('\0');
				}
			}
		});
		systolic.addKeyListener(new KeyAdapter(){
			
			public void keyTyped(KeyEvent e){
				if (e.getKeyChar()=='.'){
					JOptionPane.showMessageDialog(frmGlenview, "Decimal Not Allowed","Information"
							,JOptionPane.INFORMATION_MESSAGE);
				}else if (e.getKeyChar()==KeyEvent.VK_BACK_SPACE){
				}else if (e.getKeyChar()==KeyEvent.VK_DELETE){
				}else if (e.getKeyChar()==KeyEvent.VK_ENTER){
					diastolic.requestFocus();
					diastolic.selectAll();
				}else if (e.getKeyChar()>'9'|e.getKeyChar()<'0'){
					JOptionPane.showMessageDialog(frmGlenview, "Need to enter a number.","Information"
							,JOptionPane.INFORMATION_MESSAGE);
					e.setKeyChar('\0');
				}
			}
		});
		diastolic.addKeyListener(new KeyAdapter(){
			
			public void keyTyped(KeyEvent e){
				if (e.getKeyChar()=='.'){
					JOptionPane.showMessageDialog(frmGlenview, "Decimal Not Allowed","Information"
							,JOptionPane.INFORMATION_MESSAGE);
				}else if (e.getKeyChar()==KeyEvent.VK_BACK_SPACE){
				}else if (e.getKeyChar()==KeyEvent.VK_DELETE){
				}else if (e.getKeyChar()==KeyEvent.VK_ENTER){
					lastName.requestFocus();
					lastName.selectAll();
				}else if (e.getKeyChar()>'9'|e.getKeyChar()<'0'){
					JOptionPane.showMessageDialog(frmGlenview, "Need to enter a number.","Information"
							,JOptionPane.INFORMATION_MESSAGE);
					e.setKeyChar('\0');
				}
			}
		});
	}
}
