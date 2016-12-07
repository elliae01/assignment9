package test;

import static org.junit.Assert.*;

import org.junit.Test;
import View.PiechartUIinterface;;

public class PiechartUITester {

	private PiechartUIinterface chartInterface = new PiechartUIinterface();

	private final String[] testData = { "BORDERLINE", "BORDERLINE", "BORDERLINE", "HIGH", "DESIRABLE", "DESIRABLE",
			"DESIRABLE", "DESIRABLE", "UNDERWEIGHT", "UNDERWEIGHT", "% NORMAL", "% NORMAL", "OVERWEIGHT", "OVERWEIGHT",
			"OBESE", "*NORMAL", "PREHYPERTENSION", "STAGE 1 HYPERTENSION", "STAGE 1 HYPERTENSION",
			"STAGE 1 HYPERTENSION", "STAGE 1 HYPERTENSION", "STAGE 2 HYPERTENSION", "STAGE 2 HYPERTENSION",
			"STAGE 2 HYPERTENSION", "HYPERTENSIVE CRISIS" };

	@Test
	public void testA() {

		String[] actualResult = chartInterface.chartExport(testData);
		String expectedResult = "http://chart.apis.google.com/chart?cht=p&chs=570x250&chco=f032c8&chd=e:..v.QA&chl=Desirable|Borderline High|High&chtt=Total+Cholesteral";

		assertEquals(actualResult[0], expectedResult);
	}

	@Test
	public void testB() {
		String[] actualResult = chartInterface.chartExport(testData);
		String expectedResult = "http://chart.apis.google.com/chart?cht=p&chs=570x250&chco=3232f0&chd=e:......gA&chl=Underweight|Normal|Overweight|Obese&chtt=Body+Mass+Index";

		assertEquals(actualResult[1], expectedResult);
	}

	@Test
	public void testC() {
		String[] actualResult = chartInterface.chartExport(testData);
		String expectedResult = "http://chart.apis.google.com/chart?cht=p&chs=570x250&chco=b9000f&chd=e:QAQA..v.QA&chl=Normal|Prehypertension|Stage 1 Hypertension|Stage 2 Hypertension|Hypertensive Crisis&chtt=Blood+Pressure";
		assertEquals(actualResult[2], expectedResult);
	}
}
