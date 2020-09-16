package b10950;

import java.util.Scanner;

class Main {
    static int sum(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int a, b;
        sc.nextLine();
        for (int i = 0; i < num; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            sc.nextLine();
            System.out.println(sum(a, b));
        }
    }
}