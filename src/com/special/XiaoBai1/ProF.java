package com.special.XiaoBai1;

import java.util.Scanner;

/**
 * Create by Special on 2018/3/29 9:31
 */
public class ProF {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int X = input.nextInt();
            int Y = input.nextInt();
            int Z = input.nextInt();
            int n = input.nextInt();
            boolean[][] main = new boolean[Y + 1][X + 1];
            boolean[][] left = new boolean[Y + 1][Z + 1];
            boolean[][] below = new boolean[Z + 1][X + 1];
            for(int i = 0; i < n; i++){
                int x = input.nextInt();
                int y = input.nextInt();
                int z = input.nextInt();
                main[y][x] = left[y][z] = below[z][x] = true;
            }
            // 频繁使用输出会导致超时，我们可以用字符缓冲器！
            StringBuilder sb = new StringBuilder();
            for(int i = Y; i > 0; i--){
                for(int j = 1; j <= X; j++){
                    sb.append(main[i][j] ? "x" : ".");
                }
                sb.append(" ");
                for(int j = 1; j <= Z; j++){
                    sb.append(left[i][j] ? "x" : ".");
                }
                sb.append("\n");
            }
            sb.append("\n");
            for(int i = 1; i <= Z; i++){
                for(int j = 1; j <= X; j++){
                    sb.append(below[i][j] ? "x" : ".");
                }
                sb.append("\n");
            }
            System.out.print(sb.toString());
        }
    }
}
