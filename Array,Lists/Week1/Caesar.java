package Decryption;

import Encryption1.CaesarCipher;

public class Caesar {
    private String alphabet,shiftedAlphabet;
    Caesar(int key)
    {
        alphabet="abcdefghijklmnopqrstuvwxyz";
        shiftedAlphabet=alphabet.substring(key)+alphabet.substring(0,key);
    }
    public String encrypt(String input)
    {
        int index=0,flag=0;
        String output="";
        for(int i=0;i<input.length();i++)
        {
            if(Character.isUpperCase(input.charAt(i)))
            {
                flag=1;

                input=input.substring(0,i)+Character.toLowerCase(input.charAt(i))+input.substring(i+1);
            }
                index=alphabet.indexOf(input.charAt(i));
            if(index!=-1) {
                if (flag == 1)
                    output = output + Character.toUpperCase(shiftedAlphabet.charAt(index));
                else
                    output = output + shiftedAlphabet.charAt(index);
            }
            else
                output=output+input.charAt(i);
        }
        return output;
    }
    public String decrypt(String input)
    {
         int freq[]=new int [26];
         freq=new WordLengths().countLetters(input);
         int maxIndex=new WordLengths().indexOfMax(freq);
         int decKey=maxIndex-4;
         if(decKey<4)
             decKey=26-(4-maxIndex);
         Caesar encr=new Caesar(26-decKey);
         return encr.encrypt(input);
    }
    public static void main(String[] args)
    {
        Caesar object=new Caesar(23);
        System.out.println(object.encrypt("EEEED!"));
        System.out.println(object.decrypt("BBBBA"));
    }
}
