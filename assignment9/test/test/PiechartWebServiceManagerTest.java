package assignment9;

import static org.junit.Assert.*;

import org.junit.Test;

public class PiechartWebServiceManagerTest 
{
	private PiechartWebServiceManager pieChartManager = new PiechartWebServiceManager();

	@Test
	public void test_1() 
	{
		pieChartManager.addPieSlice(CHART_TYPE.totalCholesterol, "High", 18);
		pieChartManager.addPieSlice(CHART_TYPE.totalCholesterol, "Borderline High", 14);
		pieChartManager.addPieSlice(CHART_TYPE.totalCholesterol, "Desirable", 22);
		
		String chartUrl = pieChartManager.getUrl(CHART_TYPE.totalCholesterol);
		
		assertEquals("http://chart.apis.google.com/chart?cht=p&chs=500x250&chco=f032c8&chd=e:0Wou..&chl=High|Borderline High|Desirable",
				chartUrl);
		
		// Temporary : prints URL with Total Cholesterol Chart
		System.out.println(chartUrl);
	}
	
	@Test
	public void test_2()
	{
		pieChartManager.addPieSlice(CHART_TYPE.BMI, "Overweight", 12);
		pieChartManager.addPieSlice(CHART_TYPE.BMI, "Obese", 31);
		pieChartManager.addPieSlice(CHART_TYPE.BMI, "Underweight", 17);
		pieChartManager.addPieSlice(CHART_TYPE.BMI, "Normal", 26);
		
		String chartUrl = pieChartManager.getUrl(CHART_TYPE.BMI);

		assertEquals("http://chart.apis.google.com/chart?cht=p&chs=500x250&chco=3232f0&chd=e:Yx..jG1r&chl=Overweight|Obese|Underweight|Normal",
				pieChartManager.getUrl(CHART_TYPE.BMI));
		
		// Temporary : prints URL with Total Cholesterol Chart
		System.out.println(chartUrl);
	}
	
	@Test
	public void test_3()
	{
		pieChartManager.addPieSlice(CHART_TYPE.bloodPressure, "Stage 1 Hypertension", 17);
		pieChartManager.addPieSlice(CHART_TYPE.bloodPressure, "Stage 2 Hypertension", 31);
		pieChartManager.addPieSlice(CHART_TYPE.bloodPressure, "Hypertensive Crisis", 11);
		pieChartManager.addPieSlice(CHART_TYPE.bloodPressure, "Normal", 54);
		pieChartManager.addPieSlice(CHART_TYPE.bloodPressure, "Prehypertension", 23);

		String chartUrl = pieChartManager.getUrl(CHART_TYPE.bloodPressure);
		
		assertEquals("http://chart.apis.google.com/chart?cht=p&chs=500x250&chco=b9000f&chd=e:UJkvNC..bQ&chl=Stage 1 Hypertension|Stage 2 Hypertension|Hypertensive Crisis|Normal|Prehypertension",
				pieChartManager.getUrl(CHART_TYPE.bloodPressure));
		
		// Temporary : prints URL with Total Cholesterol Chart
		System.out.println(chartUrl);
	}
}

