package View;


public class PatientReport {
	
	private String[]data;
	
	public PatientReport(String[]data){
		this.data=data;
	}
	
	public void report() {
		
		System.out.println();
		
	    for(int i=0;i<getData().length;i++){
	        System.out.println(data[i]);
	    }
	
	    }
    public String[] getData(){
    	return data;
    }

}
