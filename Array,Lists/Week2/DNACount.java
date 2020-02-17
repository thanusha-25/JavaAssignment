package GladLib;

import edu.duke.FileResource;

import java.util.HashMap;

public class DNACount {
    private HashMap<String ,Integer> map;
    public DNACount()
    {
        map=new HashMap<String,Integer>();
    }

    public void buildCodonMap(int start,String dna)
    {
        map.clear();
        for(int i=start;i+3<dna.length();i=i+3)
        {
            String codon=dna.substring(i,i+3);
            if(!map.containsKey(codon))
            map.put(codon,1);
            else
                map.put(codon,map.get(codon)+1);
        }
        //System.out.println(map.size());
    }

    public String getMostCommonCodon()
    {
        int max=0;
        String codon="";
        for(int i=0;i<map.size();i++)
        {
            for(String key :map.keySet())
            {
                if(map.get(key)>max)
                {
                    max=map.get(key);
                    codon=key;
                }
            }
        }
        return codon;
    }

    public void printCodonCount(int start,int end)
    {
        for(String key:map.keySet())
        {
            if(map.get(key)>=start && map.get(key)<=end)
                System.out.println(key+" " +map.get(key));
        }
    }

    public void tester()
    {
        FileResource file=new FileResource("/home/pola/Desktop/thanu/tillu");
        String dna=file.asString();
        dna=dna.trim();
        System.out.println(dna.length());
       for(int i=0;i+3<dna.length();i++)
        {
            buildCodonMap(i,dna);
            System.out.println("Reading frame starting with "+i+" results in  "+map.size()+" unique codons");
            System.out.println("and most common code is "+getMostCommonCodon()+" "+map.get(getMostCommonCodon()));
            printCodonCount(1,5);
        }
    }
    public static void main(String [] args)
    {
        new DNACount().tester();
    }
}
