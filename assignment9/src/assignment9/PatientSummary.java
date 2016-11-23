package assignment9;



public class PatientSummary {

	public PatientSummary(){
		
	}
	
	public void summary(String[]data, String date){
		
		String[]classifications={"DESIRABLE","BORDERLINE","HIGH","UNDERWEIGHT",
				"NORMAL ","OVERWEIGHT","OBESE","NORMAL","PREHYPERTENSION",
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
		int sum=total[0]+total[1]+total[2];
		System.out.println("Health Screening Results\n");
		System.out.println(data[2]);
		System.out.println("Number of Individuals Screened: "+sum);
		System.out.println("\nTotal Cholesterol\n");
		System.out.println("DESIRABLE                   "+total[0]);
		System.out.println("BORDERLINE                  "+total[1]);
		System.out.println("HIGH                        "+total[2]);
		System.out.println("\nBody Mass Index\n");
		System.out.println("UNDERWEIGHT                 "+total[3]);
		System.out.println("NORMAL                      "+total[4]);
		System.out.println("OVERWEIGHT                  "+total[5]);
		System.out.println("OBESE                       "+total[6]);
		System.out.println("\nBlood Pressure\n");
		System.out.println("NORMAL                      "+total[7]);
		System.out.println("PREHYPERTENSION             "+total[8]);
		System.out.println("STAGE 1 HYPERTENSION        "+total[9]);
		System.out.println("STAGE 2 HYPERTENSION        "+total[10]);
		System.out.println("HYPERTENSIVE                "+total[11]);
		
		
	}


}
