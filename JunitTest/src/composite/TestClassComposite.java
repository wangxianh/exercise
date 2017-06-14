package composite;

import triangle.TestTriangle;
import calculator.TestCalculator;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestClassComposite extends TestCase {

	public TestClassComposite(String method)
	{
		super(method);
	}

    static public Test suite()
    {
    	TestSuite suite=new TestSuite();
    	suite.addTest(TestCalculator.suite());
    	suite.addTestSuite(TestTriangle.class);
		return suite;
    }
}