/*
* 7.	Текст шифруется по следующему правилу: из исходного текста выбирается 1, 4, 7, 10-й и т.д. (до конца текста) символы, затем 2, 5, 8, 11-й и т.д. (до конца текста) символы, затем 3, 6, 9, 12-й и т.д. Зашифровать заданный текст.
 * */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите текст для шифрования: ");
        String text = scanner.nextLine();

        // Выбираем символы по указанному правилу
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (i % 3 == 0) {
                encryptedText.append(text.charAt(i));
            }
        }
        for (int i = 0; i < text.length(); i++) {
            if (i % 3 == 1) {
                encryptedText.append(text.charAt(i));
            }
        }
        for (int i = 0; i < text.length(); i++) {
            if (i % 3 == 2) {
                encryptedText.append(text.charAt(i));
            }
        }

        System.out.println("Шифрованный текст: " + encryptedText.toString());
    }
}
