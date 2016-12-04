package test;

import static org.junit.Assert.*;

import View.PiechartWebServiceManager;
import View.PiechartWebServiceManager.CHART_TYPE;

import org.junit.Test;

public class PiechartWebServiceManagerTest 
{
	private PiechartWebServiceManager pieChartManager = new PiechartWebServiceManager();

	/** White box testing for the "getURL" method **/
	@Test
	public void getURL_test1()
	{
		String expectedURL = "http://chart.apis.google.com/chart?cht=p&chs=500x250&chco=f032c8";
		String actualURL = pieChartManager.getUrl(CHART_TYPE.totalCholesterol);
		
		assertEquals(expectedURL, actualURL);
	}
	
	@Test
	public void getURL_test2()
	{
		String expectedURL = "http://chart.apis.google.com/chart?cht=p&chs=500x250&chco=3232f0";
		String actualURL = pieChartManager.getUrl(CHART_TYPE.BMI);;
		
		assertEquals(expectedURL, actualURL);
	}
	
	@Test
	public void getURL_test3()
	{
		String expectedURL = "http://chart.apis.google.com/chart?cht=p&chs=500x250&chco=b9000f";
		String actualURL = pieChartManager.getUrl(CHART_TYPE.bloodPressure);;
		
		assertEquals(expectedURL, actualURL);
	}
	
	/** White box testing for the "addSlice" method **/
	@Test
	public void addSlice_test1()
	{
		pieChartManager.addPieSlice(CHART_TYPE.totalCholesterol, "High", 18);
		pieChartManager.addPieSlice(CHART_TYPE.totalCholesterol, "Borderline High", 14);
		pieChartManager.addPieSlice(CHART_TYPE.totalCholesterol, "Desirable", 22);
	
		String expectedURL = "http://chart.apis.google.com/chart?cht=p&chs=500x250&chco=f032c8&chd=e:0Wou..&chl=High|Borderline High|Desirable";
		String actualURL = pieChartManager.getUrl(CHART_TYPE.totalCholesterol);
		
		assertEquals(expectedURL, actualURL);
	}
	
	@Test
	public void addSlice_test2() 
	{
		pieChartManager.addPieSlice(CHART_TYPE.BMI, "Overweight", 12);
		pieChartManager.addPieSlice(CHART_TYPE.BMI, "Obese", 31);
		pieChartManager.addPieSlice(CHART_TYPE.BMI, "Underweight", 17);
		pieChartManager.addPieSlice(CHART_TYPE.BMI, "Normal", 26);

		String expectedURL = "http://chart.apis.google.com/chart?cht=p&chs=500x250&chco=3232f0&chd=e:Yx..jG1r&chl=Overweight|Obese|Underweight|Normal";
		String actualURL = pieChartManager.getUrl(CHART_TYPE.BMI);
		
		assertEquals(expectedURL, actualURL);
	}
	
	@Test
	public void addSlice_test3() 
	{
		pieChartManager.addPieSlice(CHART_TYPE.bloodPressure, "Stage 1 Hypertension", 17);
		pieChartManager.addPieSlice(CHART_TYPE.bloodPressure, "Stage 2 Hypertension", 31);
		pieChartManager.addPieSlice(CHART_TYPE.bloodPressure, "Hypertensive Crisis", 11);
		pieChartManager.addPieSlice(CHART_TYPE.bloodPressure, "Normal", 54);
		pieChartManager.addPieSlice(CHART_TYPE.bloodPressure, "Prehypertension", 23);
		
		String expectedURL = "http://chart.apis.google.com/chart?cht=p&chs=500x250&chco=b9000f&chd=e:UJkvNC..bQ&chl=Stage 1 Hypertension|Stage 2 Hypertension|Hypertensive Crisis|Normal|Prehypertension";
		String actualURL = pieChartManager.getUrl(CHART_TYPE.bloodPressure);
		
		assertEquals(expectedURL, actualURL);
	}
}

