package javaPractise;

import org.testng.annotations.Test;

public class ReplaceLetterWithIncrementalSymbols {

    @Test
    public void UsingSimpleString() {

        String in = "This is a sentence with many i's in it.";
        String out = "";
        int count = 1;
        for (int i = 0; i < in.length(); i++) {
            if (in.charAt(i) == 'i') {
                for (int j = count; j > 0; j--) {
                    out += "#";
                }
                count++;
            } else {
                out += in.charAt(i);
            }
        }
        System.out.println(out);

    }
}
