package problem.sortstring;

import java.util.Arrays;

//class sortStringTest {
//    public String[] sortStringTest(String[] strings, int n) {
//        String[] answer = new String[strings.length];
//        Arrays.sort(strings);
//        sortString[] arr = new sortString[strings.length];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = new sortString(strings[i]);
//        }
//        Arrays.sort(arr);
//        for (int i = 0; i < arr.length; i++) {
//            answer[i] = arr[i].toString();
//        }
//        int x = n;
//        return answer;
//    }
//}

class sortString implements Comparable<sortString> {
    String name;
    public String[] sortStringTest(String[] strings, int n) {
        String[] answer = new String[strings.length];
        Arrays.sort(strings);
        sortString[] arr = new sortString[strings.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new sortString(strings[i]);
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            answer[i] = arr[i].toString();
        }
        return answer;
    }

    public sortString(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(sortString o) {
        return this.name.charAt(2) - o.name.charAt(2);
    }
}