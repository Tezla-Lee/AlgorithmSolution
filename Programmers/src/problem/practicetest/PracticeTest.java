package problem.practicetest;

// https://programmers.co.kr/learn/courses/30/lessons/42840

public class PracticeTest {
    public int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int oneNum = 0;
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int twoNum = 0;
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int threeNum = 0;
        int countNum = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == one[i % 5]) {
                oneNum++;
            }
            if (answers[i] == two[i % 8]) {
                twoNum++;
            }
            if (answers[i] == three[i % 10]) {
                threeNum++;
            }
        }

        int bigNum = Math.max(oneNum, twoNum);
        int mostBig = Math.max(bigNum, threeNum);
        int[] arr = {oneNum, twoNum, threeNum};

        for (int i = 0; i < 3; i++) {
            if (arr[i] == mostBig) {
                arr[i] = i + 1;
                countNum++;
            } else {
                arr[i] = 0;
            }
        }

        int[] answer = new int[countNum];

        for (int i = 0; i < countNum; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] != 0) {
                    answer[i] = arr[j];
                    arr[j] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}