package assignment9;

import java.awt.Desktop;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

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
		int sum=total[0]+total[1]+total[2];

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
				uri = new URI( String.format("http://chart.apis.google.com/chart?cht=p&chs=800x250&chco=f032c8&chd=e:0Wou..&chl=%s",
						URLEncoder.encode( chartUrl , "UTF8" ) ) );
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				uri2 = new URI( String.format("http://chart.apis.google.com/chart?cht=p&chs=500x250&chco=3232f0&chd=e:Yx..jG1r&chl=%s",
						URLEncoder.encode( chartUrl2 , "UTF8" ) ) );
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				uri3 = new URI( String.format("http://chart.apis.google.com/chart?cht=p&chs=500x250&chco=b9000f&chd=e:UJkvNC..bQ&chl=%s",
						URLEncoder.encode( chartUrl3 , "UTF8" ) ) );
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
