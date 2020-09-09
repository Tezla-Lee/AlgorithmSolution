package hash.bestalbum;


import java.util.*;
// https://programmers.co.kr/learn/courses/30/lessons/42579
class Song implements Comparable<Song> {
    String key;
    int value;
    int index;

    public Song(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public Song(String key, int value, int index) {
        this.key = key;
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Song o) {
        return o.value - value;
    }

    @Override
    public String toString() {
        return "[" + key + ", " + value + ", " + index + "]";
    }
}

class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> best = new ArrayList<>(); // 베스트 앨범

        HashMap<String, Integer> sumPlay = new HashMap<>(); // 장르별 재생 횟수
        List<Song> list = new LinkedList<>(); // 모든 곡

        for (int i = 0; i < genres.length; i++) {
            sumPlay.put(genres[i], sumPlay.getOrDefault(genres[i], 0) + plays[i]);
            list.add(new Song(genres[i], plays[i], i));
        }

        List<Song> sumList = new LinkedList<>(); // 장르별 재생 횟수 순으로..
        for (Map.Entry<String, Integer> entry : sumPlay.entrySet()) {
            sumList.add(new Song(entry.getKey(), entry.getValue()));
        }

        Collections.sort(sumList);
        Collections.sort(list);

        while(!sumList.isEmpty()) {
            String temp = sumList.remove(0).key;
            int num = 0;
            for (Song song : list) {
                if (song.key.equals(temp)) {
                    best.add(song.index);
                    num++;
                }
                if (num == 2) {
                    break;
                }
            }
        }

        int [] answer = new int [best.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = best.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        new BestAlbum().solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
    }
}