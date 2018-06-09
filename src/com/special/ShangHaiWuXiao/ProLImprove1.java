package com.special.ShangHaiWuXiao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by Special on 2018/4/18 20:17
 */
public class ProLImprove1 {

    public static void main(String[] args){
		FastScanner input = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int n = input.nextInt();
		int k = input.nextInt();
		int[] start = new int[k];
		int sum = 0, num, ans = 0;
		for(int i = 1; i <= n; i++){
		    num = input.nextInt();
		    sum = (sum + num) % k;
		    if(sum != 0 && start[sum] == 0 ){
		        start[sum] = i;
            }else {
		        ans = Math.max(ans, i - start[sum]);
            }
        }
        out.println(ans);
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
