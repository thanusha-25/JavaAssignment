package Junit;
import org.junit.Assert;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

class FormDate {
    static int num;
    // this method is used to find the range of dates for KYC form
    public static ArrayList<String> findRange(ArrayList<ArrayList<Calendar>> signupAndCurrent) {
        ArrayList<Calendar> signup = signupAndCurrent.get(0);
        ArrayList<Calendar> current = signupAndCurrent.get(1);
        ArrayList<String> output = new ArrayList<String>();
        for (int i = 0; i < num; i++) {
            if (signup.get(i).after(current.get(i)))
                output.add("No range");
            else {
                while (signup.get(i).get(Calendar.YEAR) < current.get(i).get(Calendar.YEAR))
                    signup.get(i).add(Calendar.YEAR, 1);
                if (signup.get(i).after(current.get(i))) {
                    while (signup.get(i).after(current.get(i)))
                        signup.get(i).add(Calendar.DATE, -30);
                    signup.get(i).add(Calendar.MONTH, 1);
                    current.get(i).add(Calendar.MONTH, 1);
                    output.add(signup.get(i).get(Calendar.DATE) + "-" + signup.get(i).get(Calendar.MONTH) + "-" + signup.get(i).get(Calendar.YEAR) + " " + current.get(i).get(Calendar.DATE) + "-" + current.get(i).get(Calendar.MONTH) + "-" + current.get(i).get(Calendar.YEAR));
                } else if (signup.get(i).equals(current.get(i))) {
                    signup.get(i).add(Calendar.DATE, -30);
                    signup.get(i).add(Calendar.MONTH, 1);
                    current.get(i).add(Calendar.MONTH, 1);
                    output.add(signup.get(i).get(Calendar.DATE) + "-" + signup.get(i).get(Calendar.MONTH) + "-" + signup.get(i).get(Calendar.YEAR) + " " + current.get(i).get(Calendar.DATE) + "-" + current.get(i).get(Calendar.MONTH) + "-" + current.get(i).get(Calendar.YEAR));
                } else {
                    signup.get(i).add(Calendar.DATE, -30);
                    signup.get(i).add(Calendar.MONTH, 1);
                    String out = (signup.get(i).get(Calendar.DATE) + "-" + signup.get(i).get(Calendar.MONTH) + "-" + signup.get(i).get(Calendar.YEAR));
                    signup.get(i).add(Calendar.MONTH, -1);
                    signup.get(i).add(Calendar.DATE, 60);
                    signup.get(i).add(Calendar.MONTH, 1);
                    output.add(out + " " + signup.get(i).get(Calendar.DATE) + "-" + signup.get(i).get(Calendar.MONTH) + "-" + signup.get(i).get(Calendar.YEAR));

                }
            }
        }
        return output;
    }

    // convert the given string into date
    public static void getDateFromString(String inputDate, ArrayList<Calendar> dates) {

        StringTokenizer dateTokenizer = new StringTokenizer(inputDate, "-");
        if (dateTokenizer.hasMoreTokens()) {
            int date = Integer.parseInt(dateTokenizer.nextToken());
            int month = Integer.parseInt(dateTokenizer.nextToken());
            int year = Integer.parseInt(dateTokenizer.nextToken());
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month - 1, date);
            dates.add(calendar);
        }
    }

    // to store all signup dates in one collection and current dates in another collection
    public static ArrayList<ArrayList<Calendar>> getSignupAndCurrentDate(ArrayList<String> dates) {
        int i = 0;
        ArrayList<ArrayList<Calendar>> signupAndCurrent = new ArrayList<ArrayList<Calendar>>();
        ArrayList<Calendar> signup = new ArrayList<Calendar>();
        ArrayList<Calendar> current = new ArrayList<Calendar>();
        while (i < dates.size()) {
            StringTokenizer lineTokenizer = new StringTokenizer(dates.get(i), " ");
            String signupDate = lineTokenizer.nextToken();
            getDateFromString(signupDate, signup);
            String currentDate = lineTokenizer.nextToken();
            getDateFromString(currentDate, current);
            i++;
        }

        signupAndCurrent.add(signup);
        signupAndCurrent.add(current);
        return signupAndCurrent;
    }


    public static void main(String[] args) {
        int i;
        final Logger logger = Logger.getLogger(FormDate.class.getName());
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> input = new ArrayList<String>();
        ArrayList<Calendar> signup = new ArrayList<Calendar>();
        ArrayList<Calendar> current = new ArrayList<Calendar>();
        try {
            logger.log(Level.INFO, "Enter the number of input values:");
            num = Integer.parseInt(scanner.nextLine());

            logger.log(Level.INFO, "Enter the signup and current dates in the format of DD-MM-YYYY:");
            i = 0;
            while (i < num) {
                input.add(scanner.nextLine());
                i++;
            }
        } catch (NumberFormatException e) {
            logger.warning("Give a valid number ");
        }


        ArrayList<String> output = findRange(getSignupAndCurrentDate(input));
        System.out.println(output);
        test();

    }


    public static void test()
    {
        ArrayList<String> test =new ArrayList<String>();
        test.add("16-07-1998 27-06-2017");
        Assert.assertEquals("16-6-2017 27-6-2017",findRange(getSignupAndCurrentDate(test)).get(0));
    }
}




