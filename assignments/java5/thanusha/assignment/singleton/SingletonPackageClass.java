package thanusha.assignment.singleton;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SingletonPackageClass {
	  String string;
	  final  Logger logger = Logger.getLogger(SingletonPackageClass.class.getName());

	  public static SingletonPackageClass initializeTheNonStaticVariable(String string)
	  {
	   SingletonPackageClass instance=new SingletonPackageClass();
	   instance.string=string;
	    return instance; 
	    }
	   public void displayTheNonStaticVariable()
	   {
		   logger.log(Level.INFO,"String assigned to the variable in second class is " +string);
	    }
	}

