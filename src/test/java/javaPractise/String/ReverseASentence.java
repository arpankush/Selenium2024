package javaPractise.String;

import org.testng.annotations.Test;

public class ReverseASentence {

    @Test
    public void reverseASentenceWithWordsIntact(){
        String in = "This is an example of a sentence";
        String out = "";
        int endIndex = in.length();
        for (int i = in.length()-1; i >= 0 ; i--) {
            if (in.charAt(i) == ' '){
                out = out + in.substring(i+1, endIndex) + " ";
                endIndex = i;
            }
        }
        out += in.substring(0, endIndex);
        System.out.println(out.trim());
    }
}
