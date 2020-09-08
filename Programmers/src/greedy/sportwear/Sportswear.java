package greedy.sportwear;

import java.util.HashSet;

// https://programmers.co.kr/learn/courses/30/lessons/42862

class Sportswear {
    public int solution(int n, int[] lost, int[] reserve) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> reserveSet = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            set.add(i);
        }

        for (int e : lost) {
            set.remove(e);
        }

        for (int e : reserve) {
            if (!set.contains(e)) {
                set.add(e);
            } else {
                reserveSet.add(e);
            }
        }

        for (int e : reserveSet) {
            if (e != 1 && !set.contains(e - 1)) {
                set.add(e - 1);
            } else {
                if (e == n) {
                    break;
                }
                set.add(e + 1);
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(new Sportswear().solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
        System.out.println(new Sportswear().solution(5, new int[]{2, 3}, new int[]{3}));
        System.out.println(new Sportswear().solution(3, new int[]{3}, new int[]{1}));
        System.out.println(new Sportswear().solution(2, new int[]{3}, new int[]{2}));
        System.out.println(new Sportswear().solution(8, new int[]{5, 6}, new int[]{4, 5}));
    }
}