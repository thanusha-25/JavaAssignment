package Encryption1;

import javax.print.DocFlavor;

public class WordPlay {
    public boolean isVowel(char ch)
    {
        if(ch=='a' || ch=='e' ||ch=='i' || ch=='o' || ch=='u'||ch=='A' ||ch=='E'||ch=='I'||ch=='O'||ch=='U')
            return true;
        else {
            return false;
        }
    }

    public String replaceVowel(String phrase,char ch)
    {
        for(int i=0;i<phrase.length();i++)
        {
            if(isVowel(phrase.charAt(i)))
            {
                phrase=phrase.substring(0,i)+ch+phrase.substring(i+1);
            }
        }
        return phrase;
    }
    public  String emphasize(String phrase,char ch)
    {
        for(int i=0;i<phrase.length();i++)
        {
            if(phrase.charAt(i)==ch && i%2==0)
                phrase=phrase.substring(0,i)+"*"+phrase.substring(i+1);
            else if(phrase.charAt(i)==ch && i%2!=0)
                phrase=phrase.substring(0,i)+"+"+phrase.substring(i+1);
        }
        return phrase;
    }
   public static void main(String[] args)
   {
//       System.out.println(new WordPlay().replaceVowel("Hello World",'*'));
       System.out.println(new WordPlay().emphasize("dna ctgaaactga",'a'));
   }
}
