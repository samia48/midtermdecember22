package string.problems;

import java.util.HashMap;
import java.util.Map;

public class DetermineLargestWord {
    public static void main(String[] args) {
        /*
         Implement to Find the length and longest word in the given sentence below.
         Should return "10 biological".
         */
        String s="Human brain is a biological learning machine";
        // Map<Integer, String> wordNLength = findTheLargestWord(s);
        Map <Integer, String> res=new HashMap<>();
        res= findTheLargestWord(s);
        Map<Integer,String> finalResault=new HashMap<>();
        finalResault=resValue(res);
        for (Map.Entry ent:finalResault.entrySet()) {
            System.out.println(ent.getKey()+" "+ent.getValue());
        }


        //implement

    }
    // this method returns you a map that contain one element(who has the maximum length value )
    public  static Map<Integer, String> resValue(Map<Integer,String>map ){
        Map.Entry<Integer, String> maxEntry = null;
        Map<Integer,String>Res=new HashMap<Integer,String>();
        for (Map.Entry<Integer, String > entry : map.entrySet()) {
            if (maxEntry==null || entry.getKey().compareTo(maxEntry.getKey()) > 0) {
                maxEntry = entry;
            }
        }
        Res.put(maxEntry.getKey(),maxEntry.getValue());
        return  Res ;
    }

    // this method give you the map <length of the word, word>
    public static Map<Integer, String> findTheLargestWord(String wordGiven){
        Map<Integer, String> map = new HashMap<Integer, String>();
        String st = "Human brain is a biological learning machine";
        String words[]= wordGiven.split(" ");
        //implement

        for (String word : words) {
            map.put(word.length(),word);

        }
        Map.Entry<Integer, String>maxEntry = null;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {

            //System.out.println(map);
        }
        //System.out.println(map);
        return map;
    }
}