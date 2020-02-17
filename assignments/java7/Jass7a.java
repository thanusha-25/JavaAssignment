abstract class Rodent
{
  abstract void eat();
  abstract void sleep();
  
    
  }
class Rat extends Rodent
{
  Rat()
  {
    System.out.println("Rat class constructor");
   }
  void eat()
  {
    System.out.println("Rat eat method");
    }
  void sleep()
  {
    System.out.println("Rat sleep method");
  }
 }
class Gebril extends Rodent
{
  Gebril()
  {
    System.out.println("Gebril class constructor");
   }
  void eat()
  {
    System.out.println("Gebril eat method");
    }
  void sleep()
  {
    System.out.println("Gebril sleep method");
  }
 }
class Hamster extends Rodent
{
  Hamster()
  {
    System.out.println("Hamster class constructor");
   }
  void eat()
  {
    System.out.println("Hamster eat method");
    }
  void sleep()
  {
    System.out.println("Hamster sleep method");
  }
 }

class Jass7a
{
   public static void main(String[] args)
  {
    Rodent r[]=new Rodent[3];
    r[0]=new Rat();
    r[1]=new Gebril();
    r[2]=new Hamster();
    r[0].eat();
    r[0].sleep();
    r[1].eat();
    r[1].sleep();
    r[2].eat();
    r[2].sleep();
   } 
  }



