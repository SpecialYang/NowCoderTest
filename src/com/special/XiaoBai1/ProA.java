package com.special.XiaoBai1;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 简单题
 * 考察极限，和String.format的打印带参数的保留小数的方法
 * 或者是print
 * Create by Special on 2018/3/27 23:11
 */
public class ProA {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int T = input.nextInt();
            while(T-- > 0){
                int a = input.nextInt();
                int b = input.nextInt();
                int r = input.nextInt();
                double result = b * Math.pow(Math.E, a);
//                System.out.println(String.format("%." + r + "f", result));
                System.out.printf("%." + r + "f\n", result);
            }
        }
    }
}
