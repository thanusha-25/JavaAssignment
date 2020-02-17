package MiniProject;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import edu.duke.ImageResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.awt.*;
import java.io.File;
import java.util.logging.FileHandler;

public class BabyBirth {
    public void totalBirths(FileResource fr)
    {
        int girls=0,boys=0,girlsNames=0,boysNames=0;
        CSVParser parser=fr.getCSVParser(false);
        for(CSVRecord record : parser)
        {
            if(record.get(1).equals("F")) {
                girlsNames++;
                girls =girls + Integer.parseInt(record.get(2));
            }else
            {   boysNames++;
                boys =boys + Integer.parseInt(record.get(2));
            }
        }

        System.out.println("Total births :"+(boys+girls));
        System.out.println("Total girls :"+girls);
        System.out.println("Total boys :"+boys);
        System.out.println("Girls Names: "+girlsNames);
        System.out.println("Boys Names :"+boysNames);

    }

     public int getRank(int year,String name,String gender)
     {
         int rank=0;
         String file="/home/pola/Downloads/us_babynames_small/testing/yob"+year+"short.csv";
         FileResource fr=new FileResource(file);
         CSVParser parser=fr.getCSVParser(false);
         for(CSVRecord record : parser)
         {
             if((record.get(1).equals(gender)) && !(record.get(0).equals(name)))
             {
                 rank++;
             }
             else if((record.get(1).equals(gender)) && (record.get(0).equals(name)))
                 return rank+1;
         }
       return -1;
     }

     public String getName(int year,int rank,String gender)
     {
         int line=0;
         String file="/home/pola/Downloads/us_babynames_small/testing/yob"+year+"short.csv";
         FileResource fr=new FileResource(file);
         CSVParser parser=fr.getCSVParser(false);
         for(CSVRecord record:parser)
         {
             if(record.get(1).equals(gender) && rank-1!=line)
                 line++;
             else if (record.get(1).equals(gender) && rank-1==line)
                 return record.get(0);
         }
         return "NO NAME";
     }

     public void whatIsNameInYear(String name,int year,int newYear,String gender)
     {
         String oldFile="/home/pola/Downloads/us_babynames_small/testing/yob"+year+"short.csv";
         String newFile="/home/pola/Downloads/us_babynames_small/testing/yob"+newYear+"short.csv";
         int rank =getRank(year,name,gender);
         String newName=getName(newYear,rank,gender);
          System.out.println(name+" born in  "+year+" would be "+newName+" in "+newYear);
     }

     public int yearOfHighestRank(String name, String gender)
     {
         int year=2012,highestRankYear=0;
         while(year<2014)
         {
             if(highestRankYear==0) {
                 if(getRank(year,name,gender)!=-1)
                 highestRankYear = year;
                 else
                     return -1;
             }
             if(getRank(highestRankYear,name,gender)>getRank(year+1,name,gender))
                 highestRankYear=year+1;

             year++;
         }
         return highestRankYear;
     }

     public double getAverageRank(String name,String gender)
     {
        int avgRank,year=2012,totalRank=0;
        while(year<2015)
        {
            if(getRank(year,name,gender)!=-1)
                totalRank=totalRank+getRank(year,name,gender);
            year++;
        }
        if(totalRank==0)
            return -1;
        else
            return totalRank/3.0;

     }
     public int getTotalBirthsRankedHigher(int year,String name,String gender)
     {
         int rank=getRank(year,name,gender);
         int totalBirths=0,line=1;
         if(rank!=-1) {
             FileResource file = new FileResource("/home/pola/Downloads/us_babynames_small/testing/yob" + year + "short.csv");
             CSVParser parser = file.getCSVParser(false);

             for (CSVRecord record : parser) {
                 if (record.get(1).equals(gender)) {
                     if (line < rank)
                         totalBirths = totalBirths + Integer.parseInt(record.get(2));
                     else
                         break;
                     line++;
                 }
             }
             return totalBirths;
         }
         else
            return -1;
     }
     public void selectFiles()
     {
         DirectoryResource dr=new DirectoryResource();
        for(File f : dr.selectedFiles())
        {
            ImageResource im=new ImageResource(f);
            im.draw();
        }
     }

    public static void main(String[] args)
    {
        new BabyBirth().selectFiles();
//        System.out.println( new BabyBirth().getTotalBirthsRankedHigher(2012,"Sophia","F"));
//       System.out.println( new BabyBirth().getAverageRank("Jacobi","F"));
//        System.out.println( new BabyBirth().yearOfHighestRank("Olivia","F"));
//        new BabyBirth().whatIsNameInYear("Olivia",2012,2014,"F");
//       System.out.println( new BabyBirth().getRank(2012,"Mason","F"));
//        System.out.println( new BabyBirth().getName(2012,6,"M"));
//        new BabyBirth().totalBirths(new FileResource("/home/pola/Downloads/us_babynames_small/testing/yob2012short.csv"));
    }
}
