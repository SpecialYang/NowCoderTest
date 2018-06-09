package com.special.ChangShaLiGong;

import java.io.*;

/**
 * Created by Special on 2018/4/15 10:18
 */
public class Test {

    public static void main(String[] args) throws Exception {
        FastScanner input = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int t = input.nextInt();
        while(t-- > 0) {
            int a = input.nextInt();
            int b = input.nextInt();
            for(int i = 0; i < a; i++) {
                String str = input.next();
                out.println(a + " " + b + " " + str);
            }
        }
        out.close();
    }
    static class FastScanner{
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        public int nextInt() throws IOException {
            in.nextToken();
            return (int) in.nval;
        }

        public String next() throws IOException {
            in.nextToken();
            return (String) in.sval;
        }
    }
}
