import java.util.logging.*;
import java.util.*;
abstract class Rodent
{
  abstract void eat();
  abstract void sleep();   
  }

class Rat extends Rodent
{
  final  Logger logger = Logger.getLogger(Rat.class.getName());
  Rat()
  {
    logger.log(Level.INFO,"Rat class constructor");
   }
  void eat()
  {
    logger.log(Level.INFO,"Rat eat method");
    }
  void sleep()
  {
    logger.log(Level.INFO,"Rat sleep method");
  }
 }
class Gebril extends Rodent
{
final  Logger logger = Logger.getLogger(Gebril.class.getName());
  Gebril()
  {
    logger.log(Level.INFO,"Gebril class constructor");
   }
  void eat()
  {
    logger.log(Level.INFO,"Gebril eat method");
    }
  void sleep()
  {
   logger.log(Level.INFO,"Gebril sleep method");
  }
 }
class Hamster extends Rodent
{
final  Logger logger = Logger.getLogger(Hamster.class.getName());
  Hamster()
  {
    logger.log(Level.INFO,"Hamster class constructor");
   }
  void eat()
  {
   logger.log(Level.INFO,"Hamster eat method");
    }
  void sleep()
  {
    logger.log(Level.INFO,"Hamster sleep method");
  }
 }

class RodentDescription
{
   public static void main(String[] args)
  {
    Rodent instance[]=new Rodent[3];
    instance[0]=new Rat();
    instance[1]=new Gebril();
    instance[2]=new Hamster();
    instance[0].eat();
    instance[0].sleep();
    instance[1].eat();
    instance[1].sleep();
    instance[2].eat();
    instance[2].sleep();
   } 
  }



