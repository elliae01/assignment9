package TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ test.PatientFileTester.class, test.PiechartWebServiceManagerTest.class, test.BmiCalculatorTester.class,
		test.PatientSummaryTester.class,test.PatientClassificationTester.class,test.PiechartUITester.class })
public class AllTests {
}
