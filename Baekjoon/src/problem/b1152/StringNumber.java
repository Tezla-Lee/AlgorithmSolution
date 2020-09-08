package problem.b1152;

import java.util.Arrays;
import java.util.Scanner;

public class StringNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
//        String s = str.trim().replace(" ", "");
        String [] arr = str.split(" ");
        System.out.println(arr.length);

        System.out.println(Arrays.stream(arr).toArray());
    }
}
