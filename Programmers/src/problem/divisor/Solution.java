package problem.divisor;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        for (int e : arr) {
            if (e % divisor == 0) {
                list.add(e);
                count++;
            }
        }
        int[] answer;
        if (count == 0) {
            answer = new int[]{-1};
        } else {
            answer = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }
            Arrays.sort(answer);
        }
        return answer;
    }
}
