
import org.junit.Test;
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static junit.framework.TestCase.assertEquals;
class MatchRegularExpression {
    static int j = 0, i = 0,k=0,flag=0;
    private static ProcessBuilder pb= new ProcessBuilder();
    private static String input = null;
    static final Logger logger = Logger.getLogger(Ass1.class.getName());
   public static ArrayList<String> filePath=new ArrayList<String>();

    // find the file which matches the regular expression and add them to arraylist and return the arraylist

    public static ArrayList<String> matchAndDisplay(String regex,String input) throws IOException
    {

        for (i = 0, j = 0; i < input.length() && j < regex.length();j++,i++) {
            //matches multiple characters if regex contains '*'
            if (regex.charAt(j) == '*') {
                k = j + 1;
                int index = input.indexOf(regex.charAt(k));
                if (index == -1)
                    break;
                else
                    i = index - 1;
            }
            //matches single character if character is '?'
            else if (regex.charAt(j) == '?') {
                continue;
            }
            //breaks if characters doesn't match
            else {
                if (input.charAt(i) != regex.charAt(j))
                    break;
            }
        }
        if ((i == input.length() && j == regex.length())) {
            //find the complete path of the file which matches the regular expression
            pb.command("bash", "-c", "find -name " + input);
            Process process = pb.start();
            BufferedReader br1 = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String file = br1.readLine();
            //print the complete path of the file
            pb.command("bash", "-c", "pwd");
            process = pb.start();
            br1 = new BufferedReader(new InputStreamReader(process.getInputStream()));
            filePath.add (br1.readLine() + "" + file.substring(1));
        }
        return filePath;
    }

    public static void main(String[] args) throws IOException {
        logger.info("Enter the regular Expression:");
        Scanner sc = new Scanner(System.in);
        String regex = sc.nextLine();
        // set working directory for process builder
        pb.directory(new File("/home/pola"));
        pb.command("bash", "-c", "ls -R");
        Process process = null;
            process = pb.start();
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
        while (true) {
                if (!((input = br.readLine()) != null))
                    break;
                matchAndDisplay(regex,input);
       }
        System.out.println(filePath);
            if(filePath.size()  ==0)
                logger.info("No file present which matches the regular expression so enter a valid regular expression");

       //testing through test method

            test();
    }

    public static void test() throws IOException {
       filePath.clear();
        pb.command("bash", "-c", "ls -R");
        Process process = null;
        process = pb.start();
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));

        while ((input = br.readLine()) != null) {
            matchAndDisplay("th.java", input);
        }
            ArrayList<String> expected=new ArrayList<String >();
          expected.add("/home/pola/th.java");
          //throws exception if the expected output and actual output doesnt match
            assertEquals(expected,filePath);

    }
}

