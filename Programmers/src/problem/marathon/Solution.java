package problem.marathon;
// https://programmers.co.kr/learn/courses/30/lessons/42576
public class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        int count;
        for (int i = 0; i < participant.length; i++) {
            count = 0;
            for (int j = 0; j < completion.length; j++) {
                if (participant[i].equals(completion[j])) {
                    participant[i] = "0";
                    completion[j] = "0";
                    count++;
                    break;
                }
            }
            if (count == 0) {
                System.out.println(participant[i]);
                break;
            }
        }
        return answer;
    }
}


// 인용
class Main {
    public static void main(String[] args) {
        String answer = "";
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        int count = 0;
        outer:
        for (int i = 0; i < participant.length; i++) {
            count = 0;
            for (int j = 0; j < completion.length; j++) {
                if (participant[i].equals(completion[j])) {
                    participant[i] = "0";
                    completion[j] = "0";
                    count++;
                    break;
                }
            }
            if (count == 0) {
                System.out.println(participant[i]);
                break outer;
            }
        }
    }
}