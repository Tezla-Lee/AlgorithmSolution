package problem.middlechar;
//https://programmers.co.kr/learn/courses/30/lessons/12903
public class Solution {
    public String solution(String s) {
        String answer = "";
        int len = s.length();
        if (len %2 == 0) {
            char [] arr = {s.charAt(len / 2 - 1), s.charAt(len / 2)};
            answer = String.valueOf(arr);
        } else {
            answer = Character.toString(s.charAt(len / 2));
        }
        return answer;
    }
}


// 확인용
class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("1234"));
        System.out.println(sol.solution("12345"));
    }
}