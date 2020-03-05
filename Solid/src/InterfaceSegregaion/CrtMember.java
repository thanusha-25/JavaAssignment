package InterfaceSegregaion;

public class CrtMember extends CrtUser implements Listening,Downloading {
    public void listen()
    {
        System.out.println("registered member can listen");
    }
    public void download()
    {
        System.out.println("egistered member can download");
    }
}
