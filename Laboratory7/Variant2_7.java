/*
* 7. В тексте найти и напечатать все слова максимальной и все слова минимальной длины.
 * */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите текст: ");
        String text = scanner.nextLine();

        String[] words = text.split("\\s+");
        int maxLength = 0;
        int minLength = Integer.MAX_VALUE;

        // Поиск максимальной и минимальной длины слов
        for (String word : words) {
            int length = word.length();
            if (length > maxLength) {
                maxLength = length;
            }
            if (length < minLength) {
                minLength = length;
            }
        }

        // Вывод слов максимальной длины
        System.out.print("Слова максимальной длины: ");
        for (String word : words) {
            if (word.length() == maxLength) {
                System.out.print(word + " ");
            }
        }
        System.out.println();

        // Вывод слов минимальной длины
        System.out.print("Слова минимальной длины: ");
        for (String word : words) {
            if (word.length() == minLength) {
                System.out.print(word + " ");
            }
        }
        System.out.println();
    }
}
