package b8393;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int num = sc.nextInt();
        int sum = 0;
        for (int i = 1; i <= num ; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
