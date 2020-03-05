package DependencyInversion;

abstract class CrtBooking
{
    String type;
    int bid;
    abstract void bookingDetails();
    CrtPayment p;
}
class Item extends CrtBooking
{
    Item(int id ,)
    {
        bid=id;
    }
    void bookingDetails()
    {
        System.out.println("booking id is "+bid);
    }

}
interface CrtPayment
{
    void pay();
}
class Cash implements CrtPayment
{
    public void pay() {
        System.out.println("via cash");
    }
    }
class Card implements CrtPayment {
    public void pay() {
        System.out.println("via card");

    }
}
public class CrtDIP {
    public static void main(String[] args)
    {
        Item i=new Item(213);
        i.bookingDetails();
        i.p=new Cash();
        i.p.pay();

    }
}

