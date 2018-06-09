package com.special.ChangShaLiGong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Special on 2018/4/14 13:38
 */
public class ProA {
    static final String MATCH = "lovelive";

    public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
        while(input.hasNext()){
            String str = input.nextLine().toLowerCase();
            out.println(str.equals(MATCH) ? "yes" : "no");
        }
		out.close();
	}
}
