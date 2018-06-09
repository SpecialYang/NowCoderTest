package com.special.ShangHaiWuXiao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by Special on 2018/4/18 23:11
 */
public class ProLImprove2 {

    public static void main(String[] args){
		FastScanner input = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int n = input.nextInt();
		int k = input.nextInt();
		int[] nums = new int[n + 1];
		int[][] dp = new int[2][k + 1];
		for(int i = 1; i <= n; i++){
		    nums[i] = input.nextInt() % k;
        }
        dp[0][nums[1]] = 1;
		int last = 0;
		for(int i = 2; i <= n; i++){
		    last = 1 - last;
		    for(int j = 0; j < k; j++){
		        if(dp[1 - last][j] != 0){
		            dp[last][(j + nums[i]) % k] =
                            Math.max(dp[1 - last][(j + nums[i]) % k], dp[1 - last][j] + 1);
                }else {
		            dp[last][(j + nums[i]) % k] = dp[1 - last][(j + nums[i]) % k];
                }
            }
        }
        out.println(dp[last][0]);
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
