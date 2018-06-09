package com.special.XiaoBai1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 卡特兰数的几种求法
 * 求逆元
 * 费马小定理
 * 扩展欧几里得算法
 * Create by Special on 2018/3/31 23:25
 */
public class ProI {

     static final int MOD = 998244353;
     static final int MAX = (int) 2e5 + 5;
     static int[] fac = new int[MAX];
     static int x, y;

     static void init(){
         fac[0] = 1;
         for(int i = 1; i < MAX; i++){
             fac[i] = (int)((long) fac[i - 1] * i % MOD);
         }
     }

     static int powMod(long n, long m){
         long result = 1;
         while(m != 0){
             if((m & 1) == 1){
                 result = result * n % MOD;
             }
             n = n * n % MOD;
             m >>= 1;
         }
         return (int) result;
     }

     static void exgcd(int a, int b){
         if(b == 0){
             x = 1;
             y = 0;
         }else {
             exgcd(b, a % b);
             int temp = x;
             x = y;
             y = temp - a / b * y;
         }

     }

     static int getInverse(int a, int b){
         exgcd(a, b);
         return (x + MOD) % MOD;
     }

     public static void main(String[] args){
		FastScanner input = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		init();
        int T = input.nextInt();
        for(int i = 1; i <= T; i++) {
            int n = input.nextInt();
//            long result1 = (long) fac[n << 1] * powMod(fac[n + 1], MOD - 2) % MOD * powMod(fac[n], MOD - 2) % MOD;
//            n--;
//            long result2 = (long) fac[n << 1] * powMod(fac[n + 1], MOD - 2) % MOD * powMod(fac[n], MOD - 2) % MOD;
//            out.println("Case #" + i + ": " + (result1 - result2 + MOD) % MOD);
            int temp = n - 1;
//            long result = (long) fac[temp << 1] * powMod(fac[temp + 1], MOD - 2) % MOD
//                    * powMod(fac[temp], MOD - 2) % MOD * (3 * n - 3) % MOD * powMod(n + 1, MOD - 2) % MOD;
            long result = (long) fac[temp << 1] * getInverse(fac[temp + 1], MOD) % MOD
                    * getInverse(fac[temp], MOD) % MOD * (3 * n - 3) % MOD * getInverse(n + 1, MOD) % MOD;
            out.println("Case #" + i + ": " + result);
        }
        out.close();
	}

	private static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner() {
			try	{
				br = new BufferedReader(new InputStreamReader(System.in));
				st = new StringTokenizer(br.readLine());
			} catch (Exception e){e.printStackTrace();}
		}

		public String next() {
			if (st.hasMoreTokens())	return st.nextToken();
			try {st = new StringTokenizer(br.readLine());}
			catch (Exception e) {e.printStackTrace();}
			return st.nextToken();
		}

		public int nextInt() {return Integer.parseInt(next());}

		public long nextLong() {return Long.parseLong(next());}

		public double nextDouble() {return Double.parseDouble(next());}

		public String nextLine() {
			String line = "";
			if(st.hasMoreTokens()) line = st.nextToken();
			else try {return br.readLine();}catch(IOException e){e.printStackTrace();}
			while(st.hasMoreTokens()) line += " "+st.nextToken();
			return line;
		}
	}
}
