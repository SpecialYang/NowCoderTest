package com.special.test9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 第13届景驰-埃森哲杯K-密码
 * Create by Special on 2018/3/24 16:43
 */
public class ProK {

    /**
     * 超限！
     * @param n
     * @param str
     */
//    public static void method1(int n, String str){
//        int per = n + n - 2;
//        int count = str.length() / per + 1;
//        int col = count * (n - 1);
//        char[][] result = new char[n][col];
//        int index = 0, start = 0, cnt = 0;
//        while(cnt < count){
//            int row = 0;
//            int end = start + n - 1;
//            for(row = 0; row < n && index < str.length(); row++){
//                result[row][start] = str.charAt(index++);
//            }
//            row = row - 2;
//            for(start = start + 1; start < end && index < str.length(); start++){
//                result[row--][start] = str.charAt(index++);
//            }
//            cnt++;
//        }
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < col; j++){
//                if(result[i][j] != 0){
//                    sb.append(result[i][j]);
//                }
//            }
//        }
//        System.out.println(sb.toString());
//    }

    /**
     * 注意边界条件啊！！
     * 就因为没有考虑 n = 1,从而导致了死循环
     *
     * 观察法：
     * 我们发现第一行和最后一行相邻两个字符相隔2 *(n - 1)
     * 其他行交替相隔2 * （n - i - 1), 2 * i
     * 然后我们遍历每一行即可
     * @param n
     * @param str
     */
    public static void method2(int n, String str){
        if(n == 1){
            System.out.println(str);
            return;
        }
        int cur = 0, steps1 = 0, steps2 = 0;
        boolean flag = true;
        for(int i = 0; i < n; i++){
            cur = i;
            flag = true;
            if(i == 0 || i == n - 1){
                steps1 = 2 * (n - 1);
            }else{
                steps1 = 2 * (n - 1 - i);
                steps2 = 2 * i;
            }
            while(cur < str.length()) {
                System.out.print(str.charAt(cur));
                if (i == 0 || i == n - 1) {
                    cur = cur + steps1;
                }else{
                    cur = cur + (flag ? steps1 : steps2);
                    flag = !flag;
                }
            }
        }
        System.out.println();
    }

    /**
     * 转化为二维数组存储（解决超限问题）
     * 思路：仔细观察如何蛇形走位，
     * 模拟走位即可
     * 1.向下，行索引不断加1,当加到最大行时，跳到index-2，且方向变为向上
     * 2.向上，行索引不断减一，当减到-1时，跳到index = 1(index + 2), 且方向变为向下
     * @param n
     * @param str
     */
    public static void method3(int n, String str){
        if(n == 1){
            System.out.println(str);
            return;
        }
        List<Character>[] maps = new ArrayList[n];
        for(int i = 0; i < n; i++){
            maps[i] = new ArrayList<>();
        }
        int index = 0, step = 1;
        for(int i = 0; i < str.length(); i++){
            maps[index].add(str.charAt(i));
            index += step;
            if(index == n){
                index -= 2;
                step = -1;
            }else if(index == -1){
                index = 1;
                step = 1;
            }
        }
        for(int i = 0; i < n; i++){
            for(char item : maps[i]){
                System.out.print(item);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int T = input.nextInt();
            while(T-- > 0){
                int n = input.nextInt();
                String str = input.next();
//                method1(n, str);
//                method2(n, str);
                method3(n, str);
            }
        }
    }
}
