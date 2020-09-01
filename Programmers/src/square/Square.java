package square;

import java.math.BigInteger;
// https://programmers.co.kr/learn/courses/30/lessons/62048
class Solution {
    public static long getGCD(long a, long b) {
        while (b > 0) {
            long tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }

    // case 1
    public long solution(long w, long h) {
        long answer = w * h - w - h + getGCD(w, h);
        return answer;
    }

    // case 2
    public long solution2(long w, long h) {
        return w * h - w - h + BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).longValue();
    }

}
