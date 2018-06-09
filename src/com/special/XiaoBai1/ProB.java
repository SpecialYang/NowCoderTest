package com.special.XiaoBai1;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Create by Special on 2018/3/28 10:26
 */
public class ProB {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int T = input.nextInt();
            while(T-- > 0){
                int a = input.nextInt();
                int b = input.nextInt();
                int r = input.nextInt();
                double result = Math.pow(a, Math.E) / b;
//                System.out.println(String.format("%." + r + "f", result));
                BigDecimal ans = new BigDecimal(result).setScale(r, BigDecimal.ROUND_HALF_DOWN);
                System.out.println(ans);
            }
        }
    }
}
