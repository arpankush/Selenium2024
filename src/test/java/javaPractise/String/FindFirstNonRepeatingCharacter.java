package javaPractise.String;
import java.util.*;
import org.testng.annotations.Test;

public class FindFirstNonRepeatingCharacter {

    @Test
    public void UsingLinkedHashMap(){
        String in = "aabbccddeeff";
        boolean found = false;
        Map<Character, Integer> hm = new LinkedHashMap<>();
        for(char c: in.toLowerCase().toCharArray()){
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        for(Map.Entry<Character, Integer> e: hm.entrySet()){
            if(e.getValue() == 1){
                System.out.println(e.getKey());
                found = true;
                break;
            }
        }
        if (!found){
            System.out.println('_');
        }
    }
}
