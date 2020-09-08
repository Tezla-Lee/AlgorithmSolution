package greedy.bigNum;

// https://programmers.co.kr/learn/courses/30/lessons/42883
class BigNum {
    public String solution(String number, int k) {
        StringBuilder bigNumber = new StringBuilder(number);
        int deleteCount = 0;

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < bigNumber.length() - 1; j++) {
                if (bigNumber.charAt(j) < bigNumber.charAt(j + 1)) {
                    System.out.println(bigNumber.charAt(j));
                    bigNumber.deleteCharAt(j);
                    deleteCount++;
                    break;
                }
            }
        }
        if (deleteCount != k) {
            System.out.println("call");
            bigNumber.delete(bigNumber.length() - (k - deleteCount), bigNumber.length());
        }
        return bigNumber.toString();
    }

    // TDD
    public static void main(String[] args) {
//        System.out.println(new BigNum().solution("11111111111111", 2));
//        System.out.println(new BigNum().solution("1231234", 3));
//        System.out.println(new BigNum().solution("4177252841", 4));
//        System.out.println(new BigNum().solution("1111123456789", 4));
//        System.out.println(new BigNum().solution("7777787654321", 4));
//        System.out.println(new BigNum().solution("9999987654", 4));
        System.out.println(new BigNum().solution("9876335433331", 4));
        System.out.println(new BigNum().solution("9876995433331", 4));
    }
}