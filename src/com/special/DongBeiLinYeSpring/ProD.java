package com.special.DongBeiLinYeSpring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Create by Special on 2018/4/10 20:10
 */
public class ProD {
    static int startX, startY, endX, endY, n, m;
    static boolean[][] vis;
    static char[][] maps;
    static boolean flag;
    static int[][] steps = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static boolean isValid(int x, int y){
        return !(x < 0 || x >= n || y < 0 || y >= m);
    }

//    static void dfs(int x, int y){
////        if(x == endX && y == endY){
////            flag = true;
////            return;
////        }
////        int tempX, tempY;
////        for(int i = 0; i < 4; i++){
////            tempX = x + steps[i][0];
////            tempY = y + steps[i][1];
////            if(isValid(tempX, tempY) && !vis[tempX][tempY] && maps[tempX][tempY] != 'x'){
////                vis[tempX][tempY] = true;
////                dfs(tempX, tempY);
////                if(flag){
////                    return;
////                }
////            }
////        }
//        if(isValid(x, y) && !vis[x][y] && maps[x][y] != 'x'){
//            if(x == )
//            vis[x][y] = true;
//            dfs(x - 1, y);
//            dfs(x + 1, y);
//            dfs(x, y - 1);
//            dfs(x , y + 1);
//        }
//    }
    static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        vis[x][y] = true;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.x == endX && node.y == endY){
                flag = true;
                break;
            }
            int tempX, tempY;
            for(int i = 0; i < 4; i++){
                tempX = node.x + steps[i][0];
                tempY = node.y + steps[i][1];
                if(isValid(tempX, tempY) && !vis[tempX][tempY] && maps[tempX][tempY] != 'x'){
                    vis[tempX][tempY] = true;
                    queue.offer(new Node(tempX, tempY));
                }
            }
        }
    }
    public static void main(String[] args){
		FastScanner input = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int t = input.nextInt();
		while(t-- > 0) {
            n = input.nextInt();
            m = input.nextInt();
            maps = new char[n][m];
            vis = new boolean[n][m];
            flag = false;
            for(int i = 0; i < n; i++){
                String str = input.next();
                maps[i] = str.toCharArray();
            }
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(maps[i][j] == 's'){
                        startX = i;
                        startY = j;
                    }else if(maps[i][j] == 't'){
                        endX = i;
                        endY = j;
                    }
                }
            }
            bfs(startX, startY);
            out.println(flag ? "YES" : "NO");
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
/*
1
3 5
s...x
xxxxx
...tx
 */