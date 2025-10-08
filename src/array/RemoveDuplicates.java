package array;

import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {1, 1, 4, 1, 2, 2, 2, 3, 3, 3, 4, 4};
        removeDuplicateOptSol(arr);
        for (int j : arr) {
            System.out.print(j + " ");
        }

    }

    // brute force
    private static void removeDuplicates(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        Set<Integer> integers = new TreeSet<Integer>();
        for (int j : arr) {
            integers.add(j);
        }
        int i = 0;
        for (int num : integers) {
            arr[i++] = num;
        }
        for (; i < arr.length; i++) {
            arr[i] = 0;
        }

    }

    // optimal
    private static void removeDuplicateOptSol(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != arr[i]) {
                arr[i + 1] = arr[j];
                arr[j] = 0;
                i++;
            } else {
                arr[j] = 0;
            }
        }
    }
}