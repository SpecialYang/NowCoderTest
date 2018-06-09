package com.special.test9;

import java.util.Scanner;

/**
 * Create by Special on 2018/3/24 13:19
 */
public class ProA {
    static int[] steps = new int[33];

    public static int getSteps(int n){
        int index = 0;
        while(index < n && steps[index] != 0){
            index++;
        }
        int temp;
        for(; index <= n; index++){
            temp = 0;
            for(int j = 0; j < index; j++){
                temp += steps[j];
            }
            steps[index] = temp;
        }
        return steps[n];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        steps[0] = 1;
        steps[1] = 1;
        while(input.hasNext()){
            int t = input.nextInt();
            while(t-- > 0) {
                int n = input.nextInt();
                System.out.println(steps[n] != 0 ? steps[n] : getSteps(n));
            }
        }
    }
}
