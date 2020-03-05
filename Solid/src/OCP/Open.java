package OCP;
class Booking
{
    static int bid;
    static Payment p;
    Booking(int bid,Payment p)
    {
        this.bid=bid;
        this.p=p;
    }
    void displayBooking()
    {
        System.out.println("booking details are "+bid);
        p.paymentMethod();
    }
}


    interface Payment
    {
        void paymentMethod();
    }

    class Cash implements Payment
    {
        public void paymentMethod()
        {
            System.out.println("payment via cash");
        }
    }

    class Card implements Payment
    {
        public void paymentMethod()
        {
            System.out.println("payment via card");
        }
    }

    class Wallet implements Payment
    {
        public void paymentMethod()
        {
            System.out.println("payment via e-wallet");
        }
    }

    class Open
    {
        public static void main(String[] args)
        {
            Booking b=new Booking(1,new Cash());
            b.displayBooking();
        }
    }

