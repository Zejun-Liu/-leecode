package com.jiuxian;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: liuzejun
 * *
 * @email: 857591294@qq.com
 * *
 * @date: 2019-07-03 08:54:08
 * *
 * @description: 常用算法
 **/
public class ArithmeticTest {

    /**
     * 冒泡排序
     */
    @Test
    public void bubblingSort() {
        int[] array = { 8, 2, 5, 9, 7 };
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * 选择排序
     */
    @Test
    public void chooseSort() {
        int[] array = { 8, 2, 5, 9, 7 };
        for (int i = 0; i < array.length; i++) {
            int max = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[max]) {
                    max = j;
                }
            }

            int temp = array[i];
            array[i] = array[max];
            array[max] = temp;
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * 插入排序
     */
    @Test
    public void insertSort() {
        int[] array = { 8, 2, 5, 9, 7 };
        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (value > array[j]) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = value;
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * 希尔排序
     * TODO 不太懂
     */
    @Test
    public void shellSort() {
        int[] array = { 8, 2, 5, 9, 7, 10, 1, 15, 12, 3 };
        int length = array.length;
        int gap = 1;
        while (gap < length) {
            gap = gap * 3 + 1;
        }
        System.out.println(gap);
        while (gap > 0) {
            for (int i = gap; i < length; i++) {
                int tmp = array[i];
                int j = i - gap;
                while (j >= 0 && array[j] > tmp) {
                    array[j + gap] = array[j];
                    j -= gap;
                }
                array[j + gap] = tmp;
            }
            gap = gap / 3;
        }
        System.out.println(Arrays.toString(array));
    }


    /**
     * 归并排序
     */
    @Test
    public void mergeSort() {
        int[] array = { 8, 2, 5, 0, 7, 4, 6, 1 };
        int[] tempArr = new int[array.length];
        sort(array, tempArr, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private void sort(int[] arr, int[] tempArr, int startIndex, int endIndex) {
        if (endIndex <= startIndex) {
            return;
        }
        //中部下标
        int middleIndex = startIndex + (endIndex - startIndex) / 2;

        //分解
        sort(arr, tempArr, startIndex, middleIndex);
        sort(arr, tempArr, middleIndex + 1, endIndex);

        //归并
        merge(arr, tempArr, startIndex, middleIndex, endIndex);
    }

    private void merge(int[] arr, int[] tempArr, int startIndex, int middleIndex, int endIndex) {
        //复制要合并的数据
        System.arraycopy(arr, startIndex, tempArr, startIndex, endIndex - startIndex + 1);
        //左边首位下标
        int left = startIndex;
        //右边首位下标
        int right = middleIndex + 1;
        for (int k = startIndex; k <= endIndex; k++) {
            if (left > middleIndex) {
                //如果左边的首位下标大于中部下标，证明左边的数据已经排完了。
                arr[k] = tempArr[right++];
            } else if (right > endIndex) {
                //如果右边的首位下标大于了数组长度，证明右边的数据已经排完了。
                arr[k] = tempArr[left++];
            } else if (tempArr[right] < tempArr[left]) {
                //将右边的首位排入，然后右边的下标指针+1。
                arr[k] = tempArr[right++];
            } else {
                //将左边的首位排入，然后左边的下标指针+1。
                arr[k] = tempArr[left++];
            }
        }
    }


}
