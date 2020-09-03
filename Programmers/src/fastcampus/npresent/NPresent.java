package fastcampus.npresent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://programmers.co.kr/learn/courses/30/lessons/42895

public class NPresent {
    public int solution(int N, int number) {
        List<Set<Integer>> sets = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        sets.add(set);

        for (int i = 1; i <= 8; i++) {
            set = new HashSet<>();
            int num = N;
            for (int j = 1; j < i; j++) {
                num *= 10;
                num += N;
            }
            set.add(num);
            for (int j = 1; j < i / 2 + 1; j++) {
                for (int x : sets.get(j)) {
                    for (int y : sets.get(i - j)) {
                        if (x + y > 0) {
                            set.add(x + y);
                        }
                        if (x * y > 0) {
                            set.add(x * y);
                        }
                        if (x - y > 0) {
                            set.add(x - y);
                        }
                        if (y - x > 0) {
                            set.add(y - x);
                        }
                        if (y != 0) {
                            set.add(x / y);
                        }
                        if (x != 0) {
                            set.add(y / x);
                        }
                    }
                }
            }
            sets.add(set);
            if (set.contains(number)) {
                return i;
            }
//            System.out.println(set.size() + "개 -> " + set);  // Print Set for Check
        }
        return -1;
    }

    // TDD
    public static void main(String[] args) {
        System.out.println(new NPresent().solution(7, 7));
        System.out.println(new NPresent().solution(7, 6666));
        System.out.println(new NPresent().solution(7, 777));
    }
}