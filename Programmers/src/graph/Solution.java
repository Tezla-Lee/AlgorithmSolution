package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// https://programmers.co.kr/learn/courses/30/lessons/49189
class Node implements Comparable<Node> {
    int index;
    int dist;

    public Node(int index, int dist) {
        this.index = index;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node o) {
        return dist - o.dist;
    }

    @Override
    public String toString() {
        return index +
                ", " + dist;
    }
}

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] dists = new int[n + 1];
        Arrays.fill(dists, Integer.MAX_VALUE);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            List<Integer> list = new ArrayList<>();
            for (int[] e : edge) {
                if (e[0] == i) {
                    list.add(e[1]);
                }
                if (e[1] == i) {
                    list.add(e[0]);
                }
            }
            lists.add(list);
        }
        dists[0] = 0;
        dists[1] = 0;
        PriorityQueue<Node> heap = new PriorityQueue<>();
        heap.add(new Node(1, 0));
        while (!heap.isEmpty()) {
            Node temp = heap.remove();
            for (int e : lists.get(temp.index)) {
                if (dists[e] > temp.dist + 1) {
                    dists[e] = temp.dist + 1;
                    heap.add(new Node(e, dists[e]));
                }
            }
        }

        int max = 0;
        for (int e : dists) {
            if (e == max) {
                answer++;
            }
            if (e > max) {
                max = e;
                answer = 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }
}
