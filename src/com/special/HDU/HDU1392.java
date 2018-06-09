package com.special.HDU;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


/**
 * Created by Special on 2018/5/18 13:45
 */
public class HDU1392 {

    static class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }

        /**
         * 两点形成一个向量
         * @param node
         * @return
         */
        public Node vector(Node node){
            return new Node(this.x - node.x, this.y - node.y);
        }
    }

    /**
     * 向量积
     * @param o1
     * @param o2
     * @return
     */
    static int crossProduct(Node o1, Node o2){
        return o1.x * o2.y - o1.y * o2.x;
    }

    /**
     * 欧式距离
     * @param o1
     * @param o2
     * @return
     */
    static double distance(Node o1, Node o2){
        return Math.sqrt(Math.pow(o1.x - o2.x, 2) + Math.pow(o1.y - o2.y, 2));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        while(input.hasNext()) {
            n = input.nextInt();
            if (n == 0) {
                break;
            }
            Node[] nodes = new Node[n];
            Node[] emboss = new Node[2 * n];
            for (int i = 0; i < n; i++) {
                nodes[i] = new Node(input.nextInt(), input.nextInt());
            }
            if (n == 2) { //坑爹的题目
                System.out.println(String.format("%.2f", distance(nodes[0], nodes[1])));
            } else {
                Arrays.sort(nodes, new Comparator<Node>() {
                    @Override
                    public int compare(Node o1, Node o2) {
                        if (o1.x != o2.x) {
                            return o1.x - o2.x;
                        } else {
                            return o1.y - o2.y;
                        }
                    }
                });
                int m = 0;
                for (int i = 0; i < n; i++) { //下边界
                    while (m > 1 && (crossProduct(emboss[m - 1].vector(emboss[m - 2]), nodes[i].vector(emboss[m - 2])) < 0)) {
                        m--;
                    }
                    emboss[m++] = nodes[i];
                }
                int k = m;
                for (int i = n - 2; i >= 0; i--) { //上边界
                    while (m > k && (crossProduct(emboss[m - 1].vector(emboss[m - 2]), nodes[i].vector(emboss[m - 2])) < 0)) {
                        m--;
                    }
                    emboss[m++] = nodes[i];
                }
                double sum = 0;
                //注意这里凸包里最后一个已经是第一个点了，所以最后不用单独求最后一点与最开始点的距离
                for (int i = 1; i < m; i++) {
                    sum += distance(emboss[i], emboss[i - 1]);
                }
                System.out.println(String.format("%.2f", sum));
            }
        }
    }
}
