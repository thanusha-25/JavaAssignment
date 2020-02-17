import java.util.*;
interface Cycle
{
 void work();
 }

class Unicycle implements Cycle
{
  public void work()
  {
   System.out.println("Unicycle work method");
   }
 }

class Bicycle implements Cycle
{
  public void work()
  {
    System.out.println("Bicycle work method");
   }
 
 }

class Tricycle implements Cycle
{
  public void work()
  {
    System.out.println("Tricycle work method");
    }
 }

class GetCycleClass
{   
  public static Cycle getCycle(String s)
  { 
    if(s=="unicycle")
    return new Unicycle();
    else if(s=="bicycle")
    return new Bicycle();
    else if(s=="tricycle")
    return new Tricycle();
    return null; 
  }
}
class Jass7d
{
  public static void main(String[] args)
  {
    Scanner sc=new Scanner(System.in);
    GetCycleClass gcc=new GetCycleClass();
    Cycle c;
    c=gcc.getCycle(sc.nextLine());   
    c.work();
  }
}







