package triangle;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestTriangle extends TestCase {

	Triangle tr=new Triangle();
	
	public TestTriangle(String method){
		super(method);
	}
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		System.out.print("TestTriangle测试方法初始化\n");
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
		System.out.print("TestTriangle测试方法资源释放\n");
	}

	@Test
	public void testType1() {    //有效的不规则三角形
		tr.setTriangle(3, 4, 5);
		assertEquals(3,tr.type());
	}
	@Test
	public void testType2(){
		tr.setTriangle(3, 3, 3);   //等边三角形
		assertEquals(1,tr.type());
	}
	
	@Test
	public void testType3(){
		tr.setTriangle(4, 4, 5);  //等腰三角形  包括两等边相等的所有情况
		assertEquals(2,tr.type());
		tr.setTriangle(4, 5, 4);
		assertEquals(2,tr.type());
		tr.setTriangle(5, 4, 4);
		assertEquals(2,tr.type());
	}
	
	@Test
	public void testType4(){
		tr.setTriangle(0, 1, 3);   //某边长度等于0
		assertEquals(-1,tr.type());
	}
	
	@Test
	public void testType5(){     //某边长度为负数
		tr.setTriangle(-2, 1, 4);
		assertEquals(-1,tr.type());
	}
	
	@Test
	public void testType6(){
		tr.setTriangle(3, 3, 6);    //两边长度等于另外一边的三种情况
		assertEquals(-1,tr.type());
		tr.setTriangle(3, 6, 3);
		assertEquals(-1,tr.type());
		tr.setTriangle(6, 3, 3);
		assertEquals(-1,tr.type());
	}
	
	@Test
	public void testType7(){     //两边长度小于另外一边的三种情况
		tr.setTriangle(1, 2, 6);
		assertEquals(-1,tr.type());
		tr.setTriangle(1, 6, 2);
		assertEquals(-1,tr.type());
		tr.setTriangle(6, 1, 2);
		assertEquals(-1,tr.type());
	}
	
	@Test
	public void testType8(){   //三边长度都为0
		tr.setTriangle(0, 0, 0);
		assertEquals(-1,tr.type());	
	}
	
	public static TestSuite suite(){
		TestSuite suite=new TestSuite();
		suite.addTest(new TestTriangle("testType1"));
		suite.addTest(new TestTriangle("testType2"));
		suite.addTest(new TestTriangle("testType7"));
		return suite;
	}
}
