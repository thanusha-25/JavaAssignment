package Assignment1;

public class Part3 {

    public boolean twoOccurences(String stringa,String stringb)
    {
           int index1,index2;
           if(stringb.contains(stringa))
           {
               index1=stringb.indexOf(stringa);
               index2=stringb.lastIndexOf(stringa);
               if(index1==index2)
                   return false;
               else
                   return true;
           }
           return false;
    }
    public String lastPart(String stringa,String stringb)
    {
        int index=stringb.indexOf(stringa);
        if(index==-1)
            return stringb;
        else
            return stringb.substring(index+stringa.length());
    }
    public void testing()
    {
        //testing for twoOccurences
        System.out.println(twoOccurences("by","A story by Abby Long"));
        System.out.println(twoOccurences("l","hello"));
        System.out.println(twoOccurences("an","banana"));
        System.out.println(twoOccurences("tom","tom and jerry"));
        System.out.println(twoOccurences("harry","harryPorter"));
       //testing fot lastPart
        System.out.println(lastPart("an","banana"));
        System.out.println(lastPart("zoo","forest"));
        System.out.println(lastPart("by","A story by Abby Long"));
    }
    public static void main(String[] args)
    {
        Part3 object1=new Part3();
       object1.testing();
    }
}
