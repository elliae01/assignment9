package View;

import View.PiechartWebServiceManager;
import View.CHART_TYPE;


public class PiechartUIinterface  {

	String[]url;
	
	public PiechartUIinterface(){
		
	}
	
	public String[] chartExport(String[]data){
		
		String[]classifications={"DESIRABLE","BORDERLINE","HIGH","UNDERWEIGHT",
				"Body Mass Index is NORMAL","OVERWEIGHT","OBESE","Blood Pressure is NORMAL","PREHYPERTENSION",
				"STAGE 1 HYPERTENSION","STAGE 2 HYPERTENSION", "HYPERTENSIVE CRISIS"};
		int[]total = new int[12];
		
		for(int j=0;j<classifications.length;j++){
			int k=0;
			for(int i=0;i<data.length;i++){
			  if (data[i].contains(classifications[j])){
				   k=k+1;
				   
				  }
			}
			total[j]=k;
		}
		

		PiechartWebServiceManager pc = new PiechartWebServiceManager();
		
		pc.addPieSlice(CHART_TYPE.totalCholesterol, "High", total[0]);
		pc.addPieSlice(CHART_TYPE.totalCholesterol, "Borderline High", total[1]);
		pc.addPieSlice(CHART_TYPE.totalCholesterol, "Desirable", total[2]);
		
		pc.addPieSlice(CHART_TYPE.BMI, "Overweight", total[3]);
		pc.addPieSlice(CHART_TYPE.BMI, "Obese", total[4]);
		pc.addPieSlice(CHART_TYPE.BMI, "Underweight",total[5]);
		pc.addPieSlice(CHART_TYPE.BMI, "Normal", total[6]);
		
		pc.addPieSlice(CHART_TYPE.bloodPressure, "Stage 1 Hypertension",total[7]);
		pc.addPieSlice(CHART_TYPE.bloodPressure, "Stage 2 Hypertension", total[8]);
		pc.addPieSlice(CHART_TYPE.bloodPressure, "Hypertensive Crisis", total[9]);
		pc.addPieSlice(CHART_TYPE.bloodPressure, "Normal", total[10]);
		pc.addPieSlice(CHART_TYPE.bloodPressure, "Prehypertension", total[11]);;
		
		url=new String[3];
		url[0]=pc.getUrl(CHART_TYPE.totalCholesterol);
		url[1]=pc.getUrl(CHART_TYPE.BMI);
		url[2]=pc.getUrl(CHART_TYPE.bloodPressure);
		
    	return url;
        
    	
	}

}
