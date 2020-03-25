 
package assignments;

import java.util.logging.Level;
import java.util.logging.Logger;

class ObjectForArgumentConstructorClass
{
 	final  Logger logger = Logger.getLogger(MedianOfTimeToPing.class.getName());
 	ObjectForArgumentConstructorClass(String string)
  {
    logger.log(Level.INFO,"The string arguement which is passed to constructor is "+string);
    }
   public static void main(String[] args)
   {
	    ObjectForArgumentConstructorClass[] instance=new ObjectForArgumentConstructorClass[6];
    for(int i=0;i<6;i++)
   instance[i]=new ObjectForArgumentConstructorClass("hello");
     }
 }
