package test;

import static org.junit.Assert.*;

import View.PiechartWebServiceManager;
import View.PiechartWebServiceManager.ChartType;

import org.junit.Test;

public class PiechartWebServiceManagerTest {
	private PiechartWebServiceManager pieChartManager = new PiechartWebServiceManager();

	/** White box testing for the "getURL" method **/
	@Test
	public void getURLTestA() {
		String expectedURL = "http://chart.apis.google.com/chart?cht=p&chs=500x250&chco=f032c8";
		String actualURL = pieChartManager.getUrl(ChartType.totalCholesterol);

		assertEquals(expectedURL, actualURL);
	}

	@Test
	public void getURLTestB() {
		String expectedURL = "http://chart.apis.google.com/chart?cht=p&chs=500x250&chco=3232f0";
		String actualURL = pieChartManager.getUrl(ChartType.BMI);

		assertEquals(expectedURL, actualURL);
	}

	@Test
	public void getURLTestC() {
		String expectedURL = "http://chart.apis.google.com/chart?cht=p&chs=500x250&chco=b9000f";
		String actualURL = pieChartManager.getUrl(ChartType.bloodPressure);

		assertEquals(expectedURL, actualURL);
	}

	/** White box testing for the "addSlice" method **/
	@Test
	public void addSliceTestA() {
		pieChartManager.addPieSlice(ChartType.totalCholesterol, "High", 18);
		pieChartManager.addPieSlice(ChartType.totalCholesterol, "Borderline High", 14);
		pieChartManager.addPieSlice(ChartType.totalCholesterol, "Desirable", 22);

		String expectedURL = "http://chart.apis.google.com/chart?cht=p&chs=500x250&chco=f032c8&chd=e:0Wou..&chl=High|Borderline High|Desirable";
		String actualURL = pieChartManager.getUrl(ChartType.totalCholesterol);

		assertEquals(expectedURL, actualURL);
	}

	@Test
	public void addSliceTestB() {
		pieChartManager.addPieSlice(ChartType.BMI, "Overweight", 12);
		pieChartManager.addPieSlice(ChartType.BMI, "Obese", 31);
		pieChartManager.addPieSlice(ChartType.BMI, "Underweight", 17);
		pieChartManager.addPieSlice(ChartType.BMI, "Normal", 26);

		String expectedURL = "http://chart.apis.google.com/chart?cht=p&chs=500x250&chco=3232f0&chd=e:Yx..jG1r&chl=Overweight|Obese|Underweight|Normal";
		String actualURL = pieChartManager.getUrl(ChartType.BMI);

		assertEquals(expectedURL, actualURL);
	}

	@Test
	public void aaddSliceTestC() {
		pieChartManager.addPieSlice(ChartType.bloodPressure, "Stage 1 Hypertension", 17);
		pieChartManager.addPieSlice(ChartType.bloodPressure, "Stage 2 Hypertension", 31);
		pieChartManager.addPieSlice(ChartType.bloodPressure, "Hypertensive Crisis", 11);
		pieChartManager.addPieSlice(ChartType.bloodPressure, "Normal", 54);
		pieChartManager.addPieSlice(ChartType.bloodPressure, "Prehypertension", 23);

		String expectedURL = "http://chart.apis.google.com/chart?cht=p&chs=500x250&chco=b9000f&chd=e:UJkvNC..bQ&chl=Stage 1 Hypertension|Stage 2 Hypertension|Hypertensive Crisis|Normal|Prehypertension";
		String actualURL = pieChartManager.getUrl(ChartType.bloodPressure);

		assertEquals(expectedURL, actualURL);
	}
}
