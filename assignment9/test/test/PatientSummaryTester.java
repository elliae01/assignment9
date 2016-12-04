package test;

import static org.junit.Assert.*;

import org.junit.Test;
import View.PatientSummary;

public class PatientSummaryTester {

	@Test
	public void test() {
		PatientSummary ps = new PatientSummary();
		
		String testData[] = {"HIGH", "HIGH", "HIGH"};
		assertEquals(ps.summary(testData), 3);
	}

}
