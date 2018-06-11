package com.special.DataStructure.sort;

import java.util.Scanner;

/**
 * Created by Special on 2018/6/11 21:36
 */
public class SortTest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()) {
            int n = input.nextInt();
            int[] nums = new int[n];
            for(int i = 0; i < n; i++) {
                nums[i] = input.nextInt();
            }
//            quickSort1(nums, 0, n - 1);
//            print(nums);
//            swap(nums, 3, n - 1);
            int count = 10;
            while(count-- > 0) {
                ArrayUtil.shiftArray(nums);
//                quickSort2(nums, 0, n - 1);
                CountSort.countSort(nums);
                ArrayUtil.printArray(nums);
            }
        }
    }
}
