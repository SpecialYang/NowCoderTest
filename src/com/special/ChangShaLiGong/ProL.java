package com.special.ChangShaLiGong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by Special on 2018/4/14 14:08
 */
public class ProL {

    public static void main(String[] args){
		FastScanner input = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int t = input.nextInt();
		while(t-- > 0) {
            int a = input.nextInt();
            int b = input.nextInt();
            int n = input.nextInt();
            int total = a + b * 2;
            int num = 0, even = 0, sum = 0;
            for(int i = 0; i < n; i++){
                num = input.nextInt();
                even += num / 2;
                sum += num;
            }
            boolean flag = true;
            if(sum > total){
                flag = false;
            }else {
                b = b - even;
                if(b <= 0) {
                    a += b * 2;
                    if (a < 0 || sum - even * 2 > a) {
                        flag = false;
                    }
                }else {
                    sum -= even * 2;
                    a += b;
                    if(sum > a){
                        flag = false;
                    }
                }
            }
            out.println(flag ? "Yes" : "No");
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
