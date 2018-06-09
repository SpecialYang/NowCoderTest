package com.special.test13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Create by Special on 2018/4/2 15:48
 */
public class ProB {

    static List<Long> lists = new ArrayList<>();

    static void dfs(long num){
        lists.add(num);
        if(num < 4444444444L){
            dfs(num * 10 + 4);
            dfs(num * 10 + 7);
        }
    }

    public static void main(String[] args){
		FastScanner input = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		dfs(0);
        Collections.sort(lists);
        long l = input.nextInt();
        long r = input.nextInt();
        long result = 0;
        int index = 0;
        while(lists.get(index) < l){
            index++;
        }
        for(long i = l; i <= r; i++){
            long num = lists.get(index);
            result += (Math.min(num, r) - i + 1) * num;
            i = num;
            index++;
        }
        out.println(result);
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
