package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Model.PatientClassification;

public class PatientClassificationTester {

	
	@Test
	public void testCholesterol1() {
		PatientClassification pc = new PatientClassification();
		assertEquals(pc.cholesterol(0), "");
	}
	
	@Test
	public void testCholesterol2() {
		PatientClassification pc = new PatientClassification();
		assertEquals(pc.cholesterol(150), "DESIRABLE");
	}
	
	@Test
	public void testCholesterol3() {
		PatientClassification pc = new PatientClassification();
		assertEquals(pc.cholesterol(200), "BORDERLINE");
	}
	@Test
	public void testCholesterol4() {
		PatientClassification pc = new PatientClassification();
		assertEquals(pc.cholesterol(250), "HIGH");
	}
	
	@Test
	public void testBMI1() {
		PatientClassification pc = new PatientClassification();
		assertEquals(pc.bmi(0), "");
	}
	
	@Test
	public void testBMI2() {
		PatientClassification pc = new PatientClassification();
		assertEquals(pc.bmi(15), "UNDERWEIGHT");
	}
	
	@Test
	public void testBMI3() {
		PatientClassification pc = new PatientClassification();
		assertEquals(pc.bmi(20), "NORMAL");
	}
	
	@Test
	public void testBMI4() {
		PatientClassification pc = new PatientClassification();
		assertEquals(pc.bmi(25), "OVERWEIGHT");
	}
	
	@Test
	public void testBMI5() {
		PatientClassification pc = new PatientClassification();
		assertEquals(pc.bmi(30), "OBESE");
	}
	
	@Test
	public void testBloodPressure1() {
		PatientClassification pc = new PatientClassification();
		assertEquals(pc.bloodPressure(0,50), "");
	}
	
	@Test
	public void testBloodPressure2() {
		PatientClassification pc = new PatientClassification();
		assertEquals(pc.bloodPressure(50,0), "");
	}
	
	@Test
	public void testBloodPressure3() {
		PatientClassification pc = new PatientClassification();
		assertEquals(pc.bloodPressure(50,50), "NORMAL");
	}
	
	@Test
	public void testBloodPressure4() {
		PatientClassification pc = new PatientClassification();
		assertEquals(pc.bloodPressure(50,85), "PREHYPERTENSION");
	}
	
	@Test
	public void testBloodPressure5() {
		PatientClassification pc = new PatientClassification();
		assertEquals(pc.bloodPressure(125,95), "PREHYPERTENSION");
	}
	
	@Test
	public void testBloodPressure6() {
		PatientClassification pc = new PatientClassification();
		assertEquals(pc.bloodPressure(175,95), "STAGE 1 HYPERTENSION");
	}
	
	@Test
	public void testBloodPressure7() {
		PatientClassification pc = new PatientClassification();
		assertEquals(pc.bloodPressure(145,105), "STAGE 1 HYPERTENSION");
	}
	
	@Test
	public void testBloodPressure8() {
		PatientClassification pc = new PatientClassification();
		assertEquals(pc.bloodPressure(190,105), "STAGE 2 HYPERTENSION");
	}
	
	@Test
	public void testBloodPressure9() {
		PatientClassification pc = new PatientClassification();
		assertEquals(pc.bloodPressure(175,111), "STAGE 2 HYPERTENSION");
	}
	
	@Test
	public void testBloodPressure10() {
		PatientClassification pc = new PatientClassification();
		assertEquals(pc.bloodPressure(190,120), "HYPERTENSIVE CRISIS");
	}
	
}
