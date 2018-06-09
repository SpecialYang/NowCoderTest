package com.special.test9;

import java.util.Scanner;

/**
 * 旋转矩阵
 *
 * 最优解为统一转换为一个处理方式，一种很好的思想
 * Create by Special on 2018/3/24 16:01
 */
public class ProG {
    static int row, col;

    /**
     * 我的方法，就是普通的模拟即可，注意行列的互换
     * @param chars
     * @param cmd
     * @param n
     * @param m
     * @return
     */
    public static char[][] change(char[][] chars, String cmd, int n, int m){
        char[][] result;
        for(int k = 0; k < cmd.length(); k++){
            char c = cmd.charAt(k);
            row = m;
            col = n;
            if(c == 'L'){
                result = new char[row][col];
                for(int i = 0; i < row; i++){
                    for(int j = 0; j < col; j++){
                        char temp = chars[j][m - 1 - i];
                        if(temp == '-'){
                            temp = '|';
                        }else if(temp == '|'){
                            temp = '-';
                        }
                        result[i][j] = temp;
                    }
                }
            }else {
                result = new char[m][n];
                for(int i = 0; i < row; i++){
                    for(int j = 0; j < col; j++){
                        char temp = chars[n - 1 - j][i];
                        if(temp == '-'){
                            temp = '|';
                        }else if(temp == '|'){
                            temp = '-';
                        }
                        result[i][j] = temp;
                    }
                }
            }
            chars = result;
            int t = n;
            n = m;
            m = t;
        }
        return chars;
    }

    /**
     * 因为左旋一次等于右旋3次，所以可以统一定义为右旋
     * 我们定义当为R, 旋转次数加1，为L，旋转次数加3
     * 又因为每四次一个循环，所以对4取模即可，巧妙！
     *
     * 下面的row, col记录当前的行和列
     * @param chars
     * @param n
     * @param m
     * @param count
     * @return
     */
    public static char[][] change2(char[][] chars, int n, int m, int count){
        char[][] result;
        for(int k = 0; k < count; k++){
            row = m;
            col = n;
            result = new char[row][col];
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    char temp = chars[n - 1 - j][i];
                    if(temp == '-'){
                        temp = '|';
                    }else if(temp == '|'){
                        temp = '-';
                    }
                    result[i][j] = temp;
                }
            }
            int temp = n;
            n = m;
            m = temp;
            chars = result;
        }
        return chars;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int T = input.nextInt();
            while(T-- > 0){
                int n = input.nextInt();
                int m = input.nextInt();
                row = n;
                col = m; //注意给出初始值，防止当不用旋转时，报错！
                char[][] chars = new char[n][m];
                for(int i = 0; i < n; i++){
                    String strs = input.next();
                    for(int j = 0; j < m; j++){
                        chars[i][j] = strs.charAt(j);
                    }
                }
                String cmd = input.next();
                int count = 0;
                for(int i = 0; i < cmd.length(); i++){
                    count += cmd.charAt(i) == 'R' ? 1 : 3;
                }
                count %= 4;
//                chars = change(chars, cmd, n, m);
                chars = change2(chars, n, m, count);
                System.out.println(row + " " + col);
                for(int i = 0; i < row; i++){
                    for(int j = 0; j < col; j++){
                        System.out.print(chars[i][j]);
                    }
                    System.out.println();
                }
                System.out.println();
            }
        }
    }
}
