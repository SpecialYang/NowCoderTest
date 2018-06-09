package com.special.test9;

import java.util.Scanner;

/**
 * 强迫症序列的变形
 * Create by Special on 2018/3/26 15:33
 */
public class ProJ_Extension1 {

    /**
     * 快速选择kth算法
     * @param nums
     * @param low
     * @param high
     * @param k
     * @return
     */
    public static int quickSelect(int[] nums, int low, int high, int k){
        int i = low, index = low;
        for(; i < high; i++){
            if(nums[i] < nums[high]){
                int temp = nums[index];
                nums[index++] = nums[i];
                nums[i] = temp;
            }
        }
        if(index < high){
            int temp = nums[index];
            nums[index] = nums[high];
            nums[high] = temp;
        }
        if(index > k){
            return quickSelect(nums, low, index - 1, k);
        }else if(index < k){
            return quickSelect(nums, index + 1, high, k);
        }else{
            return nums[index];
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int T = input.nextInt();
            while(T-- > 0){
                int n = input.nextInt();
                int[] nums = new int[n];
                for(int i = 0; i < n; i++){
                    nums[i] = input.nextInt();
                }
                int medium = quickSelect(nums, 0, n - 1, n / 2);
                int sum = 0;
                for(int i = 0; i < n; i++){
                    sum += Math.abs(nums[i] - medium);
                }
                System.out.println("Lowest steps are " + sum);
            }
        }
    }
}
