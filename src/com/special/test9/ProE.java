package com.special.test9;

import java.util.Arrays;
import java.util.Scanner;

/**
 * E-回旋星空
 * 转换角度 + 排列组合
 *
 * 之前我的做法是n的三次方，用的思想是flody算法的思想
 * 最外层是允许的拐点，内2层为起点和终点，枚举了所有的结果
 * 这样复杂度太高了
 *
 * 转化思路：我们只考虑拐点
 * 从拐点出发，求到各个点的距离
 * 之后排序，求出相同的距离的出现的个数，然后大于等于2，即可找到2点构成回旋星空
 * 所以只需对这个数进行求排列即可！
 *
 * 上述也可以不用排序，用计数排序的思想也可以，简直是统计数量的利器！
 * Create by Special on 2018/3/24 15:33
 */
public class ProE {

     static class Node{
         int x;
         int y;
         public Node(int x, int y){
             this.x = x;
             this.y = y;
         }

     }
     public static int distance(Node node1, Node node2){ //求距离
         return (int)(Math.pow(node1.x - node2.x, 2) + Math.pow(node1.y - node2.y, 2));
     }

     public static int queue(int n){   // 求排列
         return n * (n - 1);
     }

     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int T = input.nextInt();
            while(T-- > 0) {
                int n = input.nextInt();
                Node[] nodes = new Node[n];
                for(int i = 0; i < n; i++){
                    nodes[i] = new Node(input.nextInt(), input.nextInt());
                }

                int[] dis = new int[n];
                int ans = 0, count = 0;
                for(int k = 0; k < n; k++) {
                    for (int i = 0; i < n; i++) {
                        dis[i] = distance(nodes[k], nodes[i]);
                    }
                    Arrays.sort(dis);
                    for(int i = 1; i < n; i++){
                        count = 1;
                        while(i < n && dis[i] == dis[i - 1]){
                            count++;
                            i++;
                        }
                        if(count >= 2){
                            ans += queue(count);
                        }
                    }
                }
                System.out.println(ans == 0 ? "WA" : ans);
            }
        }
    }
}
