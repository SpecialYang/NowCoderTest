package com.special.XiaoBai1;

import java.util.Scanner;

/**
 * D-多项式乘法，求系数
 * 暴力模拟即可，最高系数为n + m, 所以数组大小为 n + m + 1
 *
 * Create by Special on 2018/3/28 13:45
 */
public class ProD {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int m = input.nextInt();
            int max = n + m;
            int[] num1 = new int[max + 1], num2 = new int[max + 1],
                    result = new int[max + 1];
            for(int i = 0; i <= n; i++){ //注意次数为n,意思是数组有 n + 1项，故需要等于n
                num1[i] = input.nextInt();
            }
            for(int i = 0; i <= m; i++){
                num2[i] = input.nextInt();
            }
            for(int i = 0; i <= max; i++){
                for(int j = 0, k = i; k >= 0; j++, k--){
                    result[i] += num1[j] * num2[k];
                }
            }
            for(int i = 0; i <= max; i++){
                System.out.print((i == 0 ? "" : " ") + result[i]);
            }
            System.out.println();
        }
    }
}
