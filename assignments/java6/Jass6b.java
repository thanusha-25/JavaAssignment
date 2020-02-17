class Jass6b
{
   Jass6b()
  {
    this(6,7);
    System.out.println("This is no-arg constructor");
   }
  Jass6b(int a,int b)
  {
    System.out.println("This is parameterized constructor and parameters passed are "+a+" "+b);
   }
  public static void main(String[] args)
  { 
    Jass6b jb=new Jass6b(); 
    }
}

