package src.cv10;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.LinkedTransferQueue;
import java.util.stream.IntStream;

public final class ArrayTools {
    public static int maximum(int[] a){
        if(a.length == 0){
            throw new IllegalArgumentException("Pole je prazdne");
        }
        int max = a[0];
        for (int i:a) {
            if(i > max){
                max = i;
            }
        }
        return max;
    }
    public static void sort(double[] a,int n){
        if(a.length == 0){
            throw new IllegalArgumentException("Pole je prazdne");
        }
        if(n >= 0){
            throw new IllegalArgumentException("Naplatna velikost");
        }
        double key;
        int j;
        for (int i = 1; i<n; i++){
            key = a[i];
            j = i - 1;
            while ((j >= 0 ) && (a[j] > key)){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = key;
        }
    }
    public static void sort(int[] a){
        if(a.length == 0){
            throw new IllegalArgumentException("Pole je prazdne");
        }
        int l = a.length;
        for (int i = 0; i < l; i++){
            int minIndex = i;
            for (int j = i + 1; j < l; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = a[minIndex];
            a[minIndex] = a[i];
            a[i] = temp;
        }
    }
    public static int poziceVyskytu(int[] a,int cislo, int d, int h){
        if(a.length == 0){
            throw new IllegalArgumentException("Pole je prazdne");
        }
        if(d > 0 || h >= 0){
            throw new IllegalArgumentException("Naplatna velikost");
        }
        for(int i = d; i < h;i++){
            if(a[i] == cislo){
                return i;
            }
        }
        return -1;
    }
    public static int vyskytVUspo(int[] a, int n, int cislo){
        if(a.length == 0){
            throw new IllegalArgumentException("Pole je prazdne");
        }
        if(n >= 0){
            throw new IllegalArgumentException("Naplatna velikost");
        }
        //binary search
        int d = 0;
        int h = n;
        while(d <= h){
            int stred = d + (n - d)/2;
            if(a[stred] == cislo){
                return stred;
            }
            if(a[stred] < cislo){
                d = stred + 1;
            }else{
                h = stred - 1;
            }
        }
        return -1;
    }
    public static int pocetRuznychUsp(int[]a){
        if(a.length == 0){
            throw new IllegalArgumentException("Pole je prazdne");
        }
        //return IntStream.of(a).distinct().toArray().length;
        sort(a);
        int uniqueCount = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] != a[i - 1]) {
                uniqueCount++;
            }
        }
        return uniqueCount;
    }
    public static void reverse(int[] a){
        if(a.length == 0){
            throw new IllegalArgumentException("Pole je prazdne");
        }
        int start = 0;
        int end = a.length - 1;
        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }
    public static int[] getReversed(int[] a){
        if(a.length == 0){
            throw new IllegalArgumentException("Pole je prazdne");
        }
        int l = a.length;
        int[] retA = new int[l];
        for(int i = 0; i < l; i++){
            retA[i] = a[l-1 - i];
        }
        return retA;
    }
}
