package com.special.ChangShaLiGong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by Special on 2018/4/14 14:58
 */
public class ProE {

    static ArrayList<Node>[] G;
    static final int MAX = Integer.MAX_VALUE;

    static class Node{
        int ver;
        int dis;

        public Node(int ver, int dis){
            this.ver = ver;
            this.dis = dis;
        }
    }

    static long minDis(int n){
        PriorityQueue<Node> p = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.dis - o2.dis;
            }
        });
        boolean[] vis = new boolean[n + 1];
        for(int i = 0; i < G[1].size(); i++){
            Node node = G[1].get(i);
            p.offer(new Node(node.ver, node.dis));
        }
        vis[1] = true;
        int temp = n - 1;
        while(temp-- > 0){
            Node node = p.poll();
            if(node == null){
                return MAX;
            }
            int index = node.ver;
            if(index == n){
                return node.dis;
            }
            vis[index] = true;
            for(int j = 0; j < G[index].size(); j++){
                Node adj = G[index].get(j);
                if(!vis[adj.ver]){
                    p.offer(new Node(adj.ver,node.dis + adj.dis));
                }
            }
        }
        return MAX;
    }

    public static void main(String[] args){
		FastScanner input = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int n = input.nextInt();
		int m = input.nextInt();
		G = new ArrayList[n + 1];
		for(int i = 0; i <= n; i++){
		    G[i] = new ArrayList<>();
        }
		while(m-- > 0){
		    int src = input.nextInt();
		    int drc = input.nextInt();
		    int value = input.nextInt();
		    G[src].add(new Node(drc, value));
		    G[drc].add(new Node(src, value));
        }
        long min = minDis(n);
		out.println(min == MAX ? "qwb baka" : min);
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
