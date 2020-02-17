import java.util.*;
class jass2
{
 public static void main(String[] args)
 {
  int i=0;
   Scanner sc=new Scanner(System.in);
   String input=sc.nextLine();
  if(input.length()<26)
   System.out.println("doesn't contain all alphabets");
   HashMap<Character,Integer>hm=new HashMap<Character,Integer>();
   while(i<input.length())
  {
    if(Character.isLetter((input.charAt(i))))
    hm.putIfAbsent(Character.toLowerCase((input.charAt(i))),0);
    i++;
   }
   if((hm.size())==26)
   System.out.println("contains all alphabets");
      
   }
}
   
