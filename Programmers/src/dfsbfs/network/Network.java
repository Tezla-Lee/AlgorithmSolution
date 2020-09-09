
package dfsbfs.network;

import java.util.HashSet;

class Network {
    public int solution(int n, int[][] computers) {



//        // case 1
//        int answer = 0;
//        for (int i = 0; i < computers.length; i++) {
//            for (int j = 0; j < computers[0].length; j++) {
//                network[j] += computers[i][j];
//            }
//        }
//
//        for (int e : network) {
//            if (n != 1 && e == 1) {
//                answer++;
//            }
//        }


//        // case 2
//        int answer = 0;
//        int[] network = new int[n];
//        int networkCount = 0;
//        int computerCount;


//        for (int i = 0; i < computers.length; i++) {
//            int tempCount = networkCount;
//            computerCount = 0;
//            networkCount = 0;
//            for (int j = 0; j < computers[0].length; j++) {
//                network[j] += computers[i][j];
//                if (network[j] == 1) {
//                    networkCount++;
//                }
//                if (computers[i][j] == 1) {
//                    computerCount++;
//                }
//            }
//            System.out.println(networkCount + ", " + tempCount + ", " + computerCount);
//            if (networkCount - tempCount == computerCount) {
//                answer++;
//            }
//        }


        // case 3
        int answer = 0;
        boolean check;
        HashSet<Integer> networkSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            networkSet.add(i);
        }

        for (int i = 0; i < n; i++) {
            check = true;

            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1) {
                    if (!networkSet.contains(j)) {
                        check = false;
                    }
                    networkSet.remove(j);
                }
            }

            if (check) {
                answer++;
            }

            if (networkSet.isEmpty()) {
                break;
            }
        }
        return answer;
    }

    public int solution2(int n, int[][] computers) {
        int answer = 1;
        int[] network = new int[n];
        // case 1
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[0].length; j++) {
                network[j] += computers[i][j];
            }
        }

        for (int e : network) {
            if (n != 1 && e == 1) {
                answer++;
            }
        }
        if (answer == n + 1) {
            return n;
        }
        return answer;
    }


    public static void main(String[] args) {
//        System.out.println(new Network().solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
//        System.out.println(new Network().solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
//        System.out.println(new Network().solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
//        System.out.println(new Network().solution2(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
//        System.out.println(new Network().solution(3, new int[][]{{0, 1, 1}, {1, 1, 1}, {1, 1, 0}}));
//        System.out.println(new Network().solution2(3, new int[][]{{0, 1, 1}, {1, 1, 1}, {1, 1, 0}}));
//        System.out.println(new Network().solution(1, new int[][]{{1}}));
//        System.out.println(new Network().solution2(1, new int[][]{{1}}));
//        System.out.println(new Network().solution(2, new int[][]{{1, 1}, {1, 1}}));
//        System.out.println(new Network().solution2(2, new int[][]{{1, 1}, {1, 1}}));
//        System.out.println(new Network().solution(6, new int[][]{{1, 1, 1, 0, 0, 0}, {1, 1, 1, 0, 0, 0}, {1, 1, 1, 0, 0, 0}, {0, 0, 0, 1, 1, 0}, {0, 0, 0, 1, 1, 1}, {0, 0, 0, 0, 1, 1}}));
//        System.out.println(new Network().solution2(6, new int[][]{{1, 1, 1, 0, 0, 0}, {1, 1, 1, 0, 0, 0}, {1, 1, 1, 0, 0, 0}, {0, 0, 0, 1, 1, 0}, {0, 0, 0, 1, 1, 1}, {0, 0, 0, 0, 1, 1}}));
//        System.out.println(new Network().solution(6, new int[][]{{1, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}}));
//        System.out.println(new Network().solution2(6, new int[][]{{1, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}}));
//        System.out.println(new Network().solution(6, new int[][]{{1, 1, 1, 1, 1, 1}, {1, 1, 0, 0, 0, 0}, {1, 0, 1, 0, 0, 0}, {1, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 1, 0}, {1, 0, 0, 0, 0, 1}}));
//        System.out.println(new Network().solution2(6, new int[][]{{1, 1, 1, 1, 1, 1}, {1, 1, 0, 0, 0, 0}, {1, 0, 1, 0, 0, 0}, {1, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 1, 0}, {1, 0, 0, 0, 0, 1}}));
//        System.out.println(new Network().solution(6, new int[][]{{1, 1, 0, 0, 0, 1}, {1, 1, 0, 0, 0, 0}, {0, 0, 1, 1, 0, 0}, {0, 0, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1}, {1, 0, 0, 0, 1, 1}}));
//        System.out.println(new Network().solution2(6, new int[][]{{1, 1, 0, 0, 0, 1}, {1, 1, 0, 0, 0, 0}, {0, 0, 1, 1, 0, 0}, {0, 0, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1}, {1, 0, 0, 0, 1, 1}}));
//        System.out.println(new Network().solution(6, new int[][]{{1, 1, 0, 0, 0, 0}, {1, 1, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1}, {0, 0, 1, 1, 0, 0}, {0, 0, 1, 0, 1, 0}, {0, 0, 1, 0, 0, 1}}));
//        System.out.println(new Network().solution2(6, new int[][]{{1, 1, 0, 0, 0, 0}, {1, 1, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1}, {0, 0, 1, 1, 0, 0}, {0, 0, 1, 0, 1, 0}, {0, 0, 1, 0, 0, 1}}));
//        System.out.println(new Network().solution(4, new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 0}, {1, 0, 0, 1}}));
//        System.out.println(new Network().solution(5, new int[][]{{1, 0, 0, 1, 0}, {0, 1, 1, 0, 0}, {0, 1, 1, 0, 0}, {1, 0, 0, 1, 0}, {0, 0, 0, 0, 1}}));

//        HashSet<Integer> map = new HashSet<>();
//        for (int i = 1; i < 11; i++) {
//            map.add(i);
//        }
//        System.out.println(!map.remove(3));
//        System.out.println(map);
    }
}
