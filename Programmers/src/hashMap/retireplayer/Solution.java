package hashMap.retireplayer;

import java.util.HashMap;
import java.util.Iterator;

// https://programmers.co.kr/learn/courses/30/lessons/42576

class Member {
    private int memberID;
    private String memberName;

    public Member() {
    }

    public Member(int memberID, String memberName) {
        this.memberName = memberName;
        this.memberID = memberID;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @Override
    public String toString() {
        return memberName;
    }
}

class MemberHashMap {
    private HashMap<Member, Integer> hashMap;

    public MemberHashMap() {
        hashMap = new HashMap<>();
    }

    public void removeMember(String memberName) {
        if (hashMap.containsKey(memberName)) {
            hashMap.remove(memberName);
        }
    }

    public void addMember(Member member) {
        hashMap.put(member, member.getMemberID());
    }

    public void showAllMember() {
        Iterator<Member> ir = hashMap.keySet().iterator();
        while (ir.hasNext()) {
            Member key = ir.next();
            Integer member = hashMap.get(key);
            System.out.println(member);
        }
        System.out.println();
    }
}

public class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> hash = new HashMap<>();
//        for (int i = 0; i < participant.length; i++) {
//            hash.put(participant[i], i);
//        }
//
//        for (int i = 0; i < completion.length; i++) {
//            hash.remove(completion[i]);
//        }
//
//        Iterator<String> ir = hash.keySet().iterator();
//        while (ir.hasNext()) {
//            String key = ir.next();
//            System.out.println(hash.get(key));
//        }

        MemberHashMap hashMap = new MemberHashMap();
        for (int i = 0; i < participant.length; i++) {
            Member member = new Member(i, participant[i]);
            hashMap.addMember(member);
        }

        for (int i = 0; i < completion.length; i++) {
            hashMap.removeMember(completion[i]);
        }

        hashMap.showAllMember();
        return answer;
    }

    public static void main(String[] args) {
        HashMap<Integer, Member> hash = new HashMap<>();
        Solution solution = new Solution();
        solution.solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"});
    }
}