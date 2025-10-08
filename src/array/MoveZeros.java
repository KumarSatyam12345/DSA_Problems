package array;

import java.util.ArrayList;
import java.util.List;

public class MoveZeros {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 4, 0, 0, 0, 5, 1, 3, 0};
        // moveZero(arr);
        moveZeroOptimal(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }

    }

    // brute force : time complexity O(2n) that is O(n) space complexity O(n)
    private static int[] moveZero(int[] arr) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                integers.add(arr[i]);
            }
        }
        for (int i = 0; i < integers.size(); i++) {
            arr[i] = integers.get(i);
        }
        for (int i = integers.size(); i < arr.length; i++) {
            arr[i] = 0;
        }
        return arr;
    }

    // optimal : time complexity O(n) space complexity O(1)
    private static int[] moveZeroOptimal(int[] arr) {
        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }
        if(j==-1){
            return arr;
        }
        for (int i = j + 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j++] = temp;
            }
        }
        return arr;
    }
}
