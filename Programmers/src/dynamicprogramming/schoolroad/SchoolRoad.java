package dynamicprogramming.schoolroad;

class SchoolRoad {
    public int solution(int m, int n, int[][] puddles) {
        int[][] road = new int[n][m];
        road[0][0] = 1;

        // 웅덩이는 -1로
        for (int[] puddle : puddles) {
            road[puddle[1] - 1][puddle[0] - 1] = -1;
        }

        for (int i = 0; i < road.length; i++) {
            for (int j = 0; j < road[i].length; j++) {
                if (road[i][j] == -1 || (i == 0 && j == 0)) { // 웅덩이와 시작점은 패스
                    continue;
                }
                if (i == 0) { // 맨 윗 줄
                    road[i][j] = road[i][j - 1];
                } else if (j == 0) { // 맨 왼쪽 줄
                    road[i][j] = road[i - 1][j];
                } else {
                    if (road[i][j - 1] == -1 && road[i - 1][j] == -1) { // 왼쪽, 위 모두 웅덩이일 경우
                        road[i][j] = -1;
                    } else if (road[i][j - 1] == -1) { // 왼쪽만 웅덩이일 경우
                        road[i][j] = road[i - 1][j];
                    } else if (road[i - 1][j] == -1) { // 위쪽만 웅덩이일 경우
                        road[i][j] = road[i][j - 1];
                    } else { // 둘 다 웅덩이 아닐 경우
                        road[i][j] = (road[i - 1][j] + road[i][j - 1]) % 1000000007;
                    }
                }
            }
        }

        // 아예 못가게 되는 경우
        if (road[n - 1][m - 1] == -1) {
            return 0;
        }

        return road[n - 1][m - 1];
    }


    // 더 간단 i-1, j-1 이 범위를 벗어나는 경우를 생각할 필요 없음.
    public int solution2(int m, int n, int[][] puddles) {
        int[][] road = new int[m + 1][n + 1];
        road[1][1] = 1;
        for (int[] puddle : puddles) {
            road[puddle[0]][puddle[1]] = -1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                if (road[i][j] == -1) {
                    road[i][j] = 0;
                } else {
                    road[i][j] = (road[i - 1][j] + road[i][j - 1]) % 1000000007;
                }
            }
        }
        return road[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new SchoolRoad().solution(4, 3, new int[][]{{2, 2}}));
        System.out.println(new SchoolRoad().solution2(4, 3, new int[][]{{2, 2}, {2, 1}, {2, 3}}));
    }
}
