package com.special.test9;

import java.util.Scanner;

/**
 * F-等式
 * 约数个数定理的应用！，还有就是数学里的构造方法！
 *
 * Create by Special on 2018/3/27 13:37
 */
public class ProF {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int T = input.nextInt();
            while(T-- > 0){
                int n = input.nextInt();
                int ans = 1;
                int count = 0;
                for(int i = 2; i * i <= n; i++){
                    count = 0;
                    while(n % i == 0){
                        count++;
                        n /= i;
                    }
                    ans *= 2 * count + 1; //乘以2是因为n * n的质因子种类与n相同，但数量翻倍
                }
                //结束循环时，n可能是质数，也可能所有的质因子被除完，就为1
                //1不是质数，故不符合约数个数定理
                if(n > 1){
                    ans *= 1 * 2 + 1;
                }
                // 约数个数最终肯定为奇数个，因为n是他们最小差值约数，故只算一次，而其他都是以对出现
                System.out.println((ans + 1)/ 2);
            }
        }
    }
}
