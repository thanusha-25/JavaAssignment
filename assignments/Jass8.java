package assignments;
import java.util.logging.*;
public class MultipleExceptions {
	  final  Logger logger = Logger.getLogger(MultipleExceptions.class.getName());
	public void methodExceptions()
	{
		try
		{
			int array[]= {3,4};
			String string=null;
			logger.log(Level.INFO,string.charAt(3)+" ");
			logger.log(Level.INFO,array[4]+" ");
			int d=5/0;
		}
		catch(ArithmeticException | NullPointerException |ArrayIndexOutOfBoundsException ae)
		{
			logger.log(Level.INFO,ae.getClass()+" ");
		}
		finally
		{
			logger.log(Level.INFO,"finally executed");
		}
	}
	
public static void main(String[] args)
{
	MultipleExceptions object=new MultipleExceptions();
	object.methodExceptions();
}
	
}

