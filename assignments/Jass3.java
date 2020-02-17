import java.io.*;
import java.util.*;
import java.lang.*;
class Jass3
{
 public static void main(String[] args)throws IOException
 {
  ProcessBuilder pb=new ProcessBuilder();
  System.out.println("enter the host address and the number of packets to be transmitted ");
  Scanner sc=new Scanner(System.in);
  String add=sc.nextLine();
  int num=Integer.parseInt(sc.nextLine());
  add="ping "+ add.concat(" -c "+num)+" | cut -d '=' -f 4 "+"| cut -d ' ' -f 1";
  pb.command("bash","-c",add);
  Process p=pb.start();
  BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream()));
  br.readLine();
  double s;
  ArrayList<Double> al=new ArrayList<Double>();
  int i=0;
  while(i<num)
  {
  s=Double.parseDouble(br.readLine());
 // System.out.println(s);
  al.add(s);
   i++;
   }
  Collections.sort(al);
  //System.out.println(al);
   if(num%2!=0)
   System.out.println("Median of time taken to ping "+al.get(num/2));
   else
   System.out.println("Median of time taken to ping "+(al.get(num/2)+al.get((num/2)-1))/2);
   
 }
 }
  
