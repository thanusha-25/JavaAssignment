package WebServerLogs;

import edu.duke.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.LogRecord;

public class LogAnalyzer {
    private ArrayList<LogEntry> records;
    LogAnalyzer()
    {
        records=new ArrayList<LogEntry>();
    }
    public void printAll() {
        for (LogEntry le : records) {
            System.out.println(le);
        }
    }
    public void readFile()
    {
        FileResource file =new FileResource("/home/pola/Downloads/WebLogProgram/weblog-short_log");
        for(String line :file.lines())
        {
       LogEntry entry= WebLogParser.parseEntry(line);
       records.add(entry);
                    }
    }

    public int countUniqueIps()
    {
        ArrayList <String> list=new ArrayList<String>();
        for(LogEntry le :records)
        {
            String ipaddress=le.getIpAddress();
         //   System.out.println(ipaddress);
            if(!list.contains(ipaddress))
                list.add(ipaddress);
        }

        return list.size();
    }

    public void printAllHigherThanNum(int num)
    {
        HashMap<String,Integer> list=new HashMap<String, Integer>();
        for(LogEntry le :records)
        {
            String ipaddress=le.getIpAddress();
            if(!list.containsKey(ipaddress))
                list.put(ipaddress,1);
            else
                list.put(ipaddress,list.get(ipaddress)+1);
        }
        for(Map.Entry<String, Integer> map : list.entrySet())
        {
            if(map.getValue()>num)
                System.out.println(map.getValue()+" "+map.getKey());
        }
        }

        public  ArrayList<LogEntry> uniqueIpVisitsOnThatDay(String someday)
        {
            ArrayList <LogEntry> list=new ArrayList<LogEntry>();
            for(LogEntry le :records)
            {
                String time=le.getAccessTime().toString().substring(4,10);
                if(someday.equals(time))
                {
                    list.add(le);
                }
                //System.out.println(time);

            }
            return list;
        }

//        public void countUniqueIpsInRange(int low, int high)
//        {
//            ArrayList<LogEntry> listRes=new ArrayList<LogEntry>();
//            HashMap<LogEntry,Integer> list1=new HashMap<LogEntry, Integer>();
//            for(LogEntry le : records)
//
//            }
//            for(Map.Entry<LogEntry, Integer> map : list.entrySet())
//            {
//                if(map.getValue()>=low && map.getValue()<=high)
//                    System.out.println(map.getKey().getIpAddress()+" "+map.getValue());
//            }
//
//
//        }

}
