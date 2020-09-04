package heap.diskcontroller;

import java.util.Collections;
import java.util.PriorityQueue;

class Job implements Comparable<Job> {
    int call;
    int runTime;

    public Job(int[] arr) {
        this.call = arr[0];
        this.runTime = arr[1];
    }

    @Override
    public int compareTo(Job o) {
        return this.call >= o.call ? 1 : -1;
    }


    @Override
    public String toString() {
        return "( " + call + ", " + runTime + " )";
    }
}

class DiskController {
    public int solution(int[][] jobs) {
        int time = 0;
        int runTime = 0;
        int startTime = 0;

        PriorityQueue<Job> remainJobs = new PriorityQueue<>(); // call time 작은 순
        PriorityQueue<Job> waitJobs = new PriorityQueue<>(Collections.reverseOrder()); // run time 작은 순
        PriorityQueue<Job> ingJobs = new PriorityQueue<>();

        for (int[] e : jobs) {
            remainJobs.add(new Job(e));
        }


        while (!remainJobs.isEmpty() || !waitJobs.isEmpty() || !ingJobs.isEmpty()) {
            // 작업 완료 (ing 에서 제거)
            if (!ingJobs.isEmpty() && ingJobs.peek().runTime + startTime == time) {
                runTime += time - ingJobs.peek().call;
                System.out.println(time + "s : " + ingJobs.poll() + " 작업 끝");
            }

            // 대기명단에 추가 (남아 있는 작업에서 제거)
            if (remainJobs.size() != 0 && remainJobs.peek().call == time) {
//                System.out.println(time + "s: " + remainJobs.peek() + "추가");

                waitJobs.add(remainJobs.poll());
            }

            // 작업시작 (대기 명단에서 뺴서 ing 에 추가)
            if (!waitJobs.isEmpty() && ingJobs.isEmpty()) {
                ingJobs.add(waitJobs.poll());
                startTime = time;
//                System.out.println(startTime + "s : " + ingJobs.peek()  + " 작업 시작");
            }
//            System.out.println("남은 " + remainJobs);
//            System.out.println("작업 중 " + ingJobs);
//            System.out.println("대기중 " + waitJobs);
            time++;
        }
        return runTime / jobs.length;
    }

    public static void main(String[] args) {
        System.out.println(new DiskController().solution(new int[][]{{0, 3}, {1, 9}, {2, 6}}));
    }
}