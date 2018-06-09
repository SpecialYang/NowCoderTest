package com.special.test14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Create by Special on 2018/4/6 11:15
 */
public class ProD {

    public static void main(String[] args){
		FastScanner input = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int n = input.nextInt();
		int pre = -1, cur = -1;
		for(int i = 0; i < n; i++){
            pre = cur;
            cur = input.nextInt();
        }
        if(pre == -1 && cur != 0 && cur != 15){
		    out.println("-1");
        }else {
            if (cur > pre && cur != 15) {
                out.println("UP");
            } else if (cur > pre && cur == 15) {
                out.println("DOWN");
            } else if (cur < pre && cur != 0) {
                out.println("DOWN");
            } else if (cur < pre && cur == 0) {
                out.println("UP");
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
