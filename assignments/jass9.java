import java.util.regex.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;
class StartsWithCapitalAndEndsWithPeriod
{
 public static void main(String...args)
 {
   final  Logger logger = Logger.getLogger(StartsWithCapitalAndEndsWithPeriod.class.getName());
  logger.log(Level.INFO,"Enter sentence to test:");
   Scanner scanner=new Scanner(System.in);
   String input=scanner.nextLine();
   Pattern pattern=Pattern.compile("^[A-Z][a-zA-Z\\0-9!@#$%^&*()_.,\\]*.$");
   Matcher matcher=pattern.matcher(input);
   if(matcher.find())
   logger.log(Level.INFO,"matched");
   else
   logger.log(Level.INFO,"not matched"); 
 }
 }
