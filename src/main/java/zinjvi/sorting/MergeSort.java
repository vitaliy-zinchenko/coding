package zinjvi.sorting;

import java.util.Arrays;

public class MergeSort {

    public void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(int[] a, int start, int end) {
        if (end - start > 0) {
            int center = (end + start) / 2;
            sort(a, start, center);
            sort(a, center + 1, end);
            merge(a, start, center, center + 1, end);
        }
    }

    private void merge(int[]a, int leftStart, int leftEnd, int rightStart, int rightEnd) {
        int[] result = new int[rightEnd - leftStart + 1];
        int l = leftStart, r = rightStart;
        for(int i = 0; i < result.length; i++) {
            if (l > leftEnd) {
                result[i] = a[r];
                r++;
            } else if (r > rightEnd) {
                result[i] = a[l];
                l++;
            } else if (a[l] < a[r]) {
                result[i] = a[l];
                l++;
            } else {
                result[i] = a[r];
                r++;
            }
        }

        for(int i = 0; i < result.length; i++) {
            a[leftStart + i] = result[i];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 17, 10, 20, 2, 11};

        new MergeSort().sort(a);

        System.out.println(Arrays.toString(a));
    }

}
