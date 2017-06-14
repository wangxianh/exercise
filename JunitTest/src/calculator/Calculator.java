package calculator;

public class Calculator {
	private int result=0;
    Calculator(){}
	
	public void add(int a,int b)   //加法
	{
		result=a+b;
	}
	public void substract(int a,int b)  //减法
	{
		result= a-b;
	}
	public void multiply(int a,int b)    //乘法
	{
		result= a*b;
	}
	public void divide(int a,int b)   //除法
	{
		result=a/b;
	}
	public int getResult()
	{
		return result;
	}

}
