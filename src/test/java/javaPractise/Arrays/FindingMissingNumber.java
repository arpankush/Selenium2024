package javaPractise.Arrays;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindingMissingNumber {
//    Find the missing number
//    Input: arr[] = [8, 2, 4, 5, 3, 7, 1]
//    Output: 6
//    Explanation: All the numbers from 1 to 8 are present except 6.
//
//    Input: arr[] = [1, 2, 3, 5]
//    Output: 4
//    Explanation: Here the size of the array is 4, so the range will be [1, 5]. The missing number between 1 and 5 is 4

    @Test
    public void findItUsingSort(){
        int[] in = new int[]{5, 2, 3, 1};
        Arrays.sort(in);
        System.out.println(Arrays.toString(in));
        for (int i = 0; i < in.length; i++) {
            if (in[i] != i+1)
                System.out.println("Missing number is " + (i+1));
        }
    }

    @Test
    public void findItWithoutSort(){
        int in[] = new int[]{5,2,3,1};
        int size = in.length;
        List<Integer> al = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            al.add(in[i]);
            if (al.get(i) > size){
                System.out.println("Missing number must be " + (in[i]-1) + " if input is in order");
            }
        }
    }
}
