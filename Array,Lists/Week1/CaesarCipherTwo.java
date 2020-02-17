package Decryption;

import Encryption1.CaesarCipher;

public class CaesarCipherTwo {
    private String alphabet, shiftedAplhabet1, shiftedAlphabet2;

    public CaesarCipherTwo(int key1, int key2) {
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        shiftedAplhabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
    }

    public String encrypt(String input) {
        int index, flag = 0;
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            flag=0;
            if (Character.isUpperCase(input.charAt(i))) {
                flag = 1;
                input = input.substring(0, i) + Character.toLowerCase(input.charAt(i)) + input.substring(i + 1);
            }

            index = alphabet.indexOf(input.charAt(i));
            if (index == -1)
                output = output + input.charAt(i);
            else {
                if (i % 2 == 0) {
                    if (flag == 1)
                        output = output + Character.toUpperCase(shiftedAplhabet1.charAt(index));
                    else
                        output = output + shiftedAplhabet1.charAt(index);
                } else {
                    if (flag == 1)
                        output = output + Character.toUpperCase(shiftedAlphabet2.charAt(index));
                    else
                        output = output + shiftedAlphabet2.charAt(index);
                }
            }
        }
        return output;
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
        System.out.println(new CaesarCipherTwo(firstKey,secondKey).encrypt(s));
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


    public static void main(String[] args) {
        CaesarCipherTwo object1=new CaesarCipherTwo(23,17);
        //System.out.println(new CaesarCipherTwo(23,17).encrypt("First Legion"));
        System.out.println(object1.encrypt("eieeteeeeen"));
        object1.decryptTwoKeys(object1.encrypt("eieeteeeeen"));
    }
}
