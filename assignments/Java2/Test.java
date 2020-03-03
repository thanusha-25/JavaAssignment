package Junit;

import static junit.framework.TestCase.assertEquals;

public class Test {
    public void testCase()
    {
        int i;
        ContainsAllAlphabets test1=new ContainsAllAlphabets();
        i=test1.checkIfStringContainsAllAlphabets("ghhgfjshf");
        assertEquals(0,i);
        i=test1.checkIfStringContainsAllAlphabets("abcdefghijklmnopqrstuvwxyz1334554FGFHTJGTRHGUJ");
        assertEquals(1,i);
    }
}

