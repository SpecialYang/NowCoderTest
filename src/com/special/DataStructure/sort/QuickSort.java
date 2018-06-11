package com.special.DataStructure.sort;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Special on 2018/6/11 20:32
 */
public class QuickSort {

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int partition(int[] nums, int start, int end) {
        //为了降低初始值对快排性能的影响，我们随机选pivot
        int pivot = new Random().nextInt(end - start + 1) + start;
        //把pivot放到最后，纯粹为了方便编程，从头开始依次放比pivot小的值，思路明确
        swap(nums, pivot, end);
        int index = start;
        for (int i = start; i < end; i++) {
            if (nums[i] < nums[end]) {
                //当待防止的位置小于当前的索引才发生交换，避免不必要交换
                if (index < i) {
                    swap(nums, i, index);
                }
                index++;
            }
        }
        //避免不必要的交换
        if(index < end) { swap(nums, index, end); }
        return index;
    }

    public static void quickSort1(int[] nums, int start, int end) {
        if(start < end) {
            int pivot = partition(nums, start, end);
            quickSort1(nums, start, pivot - 1);
            quickSort1(nums, pivot + 1, end);
        }
    }

    /**
     * 最简洁版快排
     * @param nums
     * @param start
     * @param end
     */
    public static void quickSort2(int[] nums, int start, int end) {
        int i = start;
        int j = end;
        int mid = i + (j - i) / 2;
        /**
         * i == j 也要进行的原因，可能交换后，i j同时指向了一个小的值
         * 而这个小的值应该属于前半区间的
         */
        while(i <= j) {
            while(nums[i] < nums[mid]) { i++; }
            while(nums[j] > nums[mid]) { j--; }
            if(i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        if(i < end) {
            quickSort2(nums, i, end);
        }
        if(j > start) {
            quickSort2(nums, start, j);
        }
    }

    public static void print(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
