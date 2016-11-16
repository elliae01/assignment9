package assignment9;

import com.beetledev.www.*;
import java.rmi.RemoteException;

public class BmiCalculator {

	/**
	 * Uses the Beetledev BMI calculator service to calculate a BMI value
	 * 
	 * @param weight Weight in kilograms or pounds
	 * @param height Height in centimeters or inches
	 * @param imperial If true, use pounds/inches instead
	 * @return BMI value, or -1 if there was an error
	 */
	public static double calculateBmi(double weight, double height, boolean imperial) {

		// The BMI calculator service uses metric units, so imperial units must be converted to metric
		if (imperial) {
			ConverterServiceSoapProxy converterProxy = new ConverterServiceSoapProxy("http://www.beetledev.com/webservices/converterservice.asmx");
			
			// Convert the weight and height variables
			try {
				height = converterProxy.in2Cm(height);
				weight = converterProxy.lbs2Kg(weight);
			} catch(RemoteException e) {
				return -1;
			}
		}
		
		// Now that the weight and height are in the correct units, use the BMI calculator service
		BmiServiceSoapProxy bmiProxy = new BmiServiceSoapProxy("http://www.beetledev.com/webservices/bmiservice.asmx");

		try {
		    return bmiProxy.getBmiValue(weight, height);
		} catch(RemoteException e) {
		    return -1;
		}
	}
	
}

