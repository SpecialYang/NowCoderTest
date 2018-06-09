package com.special.DongBeiLinYeSpring;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;


/**
 * 费波纳茨循环节！
 * 大数的API的熟悉
 * Create by Special on 2018/4/11 14:25
 */
public class ProK {

	 static BigInteger TWO = new BigInteger("2");

	 static int powMod(BigInteger a, BigInteger b, BigInteger mod){
	 	BigInteger res = BigInteger.valueOf(1);
	 	while(b.compareTo(BigInteger.ZERO) > 0){
	 		if(b.mod(TWO).compareTo(BigInteger.ONE) == 0){
	 			res = res.multiply(a).mod(mod);
			}
			a = a.multiply(a).mod(mod);
	 		b = b.divide(TWO);
		}
		return res.intValue();
	 }

     public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t = input.nextInt();
		while(t-- > 0) {
            BigInteger a = new BigInteger(input.next());
            BigInteger b = new BigInteger(input.next());
            int c = input.nextInt();
            int length = c * c;
            int[] num = new int[length + 1];
            num[0] = 0;
            num[1] = 1;
            int loopLength = 0;
            for(int i = 2; i <= length; i++){
                num[i] = (num[i - 1] + num[i - 2]) % c;
                if(num[i] == 1 && num[i - 1] == 0){
                	loopLength = i - 1;
                	break;
				}
            }
            BigInteger mod = BigInteger.valueOf(loopLength);
            out.println(num[powMod(a.mod(mod), b, mod)]);
        }
		out.close();
	}
}
