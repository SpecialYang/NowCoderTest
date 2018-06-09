package com.special.DongBeiLinYeSpring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by Special on 2018/4/14 11:24
 */
public class ProJ {

    static final int MAX = Integer.MAX_VALUE;

    public static void main(String[] args){
		FastScanner input = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
        while(input.hasNextLine()){
            int n = input.nextInt();
            int v = input.nextInt();
            int[] D = new int[n + 1];
            int[] W = new int[n + 1];
            int[][][] dp = new int[n + 1][n + 1][2];
            for(int i = 0; i <= n; i++){
                for(int j = 0; j <= n; j++){
                    Arrays.fill(dp[i][j], MAX);
                }
            }
            for(int i = 1; i <= n; i++){
                D[i] = input.nextInt();
                W[i] = W[i - 1] + input.nextInt();
            }
            dp[v][v][0] = dp[v][v][1] = 1;
            for(int i = 1; i <= n; i++){
                for(int j = i + 1; j <= n + 1; j++){

                }
            }

        }
		out.close();
	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner() {
			try	{
				br = new BufferedReader(new InputStreamReader(System.in));
			} catch (Exception e){e.printStackTrace();}
		}

		public boolean hasNextLine(){
            try {
                String read = br.readLine();
                st = new StringTokenizer(read);
                if(read == null){return false;}
            }
			catch (Exception e) {e.printStackTrace();}
            return true;
        }

		public String next() {
			if (st.hasMoreTokens())	return st.nextToken();
			hasNextLine();
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
