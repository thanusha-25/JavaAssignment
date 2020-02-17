import java.util.*;
class Jass4
{
  public static void main(String[] args) throws Exception
  {
  int num,y,m,d,i;
  Scanner sc=new Scanner(System.in);
  num=Integer.parseInt(sc.nextLine());
  Calendar[] signup=new Calendar[num];
  Calendar[] current=new Calendar[num];
  for(i=0;i<num;i++)
  {
   signup[i]=Calendar.getInstance();
   current[i]=Calendar.getInstance();
   }
  i=0;
   while(i<num)
 {
   String s=sc.nextLine();
   StringTokenizer st=new StringTokenizer(s," ");
 
   String s1=st.nextToken();
  // System.out.println(s1);
    StringTokenizer st1=new StringTokenizer(s1,"-");
    if(st1.hasMoreTokens())
     { 
       d=Integer.parseInt(st1.nextToken());
       m=Integer.parseInt(st1.nextToken());
       y=Integer.parseInt(st1.nextToken());
       signup[i].set(y,m-1,d);
      }
      s1=st.nextToken();
      
    //System.out.println(s1);
   st1=new StringTokenizer(s1,"-");
    if(st1.hasMoreTokens())
     { 
       d=Integer.parseInt(st1.nextToken());
       m=Integer.parseInt(st1.nextToken());
       y=Integer.parseInt(st1.nextToken());
       current[i].set(y,m-1,d);
      }
    
     i++;
    }
    //Calendar present=Calendar.getInstance();
   // present.getTime();
   for(i=0;i<num;i++)
   {
     if(signup[i].after(current[i]))
     System.out.println("No range");
     else
     {
     while(signup[i].get(Calendar.YEAR) < current[i].get(Calendar.YEAR))
     signup[i].add(Calendar.YEAR,1);
     if(signup[i].after(current[i]))     
     {
       while(signup[i].after(current[i]))
        signup[i].add(Calendar.DATE,-30);
        signup[i].add(Calendar.MONTH,1);
        current[i].add(Calendar.MONTH,1);
        System.out.print(signup[i].get(Calendar.DATE)+"-"+signup[i].get(Calendar.MONTH)+"-"+signup[i].get(Calendar.YEAR));
        System.out.println(" "+current[i].get(Calendar.DATE)+"-"+current[i].get(Calendar.MONTH)+"-"+current[i].get(Calendar.YEAR));
       }
      else if(signup[i].equals(current[i]))
       {
         signup[i].add(Calendar.DATE,-30);
         signup[i].add(Calendar.MONTH,1);
         System.out.print(signup[i].get(Calendar.DATE)+"-"+signup[i].get(Calendar.MONTH)+"-"+signup[i].get(Calendar.YEAR));
         current[i].add(Calendar.MONTH,1);
          System.out.println(" "+current[i].get(Calendar.DATE)+"-"+current[i].get(Calendar.MONTH)+"-"+current[i].get(Calendar.YEAR));
         }
      else
      {
         signup[i].add(Calendar.DATE,-30);
         signup[i].add(Calendar.MONTH,1);
         System.out.print(signup[i].get(Calendar.DATE)+"-"+signup[i].get(Calendar.MONTH)+"-"+signup[i].get(Calendar.YEAR));
         signup[i].add(Calendar.MONTH,-1);
         signup[i].add(Calendar.DATE,60);
         signup[i].add(Calendar.MONTH,1);
         System.out.println(" "+signup[i].get(Calendar.DATE)+"-"+signup[i].get(Calendar.MONTH)+"-"+signup[i].get(Calendar.YEAR));
         
         }
      }
     }
   

  }
  }





