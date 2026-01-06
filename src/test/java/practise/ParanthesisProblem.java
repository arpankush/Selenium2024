package practise;

import java.util.HashMap;

public class ParanthesisProblem {

    public static void main(String[] args) {
        String in = "(){}[]<>";
        HashMap<Character,Integer> hm = new HashMap<>();
        for (int i = 0; i < in.length(); i++) {
           switch (in.charAt(i)){
               case '(':
                   hm.put('(', hm.get('(') + 1);
                   break;
               case '{':
                   hm.put('(', hm.get('{') + 1);
                   break;
               case '[':
                   hm.put('(', hm.get('[') + 1);
                   break;
               case '<':
                   hm.put('(', hm.get('<') + 1);
                   break;
           }
        }
        System.out.println(hm.toString());
    }
}
