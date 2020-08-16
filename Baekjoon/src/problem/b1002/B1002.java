package problem.b1002;

// https://www.acmicpc.net/problem/1002

import java.util.Scanner;

class B1002 {

    int x1, x2, y1, y2, r1, r2;

    public void input(String s) {
        String[] arr = s.split(" ");
        int[] arr2 = new int[6];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = Integer.parseInt(arr[i]);
        }
        this.x1 = arr2[0];
        this.y1 = arr2[1];
        this.r1 = arr2[2];
        this.x2 = arr2[3];
        this.y2 = arr2[4];
        this.r2 = arr2[5];
    }

    public double distance() {
        return Math.sqrt(Math.pow(this.x1 - this.x2, 2) + Math.pow(this.y1 - this.y2, 2));
    }

    public int radiusSum() {
        return this.r1 + this.r2;
    }

    public int radiusSub() {
        return Math.abs(this.r1 - this.r2);
    }

    public int pointNum() {
        if (this.x1 == this.x2 && this.y1 == this.y2 && this.r1 == this.r2) {
            return -1;
        } else {
            if (distance() > radiusSum() || distance() < radiusSub()) {
                return 0;
            } else if (distance() == radiusSum() || distance() == radiusSub()) {
                return 1;
            } else if (distance() < radiusSum()) {
                return 2;
            } else {
                return -2;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNum = scanner.nextInt();
        scanner.nextLine();
        int[] arr = new int[caseNum];
        for (int i = 0; i < caseNum; i++) {
            String s = scanner.nextLine();
            B1002 b1002 = new B1002();
            b1002.input(s);
            arr[i] = b1002.pointNum();
        }
        for (int a : arr) {
            System.out.println(a);
        }
    }
}
