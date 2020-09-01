package problem.b1978;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static int primeNumCheck(int n) {
        if (n == 1)
            return -1;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return -1;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int n = sc.nextInt();
            if (primeNumCheck(n) != -1) {
                arr.add(primeNumCheck(n));
            }
        }
        System.out.println(arr.size());
    }
}