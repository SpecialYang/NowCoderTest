package com.special.DataStructure.number;

import java.util.Scanner;

/**
 * Create by Special on 2018/4/5 23:25
 */
public class Kangtuo {

    static int[] fac = new int[13];

    static void init(){
        fac[0] = 1;
        for(int i = 1; i < 13; i++){
            fac[i] = fac[i - 1] * i;
        }
    }

    static int kangTuo(int[] perm, int num){
        init();
        int sum = 0;
        for(int i = 0; i < num; i++){
            int count = 0;
            for(int j = i + 1; j < num; j++){
                if(perm[j] < perm[i]){
                    count++;
                }
            }
            sum += count * (fac[num - i - 1]);
        }
        return sum + 1;
    }

    static int[] reverseKangTuo(int num){
        init();
        int n = 0;
        for(int i = 0; i < 13; i++){
            if(fac[i] >= num){
                n = i;
                break;
            }
        }
        int[] perm = new int[n];
        boolean[] vis = new boolean[n + 1];
        int index;
        num--;
        for(int i = 0; i < n; i++){
            int count = num / fac[n - i - 1];
            for(index = 1; index <= n; index++){
                if(!vis[index]){
                    if(count == 0){
                        break;
                    }
                    count--;
                }
            }
            vis[index] = true;
            perm[i] = index;
            num %= fac[n - i - 1];
        }
        return perm;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int num = input.nextInt();
            int[] perm = new int[num];
            for(int i = 0; i < num; i++){
                perm[i] = input.nextInt();
            }
            System.out.println(kangTuo(perm, num));
            num = input.nextInt();
            int[] result = reverseKangTuo(num);
            for(int i = 0; i < 4; i++){
                System.out.print(result[i] + " ");
            }
            System.out.println();
        }
    }
}
