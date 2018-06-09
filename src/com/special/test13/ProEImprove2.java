package com.special.test13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Create by Special on 2018/4/5 14:22
 */
public class ProEImprove2 {

    static int[] s = {-1, 1};

    public static void main(String[] args){
        FastScanner input = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
        String c = input.next();
        int n = input.nextInt();
        int dis = (c.length() + 1) << 1;
        boolean[][][][] map = new boolean[c.length() + 1][n + 1][dis + 5][2];
        map[0][0][c.length()][1] = true;
        for(int i = 1; i <= c.length(); i++){
            for(int j = 0; j <= n; j++){
                for(int e = 0; e <= j; e++) { // 考虑前i - 1个字符，执行e次的情况
                    for (int k = 1; k <= dis - 1; k++) {
                        for (int d = 0; d < 2; d++) {
                            int t = j - e;
                            if ((t & 1) == 0) {
                                if (c.charAt(i - 1) == 'F') {
                                    map[i][j][k + s[d]][d] |= map[i - 1][e][k][d];
                                } else {
                                    map[i][j][k][d ^ 1] |= map[i - 1][e][k][d];
                                }
                            }else {
                                if (c.charAt(i - 1) == 'F') {
                                    map[i][j][k][d ^ 1] |= map[i - 1][e][k][d];
                                } else {
                                    map[i][j][k + s[d]][d] |= map[i - 1][e][k][d];
                                }
                            }
                        }
                    }
                }
            }
        }
//        for(int i = 0; i <= c.length(); i++){
//            for(int j = 0; j <= n; j++){
//                for (int k = 1; k <= dis - 1; k++) {
//                    for (int d = 0; d < 2; d++) {
//                        if(map[i][j][k][d]){
//                            System.out.println(i + " " + j + " " + k + " " + d);
//                        }
//                    }
//                }
//            }
//        }
        int max = 0;
        for(int i = 0; i < 2; i++){
            for(int j = 0; j <= dis - 1; j++){
                if(map[c.length()][n][j][i]){
                    max = Math.max(max, Math.abs(j - c.length()));
                }
            }
        }
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
