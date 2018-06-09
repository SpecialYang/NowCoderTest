package com.special.POJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * POJ3276
 * 尺取法
 * 维护一个长度为K的翻转次数即可
 * Created by Special on 2018/4/21 23:53
 */
public class POJ3276 {

    public static void main(String[] args){
		FastScanner input = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int n = input.nextInt();
		int[] dir = new int[n];
		int[] flag = new int[n];
		for(int i = 0; i < n; i++){
		    dir[i] = (input.next().equals("F")) ? 0 : 1;//记录是否需要翻转
        }
        int ansK = Integer.MAX_VALUE, ansN = Integer.MAX_VALUE;
		for(int k = 1; k <= n; k++){
			int sum = 0;
			int cnt = 0;
			Arrays.fill(flag, 0);
			for(int i = 0; i <= n - k; i++){
				if(((dir[i] + sum) & 1) == 1){ //需要翻转加上之前的翻转对本位置的影响
					flag[i] = 1;
					sum++;
					cnt++;
				}
				if(i - k + 1 >= 0){//若尺子的长度已达到K，则要去掉尺子第一位的贡献
					sum -= flag[i - k + 1];
				}
			}
			// n - k + 1 到 n之间，因为长度小于k，所以无法翻转，只能靠之前的贡献
			for(int i = n - k + 1; i < n; i++){
				if(((dir[i] + sum) & 1) == 1){ //若不满足朝前，说明之前的翻转不满足
					cnt = -1;
					break;
				}
				if(i - k + 1 >= 0) {sum -= flag[i - k + 1];}
			}
			if(~cnt != 0 && cnt < ansN){
				ansN = cnt;
				ansK = k;
			}
		}
        out.println(ansK + " " + ansN);
        out.close();
	}
	//快速IO
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
