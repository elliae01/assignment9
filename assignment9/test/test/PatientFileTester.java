package test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.*;

import org.junit.Before;
import org.junit.Test;

import Model.PatientFile;

public class PatientFileTester {

	@Test
	public void testPathForDate() {
		PatientFile pf = new PatientFile();
		assertEquals(pf.pathForDate("test"), "C:\\Patient_Health_Screen\\test_summary.txt");
	}

	@Test
	public void testInFile() {
		PatientFile pf = new PatientFile();
		String outData[] = {"aaa", "bbb", "ccc"};
		String date = "test";

		// write the test data
		pf.outFile(outData, date);

		// read that test data back
		String inData[] = pf.inFile(new File(pf.pathForDate(date)));
		
		// test passes if the read data is the same as the written data
		if(!Arrays.equals(outData, inData)) {
			fail("inFile did not read the same information");
		}
	}

}
