package com.special.test13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * Create by Special on 2018/4/2 15:07
 */
public class ProA {

//    static String trimZero(String str){
//        int begin = 0, end = str.length() - 1;
//        while(begin < str.length() && str.charAt(begin) == '0'){
//            begin++;
//        }
//        while(end >= 0 && !isValid(str.charAt(end))){
//            end--;
//        }
//        return begin > end ? "" : str.substring(begin, end + 1);
//    }

    static boolean isValid(char ch){
        return ch == '4' || ch == '7';
    }

    public static void main(String[] args){
		FastScanner input = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
        String str = input.next();
        int four = 0, seven = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '4'){
                four++;
            }else if(str.charAt(i) == '7'){
                seven++;
            }
        }
        if(four == 0 && seven == 0) {
            out.println(-1);
        }else{
            out.println(four >= seven ? 4 : 7);
        }
//        Map<String, Integer> maps = new HashMap<>();
//        str = trimZero(str);
//        if(str.length() == 0){
//            out.println(-1);
//        }else {
//            int max = 0, count;
//            for (int i = 0; i < str.length(); i++) {
//                if (isValid(str.charAt(i))) {
//                    for (int j = i + 1; j <= str.length(); j++) {
//                        if (!isValid(str.charAt(j - 1))) {
//                            break;
//                        }
//                        String temp = str.substring(i, j);
//                        if (maps.get(temp) == null) {
//                            count = 1;
//                            maps.put(temp, count);
//                        } else {
//                            count = maps.get(temp) + 1;
//                            maps.put(temp, count);
//                        }
//                        max = Math.max(max, count);
//                    }
//                }
//            }
//            List<String> lists = new ArrayList<>();
//            for (String item : maps.keySet()) {
//                if (maps.get(item) == max) {
//                    lists.add(item);
//                }
//            }
//            Collections.sort(lists);
//            out.println(lists.get(0));
//        }
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
