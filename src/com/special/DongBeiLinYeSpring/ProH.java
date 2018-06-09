package com.special.DongBeiLinYeSpring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * 1.不坐车的最短距离
 * 2.走到车，开车到终点的终点
 * Created by Special on 2018/4/13 15:52
 */
public class ProH {

    static int[][] dis1, dis2, d = {{1, 0}, {-1, 0}, {0, 1}, {0, - 1}};
    static boolean[][] vis;
    static char[][] map;
    static int sX, sY, n, k;
    static Queue<Node> q;
    static final int MAX = (int) 1e9 + 1;

    static class Node{
        int x, y, step;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static class X{
        int x, y;
        public X(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static boolean isValid(int x, int y){
        return !(x < 0 || x >= n || y < 0 || y >= n);
    }

    static void bfs(int g){
        while(!q.isEmpty()){
            Node node = q.poll();
            if(map[node.x][node.y] == 'C'){
                if(g == 1) {
                    dis1[node.x][node.y] = node.step;
                }else {
                    dis2[node.x][node.y] = node.step;
                }
            }
            for(int i = 0; i < 4; i++){
                int tempX = node.x + d[i][0];
                int tempY = node.y + d[i][1];
                if(isValid(tempX, tempY) && !vis[tempX][tempY] && map[tempX][tempY] != 'O'){
                    vis[tempX][tempY] = true;
                    Node item = new Node(tempX, tempY);
                    item.step = g == 1 ? node.step + 2 : node.step + 1;
                    if(item.step > k){
                        continue;
                    }
                    q.offer(item);
                }
            }
        }
    }

    static int bfs(Node src){
        q.offer(src);
        while(!q.isEmpty()){
            Node node = q.poll();
            if(map[node.x][node.y] == 'X'){
                return node.step;
            }
            for(int i = 0; i < 4; i++){
                int tempX = node.x + d[i][0];
                int tempY = node.y + d[i][1];
                if(isValid(tempX, tempY) && !vis[tempX][tempY] && map[tempX][tempY] != 'O'){
                    vis[tempX][tempY] = true;
                    Node item = new Node(tempX, tempY);
                    item.step = node.step + 2;
                    if(item.step > k){
                        return MAX;
                    }
                    q.offer(item);
                }
            }
        }
        return MAX;
    }

    public static void main(String[] args){
		FastScanner input = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int t = input.nextInt();
		while(t-- > 0) {
            n = input.nextInt();
            k = input.nextInt();
            dis1 = new int[n][n];
            dis2 = new int[n][n];
            vis = new boolean[n][n];
            map = new char[n][n];
            q = new LinkedList<>();

            List<X> cLists = new ArrayList<>();
            for(int i = 0; i < n; i++){
                String line = input.next();
                map[i] = line.toCharArray();
                for(int j = 0; j < n; j++) {
                    if (map[i][j] == 'S') {
                        sX = i;
                        sY = j;
                    }else if(map[i][j] == 'C'){ //初始距离一定是无穷大的
                        dis1[i][j] = dis2[i][j] = MAX;
                    }else if(map[i][j] == 'X'){ //找出所有的安全区
                        cLists.add(new X(i, j));
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                Arrays.fill(vis[i], false);
            }
            q.clear();
            q.offer(new Node(sX, sY));
            bfs(1);

            for (int j = 0; j < n; j++) {
                    Arrays.fill(vis[j], false);
            }
            q.clear();
            for(int i = 0; i < cLists.size(); i++) {
                X x = cLists.get(i);
                q.offer(new Node(x.x, x.y));
            }
            bfs(2);
            for (int i = 0; i < n; i++) {
                Arrays.fill(vis[i], false);
            }
            q.clear();
            int ans = bfs(new Node(sX, sY));
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++) {
                    if (map[i][j] == 'C' && (!(dis1[i][j] == MAX || dis2[i][j] == MAX))) {
                        ans = Math.min(ans, dis1[i][j] + dis2[i][j]);
                    }
                }
            }
            if(ans <= k){
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
