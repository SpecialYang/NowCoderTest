package com.special.test9;

import java.util.Scanner;

/**
 * J-强迫症序列
 *
 * 一开始我用到了排序，因为给n - 1都加1，
 * 要想都相等，那么每次都肯定给最小的n - 1加
 * 但是这样每次都要排序，果然超时了
 *
 * 我们每次都给最小的n - 1加1，显然是为了与最大值的差小1
 * 所以转换思路为，每次给最大值减1，直到与最小值相等
 * 所以步骤数为其他数与最小值的差值的和
 * 然后最终的值为最小值加上步骤数
 *
 * 也可以推公式
 * Create by Special on 2018/3/24 15:22
 */
public class ProJ {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int T = input.nextInt();
            while(T-- > 0){
                int n = input.nextInt();
                int sum = 0, min = Integer.MAX_VALUE, num;
                for(int i = 0; i < n; i++){
                    num = input.nextInt();
                    min = Math.min(min, num);
                    sum += num;
                }
                int steps = sum - n * min;
                int per = min + steps;
                System.out.println(steps + " " + per);
            }
        }
    }
}
