package CSV_ASSIGNMENT_EXPORTS;

import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class Exports {
    public String countryInfo(CSVParser parser,String country)
    {
        for(CSVRecord record :parser)
        {
          String countryVar=record.get("Country");
            if(countryVar.contains(country))
            {
                String  exports=record.get("Exports");
                return  country+" : "+exports+" : "+record.get("Value (dollars)");
            }

        }
        return "NO Record";
    }

    public void listExportersTwoProducts(CSVParser parser,String exportItem1,String exportItem2)
    {
        for(CSVRecord record :parser)
        {
            String exports=record.get("Exports");
            if(exports.contains(exportItem1) && exports.contains(exportItem2))
            {
                System.out.println(record.get("Country"));
            }
        }
    }

    public int numberOfExporters(CSVParser parser,String exportItem)
    {
        int count=0;
        for(CSVRecord record : parser)
        {
            String exports=record.get("Exports");
            if(exports.contains(exportItem))
                count++;
        }
        return count;
    }

    public void bigExporters(CSVParser parser, String amount)
    {
        for(CSVRecord record : parser)
        {
            if((record.get("Value (dollars)").length()) > amount.length())
               System.out.println(record.get("Country")+" "+record.get("Value (dollars)"));
        }
    }

    public void tester()
    {
        FileResource file=new FileResource("/home/pola/Downloads/exports/exports_small.csv");
        System.out.println( countryInfo(file.getCSVParser(),"Germany"));
        listExportersTwoProducts(file.getCSVParser(),"lead","zinc");
        System.out.println(numberOfExporters(file.getCSVParser(),"coffee"));
        bigExporters(file.getCSVParser(),"$4,579,000,000");
    }
    public static void main(String [] args)
    {
        new Exports().tester();
    }
}
