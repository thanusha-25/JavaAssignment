import java.util.logging.*;
class First
{
final  Logger logger = Logger.getLogger(First.class.getName());
 static class Inner
 {
   Inner1(String s)
   {
     logger.log(Level.INFO," This is inner class of the First class with string "+s);
    }
   }
 }

class Second
{
 final  Logger logger = Logger.getLogger(Second.class.getName());
  class Inner extends First.Inner
  {
    Inner()
    {
      super("Hello..!!!");
      logger.log(Level.INFO,"This is the inner class of the Second class");
     }
  }
 public static void main(String[] args)
  {
  Second.Inner object=new Second().new Inner();
    } 
  }
