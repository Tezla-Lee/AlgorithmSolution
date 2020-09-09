package prefectobserve.carpet;

// https://programmers.co.kr/learn/courses/30/lessons/42842

import java.util.Arrays;

class Carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        for (int i = 1; i <= yellow / 2 + 1; i++) {
            if (yellow % i == 0) {
                int w = (yellow / i) + 2;
                int h = i + 2;
                if (2 * (w + h - 2) == brown) {
                    return new int [] {w, h};
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Carpet().solution(10, 2)));
        System.out.println(Arrays.toString(new Carpet().solution(8, 1)));
        System.out.println(Arrays.toString(new Carpet().solution(24, 24)));
    }
}
