package com.special.test9;

import java.util.Scanner;

/**
 * 13爱森杯广工-D 最长回文子序列长
 * 思路1：原字符串逆序，然后对这两个字符串进行LCS(最长公共子序列)
 * 因为回文串的逆序形式不变，所以逆序后，原串中所有的回文串都会保持原有的次序关系
 * Create by Special on 2018/3/24 14:30
 */
public class ProD {

    /**
     * 串逆序的dp
     * @param str
     * @return
     */
    public static int getMax1(String str){
        int length = str.length();
        String reverse = new StringBuilder(str).reverse().toString();
        int[][] dp = new int[length + 1][length + 1];
        for(int i = 1; i <= length; i++){
            for(int j = 1; j <= length; j++){
                if(str.charAt(i - 1) == reverse.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return length - dp[length][length];
    }

    /**
     * 原串上直接dp
     * 转移方程为
     * 1. dp[i][j] = dp[i + 1][j - 1] + 2, s.t. str[i] == str[j]
     * 2. dp[i][j] = max{dp[i + 1, j], dp[i, j - 1]}, s.t. str[i] != str[j]
     *
     * 由以上方程可知，当我们算dp[i][j]的时候，
     * dp[i + 1][j - 1]，dp[i + 1, j]，dp[i, j - 1]的状态必须考察过，且为局部最优解
     * 所以我们下面的思路按长度求所有的子串的回文串，这样当我们求更大的子串时可以利用短串的状态结果
     * 即满足动归的最优子结构和无后效性
     * @param str
     * @return
     */
    public static int getMax2(String str){
       int length = str.length();
       int[][] dp = new int[length][length];
       for(int i = 0; i < length; i++){
           dp[i][i] = 1;
       }
       // i 定义了子串的长度
       for(int i = 1; i < length; i++){
           // 求所有str[j,j + i]的子串的最长回文序列
           for(int j = 0; j + i < length; j++){
               if(str.charAt(j) == str.charAt(j + i)){
                   dp[j][j + i] = dp[j + 1][j + i - 1] + 2;
               }else {
                   dp[j][j + i] = Math.max(dp[j][j + i - 1], dp[j + 1][j + i]);
               }
           }
       }
       return length - dp[0][length - 1];
    }

    /**
     * 另一种思路：
     * 转移方程为
     * 1. dp[i][j] = dp[i - 1][j + 1] + (i != j ? 2 : 1), s.t. str[i] == str[j]
     * 2. dp[i][j] = max{dp[i - 1, j], dp[i, j + 1]}, s.t. str[i] != str[j]
     *
     * dp[i][j]表示以i作为中心或者分割的最大的回文串长度，即1到i中是否存在回文串的一半（不容易想到！）
     * @param str
     * @return
     */
    public static int getMax3(String str){
       int length = str.length();
       int[][] dp = new int[length + 2][length + 2];
       for(int i = 1; i <= length; i++){
           dp[i][i] = 1;
       }
       int ans = 0;
       for(int i = 1; i <= length; i++){
           for(int j = length; j >= i; j--){
               if(str.charAt(i - 1) == str.charAt(j - 1)){
                   dp[i][j] = dp[i - 1][j + 1] + (i != j ? 2 : 1);
               }else {
                   dp[i][j] = Math.max(dp[i][j + 1], dp[i - 1][j]);
               }
               ans = Math.max(ans, dp[i][j]);
           }
       }
       return length - ans;
    }

    public static int getMax4(String str){
       int length = str.length();
       int[][] dp = new int[length + 1][length + 1];
       for(int i = 1; i <= length; i++){
           dp[i][i] = 1;
       }
       for(int i = 1; i <= length; i++){
           for(int j = i - 1; j >= 1; j--){
               if(str.charAt(i - 1) == str.charAt(j - 1)){
                   dp[j][i] = dp[j + 1][i - 1] + 2;
               }else {
                   dp[j][i] = Math.max(dp[j][i - 1], dp[j + 1][i]);
               }
           }
       }
       return length - dp[1][length];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            String str = input.next().toLowerCase();
//            System.out.println(getMax1(str));
//            System.out.println(getMax2(str));
//            System.out.println(getMax3(str));
            System.out.println(getMax4(str));
        }
    }
}
