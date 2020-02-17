package StringThirdAssignments;

public class Part2 {
    public float cgRation(String dna)
    {
        int i=0,cnt=0;
    while(i<dna.length())
        {
            if((dna.charAt(i)=='C')||(dna.charAt(i)=='c')||(dna.charAt(i)=='G')||(dna.charAt(i)=='g'))
                cnt++;
            i++;
        }
     return (float)cnt/dna.length() ;
    }

    public int countCodon(String dna)
    {
        int cnt=0,index=0;
        while(true) {
             index = dna.indexOf("CTG",index);
            if (index == -1)
                return cnt;
            cnt++;
            index=index+3;
        }
    }
    public static void main(String[] args)
    {
        Part2 object1 =new Part2();
       System.out.println( object1.cgRation("ATGCCATAG"));
       System.out.println(object1.countCodon("ATGBGSCTGTAACTG"));
    }
}
