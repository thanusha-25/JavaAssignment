package DependencyInversion;
abstract class Booking
{
    String type;
    int bid;
    abstract void bookingDetails();
    Payment p=new Payment();
}
class Item1 extends Booking
{
    Item1(int id)
    {
        bid=id;
    }
    void bookingDetails()
    {
        System.out.println("booking id is "+bid);
    }

}
class Payment
{
    String type;
    void payViaCash()
    {
        this.type="cash";
        System.out.println("payment type is "+type);
    }
    void payViaCard()
    {
        this.type="card";
        System.out.println("payment type is "+type);
    }
}
public class DIP {
    public static void main(String[] args)
    {
        Item1 i=new Item1(213);
        i.bookingDetails();
        i.p.payViaCash();

    }
}
