package com.special.ChangShaLiGong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Special on 2018/4/14 13:46
 */
public class ProB {

    static String add(String str1, String str2){
        while(str1.length() < str2.length()){
            str1 = "0" + str1;
        }
        while(str1.length() > str2.length()){
            str2 = "0" + str2;
        }
        char[] result = new char[str1.length()];
        int temp;
        for(int i = str1.length() - 1; i >= 0; i--){
            temp = str1.charAt(i) - '0' + str2.charAt(i) - '0';
            temp %= 10;
            result[i] = (char) (temp + '0');
        }
        int index = 0;
        while(index < str1.length() - 1 && result[index] == '0'){
            index++;
        }
        return new String(result, index, str1.length() - index);
    }
    public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
        while(input.hasNextLine()){
            String str1 = input.next();
            String str2 = input.next();
            out.println(add(str1, str2));
            out.flush();
        }
		out.close();
	}
}
