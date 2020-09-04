package heap.doublepriorityqueue;

import java.util.ArrayList;
import java.util.PriorityQueue;

// https://programmers.co.kr/learn/courses/30/lessons/42628

class DoublePriorityQueue {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        String[] temp;
        PriorityQueue<Integer> top = new PriorityQueue<>();
//        PriorityQueue<Integer> reverseTop = new PriorityQueue<>(Collections.reverseOrder()); // 이것을 사용하면 최대값을 빼고 구하기 쉬움.

        for (int i = 0; i < operations.length; i++) {
            temp = operations[i].split(" ");
            if (temp[0].equals("I")) {
                top.add(Integer.parseInt(temp[1]));
            }
            if (!top.isEmpty() && temp[0].equals("D")) {
                if (top.size() == 1) {
                    top.clear();
                    continue;
                }
                if (Integer.parseInt(temp[1]) == 1) {
                    ArrayList<Integer> arr2 = new ArrayList<>();
                    top.stream().forEach(a -> arr2.add(a));
                    int max = arr2.get(0);
                    for (int b : arr2) {
                        if (b > max) {
                            max = b;
                        }
                    }
                    top.remove(max);
                } else {
                    top.poll();
                }
            }
        }

        if (top.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            ArrayList<Integer> arr = new ArrayList<>();
            top.stream().forEach(s -> arr.add(s));
            int max = arr.get(0);
            for (int e : arr) {
                if (e > max) {
                    max = e;
                }
            }
            answer[0] = max;
            answer[1] = top.peek();
        }
        System.out.println(answer[0] + "," + answer[1]);
        return answer;
    }

    public static void main(String[] args) {
//        new DoublePriorityQueue().solution(new String[] {"I 16", "D 1"});

//        new DoublePriorityQueue().solution(new String[]{"I 7", "I 5", "I -5", "D -1"});

        System.out.println(new DoublePriorityQueue().solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}));
//        System.out.println(new DoublePriorityQueue().solution(new String[] {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}));
    }
}