package Practise;

class FindLargestNonRepeatedCharString {
    public static void main(String[] args) {
        String str = "geksforgeeks";
        int max = 0;
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
}