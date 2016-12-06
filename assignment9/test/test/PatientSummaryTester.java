package test;

import static org.junit.Assert.*;

import org.junit.Test;
import View.PatientSummary;

public class PatientSummaryTester {

	@Test
	public void test_high() {
		PatientSummary ps = new PatientSummary();
		
		String testData[] = {"HIGH", "", ""};
		assertEquals(ps.summary(testData), 1);
	}

	@Test
	public void test_everything() {
		PatientSummary ps = new PatientSummary();
		
		String testEverything[] = {"DESIRABLE","BORDERLINE","HIGH"};
		assertEquals(ps.summary(testEverything), 3);
	}

	@Test
	public void test_nothing() {
		PatientSummary ps = new PatientSummary();
		
		String testData[] = {"", "", ""};
		assertEquals(ps.summary(testData), 0);
	}

	@Test
	public void test_invalid() {
		PatientSummary ps = new PatientSummary();
		
		String testData[] = {"ZACK", "CODY", "MOSEBY"};
		assertEquals(ps.summary(testData), 0);
	}

}
