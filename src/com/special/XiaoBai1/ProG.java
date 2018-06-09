package com.special.XiaoBai1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 是时候时候学习一下StreamTokenizer了
 *
 * Create by Special on 2018/3/30 19:57
 */
public class ProG {
    static final int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        FastScanner input = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int n = input.nextInt();
        int row = 4 * n - 3;
        int col = n + n - 1;
        int mid = n - 1;  //中间点
        int[][] value = new int[row][col];
        for(int i = 0; i < row; i++){
            Arrays.fill(value[i], MAX);
        }
        int start = 0, length = 0;
        for(int i = 0; i < row; i++){
            if(i < n - 1){
                length = i + 1;
            }
            else if(i < 3 * n - 2){
                length = ((i - (n - 1)) & 1) == 0 ? n : n - 1;
            }else {
                length = row - i;
            }
            start = mid - length + 1;
            for(int j = 0; j < length; j++){
                int num = input.nextInt();
                int max = MAX;
                if(i == 0){
                    max = num;
                }else {
                    if (i != 0) {
                        if (start != 0 && value[i - 1][start - 1] != MAX) {
                            max = Math.max(max, value[i - 1][start - 1] + num);
                        }
                        if (start != col - 1 && value[i - 1][start + 1] != MAX) {
                            max = Math.max(max, value[i - 1][start + 1] + num);
                        }
                    }
                    if (i >= 2) {
                        if (value[i - 2][start] != MAX) {
                            max = Math.max(max, value[i - 2][start] + num);
                        }
                    }
                }
                value[i][start] = max;
                start += 2;
            }
        }
        out.println(value[row - 1][mid]);
        out.close();
    }

    static class FastScanner{
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