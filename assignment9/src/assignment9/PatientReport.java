package assignment9;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class PatientReport {

	public PatientReport(){
		
	}
	
    public void displayPatientReport(String[]data) {
        JOptionPane.showMessageDialog(
            null, getPanel(data), "Health Screen Results",
                JOptionPane.INFORMATION_MESSAGE);
        
    }
	private JPanel getPanel(String[]data) {
	        JPanel panel = new JPanel(new GridLayout(0, 1, 5, 10));

	        for(int i=0;i<data.length;i++){
	        	JLabel label = getLabel(data[i]);
	        	label.setFont(new Font("Monospaced", Font.BOLD, 25));
	        	panel.add(label);
	        }

	        return panel;
	    }

	private JLabel getLabel(String title) {
	        return new JLabel(title);
	    }
}
