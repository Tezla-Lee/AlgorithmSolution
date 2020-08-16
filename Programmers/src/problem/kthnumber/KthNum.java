package problem.kthnumber;

// https://programmers.co.kr/learn/courses/30/lessons/42748

import java.util.Arrays;

// case 1
class Solution {
    public int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] answerArray = new int[commands[i][1] - commands[i][0] + 1];
            System.arraycopy(array, commands[i][0] - 1, answerArray, 0, commands[i][1] - commands[i][0] + 1);
            int[] new_answerArray = new int[answerArray.length];

            for (int j = 0; j < answerArray.length; j++) {

                for (int k = 0; k < answerArray.length; k++) {
                    if (j == 0) {
                        new_answerArray[k] = answerArray[j];
                        break;
                    } else if (answerArray[j] < new_answerArray[k]) {
                        System.arraycopy(new_answerArray, k, new_answerArray, k + 1, new_answerArray.length - k - 1);
                        new_answerArray[k] = answerArray[j];
                        break;
                    } else if (new_answerArray[k] == 0) {
                        new_answerArray[k] = answerArray[j];
                        break;
                    }
                }
            }
            answer[i] = new_answerArray[commands[i][2] - 1];
        }
        return answer;
    }
}


// case 2 : Arrays.sort 사용
class Solution2 {
    public int[] solution2(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] answerArray = new int[commands[i][1] - commands[i][0] + 1];
            System.arraycopy(array, commands[i][0] - 1, answerArray, 0, commands[i][1] - commands[i][0] + 1);
            Arrays.sort(answerArray);
            answer[i] = answerArray[commands[i][2] - 1];
        }
        return answer;
    }
}