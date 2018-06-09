package com.special.ChangShaLiGong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Special on 2018/4/15 10:56
 */
public class ProGImprove1 {

    static char[][] map;
    static boolean[][] vis;
    static final int MAXN = 500 + 5, MAX = Integer.MAX_VALUE;
    static int sX, sY, n, m, eX, eY;
    static int[][] dis1, dis2, d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static class Node{
        int x, y, t;
        public Node(int x, int y, int t){
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    static boolean isValid(int x, int y){
        return !(x < 0 || x >= n || y < 0 || y >= m);
    }

    static int bfs(int x, int y, int k){
        Queue<Node> q = new LinkedList<>();
        vis = new boolean[MAXN][MAXN];
        q.offer(new Node(x, y, 0));
        vis[x][y] = true;
        while(!q.isEmpty()){
            Node node = q.poll();
            if(k == 0 && map[node.x][node.y] == 'K'){
                dis1[node.x][node.y] = node.t;
            }
            if(k == 1 && map[node.x][node.y] == 'K'){
                dis2[node.x][node.y] = node.t;
            }
            for(int i = 0; i < 4; i++){
                int tX = node.x + d[i][0];
                int tY = node.y + d[i][1];
                if(isValid(tX, tY) && !vis[tX][tY] && map[tX][tY] != '#' && map[tX][tY] != 'E'){
                    vis[tX][tY] = true;
                    q.offer(new Node(tX, tY, node.t + 1));
                }
            }
        }
        return MAX;
    }
    public static void main(String[] args) {
        FastScanner input = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
		int t = input.nextInt();
		while(t-- > 0){
            n = input.nextInt();
            m = input.nextInt();
            map = new char[MAXN][MAXN];
            dis1 = new int[MAXN][MAXN];
            dis2 = new int[MAXN][MAXN];

            for(int i = 0; i < n; i++){
                String str = input.next();
                map[i] = str.toCharArray();
                for(int j = 0; j < m; j++){
                    if(map[i][j] == 'P'){
                        sX = i;
                        sY = j;
                    }else if(map[i][j] == 'E'){
                        eX = i;
                        eY = j;
                    }else if(map[i][j] == 'K'){
                        dis1[i][j] = dis2[i][j] = MAX;
                    }
                }
            }
            bfs(sX, sY, 0);
            bfs(eX, eY, 1);
            int ans = MAX;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(map[i][j] == 'K' && dis1[i][j] != MAX && dis2[i][j] != MAX){
                        ans = Math.min(ans, dis1[i][j] + dis2[i][j]);
                    }
                }
            }
            out.println(ans == MAX ? "No solution" : ans);
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
