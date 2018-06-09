package com.special.ChangShaLiGong;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 不能用st,因为.会被识别为数字。Java的IO真傻逼
 *
 * 一遍bfs，只不过有2种方式，互不影响
 * c++ 200ms, Java超时。
 * 另一种两边BFS, Java可过，但C++确600ms, 怪哉！
 * Created by Special on 2018/4/15 9:49
 */
public class ProG {

    static char[][] map;
    static boolean[][][] vis;
    static final int MAXN = 500 + 5, MAX = Integer.MAX_VALUE;
    static int sX, sY, n, m;
    static int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static class Node{
        int x, y, t, key;
        public Node(int x, int y, int key){
            this.x = x;
            this.y = y;
            this.key = key;
        }
    }

    static boolean isValid(int x, int y){
        return !(x < 0 || x >= n || y < 0 || y >= m);
    }

    static int bfs(){
        Queue<Node> q = new LinkedList<>();
        vis = new boolean[MAXN][MAXN][2];
        q.offer(new Node(sX, sY, 0));
        vis[sX][sY][0] = true;
        while(!q.isEmpty()){
            Node node = q.poll();
            if(map[node.x][node.y] == 'E'){
                return node.t;
            }
            for(int i = 0; i < 4; i++){
                int tX = node.x + d[i][0];
                int tY = node.y + d[i][1];
                if(isValid(tX, tY) && map[tX][tY] != '#'){
                    int key = node.key;
                    if(map[tX][tY] == 'K'){
                        key = 1;
                    }
                    if(vis[tX][tY][key] || (map[tX][tY] == 'E' && node.key == 0)){
                        continue;
                    }
                    Node p = new Node(tX, tY, key);
                    p.t = node.t + 1;
                    vis[tX][tY][key] = true;
                    q.offer(p);
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
            for(int i = 0; i < n; i++){
                String str = input.next();
                map[i] = str.toCharArray();
                for(int j = 0; j < m; j++){
                    if(map[i][j] == 'P'){
                        sX = i;
                        sY = j;
                    }
                }
            }
            int ans = bfs();
            out.println(ans == MAX ? "No solution" : ans);
        }
		out.close();
	}

    /**
     * 3
5 5
....P
##..E
K#...
##...
.....
5 5
P....
.....
..E..
.....
....K
5 5
P#..E
.#.#.
.#.#.
.#.#.
...#K
     */
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
