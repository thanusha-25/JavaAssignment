import java.io.*;
import java.lang.*;
import java.util.*;
class OccurenceOfCharacters
{
 public static void main(String[] args) throws IOException
 {
   String input=args[0];
   FileInputStream file=new FileInputStream(input);
   BufferedInputStream buffer=new BufferedInputStream(file);
   int i;
 HashMap<Character,Integer> map=new HashMap<Character,Integer>(26);
   while((i=buffer.read())!=-1)   
   {
     if(Character.isLetter( (char)i ) )
     map.putIfAbsent((char)i,0);
     if(map.containsKey((char)i))
     {
        map.replace((char)i,map.get((char)i),(map.get((char)i))+1);
      }
     }
   String value="";
  FileOutputStream fileOut=new FileOutputStream("/home/pola/Desktop/test.txt");    
   for(Map.Entry mapEntry : map.entrySet())
     {
       value=(String.valueOf(mapEntry.getKey()).concat(" ")).concat(String.valueOf(mapEntry.getValue())).concat("\n"); 
       byte bytes[]=value.getBytes();
       fileOut.write(bytes);  
     }
    fileOut.close();           
    }
 }
