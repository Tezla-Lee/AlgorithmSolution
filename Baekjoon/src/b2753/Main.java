package b2753;


import java.util.Scanner;

class Main {
    int isLeapYear(int year) {
        if (year % 4 == 0 && (year % 100 != 0) || year % 400 == 0) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        System.out.println(new Main().isLeapYear(year));
    }
}
