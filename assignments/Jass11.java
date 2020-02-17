import java.io.*;
import java.lang.*;
import java.util.*;
class Jass11
{
 public static void main(String[] args) throws IOException
 {
   String in=args[0];
   FileInputStream fin=new FileInputStream(in);
   BufferedInputStream bin=new BufferedInputStream(fin);
   int i;
 HashMap<Character,Integer> hm=new HashMap<Character,Integer>(26);
   while((i=bin.read())!=-1)   
   {
     if(Character.isLetter( (char)i ) )
     hm.putIfAbsent((char)i,0);
     if(hm.containsKey((char)i))
     {
        hm.replace((char)i,hm.get((char)i),(hm.get((char)i))+1);
      }
     }
   String val="";
  FileOutputStream fout=new FileOutputStream("/home/pola/Desktop/tst.txt");    
   for(Map.Entry m : hm.entrySet())
     {
       val=(String.valueOf(m.getKey()).concat(" ")).concat(String.valueOf(m.getValue())).concat("\n"); 
       byte b[]=val.getBytes();
       fout.write(b);  
     }
     
    fout.close();
  
           
    }
 }





















































