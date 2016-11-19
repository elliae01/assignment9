package test;

import static org.junit.Assert.*;
import assignment9.BmiCalculator;

import org.junit.Test;

public class BmiCalculatorTester {

	@Test
	public void testCalculateBmi_A() {
		BmiCalculator bmi = new BmiCalculator();
		assertEquals(bmi.calculateBmi(1, 1, false), 10000, 0.1);
	}

	@Test
	public void testCalculateBmi_B() {
		BmiCalculator bmi = new BmiCalculator();
		assertEquals(bmi.calculateBmi(999999, 999999, false), 0.01 , 0.001);
	}

	@Test
	public void testCalculateBmi_C() {
		BmiCalculator bmi = new BmiCalculator();
		assertEquals(bmi.calculateBmi(1, 1, true), 703.07, 0.001);
	}

	@Test
	public void testCalculateBmi_D() {
		BmiCalculator bmi = new BmiCalculator();
		assertEquals(bmi.calculateBmi(999999, 999999, true), 0, 0.1);
	}

}
