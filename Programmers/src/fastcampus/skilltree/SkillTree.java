package fastcampus.skilltree;

import java.util.ArrayList;
import java.util.List;

public class SkillTree {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        loop:
        for (String tree : skill_trees) {
            List<Integer> list = new ArrayList<>();
            for (char c : tree.toCharArray()) {
                int index = skill.indexOf(c);

                if (index > -1) {
                    list.add(index);
                }
            }

            if (list.size() > 0 && list.get(0) != 0) {
                continue;
            }
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) != list.get(i - 1) + 1) {
                    continue loop;
                }
            }
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new SkillTree().solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
}