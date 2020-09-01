package problem.b1004.littleprince;
/// https://www.acmicpc.net/problem/1004
import java.util.Scanner;

public class LittlePrince {
    int x1, y1, x2, y2;
    int count = 0;

    public LittlePrince() {
    }

    public void innerCheck(int cx, int cy, int r) {
        if ((x1 - cx) * (x1 - cx) + (y1 - cy) * (y1 - cy) <= r * r) {
            count++;
        }

        if ((x2 - cx) * (x2 - cx) + (y2 - cy) * (y2 - cy) <= r * r) {
            count++;
        }

        if (((x1 - cx) * (x1 - cx) + (y1 - cy) * (y1 - cy) <= r * r) && ((x2 - cx) * (x2 - cx) + (y2 - cy) * (y2 - cy) <= r * r)) {
            count--;
            count--;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LittlePrince littlePrince = new LittlePrince();
        int n = sc.nextInt();
        sc.nextLine();
        int [] answer = new int [n];
        for (int i = 0; i < n; i++) {

            String s = sc.nextLine();

            String[] arr = s.split(" ");
            int[] arr2 = new int[arr.length];

            for (int j = 0; j < arr.length; j++) {
                arr2[j] = Integer.parseInt(arr[j]);
            }

            littlePrince.x1 = arr2[0];
            littlePrince.y1 = arr2[1];
            littlePrince.x2 = arr2[2];
            littlePrince.y2 = arr2[3];

            int num = sc.nextInt();
            sc.nextLine();

            for (int j = 0; j < num; j++) {
                String s2 = sc.nextLine();
                String[] srr = s2.split(" ");
                littlePrince.innerCheck(Integer.parseInt(srr[0]), Integer.parseInt(srr[1]), Integer.parseInt(srr[2]));
            }

            answer[i] = littlePrince.count;
            littlePrince.count = 0;
        }
        for (int e : answer) {
            System.out.println(e);
        }
    }
}