package Junit;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import java.util.*;
import java.util.logging.*;
public class ContainsAllAlphabets
{
    // checks whether the input consists of all alphabets or not

    public static int checkIfStringContainsAllAlphabets(String input)
    {
        int i=0;
        HashMap<Character,Integer>map=new HashMap<Character,Integer>();
        while(i<input.length())
        {
            if(Character.isLetter((input.charAt(i))))
                map.putIfAbsent(Character.toLowerCase((input.charAt(i))),0);
            i++;
        }
        if((map.size())==26)
            return 1;
        else
            return 0;
    }

    public static void main(String[] args)
    {
        int status,endCharacter;
        final  Logger logger = Logger.getLogger(ContainsAllAlphabets.class.getName());
        try
        {
            do
            {
                Scanner scanner=new Scanner(System.in);
                logger.log(Level.INFO,"Enter the input String:");
                String input=scanner.nextLine();
                if(input.length()<26)
                    logger.log(Level.INFO,"doesnt contain all alphabets");
                else
                {
                    status=checkIfStringContainsAllAlphabets(input);
                    if(status==1)
                        logger.log(Level.INFO,"Input contain all alphabets");
                    else
                        logger.log(Level.INFO,"Input doesnt contain all alphabets");
                }
                logger.info("Enter 1 if you wish to provide the input else enter other number");
                endCharacter=scanner.nextInt();
            }while(endCharacter==1);
        }
        catch(InputMismatchException e)
        {
            logger.warning("Enter only numbers to provide your choice whether to continue or not ");
        }

    }
}

// time complexity is O(n)
//space complexity is 26
