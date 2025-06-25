package practise;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class FindingMissingNumber {
//    Find the missing number
//    Input: arr[] = [8, 2, 4, 5, 3, 7, 1]
//    Output: 6
//    Explanation: All the numbers from 1 to 8 are present except 6.
//
//    Input: arr[] = [1, 2, 3, 5]
//    Output: 4
//    Explanation: Here the size of the array is 4, so the range will be [1, 5]. The missing number between 1 to 5 is 4

    @Test
    public void findItUsingSort(){
//        int[] in = new int[]{8, 2, 4, 5, 3, 7, 1};
        int[] in = new int[]{1, 2, 3, 5};
        Arrays.sort(in);
        int missingNumber = 4;
        System.out.println(Arrays.toString(in));
        int j = 0;
        for (int i = in[0]; i <= in[in.length-1]; i++) {
            if (i != in[j]){
                System.out.println(i);
                Assert.assertEquals(i,missingNumber);
                break;
            }
            j++;
        }
    }
}
