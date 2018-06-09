package com.special.DongBeiLinYeSpring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * 二分查找！
 *
 * 本来想用treeSet来做，但是treeSet无法做到按索引取K大，很难受。
 * 故采用二分来动态维护列表的有序，从而提取时可做到O(1)
 * Create by Special on 2018/4/11 14:40
 */
public class ProL {

    /**
     * 改进的二分查找
     * 1.若找到key值，则返回其在列表中索引
     * 2.若未找到key值，则返回第一个大于key值的位置
     * @param lists
     * @param key
     * @return
     */
     static int binarySearch(List<Integer> lists, int key){
         int low = 0;
         int high = lists.size() - 1;
         while(low <= high){
             int mid = low + (high - low) / 2;
             int midValue = lists.get(mid);
             if(midValue < key){
                 low = mid + 1;
             }else if(midValue > key){
                 high = mid - 1;
             }else {
                 return mid;
             }
         }
         return low;
     }

     public static void main(String[] args){
		FastScanner input = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int t = input.nextInt();
		while(t-- > 0) {
            int n = input.nextInt();
            int m = input.nextInt();
            List<Integer> lists = new ArrayList<>();
            for(int i = 0; i < n; i++){
                lists.add(input.nextInt());
            }
            Collections.sort(lists);
            while(m-- > 0){
                String cmd = input.next();
                int id = input.nextInt(), index;
                if(cmd.equals("insert")){
                    index = binarySearch(lists, id);
                    lists.add(index, id);
                }else if(cmd.equals("delete")){
                    index = binarySearch(lists, id);
                    lists.remove(index);
                }else {
                    out.println(lists.get(lists.size() - id));
                }
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
