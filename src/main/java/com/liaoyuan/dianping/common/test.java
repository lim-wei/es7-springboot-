package com.liaoyuan.dianping.common;

/**
 * Created by limw on 2020/3/16.
 */
public class test {
    public static int searchPositionBySortingOrdinal (int[] array) {
        // write code here
        int n = array.length;
        int[] copy = array;
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                if(array[j]>array[i]){
                    int k = array[j];
                    array[j]=array[i];
                    array[i]=k;
                }
            }
        }
        for (int i=0;i<n;i++){
            System.out.println(array[i]);
        }
        return 1;
    }

    public static void main(String[] args) {
        int[] array = new int[10];
        int n = searchPositionBySortingOrdinal(array);
    }
}
