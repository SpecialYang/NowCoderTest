package com.special.test9;
import java.util.Scanner;

/**
 * Create by Special on 2018/3/24 13:43
 */
public class ProB {

    static class Node{
        int father;
        char value;
        int steps;

        public Node(int father, char value, int steps){
            this.father = father;
            this.value = value;
            this.steps = steps;
        }

    }

    public static String getPath(int u, Node[] nodes, int t){
        StringBuilder sb = new StringBuilder();
        do{
            char value = nodes[u].value;
            value = (char)('a' + (value - 'a' + t * nodes[u].steps) % 26);
            sb.append(value);
            u = nodes[u].father;
        } while(u != 1 && u != 0);
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int T = input.nextInt();
            while(T-- > 0){
                int n = input.nextInt();
                Node[] nodes = new Node[n + 1];
                for(int i = 2; i <= n; i++){
                    nodes[i] = new Node(input.nextInt(), input.next().charAt(0), input.nextInt());
                }
                int q = input.nextInt();
                while(q-- > 0){
                    int u = input.nextInt();
                    int v = input.nextInt();
                    int t = input.nextInt();
                    String str1 = getPath(u, nodes, t);
                    String str2 = getPath(v, nodes, t);
                    if(str1.compareTo(str2) < 0){
                        System.out.println("<");
                    }else if(str1.compareTo(str2) > 0){
                        System.out.println(">");
                    }else{
                        System.out.println("=");
                    }
                }
            }
        }
    }
}
