package hashMap.bestalbum;

import java.util.*;

public class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String, Integer> album = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            album.put(genres[i], album.getOrDefault(genres[i],0) + plays[i]);
        }

        Iterator<Map.Entry<String, Integer>> ir = album.entrySet().iterator();
        List<String> list = new ArrayList<>();
        while(ir.hasNext()) {
            Map.Entry<String, Integer> num = ir.next();
            list.add(num.getKey());
        }

        System.out.println(album);
        System.out.println();
        System.out.println(list);

        return answer;
    }

    public static void main(String[] args) {
        new BestAlbum().solution(new String []{"classic", "pop", "classic", "classic", "pop"},new int []{500, 600, 150, 800, 2500});
    }
}