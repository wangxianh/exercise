package triangle;

public class Triangle {
	 private int a, b, c;
	 public Triangle(){}
	 public void setTriangle ( int a, int b, int c )
	 { this.a = a;
       this.b = b; 
	    this.c = c; } 
	 /* ����ֵΪ1��ʾ�ǵȱ������� 
	  * ����ֵΪ2��ʾ�ǵ��������� 
	  ����ֵΪ3��ʾ����������������
       ����ֵΪ-1��ʾ���ܹ���������*/
	 
	 
	public int type()
	 { 
  while(a>0&&b>0&&c>0)
  { while(a<b+c&&b<a+c&&c<a+b)
     if(a==b)
			 if(b== c)
				 return 1;
			 else 
				return 2;
			
	else if(b==c)
			 return 2;
    else if(a==c)
			 return 2;
	else 
			return 3;
       
    return -1;
  }
  return -1;
	 }

}
