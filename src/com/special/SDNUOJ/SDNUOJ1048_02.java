package com.special.SDNUOJ;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Special on 2018/6/4 11:51
 */
public class SDNUOJ1048_02 {

    static int[] nums, sum;
    static int n;
    static int[][] dp;

    static int getSum(int i, int j){
        int result = 0;
        if(j > n){
            result = sum[j % n] + sum[n] - sum[i - 1];
        }else {
            result = sum[j] - sum[i - 1];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            n = input.nextInt();
            dp = new int[2 * n + 1][2 * n + 1];
            nums = new int[2 * n + 1];
            sum = new int[n + 1];
            for(int i = 1; i <= n; i++){
                nums[i] = input.nextInt();
                nums[n + i] = nums[i];
                sum[i] = sum[i - 1] + nums[i];
            }
            for(int i = 1; i <= 2 * n; i++){
                Arrays.fill(dp[i], Integer.MAX_VALUE);
                dp[i][i] = 0;
            }
            for(int len = 1; len < n; len++){
                for(int i = 1; i <= n; i++){
                    int j = i + len;
                    int sum = getSum(i, j);
                    for(int k = i; k < j; k++){
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] +
                                (k >= n ? dp[(k + 1) % n][j % n] : dp[k + 1][j]) + sum);
                    }
                }
            }
            int result = Integer.MAX_VALUE;
            for(int i = 1; i <= n; i++){
                result = Math.min(result, dp[i][i + n - 1]);
            }
            System.out.println(result);
        }
    }
}
