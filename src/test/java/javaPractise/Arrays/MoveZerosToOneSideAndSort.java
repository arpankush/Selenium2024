package javaPractise.Arrays;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

public class MoveZerosToOneSideAndSort {

    @DataProvider(name = "providingInputs")
    public Object[][] providingInputs(){
        return new Object[][]{
                {0,4,0,1,5,0,3,0,0,2,0},
                {0,4,0,1,5,2,100,0,3,0,0,2,0},
                {4,1,5,0,3,2,0}
        };
    }

    @Test(dataProvider = "providingInputs")
    public void doubleForLoopMethod(int[] in){
        //O(n2)
        for(int j = 0; j < in.length; j++){
            for(int i = 0; i < in.length-1; i++){
                if(in[i] != 0 && in[i+1] == 0){
                    in[i+1] = in[i];
                    in[i] = 0;
                }
                if(in[i] > in[i+1]){
                    int temp = in[i+1];
                    in[i+1] = in[i];
                    in[i] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(in));
    }

    @Test(dataProvider = "providingInputs")
    public void UsingArrayListToSort(int[] in){
        //O(n Log n)
        int[] copy = in.clone();
        int index = 0;
        List<Integer> l = new ArrayList<>();
        //Put non zeros to array list
        for(int i: in){
            if(i != 0)
                l.add(i);
        }
        Collections.sort(l);
        //Put sorted non zeros back
        for(int i: l){
            in[index++] = i;
        }
        //Put Zeros
        for(int i = index; i < copy.length; i++){
            in[i] = 0;
        }
        System.out.println(Arrays.toString(in));
    }

    @Test(dataProvider = "providingInputs")
    public void UsingCountSort(int[] in){
        //O(n)
        int index = 0;
        int[] freq = new int[101]; //Assuming numbers are in range of 0-100
        for(int i: in){
           freq[i]++;
        }
        for(int i = 0; i < freq.length; i++){
            while(freq[i] > 0){
                in[index++] = i;
                freq[i]--;
            }
        }
        System.out.println(Arrays.toString(in));
    }
}

