import java.util.regex.*;
import java.util.*;
import java.io.*;
class Jass1
{
  public static void main(String[] args) throws IOException 
  {

   Scanner sc=new Scanner(System.in);
   String regex=sc.nextLine();
   Pattern p=Pattern.compile(regex);
   ProcessBuilder pb=new ProcessBuilder();
   pb.command("bash","-c","ls -R");
   Process pr=pb.start();
   BufferedReader br=new BufferedReader(new InputStreamReader(pr.getInputStream()));
   String input=br.readLine();
    while(input!=null)
    {
      Matcher m=p.matcher(input);
      if(m.find())
      {
       //System.out.println(input);
       pb.command("bash","-c","find -name "+input );
      Process pr2=pb.start();
      BufferedReader br1=new BufferedReader(new InputStreamReader(pr2.getInputStream()));
      System.out.println(br1.readLine());
        }
      input=br.readLine();
   }

  }
 }
