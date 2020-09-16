package dfsbfs.stringconversion;

import java.util.LinkedList;

class StringConversion {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        String[] newWords = new String[words.length + 1];
        newWords[0] = begin;
        System.arraycopy(words, 0, newWords, 1, words.length);
        LinkedList<Integer> changeable;
        LinkedList<Integer> wait = null;
        LinkedList<LinkedList<Integer>> list = new LinkedList<>();
        boolean[] visited = new boolean[words.length + 1];
        for (int i = 0; i < newWords.length; i++) {
            changeable = new LinkedList<>();
            for (int j = 0; j < newWords.length; j++) {
                if (changeable(newWords[i], newWords[j])) {
                    changeable.add(j);
                }
            }
            list.add(changeable);
        }
        bfs(0, list, wait, visited);
        return answer;
    }

    public int bfs(int index, LinkedList<LinkedList<Integer>> list, LinkedList<Integer> wait, boolean[] visited) {
        if (visited[index]) {
            return 0;
        }
        visited[index] = true;
        for (int i = 0; i < list.get(index).size(); i++) {
            if (!wait.contains(list.get(index).get(i))) {
                wait.offer(list.get(index).get(i));
            }
        }
        return 1;
    }

    public boolean changeable(String s1, String s2) {
        int num = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                num++;
            }
        }
        if (num == 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        new StringConversion().solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
    }
}