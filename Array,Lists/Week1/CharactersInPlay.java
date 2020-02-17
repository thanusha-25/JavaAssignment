package Arraylist;

import edu.duke.FileResource;

import java.util.ArrayList;

public class CharactersInPlay {
    private ArrayList<String> characters;
    private ArrayList<Integer> frequency;
    CharactersInPlay()
    {
        characters=new ArrayList<String>();
        frequency=new ArrayList<Integer>();
    }

    public void update(String word)
    {
        if(characters.contains(word)) {
            int index=characters.indexOf(word);
            frequency.set(index,frequency.get(index)+1);
        }
        else
        {
            characters.add(word);
            frequency.add(1);
        }
    }
    public void findAllCharacters()
    {

        FileResource file=new FileResource("/home/pola/Desktop/thanu/tillu1");
       for (String line :file.lines())
        {
            String character;
               if(line.indexOf('.')!=-1) {
                   character = line.substring(0, line.indexOf('.'));
                   //System.out.println(character);
                   update(character);
               }

        }

    }

    public void tester()
    {
        findAllCharacters();
        for(int i=0;i<characters.size();i++)
            System.out.println(characters.get(i)+"  "+frequency.get(i));
    }

    public void charactersWithNumParts(int num1,int num2)
    {
        findAllCharacters();
        for(int i=0;i<characters.size();i++)
        {
            if(frequency.get(i) >= num1 || frequency.get(i) <=num2)
                System.out.println(characters.get(i)+"  "+frequency.get(i));
        }
    }

    public static void main(String [] args)
    {
      CharactersInPlay object1=  new CharactersInPlay();
      //object1.tester();
      object1.charactersWithNumParts(4,2);
    }
}
