package GladLib;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class WordsInFiles {
    private HashMap<String, ArrayList<String>> map;
    WordsInFiles()
    {
        map=new HashMap<String, ArrayList<String>>();
    }
    private void addWordsFromFile(File f)
    {
        FileResource file=new FileResource(f);
        for(String word:file.words())
        {
            if(!map.containsKey(word)) {
                ArrayList<String > list=new ArrayList<String>( );
                list.add(f.getName());
                map.put(word,list);
            }
            else
            {
                (map.get(word)).add(f.getName());
            }
        }
    }

    public void buildWordFileMap()
    {
        map.clear();
        DirectoryResource dir =new DirectoryResource();
        for(File f:dir.selectedFiles())
        {
            addWordsFromFile(f);
        }
    }
   public int maxNumber()
   {
       int max=0;
       for(String key : map.keySet())
       {
           if(max< (map.get(key)).size())
               max=map.get(key).size();
       }
       return max;
   }

   public ArrayList<String> wordsInNumFile(int n)
   {
       ArrayList<String> list=new ArrayList<String>();
       for(String key : map.keySet())
       {
           if(map.get(key).size()==n)
           {
               list.add(key);
           }

       }
       return list;
   }

   public void printFilesIn(String word)
   {
      for(String file :map.get(word))
          System.out.println(file);
   }
   public void tester()
   {
       buildWordFileMap();
       System.out.println(map.size()+" "+maxNumber());
       ArrayList<String> list=new ArrayList<String>();
       list=wordsInNumFile(2);
       for(String s : list)
           System.out.println(s);
       printFilesIn("cats");
   }
    public static void main(String[] args)
    {
        WordsInFiles object1=new WordsInFiles();
        object1.tester();
    }
}
