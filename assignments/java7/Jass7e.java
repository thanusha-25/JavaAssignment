class First
{

 static class Inner1
 {
   Inner1(String s)
   {
     System.out.println(s+" This is inner class of the First class");
    }
   }
 }

class Jass7e 
{
  class Inner2 extends First.Inner1
  {
    Inner2()
    {
      super("Hello..!!!");
      System.out.println("This is the inner class of the Second class");
     }
  }
 public static void main(String[] args)
  {

  Jass7e.Inner2 jc=new Jass7e().new Inner2();
    } 
  }
