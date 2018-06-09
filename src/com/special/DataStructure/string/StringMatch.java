package com.special.DataStructure.string;

import java.util.Scanner;

/**
 * 字符串匹配算法
 * 1.暴力算法
 * 2.KMP算法
 * 最重要的是理解这个KMP算法的核心思路：
 * 在暴力算法中，我们每次失配（匹配失败）的时候都会将i(原串的索引）和 j(模式串的索引）回溯为0
 * 但是实际中，我们在失配的不必回溯i,而只需把模式串向右移动几位，或者说将j变小，充分利用之前
 * 已经匹配的字符串的继续进行模式匹配。这样既可以减少不必要的匹配，而且速度又快。
 * 那么问题来了，我们怎么充分利用之前已经匹配的字符串呢，这里就要用到了next数组
 * next数组索引j对应的值为当j对应的字符失配的时候，j的值下一步应该跳到哪继续做比较
 * 或者说应该将模式串向右移动j - next[j]后，继续匹配。
 * 也就是说：
 * 我们可以发现如果当前字符失配，字符如果要想充分利用之前的已经匹配的字符，
 * 显示只要我们找出这个字符之前的字符串的最大的相同前缀和后缀长度即可。
 * 然后我们向将当前索引跳到以这个长度值作为索引的地方，然后继续匹配，因为我们根据相同的前缀和后缀
 * 确定了模式串的前next[j]个已经匹配了，无需继续比较。
 *
 *
 * 问题来了怎么求next数组呢？求next数组思想还是跟KMP的思想是一致的
 * 就是模式串不断与自身做匹配。
 * 我们知道了next[j]的值为字符串前j个的最大相同的前缀和后缀的长度
 * 我们这样求next[j]的值，其中k表示已经匹配的长度
 * 如果我们知道了next[j]的值，那么如果求next[j + 1]
 * 1.k == -1 或者 如果字符串的k的位置和j的位置对应的字符相同，那么next[j + 1] = k + 1;
 * 2.不相等，另k = next[k], 继续第一步，直到找到一个字符和最后一个字符相同或者k = -1结束
 * 这里的意思若果k的位置对应的字符与j的字符失配，那么k就要跳到已经匹配的最大前缀和后缀长度的下一个位置
 * 继续进行匹配判断，这里就是kMP的思想。充分利用之前已经匹配的子字符串的信息
 * Create by Special on 2018/3/8 21:13
 */
public class StringMatch {

    public static int[] getNext(String pattern){
        int[] next = new int[pattern.length()];
        int index = 0, k = -1;
        next[index] = k;
        while(index < pattern.length() - 1){
            if(k == -1 || pattern.charAt(k) == pattern.charAt(index)){
                k++;
                index++;
                next[index] = k;
            }else {
                k = next[k];
            }
        }
        return next;
    }

    public static int KMP(String text, String pattern){
        int[] next = getNext(pattern);
        int indexT = 0, indexP = 0;
        while (indexT < text.length() && indexP < pattern.length()){
            if(indexP == -1 || text.charAt(indexT) == pattern.charAt(indexP)){
                indexT++;
                indexP++;
            }else{
                indexP = next[indexP];
            }
        }
        if(indexP == pattern.length()){
            return indexT - pattern.length();
        }
        return -1;
    }

    public static int violentStringMatch(String text, String pattern){
        int indexT = 0, indexP = 0;
//        for(int i = 0; i <= text.length() - pattern.length(); i++){
////            indexT = i;
////            for(indexP = 0; indexP < pattern.length()
////                    && text.charAt(indexT++) == pattern.charAt(indexP); indexP++);
////            if(indexP == pattern.length()){
////                return i;
////            }
////        }
        while(indexT < text.length() && indexP < pattern.length()){
            if(text.charAt(indexT) == pattern.charAt(indexP)){
                indexT++;
                indexP++;
            }else{
                indexT = indexT - (indexP - 1);
                indexP = 0;
            }
        }
        if(indexP == pattern.length()){
            return indexT - pattern.length();
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            String text = input.nextLine();
            String pattern = input.nextLine();
            System.out.println(violentStringMatch(text, pattern));
            System.out.println(KMP(text, pattern));
        }
    }
}
