package com.special.test13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * 因为477或者447会出现循环！
 * 故可以提前结束！
 *
 * 多考虑一下单调性！
 * Create by Special on 2018/4/2 17:18
 */
public class ProC {

    public static void main(String[] args){
		FastScanner input = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
        int n = input.nextInt();
        int k = input.nextInt();
        char[] chars = input.next().toCharArray();
//        for(int i = 0; i < chars.length - 1 && k > 0; i++){
//            if(chars[i] == '4' && chars[i + 1] == '7') {
//                if ((i & 1) == 0) {
//                    if (chars[i + 2] == '7') {
//                        k %= 2;
//                    }
//                } else {
//                    if (i != 0 && chars[i - 1] == '4') {
//                        k %= 2;
//                    }
//                }
//                if(k != 0){
//                    if((i & 1) == 0){
//                        chars[i + 1] = '4';
//                    }else {
//                        chars[i] = '7';
//                    }
//                    k--;
//                }
//            }
//        }
        for(int i = 0; i < chars.length && k > 0; i++){
            if(chars[i] == '4' && chars[i + 1] == '7'){
                if((i & 1) == 0){
                    chars[i + 1] = '4';
                    k--;
                }else{
                    if(i != 0 && chars[i - 1] == '4'){
                        k %= 2;
                    }
                    if(k > 0) {
                        chars[i] = '7';
                        k--;
                    }
                }
            }
        }
        out.println(chars);
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
