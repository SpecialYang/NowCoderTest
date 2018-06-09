package com.special.DongBeiLinYeSpring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 0-1分数规划问题
 * Create by Special on 2018/4/12 9:37
 */
public class ProI {

    static double[] wei, pri, less;
    static final double diff = 1e-5;
    static final int MAX = (int) 1e6;

    public static void main(String[] args){
		FastScanner input = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int t = input.nextInt();
		while(t-- > 0) {
            int n = input.nextInt();
            int k = input.nextInt();
            wei = new double[n];
            pri = new double[n];
            less = new double[n];
            for (int i = 0; i < n; i++) {
                wei[i] = input.nextInt();
                pri[i] = input.nextInt();
            }
            double l = 0, r = MAX, mid, sum;
            while(r - l >= diff){
                mid = l + (r - l) / 2;
                for(int i = 0; i < n; i++){
                    less[i] = pri[i] - mid * wei[i];
                }
                Arrays.sort(less);
                sum = 0;
                for(int i = n - k; i < n; i++){
                    sum += less[i];
                }
                if(sum >= 0){
                    l = mid;
                }else{
                    r = mid;
                }
            }
            out.println(String.format("%.2f", l));
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
