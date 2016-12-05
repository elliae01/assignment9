package View;


public class PatientReport {
	
	private String[]data;
	/**
	 * Takes in individual patient data after the
	 * Submit button is selected.
	 * @param data
	 */
	public PatientReport(String[]data){
		this.data=data;
	}
	/**
	 * Prints individual patient data to console.
	 */
	public void report() {
		
	    for(int i=0;i<getData().length;i++){
	        System.out.println(data[i]);
	    }
	    System.out.println();
	    }
	/**
	 * Gets patient data
	 * @return patient data
	 */
    public String[] getData(){
    	return data;
    }

}
