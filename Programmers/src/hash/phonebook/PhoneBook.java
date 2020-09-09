package hash.phonebook;
// https://programmers.co.kr/learn/courses/30/lessons/42577
public class PhoneBook {
    public boolean solution(String[] phone_book) {
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book.length; j++) {
                if (i == j) {
                    continue;
                } else if (phone_book[j].length() >= phone_book[i].length()) {
                    if (phone_book[i].equals(phone_book[j].substring(0, phone_book[i].length()))) {
                        System.out.println(phone_book[i]);
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        System.out.println(phoneBook.solution(new String[]{"13452345", "119", "97674223", "1195524421"}));
        System.out.println(phoneBook.solution(new String[]{"12", "123", "1235", "567", "88"}));
        System.out.println(phoneBook.solution(new String[]{"123", "456", "789"}));
    }
}