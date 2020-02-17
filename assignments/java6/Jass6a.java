import java.util.*;
class Jass6a
{
  public static void main(String[] args)
  {
       Scanner sc=new Scanner(System.in);
       int a=Integer.parseInt(sc.nextLine());
       int cnt=0;
       int n=((String.valueOf(a)).length());
       if(n%2==0)
       {
         HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
         int b=a;
         while(b>0)
         {
            if(hm.containsKey(b%10))
             {
               hm.replace(b%10,hm.get(b%10),(hm.get(b%10))+1);
               }     
            else
               hm.put(b%10,1);
             b=b/10;
           }
           int x=n/2;
           int i=1;
          while((String.valueOf(i)).length()<x)
            {
               i=i*10;
              }
          int j=i*10;
          for(int k=i;k<j;k++)
           { 
              for(int l=k;l<j;l++)
               {
                  cnt=0;
                  if(l*k==a)
                    {
                         HashMap<Integer,Integer> hm1=new HashMap<Integer,Integer>();
                         b=l;
                         while(b>0)
                         {
                            if(hm1.containsKey(b%10))
                              {
                                  hm1.replace(b%10,hm1.get(b%10),(hm1.get(b%10))+1);
                                }     
                            else
                                  hm1.put(b%10,1);
                             b=b/10;
                           }
                        b=k;
                        while(b>0)
                         {
                            if(hm1.containsKey(b%10))
                              {
                                  hm1.replace(b%10,hm1.get(b%10),(hm1.get(b%10))+1);
                                }     
                            else
                                  hm1.put(b%10,1);
                            b=b/10;
                           }
                        for(Map.Entry m:hm1.entrySet())
                          {
                             if(hm.containsKey(m.getKey()))
                              {
                                 if( m.getValue()==hm.get(m.getKey()))
                                 cnt++;
                                 }
                             }
                       if(cnt==hm.size())
                          System.out.println(l+" "+k);
                    }
               }
           }
       }
     else
       System.out.println("number contains odd number of digits");   
  }
}
