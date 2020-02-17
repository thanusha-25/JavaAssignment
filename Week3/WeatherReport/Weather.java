package WeatherAssignment;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class Weather {
    public CSVRecord coldestHourInFile(CSVParser parser)
    {
        CSVRecord lowestRecord=null;
        for(CSVRecord record : parser)
        {
            if(lowestRecord==null)
            {
                lowestRecord=record;
            }
            else
            {
                double currTemp=Double.parseDouble(record.get("TemperatureF"));
                double lowestTemp=Double.parseDouble(lowestRecord.get("TemperatureF"));
                if(currTemp==-9999)
                    continue;
                if(currTemp<lowestTemp)
                    lowestRecord=record;
            }
        }
        return lowestRecord;
    }
   public String  fileWIthColdestTemperature()
   {
       double lowest=0;
       String fileName="";
       DirectoryResource dir=new DirectoryResource();
       for(File file:dir.selectedFiles())
       {
           FileResource fileRes=new FileResource(file);
           CSVRecord record=coldestHourInFile(fileRes.getCSVParser());
           if(lowest==0) {
               lowest = Double.parseDouble((record).get("TemperatureF"));
               fileName=file.getName();
           }else if(lowest>Double.parseDouble(record.get("TemperatureF"))) {
               lowest = Double.parseDouble(record.get("TemperatureF"));
               fileName = file.getName();
           }
       }
       return fileName;
   }
    public  CSVRecord lowestHumidityLevel(CSVParser parser)
    {
        CSVRecord lowestRecord=null;
        for(CSVRecord record : parser)
        {
            if(lowestRecord==null)
            {
                lowestRecord=record;
            }
            else
            {
                if(record.get("Humidity")=="N/A")
                    continue;
                int currHumidity=Integer.parseInt(record.get("Humidity"));
                int lowestHumidity=Integer.parseInt(lowestRecord.get("Humidity"));
                if(currHumidity<lowestHumidity)
                    lowestRecord=record;
            }

        }
        return lowestRecord;
    }

    public CSVRecord lowestHumidityInManyFiles()
    {
        CSVRecord lowestHumid=null;
        DirectoryResource dir=new DirectoryResource();
        for(File file:dir.selectedFiles())
        {
            FileResource inputFile=new FileResource(file);
            CSVRecord record=lowestHumidityLevel(inputFile.getCSVParser());
            if(lowestHumid==null) {
                lowestHumid = record;
            }
                else if((Integer.parseInt(lowestHumid.get("Humidity"))) >Integer.parseInt(record.get("Humidity")))
                    lowestHumid=record;
            }
          return  lowestHumid;

        }

    public double averageTemperature(CSVParser parser)
    {
        int n=0;
        double avg=0,total=0;
        for(CSVRecord record : parser)
        {
            total=total+Double.parseDouble(record.get("TemperatureF"));
            n++;
        }
        avg=(double)total/n;
        return avg;
    }
   public double averageTemperatureWithHighHumidityInFile(CSVParser parser,int value)
   {
       int n=0;
       double avgTemp,totalTemp=0;
       for(CSVRecord record: parser)
       {
           int humidity=Integer.parseInt(record.get("Humidity"));
           if(humidity>=value) {
               totalTemp = totalTemp + Double.parseDouble(record.get("TemperatureF"));
               n++;
           }
       }
       avgTemp= totalTemp/n;
       return avgTemp;
   }
    public static void main(String [] args)
    {
//        FileResource file=new FileResource("/home/pola/Downloads/nc_weather/2014/weather-2014-03-20.csv");
//        System.out.println((new Weather().lowestHumidityLevel(file.getCSVParser())).get("Humidity"));
//        System.out.println((new Weather().averageTemperature(file.getCSVParser())));
//        System.out.println((new Weather().averageTemperatureWithHighHumidityInFile(file.getCSVParser(),80)));
          //System.out.println(new Weather().fileWIthColdestTemperature());
        CSVRecord record=new Weather().lowestHumidityInManyFiles();
          System.out.println("lowest humidity was "+record.get("Humidity")+" "+record.get("DateUTC"));
    }
}
