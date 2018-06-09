package com.special.test14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Create by Special on 2018/4/6 14:22
 */
public class ProA {

    static int[] prime = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47};
    static long n, max;
    static int limit = 18;

    /**
     *
     * @param num 当前数的大小
     * @param sum 当前数的约数个数
     * @param limit 上一个质因子的幂次
     * @param index 考虑到哪个质数了
     */
    static void dfs(long num, long sum, int limit, int index){
        max = Math.max(max, sum);
        if(index == 15) { return; } //多往后考虑几个质数也无碍吗，万一最大约数的质因子种类很多呢
        long tmp = n / prime[index];
        for(int i = 1; i <= limit; i++){
            if(num <= tmp) { //当前的质数还可以往上乘，则继续
                num *= prime[index];
                dfs(num,sum * (i + 1), i, index + 1);
            }
        }
    }

    public static void main(String[] args){
		FastScanner input = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int t = input.nextInt();
		while(t-- > 0){
		    n = input.nextLong();
		    max = 0;
		    dfs(1, 1, limit, 0);
		    out.println(max);
        }
		out.close();
	}

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
