package com.special.ZOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * 快速幂 + 打表（发现循环节）
 * Created by Special on 2018/5/19 13:44
 */
public class ZOJ3785 {
    static String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday"};
    static final int WEEK = 7;
    static int[] loop = new int[50];

    static int fastPow(int a, int b){
        int res = 1;
        int t = a;
        while(b != 0){
            if((b & 1) == 1){
                res = res * t % WEEK;
            }
            t = t * t % WEEK;
            b >>= 1;
        }
        return res;
    }

    static void init(){
        for(int i = 1; i <= 42; i++){
            loop[i] = fastPow(i % WEEK, i);
            loop[i] = (loop[i - 1] + loop[i]) % WEEK;
        }
    }

    public static void main(String[] args){
		FastScanner input = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		init();
        int T = input.nextInt();
        while(T-- > 0){
            int n = input.nextInt();
            int count = n / 42;
            int res = n % 42;
            out.println(week[(6 + (count * loop[42]) % WEEK + loop[res]) % WEEK]);
            out.flush();
        }
	}
	//快速IO
	static class FastScanner {
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
