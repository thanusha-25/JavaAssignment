package thanusha.assignment.data;
public class pack1
{
  int a;
  char ch;
  public void display()
  {
    System.out.println("Default values for member values in First class are integer is "+a+" "+"and    character is "+ch);
   }
 /* void display1()
 {
    int b;
    char c;
   System.out.println(b+" "+c);
  }*/
 public static void main(String[] args)
 {
   pack1 p=new pack1();
   p.display();
  // p.display1();
  }
} 
