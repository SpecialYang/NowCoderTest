package com.special.BZOJ;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Special on 2018/5/29 23:09
 */
public class BZOJ3555 {
    static final int LENGTH = 205;
    static long[] factor = new long[LENGTH];
    static final int KEY = 271;
    static String[] strs;
    static long[][] sum;
    static int  n, l, s, count;

    static void init(){
        factor[0] = 1;
        for(int i = 1; i < LENGTH; i++){
            factor[i] = factor[i - 1] * KEY;
        }
    }

    static void cal(int pos){
        long[] temp = new long[n + 1];
        for(int i = 1; i <= n; i++){
            temp[i] = sum[i][l] - sum[i][pos] * factor[l - pos] + sum[i][pos - 1] * factor[l - pos + 1];
        }
        Arrays.sort(temp, 1, temp.length);
        int now = 1;
        for(int i = 1; i <= n; i++){
            if(temp[i] == temp[i - 1]){
                count += now;
                now++;
            }else {
                now = 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        init();
        while(input.hasNext()){
            n = input.nextInt();
            l = input.nextInt();
            s = input.nextInt();
            strs = new String[n + 1];
            sum = new long[n + 1][LENGTH];
            count = 0;

            for(int i = 1; i <= n; i++){
                strs[i] = input.next();
            }
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= l; j++){
                    sum[i][j] = sum[i][j - 1] * KEY + strs[i].charAt(j - 1);
                }
            }
            for(int i = 1; i <= l; i++){
                cal(i);
            }
            System.out.println(count);
        }
    }
}
