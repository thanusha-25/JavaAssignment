package WebServerLogs;

import edu.duke.FileResource;

import java.util.Date;

public class Tester {
    public void testLogAnalyzer()
    {
        Date date=new Date();
        LogAnalyzer analyze =new LogAnalyzer();
       analyze.readFile();
        analyze.printAll();
        System.out.println(analyze.countUniqueIps());
        analyze.printAllHigherThanNum(1);
        for(LogEntry e:analyze.uniqueIpVisitsOnThatDay("Sep 14"))
            System.out.println(e+"\n\n\n\n");
         //  analyze.countUniqueIpsInRange(1,3);
    }
    public static void main(String[] args)
    {
        Tester test=new Tester();
        test.testLogAnalyzer();
    }
}
