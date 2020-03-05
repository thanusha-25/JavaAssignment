package LSP;
abstract class Doctor
{
    abstract void surgery();
    abstract void consultancy();
}
class Surgeon extends Doctor
{
  public void surgery(){
      System.out.println("performs surgery");
  }
  public void consultancy()
{

}
}
class Consultant extends Doctor
{
    public void surgery(){

    }
    public void consultancy()
{
    System.out.println(" consultant");
}
}
public class liskov {
    public static void main(String[] args)
    {

    }
}
