 
class Jass6d
{
 Jass6d(String str)
 {
  System.out.println("The string arguement which is passed to constructor is "+str);
   }
 public static void main(String[] args)
 {
   Jass6d[] jc=new Jass6d[6];
   for(int i=0;i<6;i++)
   jc[i]=new Jass6d("hello");
   }
}

