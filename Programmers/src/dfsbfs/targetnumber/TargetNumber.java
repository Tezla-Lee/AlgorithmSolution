package dfsbfs.targetnumber;

import java.util.LinkedList;
import java.util.Queue;

class TargetNumber {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        Queue<Integer> arr = new LinkedList<>();
        arr.add(0);
        for (int i = 0; i < numbers.length; i++) {
            Queue<Integer> temp = new LinkedList<>();
            while (!arr.isEmpty()) {
                int number = arr.poll();
                temp.add(number + numbers[i]);
                temp.add(number - numbers[i]);
                if (i == numbers.length - 1 && (number + numbers[i] == target || number - numbers[i] == target)) {
                    answer++;
                }
            }
            arr = temp;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new TargetNumber().solution(new int[]{1, 1, 1, 1, 1}, 3));
    }
}