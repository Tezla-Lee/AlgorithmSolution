package sort.biggestnum;

import java.util.PriorityQueue;

class Number implements Comparable<Number> {
    String number;

    private Number() {
    }

    public Number(String number) {
        this.number = number;
    }


    @Override
    public String toString() {
        return number;
    }

    @Override
    public int compareTo(Number o) {
        return Integer.parseInt(o.number + this.number) - Integer.parseInt(this.number + o.number);
    }
}

public class BiggestNum {
    public String solution(int[] numbers) {
        StringBuilder bigNum = new StringBuilder();

        // case 1
        PriorityQueue<Number> list = new PriorityQueue<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != 0) {
                break;
            }
            if (i == numbers.length - 1 && numbers[i] == 0) {
                return "0";
            }
        }
        for (int number : numbers) {
            list.add(new Number(Integer.toString(number)));
        }
        for (int i = 0; i < numbers.length; i++) {
            Number temp = list.poll();
            bigNum.append(temp);
        }

        // case 2 (더 빠름)
//        ArrayList<String> list2 = new ArrayList<>();
//        for (int i = 0; i < numbers.length; i++) {
//            if (numbers[i] != 0) {
//                break;
//            }
//        for (int number : numbers) {
//            list2.add(String.valueOf(number));
//        }
//
//        Collections.sort(list2,((o1, o2) -> (o2+o1).compareTo(o1+o2)));
//
//        for (String s : list2) {
//            bigNum.append(s);
//        }
        return bigNum.toString();
    }

    public static void main(String[] args) {
        System.out.println(new BiggestNum().solution(new int[]{6,10,2}));
        System.out.println(new BiggestNum().solution(new int[]{0,0,0,0,0,0}));
        System.out.println(new BiggestNum().solution(new int[]{3,30,34,5,9}));
        System.out.println(new BiggestNum().solution(new int[]{3,1,1,1,1,1,130,34,5,9,4,6,2,3,5,6,8,9,100}));
    }
}