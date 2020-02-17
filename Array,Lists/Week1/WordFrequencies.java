package Arraylist;

import edu.duke.FileResource;

import java.util.ArrayList;

public class WordFrequencies {
    private ArrayList<String > myWords;
    private ArrayList<Integer> myFreqs;
    WordFrequencies()
    {
        myFreqs=new ArrayList<Integer>();
        myWords=new ArrayList<String>();
    }

    public void findUnique()
    {
         myWords.clear();
         myFreqs.clear();
        FileResource file=new FileResource("/home/pola/Desktop/thanu/tillu3");
        for(String word :file.words())
        {

            word=word.toLowerCase();
            if(!myWords.contains(word))
            {
                myWords.add(word);
                myFreqs.add(1);
            }
            else
            {
                int index=myWords.indexOf(word);
                myFreqs.set(index,myFreqs.get(index)+1);
            }
        }

    }
    public void testFindUnique()
    {
         findUnique();
          System.out.println("unique words are:"+myWords.size());
          for(int i=0;i<myWords.size();i++)
          {
              System.out.println(myWords.get(i)+" "+myFreqs.get(i));
          }
    }

    public  int findIndexOfMax()
    {
        int index=0,max=0;
        for(int i=0;i<myFreqs.size();i++)
        {
            if(max<myFreqs.get(i))
            {
                max=myFreqs.get(i);
                index=i;
            }
        }
        return index;
    }
    public void tester()
    {
      testFindUnique();
        System.out.println("max index is "+findIndexOfMax()+" and string is "+myWords.get(findIndexOfMax()));
    }
    public static void main (String [] args)
    {
       WordFrequencies object1= new WordFrequencies();
        object1.tester();
    }
}
