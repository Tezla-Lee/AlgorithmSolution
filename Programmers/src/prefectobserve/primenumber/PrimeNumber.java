package prefectobserve.primenumber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class PrimeNumber {
    public int solution(String numbers) {
        int answer = 0;
        String [] numberArr = numbers.split("");
        HashSet<Integer> availableNumber = new HashSet<>();
        HashSet<Integer> numberSet = new HashSet<>();
        List<Integer> numberList = new ArrayList<>();

        for (String s : numberArr) {
//            numberSet.add(Integer.parseInt(s));
            numberList.add(Integer.parseInt(s));
        }
        return answer;
    }

    public static void main(String[] args) {
        new PrimeNumber().solution("1111164235677");
    }
}