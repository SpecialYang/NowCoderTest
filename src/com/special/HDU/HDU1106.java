package com.special.HDU;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Special on 2018/5/20 14:37
 */
public class HDU1106 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            String str = input.nextLine();
            String[] numsStr = str.split("5+");
            int[] nums = new int[numsStr.length];
            int count = 0;
            int index = 0;
            if(numsStr[0].equals("")){
                index = 1;
            }
            for(; index < nums.length; index++){
                nums[count++] = Integer.valueOf(numsStr[index]);
            }
            Arrays.sort(nums, 0, count);
            for(int i = 0; i < count; i++){
                System.out.print((i == 0 ? "" : " ") + nums[i]);
            }
            System.out.println();
        }
    }
}
