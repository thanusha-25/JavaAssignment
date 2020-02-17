class Excep1 extends Exception
{
  public Excep1(String s)
  {

    super(s);
   }
 }

class Excep2 extends Exception
{
  public Excep2(String s)
  {

    super(s);
   }
 }

class Excep3 extends Exception
{
  public Excep3(String s)
  {

    super(s);
   }
 }

class Jass8 
{
  int i=-4;
  static void getExcep()
  {
    try
   {
    int i=-4;
    if(i<0)
    { 
      throw new Excep1("excep1");
     }
    }
    catch(Excep1 e)
   {  
    System.out.print("catch ");
     System.out.println(e.getMessage());  
     }

    }
  public static void main(String[] args)
  {
   
    getExcep();
          
   
  
   }
}
