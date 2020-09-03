package hashMap.bestalbum;

import java.util.*;

public class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String, Integer> album = new HashMap<>();
        HashMap<Integer, String> album2 = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            album.put(genres[i], album.getOrDefault(genres[i], 0) + plays[i]);
        }

        for (int i = 0; i < genres.length; i++) {
            album2.put(plays[i], genres[i]);
        }

        List<HashMap<Integer, String>> list = new ArrayList<>();
        Iterator<Map.Entry<String, Integer>> ir = album.entrySet().iterator();

        for (int i = 0; i < album.size(); i++) {
            HashMap<String, Integer> eachGeneres = new HashMap<>();
             Map.Entry<String, Integer> entry = ir.next();
//            if (entry.getKey().equals())
        }

        System.out.println(album.keySet());
        System.out.println(album);
        System.out.println();
        System.out.println(album2.keySet());
        System.out.println(album2);

        return answer;
    }

    public static void main(String[] args) {
        new BestAlbum().solution(new String[]{"classic", "pop", "classic", "classic", "pop", "pop"}, new int[]{500, 600, 150, 800, 2500, 2500});
    }
}