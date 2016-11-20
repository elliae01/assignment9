package assignment9;

import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import assignment9.CHART_TYPE;
import assignment9.PiechartWebServiceManager;

public class PiechartUIinterface {

	public PiechartUIinterface(){
		
	}
	
	public void chartExport(String[]data){
		
		String[]classifications={"DESIRABLE","BORDERLINE","HIGH","UNDERWEIGHT",
				"NORMAL","OVERWEIGHT","OBESE","NORMAL","PREHYPERTENSION",
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
		String chartUrl = pc.getUrl(CHART_TYPE.totalCholesterol);
		//System.out.println(chartUrl);
		
		pc.addPieSlice(CHART_TYPE.BMI, "Overweight", total[3]);
		pc.addPieSlice(CHART_TYPE.BMI, "Obese", total[4]);
		pc.addPieSlice(CHART_TYPE.BMI, "Underweight",total[5]);
		pc.addPieSlice(CHART_TYPE.BMI, "Normal", total[6]);
		String chartUrl2 = pc.getUrl(CHART_TYPE.BMI);
		
		pc.addPieSlice(CHART_TYPE.bloodPressure, "Stage 1 Hypertension",total[7]);
		pc.addPieSlice(CHART_TYPE.bloodPressure, "Stage 2 Hypertension", total[8]);
		pc.addPieSlice(CHART_TYPE.bloodPressure, "Hypertensive Crisis", total[9]);
		pc.addPieSlice(CHART_TYPE.bloodPressure, "Normal", total[10]);
		pc.addPieSlice(CHART_TYPE.bloodPressure, "Prehypertension", total[11]);
		String chartUrl3 = pc.getUrl(CHART_TYPE.bloodPressure);
		
		System.out.println(chartUrl);
		System.out.println(chartUrl2);
		System.out.println(chartUrl3);
		
		URI uri = null;
		URI uri2 = null;
		URI uri3 = null;
		
	    try {
	      URL url = new URL(chartUrl);
	      URL url2 = new URL(chartUrl2);
	      URL url3 = new URL(chartUrl3);
	      String nullFragment = null;
	      String nullFragment2 = null;
	      String nullFragment3 = null;
	      uri = new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), nullFragment);
	      uri2 = new URI(url2.getProtocol(), url2.getHost(), url2.getPath(), url2.getQuery(), nullFragment2);
	      uri3 = new URI(url3.getProtocol(), url3.getHost(), url3.getPath(), url3.getQuery(), nullFragment3);
	      System.out.println("URI " + uri.toString() + " is OK");
	      System.out.println("URI " + uri2.toString() + " is OK");
	      System.out.println("URI " + uri3.toString() + " is OK");
	    } catch (MalformedURLException e) {
	      System.out.println("URL " + chartUrl + " is a malformed URL");
	      System.out.println("URL " + chartUrl2 + " is a malformed URL");
	      System.out.println("URL " + chartUrl3 + " is a malformed URL");
	    } catch (URISyntaxException e) {
	      System.out.println("URI " + chartUrl + " is a malformed URL");
	      System.out.println("URL " + chartUrl2 + " is a malformed URL");
	      System.out.println("URL " + chartUrl3 + " is a malformed URL");
	    }
	  
        Desktop d=Desktop.getDesktop();
        // Browse a URL
        
        try {
			d.browse(uri);
			d.browse(uri2);
			d.browse(uri3);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
	}


}
