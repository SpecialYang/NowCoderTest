package com.special.XiaoBai1;

import java.util.Scanner;

/**
 * E-圆与三角形
 * 三角函数的变换公式
 * tanA/2tanB/2+tanB/2tanC/2+tanC/2tanA/2 = 1
 * 证明需用到tan(x + y) = (tanx + tany) / (1 - tanxtany)
 * Create by Special on 2018/3/28 22:32
 */
public class ProE {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            double r = input.nextDouble();
            System.out.println(String.format("%.2f", r + 1));
        }
    }
}
