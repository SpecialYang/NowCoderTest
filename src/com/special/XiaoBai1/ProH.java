package com.special.XiaoBai1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Create by Special on 2018/4/2 14:29
 */
public class ProH {
    static final String TOUES = "FEDCBAGFE";

    public static void main(String[] args){
		Templete2.FastScanner input = new Templete2.FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int n = input.nextInt();
		String[] chars = new String[9];
		for(int i = 0; i < 9; i++) {
            chars[i] = input.next();
        }
        for(int i = 0; i < n; i++){
		    if(chars[0].charAt(i) == '|'){
		        out.print('|');
            }else{
		        for(int j = 0; j < 9; j++){
		            if(chars[j].charAt(i) == 'o'){
		                out.print(TOUES.charAt(j));
                    }
                }
            }
        }
        out.println();
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
