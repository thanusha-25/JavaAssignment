package Encryption1;

import edu.duke.FileResource;

public class CaesarCipher {
    public String encrypt(String input,int key)
    {
        String output="",encr="";
        int index,flag=0;
        String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        encr=alphabet.substring(key)+alphabet.substring(0,key);
        for(int i=0;i<input.length();i++)
        {
           if(input.charAt(i) > 96 && input.charAt(i)<123)
           {
               index= alphabet.indexOf((char)(input.charAt(i)-32));
               if(index!=-1)
                   output=output+(char)(encr.charAt(index)+32);
               else
                   output=output+input.charAt(i);
           }
            else {
               index = alphabet.indexOf(input.charAt(i));
               if (index != -1)
                   output = output + encr.charAt(index);
               else
                   output = output + input.charAt(i);
           }
        }
        return output;
    }
    public void testCaesar()
    {
        FileResource fileRes=new FileResource("/home/pola/Desktop/thanu/aw");
        String message=fileRes.asString();
        System.out.println(encrypt(message,23));
    }

    public  String encyptTwoKeys(String input,int key1,int key2)
    {
        String output="";
        for(int i=0;i<input.length();i++)
        {
            if(i%2==0)
               output=output+encrypt(input.charAt(i)+"",key1);
               else
                   output=output+encrypt(input.charAt(i)+"",key2);
        }
        return output;
    }
    public static void main(String[] args)
    {
       // new CaesarCipher().testCaesar();
        System.out.println(new CaesarCipher().encyptTwoKeys("First Legion",23,17));
    }
}
