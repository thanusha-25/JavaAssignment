package Assignment1;

public class Part1 {
    public String findSimpleGene(String dna)
    {
        String result="";
        int startIndex,stopIndex;
        startIndex=dna.indexOf("ATG");
        if(startIndex==-1)
            return result;
        stopIndex=dna.indexOf("TAA",startIndex+3);
        if(stopIndex==-1)
            return result;
        if(((stopIndex+3)-startIndex)%3==0)
           result=dna.substring(startIndex,stopIndex+3);

        return result;

    }
    public void testSimpleGene()
    {
        String test1="CVATGBBNNH"; //with no TAA
        String test2="CVBGTNMTAA"; // with no ATG
        String test3="CVBNHYTGDFATT"; //with no ATG and TAA
        String test4 = "CVBATGASDFGHTAA"; //with ATG and TAA and string length between them is multiple of 3
        String test5 ="VBGATGSDFVTAA"; ///with ATG and TAA and string length between them is not multiple of 3
        System.out.println("DNA String is "+test1);
        System.out.println("Gene is " +findSimpleGene(test1));
        System.out.println("DNA String is "+test2);
        System.out.println("Gene is " +findSimpleGene(test2));
        System.out.println("DNA String is "+test3);
        System.out.println("Gene is " +findSimpleGene(test3));
        System.out.println("DNA String is "+test4);
        System.out.println("Gene is " +findSimpleGene(test4));
        System.out.println("DNA String is "+test5);
        System.out.println("Gene is " +findSimpleGene(test5));
    }
    public static void main(String[] args)
    {
        Part1 object1=new Part1();
        //System.out.println(test1.findSimpleGene("CGGFATGBHJBJITAA"));
       object1.testSimpleGene();
    }
}

