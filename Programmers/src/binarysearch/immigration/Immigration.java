package binarysearch.immigration;

import java.util.PriorityQueue;

class Examiner implements Comparable<Examiner> {
    int time;
    int remain;
    boolean ing = false;
    int a = ing ? time + remain : time;

    public Examiner(int time, int remain) {
        this.time = time;
        this.remain = remain;
    }

    @Override
    public int compareTo(Examiner o) {
        return a - o.a;
    }
}

class Immigration {
    public long solution(int n, int[] times) {
        long answer = 0;
        PriorityQueue<Examiner> qu = new PriorityQueue<>();
        while (n != 0) {
            answer++;
        }
        return answer;
    }
}