package LSP;
class CrtDr
{
    int id;
    String name;
    CrtDr(int id,String name)
    {
        this.id=id;
        this.name=name;
    }
}
class CrtSurgeon extends CrtDr
{
    CrtSurgeon(int i, String name)
    {
        super( i,name);
    }
    public void surgery()
    {
        System.out.println("performs surgery");
    }
}
class NotSurgeon extends CrtDr
{
    NotSurgeon(int id,String name)
    {
        super(id,name);
    }
    public void consultancy()
    {
        System.out.println("consulting patients");
    }
}
public class CrtLiskov {
    public static void main(String[] args)
    {
          CrtSurgeon rishi=new CrtSurgeon(1,"rishi");
          rishi.surgery();
    }
}
