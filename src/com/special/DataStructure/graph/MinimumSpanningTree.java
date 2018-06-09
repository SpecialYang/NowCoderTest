package com.special.DataStructure.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 最小生成树
 * Kruskal算法，每次添加一条当前边数集合中最小权值的边，
 * 且边的两个顶点在不同的连通分量，所以对边进行抽象出数据结构。
 *
 * 测试数据：
 * 6 10
0 1 6
0 2 1
0 3 5
1 2 5
1 4 3
2 3 5
2 4 6
2 5 4
3 5 2
4 5 6
 * Create by Special on 2018/3/13 19:50
 */
public class MinimumSpanningTree {

    static final int MAX = Integer.MAX_VALUE;
    static int[] father, rank; // 每个联通分量的根节点
    static char vextex[] = { 'A', 'B', 'C', 'D', 'E', 'F' };//顶点的具名信息

    static class Edge implements Comparable<Edge>{ //抽象出边对象，且可排序
        int start;
        int end;
        int value;

        public Edge(int start, int end, int value){
            this.start = start;
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return this.value - o.value;
        }
    }

    /**
     * 根据连接矩阵，求出所有的边集合中
     * 注意无向图中只存一条边，因为1到2,2到1是一条边
     * @param verteice
     * @param adjecentMatrix
     * @return
     */
    public static List<Edge> convertToArc(int verteice, int[][] adjecentMatrix){
        List<Edge> edges = new ArrayList<>();
        for(int i = 0; i < verteice; i++){
            for(int j = 0; j < i; j++){ //注意内循环终止条件，只存对角线以上或者以下即可
                if(adjecentMatrix[i][j] != MAX){
                    edges.add(new Edge(i, j, adjecentMatrix[i][j]));
                }
            }
        }
        return edges;
    }

    /**
     * 找当前节点的根节点
     * @param x
     * @return
     */
    public static int find(int x){
        if(x != father[x]){
            father[x] = find(father[x]);
        }
        return father[x];
    }

    /**
     * 合并两个联通分量，
     * 使其中一个分量的根节点指向另一个分量的根节点
     * 即要始终把树高小的树高的大，
     * 均衡整棵树，加快查询速速
     * @param x
     * @param y
     */
    public static void union(int x, int y){
        if(rank[x] < rank[y]){
            father[x] = father[y];
        }else if(rank[x] > rank[y]){
            father[y] = father[x];
        }else{
            rank[y]++;
            father[x] = father[y];
        }
    }

    /**
     * Kruskal算法的主体部分
     * @param verteice
     * @param edges
     * @return
     */
    public static int Kruskal(int verteice, List<Edge> edges){
        Collections.sort(edges);
        int count = 0, index = 0, price = 0;
        while(count < verteice - 1){
            Edge edge = edges.get(index++);
            int x = find(edge.start);
            int y = find(edge.end);
            if(x != y){
                System.out.println(vextex[edge.start] + " "
                        + vextex[edge.end] + " " + edge.value);
                price += edge.value;
                union(x, y);
                count++;
            }
        }
        return price;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int verteice = input.nextInt();
            int arcs = input.nextInt();
            int[][] adjecentMatrix = new int[verteice][verteice];
            for(int i = 0; i < verteice; i++){
                for(int j = 0; j < verteice; j++){
                    adjecentMatrix[i][j] = MAX;
                }
            }
            father = new int[verteice];
            rank = new int[verteice];
            for(int i = 0; i < verteice; i++){
                father[i] = i;
                rank[i] = 0;
            }
            int src, drc, value;
            while(arcs-- > 0){
                src = input.nextInt();
                drc = input.nextInt();
                value = input.nextInt();
                adjecentMatrix[src][drc] = Math.min(adjecentMatrix[src][drc], value);
                adjecentMatrix[drc][src] = adjecentMatrix[src][drc];
            }
            List<Edge> edges = convertToArc(verteice, adjecentMatrix);
            System.out.println(Kruskal(verteice, edges));
        }
    }
}
