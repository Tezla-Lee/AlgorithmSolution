package problem.b1001;

// https://www.acmicpc.net/problem/1001

import java.util.Scanner;

class B1001 {
    public static int sub() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        return a - b;
    }

    public static void main(String[] args) {
        System.out.println(B1001.sub());
    }
}