package ass;

public class Jass8 {
	
	public void methodExceptions()
	{
		try
		{
			int a[]= {3,4};
			String s=null;
			System.out.println(s.charAt(3));
			System.out.println(a[4]);
			int d=5/0;
		}
		catch(ArithmeticException | NullPointerException |ArrayIndexOutOfBoundsException ae)
		{
			System.out.println(ae.getClass());
		}
		finally
		{
			System.out.println("finally executed");
		}
	}
	
public static void main(String[] args)
{
	Jass8 obj=new Jass8();
	obj.methodExceptions();
}
	
}
