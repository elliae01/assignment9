package TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({test.PatientFileTester.class, test.PiechartWebServiceManagerTest.class, test.BmiCalculatorTester.class})
public class AllTests {
}
