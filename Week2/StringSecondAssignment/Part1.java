package StringSecondAssignment;

public class Part1 {
    public int findStopCodon(String dna,int startIndex,String stopCodon)
    {
        int currIndex=dna.indexOf(stopCodon,startIndex+3);
       while(currIndex!=-1)
       {

           if((currIndex-startIndex)%3 ==0)
               return currIndex;
           else
               currIndex=dna.indexOf(stopCodon,currIndex+1);
       }
       return -1;
    }
    public void testFindStopCodon()
    {
        System.out.println(findStopCodon("CCATGHYGBNMTAA",2,"TAA"));
        System.out.println(findStopCodon("ATGFDCVTGA",0,"TGA"));
        System.out.println(findStopCodon("CATGBHGSDFG",1,"TGA"));
    }
    public String findGene(String dna,int startIndex1)
    {
        int minIndex,tempIndex;
        int startIndex=dna.indexOf("ATG",startIndex1);
        if(startIndex==-1)
            return "";
        int taaIndex=findStopCodon(dna,startIndex,"TAA");
        int tagIndex=findStopCodon(dna,startIndex,"TAG");
        int tgaIndex=findStopCodon(dna,startIndex,"TGA");
        if(taaIndex==-1 || tagIndex!=-1 && tagIndex<taaIndex)
            tempIndex=tagIndex;
        else
            tempIndex=taaIndex;
        if(tempIndex==-1 || tgaIndex!=-1 && tgaIndex<tempIndex)
            minIndex=tgaIndex;
        else
            minIndex=tempIndex;
        if(minIndex!=-1)
        return dna.substring(startIndex,minIndex+3);

        return "";
    }
//    public void testFindGene()
//    {
//        System.out.println("DNA String is AGCVBHTY and the gene is "+findGene("AGCVBHTY"));
//        System.out.println("DNA String is CGATGAVBHTAAVBTGAVBN and the gene is "+findGene("CGATGAVBHTAAVBTGAVBN"));
//        System.out.println("DNA String is VATGBNHTAGNJHTAA and the gene is "+findGene("VATGBNHTAGNJHTAA"));
//        System.out.println("DNA String is CVFATGHNJIK and the gene is "+findGene("CVFATGHNJIK"));
//    }

    public void printAllGenes(String dna) {
        int startIndex=0;
        while(true)
        {
           String gene= findGene(dna,startIndex);
            if(gene.isEmpty())
                break;
            System.out.println(gene);
            startIndex=dna.indexOf(gene,startIndex)+gene.length();
        }
    }
    public static void main(String[] args)
    {
        Part1 object1=new Part1();
        object1.printAllGenes("CATGSGCTAAVBNATGDCFTAG");
    }
}
