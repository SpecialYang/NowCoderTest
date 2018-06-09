package com.special.XiaoBai1;

import java.io.*;

/**
 * Create by Special on 2018/3/31 17:15
 */
public class Templete {

    public static void main(String[] args) throws Exception{
        while(in.nextToken() != StreamTokenizer.TT_EOF){

        }
    }



    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    public static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static String next() throws IOException {
        in.nextToken();
        return (String) in.sval;
    }
}
