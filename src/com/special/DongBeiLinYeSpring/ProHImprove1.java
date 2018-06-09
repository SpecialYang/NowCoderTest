package com.special.DongBeiLinYeSpring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * 启发式搜索
 * Created by Special on 2018/4/13 22:40
 */
public class ProHImprove1 {

    static int sX, sY, n, k;
    static boolean[][][] vis;
    static char[][] map;
    static int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static class Node implements Comparable<Node>{
        int x, y, step, car;
        public Node(int x, int y, int car){
            this.x = x;
            this.y = y;
            this.car = car;
        }

        @Override
        public int compareTo(Node o) {
            return this.step - o.step;
        }
    }

    static boolean isValid(int x, int y){
        return !(x < 0 || x >= n || y < 0 || y >= n);
    }

    static int bfs(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(sX, sY, 0));
        vis[sX][sY][0] = true;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(node.step > k){
                return Integer.MAX_VALUE;
            }
            if(map[node.x][node.y] == 'X'){
                return node.step;
            }
            for(int i = 0; i < 4; i++){
                int tempX = node.x + d[i][0];
                int tempY = node.y + d[i][1];
                if(isValid(tempX, tempY) && map[tempX][tempY] != 'O'){
                    int car = node.car | (map[tempX][tempY] == 'C' ? 1 : 0);
                    if(vis[tempX][tempY][car]){
                        continue;
                    }
                    Node next = new Node(tempX, tempY, car);
                    /**
                     * 注意我们步数的增长，则是根据上一个节点的状态，而不是本节点。
                     * 上一个没车有车，到本节点步骤为2，或1。
                     */
                    next.step = node.car == 0 ? node.step + 2 : node.step + 1;
                    pq.offer(next);
                    vis[tempX][tempY][car] = true;
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args){
		FastScanner input = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int t = input.nextInt();
		while(t-- > 0) {
            n = input.nextInt();
            k = input.nextInt();
            vis = new boolean[n][n][2];
            map = new char[n][n];

            String line;
            for(int i = 0; i < n; i++){
                line = input.next();
                map[i] = line.toCharArray();
                for(int j = 0; j < n; j++){
                    if(map[i][j] == 'S'){
                        sX = i;
                        sY = j;
                    }
                }
            }
            int ans = bfs();
            if(ans != Integer.MAX_VALUE){
                out.println("YES");
                out.println(ans);
            }else {
                out.println("NO");
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
