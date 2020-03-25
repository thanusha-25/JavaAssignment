package thanusha.assignment.data;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DataPackageClass
{
  int classNumber;
  char classCharacter;
  final  Logger logger = Logger.getLogger(DataPackageClass.class.getName());
  public void displayUninitializedClassVariables()
  {
	  logger.log(Level.INFO,"Default values for class variables are : for integer is "+classNumber+" "+"and  character is "+classCharacter);
	  }
 
  /* We cant display the uninitialized local variables.It throws an error.
  void displayUninitializedLocalVariables()
 {
    int localNumber;
    char localCharacter ;
   System.out.println(localNumber+" "+localCharacter);
  }*/
  
} 
