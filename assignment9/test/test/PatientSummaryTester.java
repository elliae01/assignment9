package test;

import static org.junit.Assert.*;

import org.junit.Test;
import View.PatientSummary;

public class PatientSummaryTester {

	@Test
	public void testHigh() {
		PatientSummary ps = new PatientSummary();

		String[] testData = { "HIGH", "", "" };
		assertEquals(ps.summary(testData), 1);
	}

	@Test
	public void testEverything() {
		PatientSummary ps = new PatientSummary();

		String[] testEverything = { "DESIRABLE", "BORDERLINE", "HIGH" };
		assertEquals(ps.summary(testEverything), 3);
	}

	@Test
	public void testNothing() {
		PatientSummary ps = new PatientSummary();

		String[] testData = { "", "", "" };
		assertEquals(ps.summary(testData), 0);
	}

	@Test
	public void testInvalid() {
		PatientSummary ps = new PatientSummary();

		String[] testData = { "ZACK", "CODY", "MOSEBY" };
		assertEquals(ps.summary(testData), 0);
	}

}
