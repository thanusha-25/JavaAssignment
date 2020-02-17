class Cycle
{
   /*void balance()
  {
    System.out.println("balance method");
   }*/
 }
 
class Unicycle extends Cycle
{
  void balance()
  {
    System.out.println("unicycle balance method");
   }
 }

class Bicycle extends Cycle
{
   void balance()
  {
    System.out.println("bicycle balance method");
   }
 }

class Tricycle extends Cycle
{
  }
 
class Jass7b
{
  public static void main(String[] args) 
  {
   /**upcasting
   Unicycle uni=new Unicycle();
    Bicycle bi=new Bicycle();
    Tricycle tri=new Tricycle();
    Cycle c[]= new Cycle[3];
    c[0]=uni;
    c[1]=bi;
    c[2]=tri;
     c[0].balance();
     c[1].balance();
     c[2].balance();
  */
  /**downcating
   Cycle c[]=new Cycle[3];
    c[0]=new Unicycle();
    c[1]=new Bicycle();
    c[2]=new Tricycle();
   Unicycle uni=(Unicycle)c[0];
   Bicycle bi=(Bicycle)c[1];
   Tricycle tri=(Tricycle)c[2];
   uni.balance();
   bi.balance();  
    tri.balance();
   **/
    }
  }




















/*
class Jass7b{
   public static void main(String args[]){
     Account obj[] = new Account[2] ;
     obj[0] = new Account();
     obj[1] = new Account();
    obj[0].setData(1,2);
    obj[1].setData(3,4);
    System.out.println("For Array Element 0");
    obj[0].showData();
    System.out.println("For Array Element 1");
     obj[1].showData();
  }
}
class Account{
  int a;
  int b;
 public void setData(int c,int d){
   a=c;
   b=d;
 }
 public void showData(){
   System.out.println("Value of a ="+a);
   System.out.println("Value of b ="+b);
 }
}*/


