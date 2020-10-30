package task1;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean anagram = true;
        int i = 0;
        System.out.println("введите строку 1: ");
	    String str1 = scanner.nextLine();
        System.out.println("введите строку 2: ");
        String str2 = scanner.nextLine();

        do {
            System.out.println("Выберете метод работы: /n   1 сортировка /n  2 счетчики");
            i = scanner.nextInt();
        } while ((i != 2) && (i != 1));
        switch (i){
            case 1: {
                anagram = permutation(sorting(str1), sorting(str2));
                System.out.println("строки совпадают? => " + anagram);
            };
            case 2: {
                anagram = permute(sorting(str1), sorting(str2));
                System.out.println("строки совпадают? => " + anagram);
            }
        }

        scanner.close();
    }
    public static String sorting(String s) {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }
    public static boolean permutation (String s,String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return sorting(s).equals(sorting(t));
    }
    public static boolean permute(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] letters = new int[256];

        char[] s_array = s.toCharArray();
        for (char c : s_array) {
            letters[c]++;
        }

        for (int i = 0; i < t.length(); i++) {
            int c = (int) t.charAt(i);
            if (--letters[c] < 0) {
                return false;
            }
        }

        return true;
    }
}
