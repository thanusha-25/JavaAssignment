package thanusha.assignment.singleton;
public class pack2
{
  String s;
  public static pack2 show(String str)
  {
   pack2 pk2=new pack2();
   pk2.s=str;
    return pk2; 
    }
   public void show1()
   {
     System.out.println("String assigned to the variable in second class is " +s);
    }
}
