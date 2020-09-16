package b1001;

import java.util.Scanner;

class Main {
    public int sub() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        return a - b;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.sub());
    }
}