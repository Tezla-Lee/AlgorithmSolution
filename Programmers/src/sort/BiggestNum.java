package sort;

public class BiggestNum {
//    public String solution(int[] numbers) {
//        String answer = "";
//
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < numbers.length; i++) {
//            stringBuilder.append(i);
//        }
//        return answer;
//    }

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        int[] numbers = new int[]{3, 30, 34, 5, 9};
        for (int i = 0; i < numbers.length; i++) {
            stringBuilder.append(numbers[i]);
        }

        System.out.println(stringBuilder);
    }
}
