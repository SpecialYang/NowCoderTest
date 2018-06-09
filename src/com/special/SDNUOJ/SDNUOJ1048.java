package com.special.SDNUOJ;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Special on 2018/6/4 11:30
 */
public class SDNUOJ1048 {

    static int[] nums;
    static int n;
    static int[][] dp;

    static int getSum(int index, int length){
        int sum = 0;
        for(int i = 1; i <= length; i++){
            sum += nums[index];
            index++;
            if(index > n){
                index = 1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            n = input.nextInt();
            nums = new int[n + 1];
            dp = new int[n + 1][n + 1];
            for(int i = 1; i <= n; i++) {
                nums[i] = input.nextInt();
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
            for(int j = 1; j <= n; j++){
                for(int i = 1; i <= n; i++){
                    int sum = getSum(i, j);
                    dp[i][1] = 0;
                    for(int k = 1; k < j; k++){
                        dp[i][j] = Math.min(dp[i][j],
                                dp[i][k] + dp[(i + k - 1) % n + 1][j - k] + sum);
                    }
                }
            }
            int ans = Integer.MAX_VALUE;
            for(int i = 1; i <= n; i++){
                ans = Math.min(ans, dp[i][n]);
            }
            System.out.println(ans);
        }
    }
}
