package com.special.test13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * F-m皇后问题
 * Create by Special on 2018/4/3 19:16
 */
public class ProF {

    static class Node{
        int x, y, count;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static class cmp1 implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            if(o1.x != o2.x) return o1.x - o2.x;
            else return o1.y - o2.y;
        }
    }

    public static void main(String[] args){
        FastScanner input = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
        int n = input.nextInt();
        int m = input.nextInt();
        Node[] nodes = new Node[m];
        int length = n + 1;
        boolean[] row = new boolean[length];
        boolean[] col = new boolean[length];
        boolean[] left = new boolean[length << 1];
        boolean[] right = new boolean[length << 1];
        for(int i = 0; i < m; i++){
            nodes[i] = new Node(input.nextInt(), input.nextInt());
        }
        Arrays.sort(nodes, new cmp1());
        for(int i = 0; i < m; i++){
            if(row[nodes[i].x]) nodes[i].count++;
            row[nodes[i].x] = true;
            if(col[nodes[i].y]) nodes[i].count++;
            col[nodes[i].y] = true;
            if(left[nodes[i].x - nodes[i].y + length]) nodes[i].count++;
            left[nodes[i].x - nodes[i].y + length] = true;
            if(right[nodes[i].x + nodes[i].y]) nodes[i].count++;
            right[nodes[i].x + nodes[i].y] = true;
        }
        Arrays.fill(row, false);
        Arrays.fill(col, false);
        Arrays.fill(left, false);
        Arrays.fill(right, false);
        for(int i = m - 1; i >= 0; i--){
            if(row[nodes[i].x]) nodes[i].count++;
            row[nodes[i].x] = true;
            if(col[nodes[i].y]) nodes[i].count++;
            col[nodes[i].y] = true;
            if(left[nodes[i].x - nodes[i].y + length]) nodes[i].count++;
            left[nodes[i].x - nodes[i].y + length] = true;
            if(right[nodes[i].x + nodes[i].y]) nodes[i].count++;
            right[nodes[i].x + nodes[i].y] = true;
        }
        int[] counts = new int[9];
        for(int i = 0; i < m; i++){
            counts[nodes[i].count]++;
        }
        for(int i = 0; i < 9; i++){
            out.print((i == 0 ? "" : " ") + counts[i]);
        }
        out.println();
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
