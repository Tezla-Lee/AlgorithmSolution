package fastcampus.tile;

public class Tile {
    public int solution(int n) {
        // 강사님 방법
        int[] integers = new int[n + 1];
        integers[1] = 1;
        integers[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            integers[i] = integers[i - 1] + integers[i - 2];
        }
        return integers[n];

        // 내 방법
//        if (n == 1) {
//            return 1;
//        } else if (n == 2) {
//            return 2;
//        } else {
//            int num1 = 1;
//            int num2 = 2;
//            for (int i = 0; i < n - 2; i++) {
//                int temp = num2;
//                num2 = (num1 + num2) % 1000000007;
//                num1 = temp;
//            }
//            int answer = num2;
//            return answer;
//        }
    }

    public static void main(String[] args) {
        Tile tile = new Tile();
    }
}