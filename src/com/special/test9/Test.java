package com.special.test9;

import java.io.*;

/**
 * Create by Special on 2018/3/31 12:35
 */
public class Test {

    public static void main(String[] args) throws Exception{
//        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
//        in.nextToken();
//        String s = in.sval;
        out.println(~-3);
        out.flush();
    }
}
