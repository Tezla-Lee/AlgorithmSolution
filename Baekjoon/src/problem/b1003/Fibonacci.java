package problem.b1003;

import java.util.Scanner;
// https://www.acmicpc.net/problem/1003

class Solution {
    int countZero(int n) {
        int num0 = 1;
        int num1 = 0;
        int temp = 1;

        if (n == 0) {
            return num0;
        } else if (n == 1) {
            return num1;
        } else {
            for (int i = 0; i < n - 1 ; i++) {
                temp = num0 + num1;
                num0 = num1;
                num1 = temp;
            }
            return temp;
        }
    }

    int countOne(int n) {
        int num0 = 0;
        int num1 = 1;
        int temp = 1;

        if (n == 0) {
            return num0;
        } else if (n == 1) {
            return num1;
        } else {
            for (int i = 0; i < n - 1; i++) {
                temp = num0 + num1;
                num0 = num1;
                num1 = temp;
            }
            return temp;
        }
    }

    String printCount (int n) {
        return countZero(n) + " " + countOne(n);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String [] arr = new String [num];
        for (int i = 0; i < num; i++) {
            int n = sc.nextInt();
            arr[i] = sol.printCount(n);
        }

        for (String e : arr) {
            System.out.println(e);
        }
    }
}