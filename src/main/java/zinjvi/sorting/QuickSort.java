package zinjvi.sorting;

import java.util.Arrays;

public class QuickSort {

    public void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivotIndex = partition(a, start, end);
        sort(a, start, pivotIndex - 1);
        sort(a, pivotIndex + 1, end);
    }

    private int partition(int[] a, int start, int end) {
        int pivotValue = a[end];
        int pivotIndex = start;
        for (int i = start; i < end; i++) {
            if(a[i] < pivotValue) {
                swap(a, i, pivotIndex);
                pivotIndex++;
            }
        }
        swap(a, pivotIndex, end);
        return pivotIndex;
    }

    private void swap(int[] a, int from, int to) {
        int tmp = a[to];
        a[to] = a[from];
        a[from] = tmp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 17, 10, 20, 2, 11};

        new QuickSort().sort(a);

        System.out.println(Arrays.toString(a));
    }


}
