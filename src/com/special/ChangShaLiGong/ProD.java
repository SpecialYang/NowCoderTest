package com.special.ChangShaLiGong;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 素数 + 合数 的结合应用
 *
 * Created by Special on 2018/4/20 14:16
 */
public class ProD {

    static final int MAX = (int) 1e6 + 10;
    static boolean[] vis = new boolean[MAX];
    static List<Integer> primes = new ArrayList<>();

    static void init(){
        vis[0] = true;
        vis[1] = true;
        for(int i = 2; i < MAX; i++){
            if(!vis[i]){
                for(int j = i + i; j < MAX; j += i){
                    vis[j] = true;
                }
            }
        }
        for(int i = 0; i < MAX; i++){
            if(!vis[i]){
                primes.add(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        init();
        while(input.hasNext()){
            int l = input.nextInt();
            int r = input.nextInt();
            int count = 0;
            for(int j = 0; j < primes.size(); j++){
                int temp = r / primes.get(j);
                if(l <= temp){
                    count += temp - l + 1;
                }else {
                    break;
                }
            }
            out.println(count);
            out.flush();
        }
        out.close();
    }
}
