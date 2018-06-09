package com.special.XiaoBai1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Create by Special on 2018/3/31 20:00
 */
public class ProJ {
    static final int SIZE = 3;
    public static void main(String[] args){
		FastScanner input = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
        Map<String, String> maps = new HashMap<>();
        String v1, v2;
        for(int i = 0; i < SIZE; i++){
            v1 = input.next();
            v2 = input.next();
            maps.put(v2, v1);
        }
        int n = input.nextInt();
        while(n-- > 0){
            v2 = input.next();
            if(!maps.containsKey(v2)){
                out.println("Fake");
            }else {
                out.println(maps.get(v2));
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
