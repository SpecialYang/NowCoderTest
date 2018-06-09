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
 * 康托展开与康托逆展开
 * Create by Special on 2018/4/3 9:49
 */
public class ProD {

    static final int MAX = 1000000000;
    static long[] fac = new long[15];
    static int limit;
    static List<Long> lists = new ArrayList<>();

    static void dfs(long num){
        lists.add(num);
        if(num < 1000000000){
            dfs(num * 10 + 4);
            dfs(num * 10 + 7);
        }
    }

    static void init(){
        fac[0] = 1;
        for(int i = 1; i < 15; i++){
            long temp = fac[i - 1] * i;
            fac[i] = temp;
            if(temp > MAX){
                limit = i;
                break;
            }
        }
    }

    static boolean isValid(int num){
        String str = String.valueOf(num);
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != '4' && str.charAt(i) != '7'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        FastScanner input = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		init();
		dfs(0);
        Collections.sort(lists);

        int n = input.nextInt();
        int k = input.nextInt();
        if(n <= limit && k > fac[n]){
            out.println(-1);
        }else{
            int begin = n > limit ? n - limit + 1 : 1;
            int length = Math.min(n, limit);
            int[] nums = new int[length];
            boolean[] vis = new boolean[length];
            k--;
            int div, num;
            //以下为康托逆展开
            for(int i = 0; i < length; i++){
                div = k / (int) fac[length - i - 1];
                for(num = 0; num < length; num++){
                    if(!vis[num]){
                        if(div == 0){
                            break;
                        }
                        div--;
                    }
                }
                vis[num] = true;
                nums[i] = num + begin;
                k %= (int) fac[length - i - 1];
            }
            int sum = 0;
            for(int i = 1; i < lists.size(); i++){
                long item = lists.get(i);
                if(item >= begin){
                    break;
                }
                sum++;
            }
            for(int i = 0; i < length; i++){
                if(isValid(begin + i) && isValid(nums[i])){
                    sum++;
                }
            }
            out.println(sum);
        }
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
