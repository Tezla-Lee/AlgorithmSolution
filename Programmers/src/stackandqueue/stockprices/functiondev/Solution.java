package stackandqueue.stockprices.functiondev;

import java.util.Stack;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int count = 0;
        int [] arr = new int [progresses.length];
        for (int i =0; i < 100; i++) {
            for (int j = 0; j < progresses.length; j++) {
                arr[j] = progresses[j] + speeds[j];
                if (arr[j] >= 100) {
                    count++;
                }
            }
        }
        Stack stack = new Stack();
        return answer;
    }
}