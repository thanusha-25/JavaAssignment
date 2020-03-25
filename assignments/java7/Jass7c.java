import java.util.logging.*;
interface First
{
  void method1();
  void method2();
 }
interface Second
{
  void method3();
  void method4();
 }
interface Third
{
  void method5();
  void method6();
 }
interface Fourth extends First,Second,Third
{
 void method7();
}

class newClass
{
  final  Logger logger = Logger.getLogger(newClass.class.getName());
  void show()
  {
    logger.log(Level.INFO,"concrete class method ");
    }
 }

class Jass7c extends newClass implements Fourth 
{
   public void method1()
      {      
        logger.log(Level.INFO,"First method of First class");
         }
    public void method2()
      {
      logger.log(Level.INFO,"Second method of First Class");
         }
   public void method3()
      {
        logger.log(Level.INFO,"First method of First class");
         }
   public void method4()
      {
        logger.log(Level.INFO,"Second method of Second Class");
         }
   public void method5()
      {
        logger.log(Level.INFO,"First method of First class");
         }
   public void method6()
      {
        logger.log(Level.INFO,"Second method of Third Class");
         }
   public void method7()
      {
        logger.log(Level.INFO,"Method of Fourth Class ");
         }
  static void implementingMethod1(First first)
  {
    first.method1();
    first.method2();
    }
   static void implementingMethod2(Second second)
  {
    second.method3();
    second.method4();
   }
  static void implementingMethod3(Third third)
   { 
     third.method5();
     third.method6();
     }   
 static void implementingMethod4(Fourth fourth)
    {
      fourth.method7();
      }
   

   public static void main(String[] args)
   {   
    Jass7c object=new Jass7c();
      implementingMethod1(object);
      implementingMethod2(object);
      implementingMethod3(object);
      implementingMethod4(object);
      object.show();
     }
 }



  
