package com.special.ChangShaLiGong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * 区间求和问题，不用想太多，分割维护最大值即可
 *
 * what about 线段树？
 * Created by Special on 2018/4/15 14:56
 */
public class ProH {

    public static void main(String[] args){
		FastScanner input = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int t = input.nextInt();
		while(t-- > 0) {
            int n = input.nextInt();
            int k = input.nextInt();
            long num;
            long[] sum = new long[n + 1];
            long[] part = new long[n + 1];
            for(int i = 1; i <= n; i++){
                num = input.nextInt();
                sum[i] = sum[i - 1] + num;
            }
            for(int i = 1; i <= n - k + 1; i++){
                part[i] = sum[i + k - 1] - sum[i - 1];
            }
            long max = Long.MIN_VALUE;
            long ans = Long.MIN_VALUE;
            for(int i = k + 1; i <= n - k + 1; i++){
                max = Math.max(max, part[i - k]);
                ans = Math.max(ans, max + part[i]);
            }
            out.println(ans);
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
