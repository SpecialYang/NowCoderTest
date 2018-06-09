package com.special.test13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Create by Special on 2018/4/5 16:27
 */
public class ProEImprove3 {

    static int[] s = {-1, 1};
    static final int MIN = -1000;
    static final int MAX = 1000;

    public static void main(String[] args){
        FastScanner input = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
        String c = input.next();
        int n = input.nextInt();
        int[][][] dp1 = new int[c.length() + 1][n + 1][2];
        int[][][] dp2 = new int[c.length() + 1][n + 1][2];
        for(int i = 0; i <= c.length(); i++){
            for(int j = 0; j <= n; j++){
                for(int d = 0; d < 2; d++){
                    dp1[i][j][d] = MIN;
                    dp2[i][j][d] = MAX;
                }
            }
        }
        dp1[0][0][1] = dp2[0][0][1] = 0;
        dp1[0][0][0] = dp2[0][0][0] = 0;
        for(int i = 1; i <= c.length(); i++){
            for(int j = 0; j <= n; j++){
                for(int e = 0; e <= j; e++){
                    int t = j - e;
                    if((t & 1) == 0){
                        if(c.charAt(i - 1) == 'F') {
                            dp1[i][j][0] = Math.max(dp1[i - 1][e][0] - 1, dp1[i][j][0]);
                            dp1[i][j][1] = Math.max(dp1[i - 1][e][1] + 1, dp1[i][j][1]);
                            dp2[i][j][0] = Math.min(dp2[i - 1][e][0] - 1, dp2[i][j][0]);
                            dp2[i][j][1] = Math.min(dp2[i - 1][e][1] + 1, dp2[i][j][1]);
                        }else {
                            dp1[i][j][0] = Math.max(dp1[i - 1][e][1], dp1[i][j][0]);
                            dp1[i][j][1] = Math.max(dp1[i - 1][e][0], dp1[i][j][1]);
                            dp2[i][j][0] = Math.min(dp2[i - 1][e][1], dp2[i][j][0]);
                            dp2[i][j][1] = Math.min(dp2[i - 1][e][0], dp2[i][j][1]);
                        }
                    }else{
                        if(c.charAt(i - 1) == 'F') {
                            dp1[i][j][0] = Math.max(dp1[i - 1][e][1], dp1[i][j][0]);
                            dp1[i][j][1] = Math.max(dp1[i - 1][e][0], dp1[i][j][1]);
                            dp2[i][j][0] = Math.min(dp2[i - 1][e][1], dp2[i][j][0]);
                            dp2[i][j][1] = Math.min(dp2[i - 1][e][0], dp2[i][j][1]);
                        }else {
                            dp1[i][j][0] = Math.max(dp1[i - 1][e][0] + 1, dp1[i][j][0]);
                            dp1[i][j][1] = Math.max(dp1[i - 1][e][1] - 1, dp1[i][j][1]);
                            dp2[i][j][0] = Math.min(dp2[i - 1][e][0] - 1, dp2[i][j][0]);
                            dp2[i][j][1] = Math.min(dp2[i - 1][e][1] + 1, dp2[i][j][1]);
                        }
                    }
                }
            }
        }
        int max = 0;
        max = Math.max(Math.abs(dp1[c.length()][n][0]), max);
        max = Math.max(Math.abs(dp1[c.length()][n][1]), max);
        max = Math.max(Math.abs(dp2[c.length()][n][0]), max);
        max = Math.max(Math.abs(dp2[c.length()][n][1]), max);
        out.println(max);
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
