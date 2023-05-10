/*
* 8.	Из небольшого текста удалить все символы, кроме пробелов, не являющиеся буквами. Между последовательностями подряд идущих букв оставить хотя бы один пробел.
 * */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите текст: ");
        String text = scanner.nextLine();

        // Удаление символов, не являющихся буквами
        text = text.replaceAll("[^A-Za-z ]", "");

        // Вставка пробелов между буквами
        StringBuilder builder = new StringBuilder(text);
        for (int i = 1; i < builder.length() - 1; i++) {
            if (Character.isLetter(builder.charAt(i)) &&
                    Character.isLetter(builder.charAt(i - 1)) &&
                    Character.isLetter(builder.charAt(i + 1))) {
                builder.insert(i + 1, ' ');
            }
        }
        text = builder.toString();

        System.out.println("Измененный текст: " + text);
    }
}
