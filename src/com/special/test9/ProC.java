package com.special.test9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Create by Special on 2018/3/26 19:21
 */
public class ProC {

    public static long solve(List<Integer> lists, long avg){
        long[] b = new long[lists.size()];
        b[0] = lists.get(0) - avg;
        for(int i = 1; i < lists.size(); i++){
            b[i] = lists.get(i) + b[i - 1] - avg;
        }
        Arrays.sort(b);
        long mid = b[lists.size() >> 1];
        long result = 0;
        for(int i = 0; i < lists.size(); i++){
            result += Math.abs(b[i] - mid);
        }
        return result;
    }

    public static void main(String[] args) {
        FastScanner input = new FastScanner();

        int n = input.nextInt();
        int k = input.nextInt();
        long sum = 0;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
            sum += a[i];
        }
        if (sum % n != 0) {
            System.out.println("gg");
            return;
        }
        sum /= n;
        if (k >= n - 1) {
            int i;
            for (i = 0; i < n; i++) {
                if (a[i] != sum) {
                    break;
                }
            }
            System.out.println(i < n ? "gg" : 0);
            return;
        }
        boolean[] vis = new boolean[n];
        List<Integer> lists = new ArrayList<>();
        boolean flag = true;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;
            lists.clear();
            int index = i;
            long s = 0;
            do {
                s += a[index];
                lists.add(a[index]);
                vis[index] = true;
                index = (index + k + 1) % n;
            } while (!vis[index]);
            if (s != sum * lists.size()) {
                flag = false;
                break;
            }
            ans += solve(lists, sum);
        }
        System.out.println(flag ? ans : "gg");
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
