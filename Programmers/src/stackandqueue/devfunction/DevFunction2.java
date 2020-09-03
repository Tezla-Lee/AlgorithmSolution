package stackandqueue.devfunction;

import java.util.Stack;

public class DevFunction2 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Stack<Integer> list = new Stack<>();
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < progresses.length; j++) {
                list.add(progresses[progresses.length - j - 1] + speeds[speeds.length - j - 1] * i);
            }

        }

//        list.pop();
        System.out.println(list);
        return answer;
    }

    // TDD
    public static void main(String[] args) {
        new DevFunction2().solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
        new DevFunction2().solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{5, 10, 1, 2, 20, 1});
        new DevFunction2().solution(new int[]{0, 1, 2, 3, 4, 5}, new int[]{15, 1, 1, 1, 1, 1});
    }
}
