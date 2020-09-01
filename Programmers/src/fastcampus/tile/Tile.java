package fastcampus.tile;

public class Tile {
    public long factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            long total = 1;
            for (int i = 1; i <= n; i++) {
                total = total * i;
            }
            return total;
        }
    }

    public long combination(int a, int b) {
        return factorial(a) / (factorial(b) * factorial(a - b));
    }

    public int solution(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            int num1 = 1;
            int num2 = 2;
            for (int i = 0; i < n - 2; i++) {
                int temp = num2;
                num2 = (num1 + num2) % 1000000007;
                num1 = temp;
            }
            int answer = num2;
            return answer;
        }
    }

    public static void main(String[] args) {
        Tile tile = new Tile();
    }
}