package com.special.DataStructure.sort;

import java.util.Random;

/**
 * Created by Special on 2018/6/11 21:29
 */
public class ArrayUtil {

    public static void printArray(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    /**
     * 打散数组
     * @param nums
     */
    public static void shiftArray(int[] nums) {
        int length = nums.length;
        Random random = new Random();
        while(length-- > 0) {
            int i = random.nextInt(nums.length);
            int j = random.nextInt(nums.length);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

}
