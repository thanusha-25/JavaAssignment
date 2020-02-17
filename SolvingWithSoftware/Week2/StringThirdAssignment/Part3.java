package StringThirdAssignments;

import edu.duke.FileResource;
import edu.duke.StorageResource;

import java.util.StringTokenizer;

public class Part3 {
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
    public StorageResource printAllGenes(String dna) {
        int startIndex=0;
        StorageResource wordStrorage=new StorageResource();
        while(true)
        {
            String gene= findGene(dna,startIndex);
            if(gene.isEmpty())
                break;
           // System.out.println(gene);
           wordStrorage.add(gene);
            startIndex=dna.indexOf(gene,startIndex)+gene.length();
        }
        return wordStrorage;
    }


    public void processGene(StorageResource sr) {
      int wordcnt=0,cgcnt=0,maxlength=0;
      String maxgene="";
      StorageResource wordStrorage=new StorageResource();
      StorageResource cgStorage=new StorageResource();

      for(String line :sr.data())
      {
          //calculating maxlength and maxlength

          if(maxlength<line.length()) {
              maxgene = line;
              maxlength=maxgene.length();
          }//System.out.println(maxlength);

          //storing all genes greater than 9 characters

          int i=0,cg=0;
               if(line.length() > 60) {
                   wordStrorage.add(line);
                   wordcnt++;
               }

           //calculating and storing the c-g ratio


               while(i<line.length())
              {
                  if((line.charAt(i)=='c')||(line.charAt(i)=='C')||(line.charAt(i)=='g')||(line.charAt(i)=='G')) {
                      cg++;
                  }
                  i++;
              }
              if((float)cg/line.length() >0.35) {
                  cgStorage.add(line);
                  cgcnt++;
              }


          }

      //display the required output

      System.out.println("Greater than 9 characters are:");
      for(String line:wordStrorage.data())
      {
          System.out.println(line);
      }
      System.out.println(wordcnt);
        System.out.println("Greater than 0.35 ratio are:");
        for(String line:cgStorage.data())
        {
            System.out.println(line);
        }
        System.out.println(cgcnt);
        System.out.println("longest gene is "+maxgene);
    }


    public  void testProcessGene()
    {
        processGene(printAllGenes("FCVATGBHNMJBTAACVF"));
        processGene(printAllGenes("FCVATGCCCGGGTAACVF"));
        processGene(printAllGenes("FCVATGTAACVF"));
        processGene(printAllGenes("FCVATGVBNCVBBGFTAACVFATGCVBGHTTAA"));

    }
    public static void main(String[] args)
    {
        Part3 object1=new Part3();
        FileResource file=new FileResource("/home/pola/Downloads/brca1line.fa");
        String result=file.asString();
        //System.out.println(result);
        object1.processGene(object1.printAllGenes(result.toUpperCase()));
    }
}