package Decryption;

import Encryption1.CaesarCipher;
import edu.duke.FileResource;

public class WordLengths {
    public void countWordLength(FileResource resource,int count[])
    {
        int i=0,length=0;

       for( String word : resource.words())
       {
           length= word.length();
           if(!(Character.isLetter(word.charAt(0))))
               length--;
           if(!(Character.isLetter(word.charAt(word.length()-1))))
               length--;
           if (length >= 0 && length <= count.length)
                count[length]++;
       }
       for(int j=0;j<31;j++)
       System.out.println(count[j]);
    }
    public int indexOfMax(int values[])
    {
        int max=0,maxIndex=0;
        for(int i=0;i<values.length;i++)
        {
            if(values[i]>max) {
                maxIndex = i;
                max=values[i];
            }
        }
        return maxIndex;
    }
    public  void testCountWordLength()
    {
        int count[]=new int[31];
        //System.out.println(count[0]);
         FileResource file=new FileResource("/home/pola/Desktop/thanu/hamlet.txt");
       countWordLength(file,count);
       System.out.println(indexOfMax(count));
    }

    public int[] countLetters(String input)
    {
        int letterCount[]=new int[26];
        String alphabets="abcdefghijklmnopqrstuvwxyz";
        input=input.toLowerCase();
        for(int i=0;i<input.length();i++)
        {

            if(alphabets.indexOf(input.charAt(i))!=-1)
                letterCount[alphabets.indexOf(input.charAt(i))]++;

        }
        return letterCount;
    }
     public String decrypt(String encrypted)
     {
         int max=0;
         int freq[]=countLetters(encrypted);
         int maxIndex=indexOfMax(freq);
         int decIndex=maxIndex-4;
         if(decIndex<4)
         {
             decIndex=26-(4-decIndex);
         }
         return new CaesarCipher().encrypt(encrypted,26-decIndex);
     }
     public String halfOfString(String message,int start)
     {
         String output="";
         for(int i=start;i<message.length();i=i+2)
         {
             output=output+message.charAt(i);
         }
         return output;
     }

     public int getKey(String s)
     {
         return indexOfMax(countLetters(s));
     }
     public void decryptTwoKeys(String s)
     {
         String first=halfOfString(s,0);
         String second=halfOfString(s,1);
         int firstKey=getKey(first);
         int secondKey=getKey(second);
         System.out.println(firstKey+" "+secondKey);
         System.out.println(new CaesarCipher().encyptTwoKeys(s,firstKey,secondKey));
     }
    public static void main(String[] args)
    {
        new WordLengths().decryptTwoKeys("eeeeeeeeeeeeees" );
    }
}
