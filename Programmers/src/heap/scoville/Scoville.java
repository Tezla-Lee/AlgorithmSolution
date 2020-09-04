package heap.scoville;

import java.util.PriorityQueue;

public class Scoville {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> qu = new PriorityQueue<>();

        for (int e : scoville) {
            qu.offer(e);
        }
        while (Integer.parseInt(String.valueOf(qu.peek())) < K) {
            if (qu.size() == 1) {
                return -1;
            }
            qu.offer(qu.poll() + qu.poll() * 2);
            answer++;
        }

        // 시간 초과
//        LinkedList<Integer> list = new LinkedList<>();
//        Arrays.stream(scoville).sorted().forEach(list::add);
//        if (list.getLast() * Math.pow(2,scoville.length - 1) + list.getLast() < K) {
//            return -1;
//        }
//        if (list.getFirst() * Math.pow(2,scoville.length - 1) + list.getFirst() < K) {
//            return -1;
//        }
//        while (list.peek() < K) {
//            if (list.size() == 1) {
//                return -1;
//            }
//            int a = list.poll();
//            int b = list.poll();
//            list.add(a + 2 * b);
//            Collections.sort(list);
//            answer++;
//        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Scoville().solution(new int[]{1, 45, 67, 564, 4, 3, 1, 5, 7, 9}, 5));
    }
}