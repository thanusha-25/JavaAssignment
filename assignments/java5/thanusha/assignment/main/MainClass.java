package thanusha.assignment.main;
import thanusha.assignment.singleton.*;
import thanusha.assignment.data.*;
class MainClass
{
  public static void main(String[] args)
  {
    DataPackageClass instance1=new DataPackageClass ();
    instance1.displayUninitializedClassVariables();
   /* instance1.displayUninitializedLocalVariables();
    LocalVariables cannot be displayed without initializing*/
   SingletonPackageClass instance2=SingletonPackageClass.initializeTheNonStaticVariable("hello");
    instance2.displayTheNonStaticVariable();
   }
 }

