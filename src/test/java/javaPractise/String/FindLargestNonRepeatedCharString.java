package javaPractise.String;

import org.testng.annotations.Test;

public class FindLargestNonRepeatedCharString {
    @Test
    public void findLongestNonRepeatingCharString1(String[] args) {
        String str = "geksforieeks";
        String partialString;
        String out = "";
        for (int start = 0; start < str.length()-1; start++) {
            String res = "";
            for (int i = start+1; i < str.length(); i++) {
                partialString = str.substring(start,i+1);
                String leftString = partialString.substring(0,partialString.length()-1);
                String lastChar = String.valueOf(partialString.charAt(partialString.length()-1));
                if(!leftString.contains(lastChar)){
                    res = partialString;
                }
                else{
                    if (res.length() > out.length())
                        out = res;
                    break;
                }
            }
        }
        System.out.println("Result is : '" + out + "' and it's length is " + out.length());
    }


    @Test
    public void findLongestNonRepeatingCharString(){
        String input = "ABCDABCEABCDEFAB";
        if (input.length() > 2){
            String longestString = String.valueOf(input.charAt(0));
            for (int i = 0; i < input.length(); i++) {
                for (int j = i+1; j < input.length(); j++) {
                    String partialText = input.substring(i, j+1);
                    String lastChar = String.valueOf(partialText.charAt(partialText.length()-1));
                    String partialTextOlderVersion = partialText.substring(0,partialText.length()-1);
                    if (!partialTextOlderVersion.contains(lastChar)){
                        if(partialText.length() > longestString.length())
                            longestString = partialText;
                    }
                    else
                        break;
                }
            }
            System.out.println(longestString);
        }
        else {
            System.out.println("Not enough length to check unique char string.");
        }
    }
}