interface First
{
  void m1();
  void m2();
 }
interface Second
{
  void m3();
  void m4();
 }
interface Third
{
  void m5();
  void m6();
 }
interface Fourth extends First,Second,Third
{
 void m7();
}

class newClass
{
  void show()
  {
    System.out.println("concrete class method ");
    }
 }

class Jass7c extends newClass implements Fourth 
{
   public void m1()
      {
        System.out.println("First method of First class");
         }
    public void m2()
      {
        System.out.println("Second method of First Class");
         }
   public void m3()
      {
        System.out.println("First method of First class");
         }
   public void m4()
      {
        System.out.println("Second method of Second Class");
         }
   public void m5()
      {
        System.out.println("First method of First class");
         }
   public void m6()
      {
        System.out.println("Second method of Third Class");
         }
   public void m7()
      {
        System.out.println("Method of Fourth Class ");
         }
  static void s1(First f)
  {
    f.m1();
    f.m2();
    }
   static void s2(Second s)
  {
    s.m3();
    s.m4();
   }
  static void s3(Third t)
   { 
     t.m5();
     t.m6();
     }   
 static void s4(Fourth fr)
    {
      fr.m7();
      }
   

   public static void main(String[] args)
   {
     
    Jass7c jc=new Jass7c();
      s1(jc);
      s2(jc);
      s3(jc);
      s4(jc);
      jc.show();
     }
 }



  
