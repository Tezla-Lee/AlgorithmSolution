package greedy.lifeboat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

// https://programmers.co.kr/learn/courses/30/lessons/42885
class Lifeboat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int person : people) {
            list.add(person);
        }
        Collections.sort(list);

        while (!list.isEmpty()) {
            int boatFirst = list.poll();
            if (boatFirst == limit / 2) {
                int count = 1;
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) > limit / 2) {
                        break;
                    } else {
                        count++;
                    }
                }
                return count % 2 == 0 ? list.size() + 1 - count / 2 : list.size() - count / 2;
            }
            if (boatFirst > limit / 2) {
                answer += list.size() + 1;
                break;
            }
            if (boatFirst < limit / 2) {
                for (int i = 0; i < list.size(); i++) {
                    if (i != 0 && boatFirst + list.get(i) > limit) {
                        if (boatFirst + list.get(i - 1) <= limit) {
                            list.remove(i - 1);
                        }
                        break;
                    }
                }
            }
            answer++;
        }
        return answer;
    }

    // 오름차순, LinkedList
    public int solution2(int[] people, int limit) {
        int answer = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int person : people) {
            list.add(person);
        }
        Collections.sort(list);
        if (list.getLast() <= limit / 2) {
            return (list.size() + 1) / 2;
        }

        while (!list.isEmpty()) {
            int firstPerson = list.poll();
            answer++;
            if (firstPerson <= limit / 2) {
                for (int i = 0; i < list.size(); i++) {
                    // 앞에서부터 확인 (더 빠름)
//                    if (firstPerson + list.get(i) > limit) {
//                        if (i != 0 && firstPerson + list.get(i - 1) <= limit) {
//                            list.remove(i - 1);
//                            break;
//                        }
//                    }
                    // 뒤에서부터 확인
                    if (firstPerson + list.get(list.size() - 1 - i) <= limit) {
                        list.remove(list.size() - 1 - i);
                        break;
                    }
                }
            } else if (firstPerson == limit / 2) {
                if (list.getFirst() == limit / 2) {
                    list.poll();
                } else {
                    return answer + list.size();
                }
            } else {
                return answer + list.size();
            }
        }
        return answer;
    }

    // 내림차순
    public int solution3(int[] people, int limit) {
        int answer = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int person : people) {
            list.add(person);
        }
        list.sort(((o1, o2) -> o2 - o1));

        if (list.getLast() > limit / 2) {
            return list.size();
        }

        while (!list.isEmpty()) {
            int firstPerson = list.poll();
            answer++;
            if (firstPerson > limit / 2) {
                if (firstPerson + list.getLast() <= limit) {
                    list.removeLast();
                    break;
                }
            } else {
                return answer + list.size() / 2;
            }
        }
        return answer;
    }

    /** ArrayList
     * ( LinkedList 보다 훨씬 빠름 ) */
    public int solution4(int[] people, int limit) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int person : people) {
            list.add(person);
        }
        Collections.sort(list);

        // 제일 큰 값 확인
        if (list.get(list.size() - 1) <= limit / 2) {
            return (list.size() + 1) / 2;
        }

        while (!list.isEmpty()) {
            int firstPerson = list.remove(0);
            answer++;
            if (firstPerson <= limit / 2) {
                for (int i = 0; i < list.size(); i++) {
                    // 앞에서부터 확인 (더 빠름)
                    if (firstPerson + list.get(i) == limit) {
                        list.remove(i);
                        break;
                    } else if (firstPerson + list.get(i) > limit) {
                        if (i != 0 && firstPerson + list.get(i - 1) <= limit) {
                            list.remove(i - 1);
                            break;
                        }
                        break;
                    }
                    // 뒤에서부터 확인
//                    if (firstPerson + list.get(list.size() - 1 - i) <= limit) {
//                        list.remove(list.size() - 1 - i);
//                        break;
//                    }
                }
            } else if (firstPerson == limit / 2) {
                if (list.get(0) == limit / 2) {
                    list.remove(0);
                } else {
                    return answer + list.size();
                }
            } else {
                return answer + list.size();
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        System.out.println(new Lifeboat().solution4(new int[]{60}, 100)); // 1
        System.out.println(new Lifeboat().solution4(new int[]{50}, 100)); // 1
        System.out.println(new Lifeboat().solution4(new int[]{70, 50, 80, 50}, 100)); // 3
        System.out.println(new Lifeboat().solution4(new int[]{70, 80, 50}, 100)); // 3
        System.out.println(new Lifeboat().solution4(new int[]{70, 80, 60}, 100)); // 3
        System.out.println(new Lifeboat().solution4(new int[]{30, 30, 30}, 100)); // 2
        System.out.println(new Lifeboat().solution4(new int[]{50, 50, 50, 50, 50, 50, 50, 50, 60}, 100)); // 5

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(5);
        arr.add(3);
        arr.add(4);
    }
}