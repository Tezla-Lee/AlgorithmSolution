package problem.b1000;

// https://www.acmicpc.net/problem/1000

import java.util.Scanner;

class B1000 {
    public static int sum() {
        Scanner scanner = new Scanner(System.in);
        int a, b;
        a = scanner.nextInt();
        b = scanner.nextInt();
        return a + b;
    }
    public static void main(String[] args) {
        System.out.println(sum());
    }
}