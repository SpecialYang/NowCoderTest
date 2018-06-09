package com.special.XiaoBai1;

import java.util.Scanner;

/**
 * 同余定理 + 快速幂取模
 *
 * Create by Special on 2018/3/28 11:31
 */
public class ProC {

    public static long powerMod(long kinds, long counts, long mod){
        long result = 1;
        long digit = kinds;
        while(counts != 0){
            if((counts & 1) == 1){
                result = result * digit % mod;
            }
            digit = digit * digit % mod;
            counts >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            long a = input.nextLong();
            long b = input.nextLong();
            long c = input.nextLong();
            long d = input.nextLong();
            long e = input.nextLong();
            long kinds = ((a % e) * (b % e)) % e;//幂的同余只需对底数取余，而不能对指数取余
            System.out.println(kinds == 0 ? 0 : powerMod(kinds, c * d, e));
        }
    }
}
