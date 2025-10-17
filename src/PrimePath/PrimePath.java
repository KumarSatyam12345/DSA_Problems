package PrimePath;

import java.util.*;

public class PrimePath {

    static Set<Integer> generatePrimes() {
        Set<Integer> primes = new HashSet<>();
        for (int i = 1000; i <= 9999; i++) {
            if (isPrime(i)) primes.add(i);
        }
        return primes;
    }

    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    static boolean differByOneDigit(int a, int b) {
        String s1 = String.valueOf(a);
        String s2 = String.valueOf(b);
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (s1.charAt(i) != s2.charAt(i)) count++;
        }
        return count == 1;
    }

    static int minSteps(int A, int B, Set<Integer> primes) {
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(new int[]{A, 0});
        visited.add(A);

        while (!queue.isEmpty()) {
            int[] currData = queue.poll();
            int curr = currData[0];
            int steps = currData[1];

            if (curr == B) return steps;

            for (int neighbor : primes) {
                if (!visited.contains(neighbor) && differByOneDigit(curr, neighbor)) {
                    visited.add(neighbor);
                    queue.add(new int[]{neighbor, steps + 1});
                }
            }
        }
        return -1; // impossible
    }

    public static void main(String[] args) {
        int A = 1033;
        int B = 8179;

        Set<Integer> primes = generatePrimes();
        int steps = minSteps(A, B, primes);
        System.out.println("Minimum steps: " + steps); // Output: 6
    }
}

