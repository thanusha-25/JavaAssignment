package InterfaceSegregaion;

public class CrtNotMember extends CrtUser implements Listening {
    public void listen()
    {
        System.out.println("not registered member can listen");
    }

}
