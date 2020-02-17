package StringSecondAssignment;

public class Part2 {
    public int howMany(String stringa,String stringb)
    {
        int cnt=0,startIndex=0;
        while(true)
        {
            startIndex=stringb.indexOf(stringa,startIndex);
            if(startIndex==-1)
                return cnt;
             cnt++;
             startIndex=stringa.length()+startIndex;

        }
    }
    public void testHowMany()
    {
        System.out.println(howMany("ATA","ATATATATA"));
        System.out.println(howMany("GAA","ATGAACGAATTGAATC"));
        System.out.println(howMany("AAT","ASGFVBJMSHNA"));
    }
    public static void main(String[] args)
    {
        Part2 object1=new Part2();
        object1.testHowMany();
    }
}
