package com.special.test14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * 状压BFS
 * Java竟然超时，我不得不放弃Java啊！
 *
 * Create by Special on 2018/4/6 11:34
 */
public class ProE {

    static final int MAX = Integer.MAX_VALUE;
    static int[] dis;
    static ArrayList<Integer>[] G;
    static BitSet[][] bit;
    static int n;

    static void bfs(int src){
        Queue<Integer> queue = new LinkedList<>();
        dis = new int[n + 1];
        Arrays.fill(dis, MAX);
        queue.offer(src);
        dis[src] = 0;
        bit[src][dis[src]].set(src);
        while(!queue.isEmpty()){
            int v = queue.poll();
            List<Integer> ad = G[v];
            for(int i = 0; i < ad.size(); i++){
                int u = ad.get(i);
                if(dis[u] == MAX) {
                    dis[u] = dis[v] + 1;
                    bit[src][dis[u]].set(u);
                    queue.offer(u);
                }
            }
        }
    }

    public static void main(String[] args){
		FastScanner input = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		n = input.nextInt();
		int m = input.nextInt();
		int q = input.nextInt();
		G = new ArrayList[n + 1];
		bit = new BitSet[n + 1][n + 1];
		for(int i = 0; i <= n; i++){
		    G[i] = new ArrayList<>();
        }
		dis = new int[n + 1];
		for(int i = 0; i <= n; i++){
		    for(int j = 0; j <= n; j++){
		        bit[i][j] = new BitSet(n + 1);
            }
        }
		int src, drc;
		while(m-- > 0){
		    src = input.nextInt();
		    drc = input.nextInt();
            G[src].add(drc);
            G[drc].add(src);
        }
        for(int i = 1;  i <= n; i++){
		    bfs(i);
            for(int j = 1; j <= n; j++){
		        bit[i][j].or(bit[i][j - 1]);
            }
        }
        while(q-- > 0){
            int c = input.nextInt();
            BitSet b = new BitSet(n + 1);
            while(c-- > 0){
                b.or(bit[input.nextInt()][input.nextInt()]);
            }
            out.println(b.cardinality());
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

/**
 * 5 6 6
2 3
1 3
2 5
1 3
3 2
2 5
1
3 1
1
1 1
1
1 4
1
5 2
1
1 4
2
1 0 5 1
 */
