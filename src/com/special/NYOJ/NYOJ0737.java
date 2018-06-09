package com.special.NYOJ;

import java.util.*;
/**
 * Created by Special on 2018/5/31 8:34
 */
public class NYOJ0737 {

    static final int MAX = (int) 1e6;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int[] num = new int[n + 1];
            int[] sum = new int[n + 1];
            int[][] dp = new int[n + 1][n + 1];
            for(int i = 0; i < n + 1; i++) {
                Arrays.fill(dp[i], MAX);
            }
            for(int i = 1; i <= n; i++){
                num[i] = input.nextInt();
                sum[i] = sum[i - 1] + num[i];
                dp[i][i] = 0;
            }
            int temp = 0;
            for(int len = 1; len < n; len++){
                for(int i = 1; i + len <= n; i++){
                    int j = i + len;
                    temp = sum[j] - sum[i - 1];
                    for(int k = i; k < j; k++){
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + temp);
                    }
                }
            }
            System.out.println(dp[1][n]);
        }
    }
}
