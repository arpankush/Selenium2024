package javaPractise;

import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FrequencyOfChars {

    @Test
    public void frequencyOfChars(){

        char[] inputArray = {'a', 'w', 'g', 'q', 'a', 't', 'g', 'q', 'q', 'n'};

        //Put char and freq
        HashMap<Character, Integer> map = new HashMap<>();
        for (char i : inputArray){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        //Print
        for (Map.Entry<Character, Integer> entry: map.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }


//        System.out.println("Acending order:\n");
//        map.entrySet().stream().sorted(Map.Entry.comparingByValue())
//                .forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));

        System.out.println("Descending Order\n");
       map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
               .forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));

        System.out.println("Most frequent number");
        Optional<Map.Entry<Character, Integer>> maxFrequency = map.entrySet().stream().max(Map.Entry.comparingByValue());
        maxFrequency.stream().forEach(entry -> System.out.println(entry.getKey() + " frequency of " + entry.getValue()));

        System.out.println("2nd Most Frequent number");
        Optional<Map.Entry<Character,Integer>>  secondMostFrequent= map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .skip(1).findFirst();
        secondMostFrequent.stream().forEach(entry -> System.out.println(entry.getKey() + " occuring freq of " + entry.getValue()));

    }
}
