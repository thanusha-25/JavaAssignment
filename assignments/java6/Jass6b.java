import java.util.*;
import java.util.logging.*;
class OverloadedConstructorDemo
{
   final static  Logger logger = Logger.getLogger(OverloadedConstructorDemo.class.getName());
  OverloadedConstructorDemo()
  {
    this(6,7);
    logger.log(Level.INFO,"This is no-arg constructor");
   }
  OverloadedConstructorDemo(int number1,int number2)
  {
    logger.log(Level.INFO,"This is parameterized constructor and parameters passed are "+number1+" "+number2);
   }
  public static void main(String[] args)
  { 
    OverloadedConstructorDemo instance=new OverloadedConstructorDemo(); 
    }
}

