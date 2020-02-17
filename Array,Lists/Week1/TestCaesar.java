package Decryption;

import edu.duke.FileResource;

public class TestCaesar {
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
    public void simpleTest()
    {
        FileResource file=new FileResource("/home/pola/Desktop/thanu/aw");
        String test=file.asString();
       String encrypted=(new Caesar(18).encrypt(test));
       String decrypted=new Caesar(18).decrypt(encrypted);
    }
    public void breakCaesarCipher(String input)
    {
        int freq[]=new int [26];
        freq=new WordLengths().countLetters(input);
        int maxIndex=new WordLengths().indexOfMax(freq);
        int decKey=maxIndex-4;
        if(decKey<4)
            decKey=26-(4-maxIndex);
        Caesar encr=new Caesar(26-decKey);
       System.out.println( encr.encrypt(input));
    }
    public void simpleTests()
    {
       Caesar object=new Caesar(18);

             String encrypted=object.encrypt("eeeeeeeefgc");
        System.out.println(encrypted);
        breakCaesarCipher(encrypted);
    }
    public static void main(String[] args)
    {
        new TestCaesar().simpleTests();
    }
}
