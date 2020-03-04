package Junit;

import org.junit.Assert;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class Test {
    public static void test()
    {
        ArrayList<String> test =new ArrayList<String>();
        test.add("16-07-1998 27-06-2017");
        Assert.assertEquals("16-6-2017 27-6-2017",FormDate.findRange(FormDate.getSignupAndCurrentDate(test)).get(0));
    }
}


