package com.special.test8;

import java.util.Scanner;

/**
 * D-加边的无向图
 * 并查集的典型应用
 * 果然知识是第一生产力啊！！！！
 * Create by Special on 2018/3/13 22:45
 */
public class Pro04 {
    static int[] father, rank;
    static int count;

    public static int find(int x){
        if(x != father[x]){
            father[x] = find(father[x]);
        }
        return father[x];
    }

    public static void union(int x, int y){
        if(rank[x] < rank[y]){
            father[x] = father[y];
        }else if(rank[x] > rank[y]){
            father[y] = father[x];
        }else {
            rank[y]++;
            father[x] = father[y];
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int m = input.nextInt();
            count = n;
            father = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++){
                father[i] = i;
            }
            int x, y;
            while(m-- > 0){
                x = find(input.nextInt() - 1);
                y = find(input.nextInt() - 1);
                if(x != y){
                    union(x, y);
                    count--;
                }
            }
            System.out.println(count - 1);
        }
    }
}
