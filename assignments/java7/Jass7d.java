import java.util.*;
import java.util.logging.*;
interface Cycle
{
 void work();
 }

class Unicycle implements Cycle
{
final  Logger logger = Logger.getLogger(Unicycle.class.getName());
  public void work()
  {
   logger.log(Level.INFO,"Unicycle work method");
   }
 }

class Bicycle implements Cycle
{
final  Logger logger = Logger.getLogger(Bicycle.class.getName());
  public void work()
  {
    logger.log(Level.INFO,"Bicycle work method");
   }
 
 }

class Tricycle implements Cycle
{
final  Logger logger = Logger.getLogger(Tricycle.class.getName());
  public void work()
  {
    logger.log(Level.INFO,"Tricycle work method");
    }
 }

class GetCycleClass
{   
  public static Cycle getCycle(String string)
  { 
    if(string=="unicycle")
    return new Unicycle();
    else if(string=="bicycle")
    return new Bicycle();
    else if(string=="tricycle")
    return new Tricycle();
    return null; 
  }
}
class CycleImplementations
{
  public static void main(String[] args)
  {
    Scanner scanner=new Scanner(System.in);
    GetCycleClass getCycleClass=new GetCycleClass();
    Cycle cycle;
    cycle=getCycleClass.getCycle(scanner.nextLine());   
    cycle.work();
  }
}
