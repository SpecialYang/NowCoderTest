package com.special.test14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 *
 * 倍增法
 * Create by Special on 2018/4/6 10:26
 */
public class ProB {
	static int[][] st;

    public static void main(String[] args){
		FastScanner input = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int n = input.nextInt();
		int m = input.nextInt();
		int k = input.nextInt();
		int[] num = new int[n + 1];
		st = new int[n + 3][21];
		for(int i = 1; i <= n; i++){
			num[i] = input.nextInt();
		}
		long sum = 0;
		int id = 0;
		for(int i = 1; i <= n; i++){
			id = Math.max(id, i);
			while(id <= n && sum + num[id] <= k){
				sum += num[id];
				id++;
			}
			if(sum != 0) { sum -= num[i]; }
			st[i][0] = id;
		}
		for(int i = 1; (1 << i) <= n; i++){
			for(int j = 1; j <= n; j++){
				st[j][i] = st[st[j][i - 1]][i - 1];
			}
		}
		while(m-- > 0){
			int l = input.nextInt();
			int r = input.nextInt();
			int ans = 0;
			for(int i = 20; i >= 0; i--){
				if(st[l][i] != 0 && st[l][i] <= r){
					ans += (1 << i);
					l = st[l][i];
				}
			}
			if(l <= r){
				l = st[l][0];
				ans++;
			}
			out.println(l > r ? ans : "Chtholly");
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
