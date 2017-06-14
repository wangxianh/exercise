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
		System.out.print("TestTriangle���Է�����ʼ��\n");
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
		System.out.print("TestTriangle���Է�����Դ�ͷ�\n");
	}

	@Test
	public void testType1() {    //��Ч�Ĳ�����������
		tr.setTriangle(3, 4, 5);
		assertEquals(3,tr.type());
	}
	@Test
	public void testType2(){
		tr.setTriangle(3, 3, 3);   //�ȱ�������
		assertEquals(1,tr.type());
	}
	
	@Test
	public void testType3(){
		tr.setTriangle(4, 4, 5);  //����������  �������ȱ���ȵ��������
		assertEquals(2,tr.type());
		tr.setTriangle(4, 5, 4);
		assertEquals(2,tr.type());
		tr.setTriangle(5, 4, 4);
		assertEquals(2,tr.type());
	}
	
	@Test
	public void testType4(){
		tr.setTriangle(0, 1, 3);   //ĳ�߳��ȵ���0
		assertEquals(-1,tr.type());
	}
	
	@Test
	public void testType5(){     //ĳ�߳���Ϊ����
		tr.setTriangle(-2, 1, 4);
		assertEquals(-1,tr.type());
	}
	
	@Test
	public void testType6(){
		tr.setTriangle(3, 3, 6);    //���߳��ȵ�������һ�ߵ��������
		assertEquals(-1,tr.type());
		tr.setTriangle(3, 6, 3);
		assertEquals(-1,tr.type());
		tr.setTriangle(6, 3, 3);
		assertEquals(-1,tr.type());
	}
	
	@Test
	public void testType7(){     //���߳���С������һ�ߵ��������
		tr.setTriangle(1, 2, 6);
		assertEquals(-1,tr.type());
		tr.setTriangle(1, 6, 2);
		assertEquals(-1,tr.type());
		tr.setTriangle(6, 1, 2);
		assertEquals(-1,tr.type());
	}
	
	@Test
	public void testType8(){   //���߳��ȶ�Ϊ0
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
