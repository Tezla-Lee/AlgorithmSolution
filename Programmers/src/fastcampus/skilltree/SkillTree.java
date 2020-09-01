package fastcampus.skilltree;

import java.util.Arrays;
import java.util.HashSet;

public class SkillTree {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (int i = 0; i < skill_trees.length; i++) {
            HashSet<String> hash = new HashSet<>();
            String[] arr = skill_trees[i].split("");
            hash.addAll(Arrays.asList(arr));

            for (int j =0; j < skill.length(); j++) {
                while(hash.contains(skill.charAt(j))) {

                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        SkillTree skillTree = new SkillTree();

        skillTree.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"});
    }
}