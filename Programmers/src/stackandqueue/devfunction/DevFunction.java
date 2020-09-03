package stackandqueue.devfunction;

import java.util.ArrayList;
import java.util.List;

public class DevFunction {
    public int[] solution(int[] progresses, int[] speeds) {
        int count = 0;
        int num = 0;
        List<Integer> temp = new ArrayList<>();
        loop :
        for (int i = 0; i < progresses.length;) {
            for (int a = 0; a < 100; a++) {
                for (int j = 0; j < progresses.length; j++) {
                    for (int b = 0; b < progresses.length; b++) {
                        progresses[b] += speeds[b];
                    }
                    if (progresses[i] >= 100) {
                        for (int k = 0; k < 100 - i; k++) {
                            if (progresses[i + k] >= 100) {
                                count++;
                                num++;
                                if (num == progresses.length) {
                                    temp.add(count);
                                    break loop;
                                }
                            } else {
                                temp.add(count);
                                i += count;
                                count = 0;
                                break;
                            }
                        }
                    }
                }
            }
        }
        int[] answer = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            answer[i] = temp.get(i);
            System.out.printf("%3d", answer[i]);
        }
        System.out.println();
        return answer;
    }

    public static void main(String[] args) {
        new DevFunction().solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
        new DevFunction().solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{5, 10, 1, 2, 20, 1});
        new DevFunction().solution(new int[]{0,1,2,3,4,5}, new int[]{15,1,1,1,1,1});
    }
}

