package com.special.SwordMeansOffer;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Special on 2018/6/11 20:00
 */
public class Pro06 {

    public static int minNumberInRotateArray(int [] array) {
        if(array.length == 0) {
            return 0;
        }
        int low = 0;
        int high = array.length;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(array[low] <= array[mid]) {
                low = mid;
            }else {
                high = mid;
            }
        }
        return array[high];
    }

    private static void reverseArray(int start, int end, int[] array) {
        for(int i = start; i <= end; i++) {
            int temp = array[i];
            array[i] = array[end - i];
            array[end - i] = temp;
        }
    }

    public static void revolveArray(int index, int[] array) {
        reverseArray(0, index, array);
        reverseArray(index + 1, array.length - 1, array);
        reverseArray(0, array.length - 1, array);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()) {
            int n = input.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = input.nextInt();
            }
            revolveArray(new Random().nextInt(n), array);
            System.out.println(minNumberInRotateArray(array));
        }
    }
}
