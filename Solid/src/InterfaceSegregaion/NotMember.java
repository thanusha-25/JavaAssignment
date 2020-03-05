package InterfaceSegregaion;

public class NotMember extends User {
    public void listen()
    {
        System.out.println("Not registred user also can listen");
    }
    public void download()
    {
        System.out.println("Not registred user  cant download");
    }
    public  void search()
    {
        System.out.println("Not registred user also can search");
    }
}
