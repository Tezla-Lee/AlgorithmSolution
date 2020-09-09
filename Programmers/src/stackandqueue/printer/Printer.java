package stackandqueue.printer;

import java.util.ArrayList;
import java.util.List;
// https://programmers.co.kr/learn/courses/30/lessons/42587
class Document{
    int index;
    int priority;

    public Document(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "[" + index + ", " + priority + "]";
    }

}

class Printer {
    public int solution(int[] priorities, int location) {
        Document locationDoc;
        List<Document> waitingList = new ArrayList<>();
        List<Document> completeList = new ArrayList<>();

        for (int i = 0; i < priorities.length; i++) {
            if (i == location) {
                locationDoc = new Document(location, priorities[location]);
                waitingList.add(locationDoc);
            } else {
                waitingList.add(new Document(i, priorities[i]));
            }
        }

        while (!waitingList.isEmpty()) {
            boolean check = true;
            Document doc = waitingList.remove(0);
            for (int i = 0; i < waitingList.size(); i++) {
                if (waitingList.get(i).priority > doc.priority) {
                    check = false;
                    break;
                }
            }
            if (check) {
                completeList.add(doc);
                if (doc.index == location) {
                    return completeList.size();
                }
            } else {
                waitingList.add(doc);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Printer().solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(new Printer().solution(new int[]{1,1,9,1,1,1}, 0));
    }
}
