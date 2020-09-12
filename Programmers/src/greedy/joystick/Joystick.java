package greedy.joystick;

import java.util.Arrays;
// https://programmers.co.kr/learn/courses/30/lessons/42860
class Joystick {
    public int solution(String name) {
        int answer = 0;
        int num = 0;

        // 좌, 우 최소이동 횟수 구하기
        int[] a = new int[name.length()];
        // 첫 번째 문자를 제외한 나머지 문자 확인 후 1, 0으로 표현.
        Arrays.fill(a, 0);
        for (int i = 1; i < name.length(); i++) {
            if (name.charAt(i) != 'A') {
                a[i] = 1;
                num++;
            }
        }
        a[0] = 0;

        int currentLocation = 0;
        int move = 0;
        for (int i = 0; i < num; i++) {
            int right = 0;
            int left = 0;
            int tempLocation = currentLocation;
            for (int j = 0; j < name.length() - 1; j++) {
                if (a[(++tempLocation % name.length())] == 1) {
                    right++;
                    break;
                } else {
                    right++;
                }
            }
            tempLocation = currentLocation;
            for (int j = 0; j < name.length() - 1; j++) {
                if (a[(--tempLocation + name.length()) % name.length()] == 1) {
                    left++;
                    break;
                } else {
                    left++;
                }
            }

            if (right <= left) { /** right < left 가 맞음. 문제 테스트 케이스에 문제가 있음. */
                currentLocation = (currentLocation + right) % name.length();
                a[currentLocation] = 0;
                move += right;
            } else {
                currentLocation = (currentLocation - left + name.length()) % name.length();
                a[currentLocation] = 0;
                move += left;
            }
        }
        answer += move;
        System.out.println("move : " + move);

        // 알파벳 바꾸는 횟수 구하기
        for (int i = 0; i < name.length(); i++) {
            if ((int) name.charAt(i) > (int) 'N') {
                answer += 91 - (int) name.charAt(i);
            } else {
                answer += (int) name.charAt(i) - (int) 'A';
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Joystick().solution("JEROEN"));
        System.out.println(new Joystick().solution("JAN"));
        System.out.println(new Joystick().solution("BBBAAAB")); // 8
        System.out.println(new Joystick().solution("ABABAAAAABA")); // 11
    }
}