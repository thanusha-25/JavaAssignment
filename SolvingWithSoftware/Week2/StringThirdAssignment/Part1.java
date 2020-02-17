package StringThirdAssignments;


import edu.duke.*;
//import edu.duke.URLResource;
//
public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1) {

            if ((currIndex - startIndex) % 3 == 0)
                return currIndex;
            else
                currIndex = dna.indexOf(stopCodon, currIndex + 1);
        }
        return -1;
    }

    public String findGene(String dna, int startIndex1) {
        int minIndex, tempIndex;
        int startIndex = dna.indexOf("ATG", startIndex1);
        if (startIndex == -1)
            return "";
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        if (taaIndex == -1 || tagIndex != -1 && tagIndex < taaIndex)
            tempIndex = tagIndex;
        else
            tempIndex = taaIndex;
        if (tempIndex == -1 || tgaIndex != -1 && tgaIndex < tempIndex)
            minIndex = tgaIndex;
        else
            minIndex = tempIndex;
        if (minIndex != -1)
            return dna.substring(startIndex, minIndex + 3);

        return "";
    }

    public StorageResource getALLGenes(String dna) {
        int startIndex = 0,cnt=0;StorageResource sr=new StorageResource();
        while (true) {
            String gene = findGene(dna, startIndex);
            if (gene.isEmpty())
                break;
            sr.add(gene);
            startIndex = dna.indexOf(gene, startIndex) + gene.length();
        }
        return sr;
    }
    public static void main(String[] args)
    {
       Part1 object1=new Part1();
       StorageResource store=object1.getALLGenes("ATGCVGTAACVF");
       for(String record :store.data())
       {
       System.out.println(record);
       }
}
}