package com.special.ChangShaLiGong;

import java.io.*;
import java.util.*;

/**
 * Created by Special on 2018/4/14 22:43
 */
public class ProEImprove1 {

    static int n, m;
    static ArrayList<Node>[] adj;
    static boolean[] vis;
    static int[] dis;
    static Queue<Integer> queue;
    static final int MAX = Integer.MAX_VALUE;
    static final int MAXN = 200000 + 5; //有个测试用例傻逼了

    static class Node{
        int ver, dis;
        public Node(int ver, int dis){
            this.ver = ver;
            this.dis = dis;
        }
    }

    static int SPFA(){ // 调用这个函数，n就会变为0，咋回事
        dis = new int[n + 1];
        Arrays.fill(dis, MAX);
        vis = new boolean[n + 1];
        queue = new LinkedList<>();
        queue.offer(1);
        vis[1] = true;
        dis[1] = 0;
        while(!queue.isEmpty()){
            int s = queue.poll();
            vis[s] = false;
            for(int i = 0; i < adj[s].size(); i++){
                Node node = adj[s].get(i);
                int e = node.ver;
                int w = node.dis;
                if(dis[s] + w < dis[e]){
                    dis[e] = dis[s] + w;
                    if(!vis[e]){
                        queue.offer(e);
                        vis[e] = true;
                    }
                }
            }
        }
        return dis[n];
    }

    public static void main(String[] args) throws Exception{
        FastScanner input = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
		n = input.nextInt();
		m = input.nextInt();
		adj = new ArrayList[MAXN];

		for(int i = 0; i < MAXN; i++){
		    adj[i] = new ArrayList<>();
        }
		while(m-- > 0){
		    int src = input.nextInt();
		    int drc = input.nextInt();
		    int value = input.nextInt();
		    adj[src].add(new Node(drc, value));
		    adj[drc].add(new Node(src, value));
        }
        long min = SPFA();
		out.println(min == MAX ? "qwb baka" : min);
		out.close();
	}

    static class FastScanner{
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        public int nextInt() throws IOException {
            in.nextToken();
            return (int) in.nval;
        }

        public String next() throws IOException {
            in.nextToken();
            return (String) in.sval;
        }
    }
}
