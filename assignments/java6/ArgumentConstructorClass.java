package assignments;

import java.util.logging.Level;
import java.util.logging.Logger;

class ArgumentConstructorClass
{
 	final  Logger logger = Logger.getLogger(MedianOfTimeToPing.class.getName());
 	ArgumentConstructorClass(String string)
  {
    logger.log(Level.INFO,"The string arguement which is passed to constructor is "+string);
    }
   public static void main(String[] args)
   {
	    ArgumentConstructorClass[] instance=new ArgumentConstructorClass[6];
     }
 }


