package com.special.DataStructure.sort;

/**
 * Created by Special on 2018/6/11 21:36
 */
public class CountSort {

    /**
     * 计数排序
     * @param nums
     */
    public static void countSort(int[] nums) {
        int max = Integer.MIN_VALUE;
        //找出最大值
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        //申请计数数组
        int[] aux = new int[max + 1];
        //申请新的数组用于存放排序结果
        int[] newArray = new int[nums.length];
        //计数
        for(int i = 0; i < nums.length; i++) {
            aux[nums[i]]++;
        }
        //累加，从而知道每个数应该在的位置
        for(int i = 1; i < aux.length; i++) {
            aux[i] += aux[i - 1];
        }
        //从后往前考察每一个数组的元素应该在的位置
        for(int i = nums.length - 1; i >= 0; i--) {
            newArray[aux[nums[i]] - 1] = nums[i];
            aux[nums[i]]--;
        }
        //排序结果拷贝到原始数组
        System.arraycopy(newArray, 0, nums, 0, newArray.length);
    }
}
