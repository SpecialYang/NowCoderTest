package com.special.DongBeiLinYeSpring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Create by Special on 2018/4/11 11:23
 */
public class ProE {

    /**
     * 最优解
     * @param n
     * @return
     */
    static int method1(int n){
        int num = 0;
        while(n != 0){
            num += n / 5;
            n /= 5;
        }
        return num;
    }

    /**
     * 这个会超时
     * @param n
     * @return
     */
    static int method2(int n){
        int num = 0, temp;
        for(int i = 5; i <= n; i += 5){
            temp = i;
            while(temp % 5 == 0){
                num++;
                temp /= 5;
            }
        }
        return num;
    }
    public static void main(String[] args){
		FastScanner input = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int t = input.nextInt();
		while(t-- > 0) {
            int n = input.nextInt();
            out.println(method2(n));
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
