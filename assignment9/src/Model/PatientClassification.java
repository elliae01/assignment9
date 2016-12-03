package Model;

public class PatientClassification {
	String[]cholesterol;
	String[]BMI;
	String[]bloodpressure;
	
	public PatientClassification(){
	cholesterol=new String[]{"DESIRABLE","BORDERLINE","HIGH"};
	BMI=new String[]{"UNDERWEIGHT","Index: NORMAL","OVERWEIGHT","OBESE"};
	bloodpressure=new String[]{"Blood Pressure: NORMAL","PREHYPERTENSION","STAGE 1 HYPERTENSION",
			"STAGE 2 HYPERTENSION","HYPERTENSIVE CRISIS"};
	}

	public String Cholesterol(int calc){
		
			if(calc<200&&calc>0){
				return cholesterol[0];
			}
			if(calc>=200&&calc<=239){
				return cholesterol[1];
			}
			if(calc>=240){
				return cholesterol[2];
			}else{
				return "n/a";
			}	
	}
	public String BMI(double calc){

		if(calc<18.5&&calc>0){
			return BMI[0];
		}
		if(calc>=18.5&&calc<=24.9){
			return BMI[1];
		}
		if(calc>=25.0&&calc<=29.9){
			return BMI[2];
		}
		if(calc>=30){
			return BMI[3];
		}else{
			return "n/a";
		}
	}
	public String bloodPressure(int sys,int dias){

		if(sys<120&&sys>0&&dias<80&&dias>0){
			return bloodpressure[0];
		}
		if(sys>=120&&sys<=139||dias>=80&&dias<=89){
			return bloodpressure[1];
		}
		if(sys>=140&&sys<=159||dias>=90&&dias<=99){
			return bloodpressure[2];
		}
		if(sys>=160&&sys<=180||dias>=100&&dias<=110){
			return bloodpressure[3];
		}
		if(sys>180&&dias>110){
			return bloodpressure[4];
		}else{
			return "n/a";
		}
	}
}
