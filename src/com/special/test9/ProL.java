package com.special.test9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 第13届景驰-埃森哲杯L-用来作弊的药水
 * 比较两个x的a的幂结果是否与y的b的幂结果相同
 * 我的思路是两边求对数，平滑一下
 * 但是这样就出现精度问题了
 * 不知道为什么Java的做法小于0.1就要默认是相等，不知道测试数据集怎么样
 *
 * 下面又给出2种解法
 * Create by Special on 2018/3/24 15:05
 */
public class ProL {
    static final int MOD = (int) 1e9 + 7;

    public static void caculate(List<Integer> prime, List<Integer> count, int num){
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                int tot = 0;
                prime.add(i);
                while(num % i == 0){
                    num /= i;
                    tot++;
                }
                count.add(tot);
            }
        }
        if(num > 1){
            prime.add(num);
            count.add(1);
        }
    }

    /**
     * 求出底数的质因子集合，并存放每个质因子的个数
     * 之后我们比较每个质因子的个数与指数的乘积是否与另一个一样，即可
     * 原理:任何一个数都可以分解为质因子的乘积
     * 若一个数的幂与令一个数相等，那么他们的质因子必然一样
     * 且个数也一样！！
     * @param x
     * @param a
     * @param y
     * @param b
     * @return
     */
    public static boolean method2(int x, int a, int y, int b){
        List<Integer> prime1 = new ArrayList<>();
        List<Integer> count1 = new ArrayList<>();
        List<Integer> prime2 = new ArrayList<>();
        List<Integer> count2 = new ArrayList<>();
        caculate(prime1, count1, x);
        caculate(prime2, count2, y);
        if(prime1.size() != prime2.size() || count1.size() != count2.size()){
            return false;
        }else{
            for(int i = 0; i < prime1.size(); i++){
                if(prime1.get(i) != prime2.get(i)
                        || 1L * count1.get(i) * a != 1L * count2.get(i) * b){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int T = input.nextInt();
            while(T-- > 0){
                int x = input.nextInt();
                int a = input.nextInt();
                int y = input.nextInt();
                int b = input.nextInt();
//                double life = a * Math.log10(x);
//                double energy = b * Math.log10(y);
//                System.out.println(Math.abs(life - energy) < 0.1 ? "Yes" : "No");
//                System.out.println(method2(x, a, y, b) ? "Yes" : "No");
                System.out.println(method3(x, a, y, b) ? "Yes" : "No");
            }
        }
    }


    /**
     * 快速幂取模（取模的原因，结果会非常大）
     * 能ac的原因是，发生的碰撞的几率特别小，
     * orz.....又掌握了一个巧妙的做法
     * @param x
     * @param a
     * @param y
     * @param b
     * @return
     */
    public static boolean method3(int x, int a, int y, int b){
        return powMod(x, a, MOD) == powMod(y, b, MOD);
    }

    public static long powMod(int n, int m, int MOD){
        long result = 1;
        long digit = n;
        while(m != 0){
            if((m & 1) == 1){
                result = result * digit % MOD;
            }
            m >>= 1;
            digit = digit * digit % MOD;
        }
        return result;
    }
}

/**
 * 4
2 20 4 10
20 20 20 20
20 21 21 20
32768 32768 1048576 24576
 */
