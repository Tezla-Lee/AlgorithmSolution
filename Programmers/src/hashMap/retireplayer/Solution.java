package hashMap.retireplayer;

import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// https://programmers.co.kr/learn/courses/30/lessons/42576

public class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> hash = new HashMap<>();

        for (int i = 0; i < participant.length; i++) {
            hash.put(participant[i], hash.getOrDefault(participant[i], 0) + 1);
        }
        for (int i = 0; i < completion.length; i++) {
            hash.put(completion[i], hash.getOrDefault(completion[i], 0) - 1);
        }

        System.out.println(hash);

        Iterator<Map.Entry<String, Integer>> ir = hash.entrySet().iterator();

        while (ir.hasNext()) {
            Map.Entry<String, Integer> key = ir.next();
            if (key.getValue() > 0) {
                answer = key.getKey();
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        HashMap<Integer, Member> hash = new HashMap<>();
        Solution solution = new Solution();

        System.out.println(solution.solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
    }
}