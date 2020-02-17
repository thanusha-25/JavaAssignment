package Assignment1;

public class Part2 {
    public String findSimpleGene(String dna,String startCodon,String stopCodon)
    {
        int flag=0;
        if(dna.charAt(0)> 96)
        {
            dna=dna.toUpperCase();
            flag=1;
        }
        String result="";
        int startIndex,stopIndex;
        startIndex=dna.indexOf(startCodon);
        if(startIndex==-1)
            return result;
        stopIndex=dna.indexOf(stopCodon,startIndex+3);
        if(stopIndex==-1)
            return result;
        if(((stopIndex+3)-startIndex)%3==0)
            result=dna.substring(startIndex,stopIndex+3);
            if(flag==1)
               result=result.toLowerCase();
        return result;

    }
    public void testSimpleGene()
    {
        String test1="cvsatgfdsc"; //with no TAA
        String test2="CVBGTNMTAA"; // with no ATG
        String test3="CVBNHYTGDFATT"; //with no ATG and TAA
        String test4 = "dgbatgasdfghtaabn"; //with ATG and TAA and string length between them is multiple of 3
        String test5 ="VBGATGSDFVTAA";///with ATG and TAA and string length between them is not multiple of 3
        System.out.println("DNA String is "+test1);
        System.out.println("Gene is " +findSimpleGene(test1,"ATG","TAA"));
        System.out.println("DNA String is "+test2);
        System.out.println("Gene is " +findSimpleGene(test2,"ATG","TAA"));
        System.out.println("DNA String is "+test3);
        System.out.println("Gene is " +findSimpleGene(test3,"ATG","TAA"));
        System.out.println("DNA String is "+test4);
        System.out.println("Gene is " +findSimpleGene(test4,"ATG","TAA"));
        System.out.println("DNA String is "+test5);
        System.out.println("Gene is " +findSimpleGene(test5,"ATG","TAA"));
    }
    public static void main(String[] args)
    {
        Part2 object1=new Part2();
        //System.out.println(test1.findSimpleGene("CGGFATGBHJBJITAA"));
        object1.testSimpleGene();
    }
}
