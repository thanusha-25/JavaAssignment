package InterfaceSegregaion;

public class Exec {
    public static void main(String[] args)
    {
        Member m=new Member();
        m.download();
        m.listen();
        m.search();
        NotMember nm=new NotMember();
        nm.download();
        nm.listen();
        nm.search();
    }
}
