/*


A vampire number v is a number with an even number of digits n, 
that can be factored into two numbers x and y each with n/2 digits and not both with trailing zeroes,
where v contains precisely all the digits from x and from y, in any order. 
Write a java program to print first 100 vampire numbers.


*/





package assignments;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
class VampireNumber
{
	 final static  Logger logger = Logger.getLogger(VampireNumber.class.getName());

  public static void main(String[] args)
  {
       Scanner scanner=new Scanner(System.in);
       int number=10,countNum=0;
       while(countNum<=100)
       {
    	   int count=0;
       
       int length=((String.valueOf(number)).length());
       if(length%2==0)
       {
         HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
         int b=number;
         while(b>0)
         {
            if(map.containsKey(b%10))
             {
               map.replace(b%10,map.get(b%10),(map.get(b%10))+1);
               }     
            else
               map.put(b%10,1);
             b=b/10;
           }
           int x=length/2;
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
                  count=0;
                  if(l*k==number)
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
                             if(map.containsKey(m.getKey()))
                              {
                                 if( m.getValue()==map.get(m.getKey()))
                                 count++;
                                 }
                             }
                       if(count==map.size())
                       {  logger.log(Level.INFO,number+"   "+countNum);
                         countNum++;
                       }
                       }
                    }
               }
           }
       number++;
       }
       
       }
  }

