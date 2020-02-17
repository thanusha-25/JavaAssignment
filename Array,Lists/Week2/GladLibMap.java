//package GladLib;
//
//import edu.duke.*;
//
//import java.lang.reflect.Array;
//import java.util.*;
//
//public class GladLibMap {
////    private ArrayList<String> adjectiveList;
////    private ArrayList<String> nounList;
////    private ArrayList<String> colorList;
////    private ArrayList<String> countryList;
////    private ArrayList<String> nameList;
////    private ArrayList<String> animalList;
////    private ArrayList<String> timeList;
////    private ArrayList<String> verbList;
////    private ArrayList<String> fruitList;
//    private ArrayList<String> test = new ArrayList<String>();
//    private HashMap<String,ArrayList<String>> map;
//    private Random myRandom;
//    private int count = 0;
//    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
//    private static String dataSourceDirectory = "data";
//
//    public GladLibMap() {
//        initializeFromSource(dataSourceDirectory);
//        myRandom = new Random();
//    }
//
//    public GladLibMap(String source) {
//        initializeFromSource(source);
//        myRandom = new Random();
//        map=new HashMap<String, ArrayList<String>>();
//    }
//
//    private void initializeFromSource(String source) {
//        String words[] ={  "adjective","noun","color","country","name","animal","timeframe","verb","fruit"};
////        adjectiveList = readIt(source + "/adjective.txt");
////        nounList = readIt(source + "/noun.txt");
////        colorList = readIt(source + "/color.txt");
////        countryList = readIt(source + "/country.txt");
////        nameList = readIt(source + "/name.txt");
////        animalList = readIt(source + "/animal.txt");
////        timeList = readIt(source + "/timeframe.txt");
////        verbList = readIt(source + "/verb.txt");
////        fruitList = readIt(source + "/fruit.txt");
//        for(int i=0;i<words.length;i++)
//
//    }
//
//    private String randomFrom(ArrayList<String> source) {
//        int index = myRandom.nextInt(source.size());
//        return source.get(index);
//    }
//
//    private String getSubstitute(String label, ArrayList<String> test) {
//        String substituted = null;
//        if (label.equals("country")) {
//            substituted = randomFrom(countryList);
//            while (test.contains(substituted))
//                substituted = randomFrom(countryList);
//
//        }
//
//        if (label.equals("color")) {
//            substituted = randomFrom(colorList);
//            while (test.contains(substituted))
//                substituted = randomFrom(colorList);
//        }
//        if (label.equals("noun")) {
//            substituted = randomFrom(nounList);
//            while (test.contains(substituted))
//                substituted = randomFrom(nounList);
//        }
//        if (label.equals("name")) {
//            substituted = randomFrom(nameList);
//            while (test.contains(substituted))
//                substituted = randomFrom(nameList);
//        }
//        if (label.equals("adjective")) {
//            substituted = randomFrom(adjectiveList);
//            while (test.contains(substituted))
//                substituted = randomFrom(adjectiveList);
//        }
//        if (label.equals("animal")) {
//            substituted = randomFrom(animalList);
//            while (test.contains(substituted))
//                substituted = randomFrom(animalList);
//        }
//        if (label.equals("timeframe")) {
//            substituted = randomFrom(timeList);
//            while (test.contains(substituted))
//                substituted = randomFrom(timeList);
//        }
//        if (label.equals("number")) {
//            substituted = "" + myRandom.nextInt(50) + 5;
//        }
//        if (label.equals("verb")) {
//            substituted = randomFrom(verbList);
//            while (test.contains(substituted))
//                substituted = randomFrom(verbList);
//        }
//        if (label.equals("fruit")) {
//            substituted = randomFrom(fruitList);
//            while (test.contains(substituted))
//                substituted = randomFrom(fruitList);
//        }
//        test.add(substituted);
//        count++;
//        // System.out.println(substituted);
//        if (substituted != null) {
//
//            return substituted;
//        } else
//            return "**UNKNOWN**";
//    }
//
//    private String processWord(String w) {
//        int first = w.indexOf("<");
//        int last = w.indexOf(">", first);
//        if (first == -1 || last == -1) {
//            return w;
//        }
//        String prefix = w.substring(0, first);
//        String suffix = w.substring(last + 1);
//        String sub = getSubstitute(w.substring(first + 1, last), test);
//        return prefix + sub + suffix;
//    }
//
//    private void printOut(String s, int lineWidth) {
//        int charsWritten = 0;
//        for (String w : s.split("\\s+")) {
//            if (charsWritten + w.length() > lineWidth) {
//                System.out.println();
//                charsWritten = 0;
//            }
//            System.out.print(w + " ");
//            charsWritten += w.length() + 1;
//        }
//    }
//
//    private String fromTemplate(String source) {
//        String story = "";
//        if (source.startsWith("http")) {
//            URLResource resource = new URLResource(source);
//            for (String word : resource.words()) {
//                story = story + processWord(word) + " ";
//            }
//        } else {
//            FileResource resource = new FileResource(source);
//            for (String word : resource.words()) {
//                story = story + processWord(word) + " ";
//            }
//        }
//        return story;
//    }
//
//    private ArrayList<String> readIt(String source) {
//        ArrayList<String> list = new ArrayList<String>();
//        if (source.startsWith("http")) {
//            URLResource resource = new URLResource(source);
//            for (String line : resource.lines()) {
//                list.add(line);
//            }
//        } else {
//            FileResource resource = new FileResource(source);
//            for (String line : resource.lines()) {
//                list.add(line);
//            }
//        }
//        return list;
//    }
//
//    public void makeStory() {
//        System.out.println("\n");
//        String story = fromTemplate("/home/pola/Downloads/GladLib/data/madtemplate.txt");
//        printOut(story, 60);
//        test.clear();
//    }
//
//    public static void main(String[] args) {
//        GladLib objet1 = new GladLib("/home/pola/Downloads/GladLib/data");
//        objet1.makeStory();
//        System.out.println("total replaced are " + objet1.count);
//    }
//
//
//}