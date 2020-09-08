package heap.diskcontroller;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/42627
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

class Job2 implements Comparable<Job2> {
    int call;
    int runTime;

    public Job2(int[] arr) {
        this.call = arr[0];
        this.runTime = arr[1];
    }

    @Override
    public int compareTo(Job2 o) {
        return this.runTime >= o.runTime ? 1 : -1;
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

        PriorityQueue<Job> remainJobs = new PriorityQueue<>(); // call time 작은 순
        PriorityQueue<Job2> waitJobs = new PriorityQueue<>(); // run time 작은 순

        for (int[] e : jobs) {
            remainJobs.add(new Job(e));
        }

        while (!remainJobs.isEmpty() || !waitJobs.isEmpty()) {

            // time 보다 작은 call 모두 대기명단에 추가
            while (!remainJobs.isEmpty() && remainJobs.peek().call <= time) {
                Job remainJob = remainJobs.poll();
                waitJobs.add(new Job2(new int[]{remainJob.call, remainJob.runTime}));
            }

            // 대기명단에서 runTime 짧은 순서대로 작업.
            if (waitJobs.isEmpty()) {
                time = remainJobs.peek().call;
            } else {
                Job2 waitJob = waitJobs.poll();
                if (time < waitJob.call) {
                    time = waitJob.call;
                } else {
                    time += waitJob.runTime;
                }
                runTime += time - waitJob.call;
            }

        }
//        System.out.println(time + ", " + runTime);
        return runTime / jobs.length;
    }




    ///////////////////////////////////////////////////////////////////////////
    // Job, Job2 클래스를 만들어서 하는 것 말고 이렇게 하는 방법도 있음. 더 간단
    ///////////////////////////////////////////////////////////////////////////
    public int solution2(int[][] jobs) {
        int time = 0;
        int index = 0;
        int runTime = 0;

        // jobs[][0] 을 비교하여 정렬. (요청 시간 순)
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // jobs[][1] 를 비교하여 정렬. (작업 시간 순)
        PriorityQueue<int[]> qu = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        while (index <= jobs.length) {
            while (index < jobs.length && jobs[index][0] <= time) {
                qu.offer(jobs[index]);
                index++;
            }
            if (qu.isEmpty()) {
                time = jobs[index][0];
                continue;
            }

            int[] job = qu.poll();
            time += job[1];
            runTime += time - job[0];

            if (index == jobs.length && qu.isEmpty()) {
                break;
            }
        }
        return runTime / jobs.length;
    }

    public static void main(String[] args) {
        System.out.println(new DiskController().solution(new int[][]{{0, 3}, {1, 9}, {2, 6}, {20, 10}}));
        System.out.println(new DiskController().solution2(new int[][]{{1, 9}, {0, 3}, {2, 6}}));
    }
}