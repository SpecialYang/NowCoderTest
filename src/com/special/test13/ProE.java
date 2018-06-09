package com.special.test13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Create by Special on 2018/4/4 16:09
 */
public class ProE {

     static boolean[][][][] maps;
     static String c;
     static int n, max;

     static void dfs(int index, int n, int pos, int d){
         int f = d == 1 ? 1 : 0;
         //次数用完，直接返回即可，没有考察完全部字符串，次数就用完了，没法知道全局结果
         if(n < 0){
             return;
         }
         if(index == c.length()){ //考察完了全部字符串
             /**
              * 因为如果到末尾了，还有奇数次更改次数，不能直接求当前最大值
              * 因为实际的更改次数全部用完，一定与当前的状态不一致
              * 比如末尾为FFF,如果当前的次数还有3次，直接求最大值的话，是3
              * 而实际3次更改用完，末尾会变为T, 最大值为2
              * 末尾奇数次可以的情况可以由末尾改变一次得到或者末尾不变得到
              */
             if(n == 0) {
                 max = Math.max(max, Math.abs(pos - c.length()));
             }
             return;
         }
         if(maps[index][n][pos][f]){ //当前状态已考察过，不必再考察了
             return;
         }
         maps[index][n][pos][f] = true;  //记录当前状态
         if(c.charAt(index) == 'F'){
             dfs(index + 1, n - 1, pos, -d); //改变
             dfs(index + 1, n, pos + d, d); //不改变
         }else {
             dfs(index + 1, n - 1, pos + d, d); //改变
             dfs(index + 1, n, pos, -d); //不改变
         }
     }
     public static void main(String[] args){
        FastScanner input = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
        c = input.next();
        n = input.nextInt();
        max = 0;
        maps = new boolean[c.length()][n + 1][(c.length() + 1) << 1][2];
        dfs(0, n, c.length(), 1);
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
