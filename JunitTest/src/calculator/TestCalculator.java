package calculator;

import org.junit.*;

import junit.extensions.TestSetup;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestCalculator extends TestCase { 
	
	public TestCalculator(String method){
		super(method);
	}
	Calculator cal=new Calculator();   //创建一个对象
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		System.out.print("TestCalculator测试方法初始化\n");
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
		System.out.print("TestCalculator测试方法资源释放\n");
	}

	@Test
	public void testAdd() {
		cal.add(2, 3);
		assertEquals(5, cal.getResult());
		cal.add(3, 2);
		assertEquals(5, cal.getResult());
		cal.add(0, 1);
		assertEquals(1,cal.getResult());
		cal.add(0, 0);
		assertEquals(0,cal.getResult());
		cal.add(-1, 1);
		assertEquals(0,cal.getResult());
		cal.add(-2, -3);
		assertEquals(-5, cal.getResult());
	}
	
	@Test
	public void testSubstract(){
		cal.substract(5, 1);
		assertEquals(4,cal.getResult());
	}
	
	@Test
	public void testMultiply(){
		cal.multiply(2, 3);
		assertEquals(6,cal.getResult());
	}
	
	@Test(expected = ArithmeticException.class)
	public void testDivide() 
	{
		cal.divide(2, 3);
		assertEquals(0,cal.getResult());
		cal.divide(-1, 1);
		assertEquals(-1,cal.getResult());
		cal.divide(2, 0);
		assertEquals(0,cal.getResult());
		
	}
	
	public static TestSetup suite(){
		TestSuite suite=new TestSuite();
		//只测试加法和除法
		suite.addTest(new TestCalculator("testAdd"));
		suite.addTest(new TestCalculator("testDivide"));
		TestSetup wrapper=new TestSetup(suite){
			protected void setUp(){
				oneTimeSetUp();
			}
			protected void tearDown(){
				oneTimeTearDown();
			}
		};
		return  wrapper;
	}
	
	public static void oneTimeSetUp(){
		System.out.print("TestSuite初始化\n");
	}
	
	public static void oneTimeTearDown(){
		System.out.print("TestSuite释放资源\n");
	}

}
