package InterfaceSegregaion;

public class CrtExec {
    public static void main(String[] args)
    {
        CrtMember m=new CrtMember();
        m.download();
        m.listen();
        m.search();
        CrtNotMember nm=new CrtNotMember();
        //nm.download();
        nm.listen();
        nm.search();
    }
}
