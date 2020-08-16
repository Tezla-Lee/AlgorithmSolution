package problem.crane;

// https://programmers.co.kr/learn/courses/30/lessons/64061

// 제출용
public class Crane {
    public int solution(int[][] board, int[] moves) {
        int amount = -1;
        int answer = 0;
        int[] arr = new int[(board[0].length + 1) * (board.length + 1)];

        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][moves[i] - 1] == 0) {
                    continue;
                } else {
                    if (amount == -1 || arr[amount] != board[j][moves[i] - 1]) {
                        arr[amount + 1] = board[j][moves[i] - 1];
                        board[j][moves[i] - 1] = 0;
                        amount++;
                        break;
                    } else {
                        board[j][moves[i] - 1] = 0;
                        arr[amount] = 0;
                        amount--;
                        answer++;
                        break;
                    }
                }
            }
        }
        answer *= 2;
        return answer;
    }
}

// Test 용
class Crane2 {
    public int solution() {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        //             4, 3, 1, 1, 3, 2,  , 4
        int amount = -1;
        int answer = 0;
        int[] arr = new int[(board[0].length + 1) * (board.length + 1)];

        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][moves[i] - 1] == 0) {
                    continue;
                } else {
                    if (amount == -1 || arr[amount] != board[j][moves[i] - 1]) {
                        arr[amount + 1] = board[j][moves[i] - 1];
                        board[j][moves[i] - 1] = 0;
                        amount++;
                        break;
                    } else {
                        board[j][moves[i] - 1] = 0;
                        arr[amount] = 0;
                        amount--;
                        answer++;
                        break;
                    }
                }
            }
        }
        answer *= 2;
//        for (int e : arr) {               // 바구니 확인
//            System.out.print(e + " ");
//        }
//        System.out.println();
        return answer;
    }
}

class Test {
    public static void main(String[] args) {
        Crane2 cr = new Crane2();
        System.out.println(cr.solution());
    }
}