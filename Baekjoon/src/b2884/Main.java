package b2884;

import java.util.Scanner;

class Main {
    static void earlyTimeSet(int time, int minutes) {
        int newTime = ((time + 24) * 60 + minutes - 45) / 60 % 24;
        int newMinutes = (60 + minutes - 45) % 60;
        System.out.printf("%d %d", newTime, newMinutes);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int time = sc.nextInt();
        int minutes = sc.nextInt();
        earlyTimeSet(time, minutes);
    }
}