package assignments;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.*;
public class MedianOfTimeToPing
{	

	public static boolean isValidIpAddress(String address)
	{
		int i=0,dotCount=0;
		while(i<address.length())
		{
			if(address.charAt(i)=='.')
				dotCount++;
			i++;
		}
		if(dotCount==3)
		{
			int num ;
			StringTokenizer tokenizer=new StringTokenizer(address,".");
			while(tokenizer.hasMoreTokens())
			{
			     num =Integer.parseInt(tokenizer.nextToken());
				if(num>=0 && num<=255)
					continue;
				else
					return false;
			}
			
			num=Integer.parseInt(address.substring(address.lastIndexOf('.')+1,address.length()));
			if(num>=0 && num<=255)
				return true;
			else
				return false;
			
		}
		else
			return false;
		
	}
	
	public static double findMedian(String value,int num)
	{
		 double s;
		  ArrayList<Double> list=new ArrayList<Double>();
		  int i=0;
		  while(i<num)
		  {
		  s=Double.parseDouble(value);
		  list.add(s);
		   i++;
		   }
		  Collections.sort(list);
		   if(num%2!=0)
		  return list.get(num/2);
		   else
		   return (list.get(num/2)+list.get((num/2)-1))/2;
	}
	
 public static void main(String[] args)throws IOException
 {
	 final  Logger logger = Logger.getLogger(MedianOfTimeToPing.class.getName());
	 try
	 {
        ProcessBuilder processBuilder=new ProcessBuilder(); 
        logger.log(Level.INFO,"enter the host address and the number of packets to be transmitted:");
        Scanner scanner=new Scanner(System.in);
        String address=scanner.nextLine();       
        int num=(scanner.nextInt());
        if(isValidIpAddress(address))  	
        {
        address="ping "+ address.concat(" -c "+num)+" | cut -d '=' -f 4 "+"| cut -d ' ' -f 1";    
        processBuilder.command("bash","-c",address);
        Process process=processBuilder.start();
        BufferedReader bufferReader=new BufferedReader(new InputStreamReader(process.getInputStream()));
        bufferReader.readLine();
        double median =findMedian(bufferReader.readLine(),num);
        System.out.println("Median of time taken to ping is "+median);
       
	 }
        else
        	logger.warning("enter a valid hostname");
	 }
	 catch(InputMismatchException e)
	 {
		 logger.warning("Enter valid number of packets to be transmitted");
	 }
	 catch(NumberFormatException e)
	 {
		 logger.warning("enter a valid hostname"); 
	 }
 	}
}
