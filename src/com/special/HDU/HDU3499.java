package com.special.HDU;

import java.util.*;

/**
 * Created by Special on 2018/6/5 10:25
 */
public class HDU3499 {
    static class Node{
        int id;
        int dis;
        public Node(int id, int dis){
            this.id = id;
            this.dis = dis;
        }
    }
    static int n, m, cnt, s, e;
    static Map<String, Integer> indicies;
    static List<Node>[] adj;
    static final long MAX = Long.MAX_VALUE;
    static long[][] dis;

    static void spfa(int s){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i++){
            dis[i][0] = dis[i][1] = MAX;
        }
        queue.offer(s);
        dis[s][0] = dis[s][1] = 0; //关键
        while(!queue.isEmpty()){
            int t = queue.poll();
            vis[t] = false;
            List<Node> nodes = adj[t];
            if(nodes != null){
                for(int i = 0; i < nodes.size(); i++){
                    Node node = nodes.get(i);
                    boolean flag = false;
                    if(dis[node.id][0] > dis[t][0] + node.dis) {
                        flag = true;
                        dis[node.id][0] = dis[t][0] + node.dis;
                    }
                    if(dis[node.id][1] > dis[t][1] + node.dis
                            || dis[node.id][1] > dis[t][0] + node.dis / 2){
                        flag = true;
                        dis[node.id][1] = Math.min(dis[t][1] + node.dis, dis[t][0] + node.dis / 2);
                    }
                    if(flag && !vis[node.id]){
                        vis[node.id] = true;
                        queue.offer(node.id);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            n = input.nextInt();
            m = input.nextInt();
            cnt = 0;
            indicies = new HashMap<>();
            adj = new ArrayList[n];
            dis = new long[n][2];
            for(int i = 0; i < n; i++){
                adj[i] = new ArrayList<>();
            }
            String src, drc;
            while(m-- > 0){
                int dis;
                src = input.next();
                drc = input.next();
                dis = input.nextInt();
                if(!indicies.containsKey(src)){
                    indicies.put(src, cnt++);
                }
                if(!indicies.containsKey(drc)){
                    indicies.put(drc, cnt++);
                }
                adj[indicies.get(src)].add(new Node(indicies.get(drc), dis));
            }
            src = input.next();
            drc = input.next();
            //以下两步也是坑
            if (!indicies.containsKey(src)) {
                indicies.put(src, cnt++);
            }
            if (!indicies.containsKey(drc)) {
                indicies.put(drc, cnt++);
            }
            s = indicies.get(src);
            e = indicies.get(drc);
            spfa(s);
            System.out.println((dis[e][1] == MAX ? -1 : dis[e][1]));
        }
    }
}
