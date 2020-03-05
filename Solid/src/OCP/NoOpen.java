package OCP;

 class NPayment
{
    String type;
}

class NBooking
{
    static int bid;
    NPayment p=new NPayment();
    NBooking(int bid,String type)
    {
        this.bid=bid;
        this.p.type=type;
    }
    void displayBooking()
    {
        if(p.type=="cash")
            System.out.println("pay via cash");
        else if(p.type=="card")
            System.out.println("pay via card");
        else if(p.type=="wallet")
            System.out.println("pay via wallet");

    }
}



class NoOpen
{
    public static void main(String[] args)
    {
        NBooking b=new NBooking(1,"cash");
        b.displayBooking();
    }
}





