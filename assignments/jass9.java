import java.util.regex.*;
import java.io.*;
import java.util.*;

class jass9
{
 public static void main(String...args)
 {
  System.out.println("Enter sentence to test:");
   Scanner sc=new Scanner(System.in);
   String input=sc.nextLine();
   Pattern p=Pattern.compile("^[A-Z][a-zA-Z\\0-9!@#$%^&*()_.,\\]*.$");
   Matcher m=p.matcher(input);
   if(m.find())
    System.out.println("matched");
   else
     System.out.println("not matched"); 
 }
 }
//\\h0-9\\p{!@#$%^&*()_.,\\}
