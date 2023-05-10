/*
* 8.	На основании правила кодирования, описанного в предыдущем примере, расшифровать заданный набор символов.
 * */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите текст для расшифровки: ");
        String text = scanner.nextLine();

        int length = text.length();
        int rows = length / 3;
        char[][] matrix = new char[rows][3];
        int index = 0;
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < rows; i++) {
                matrix[i][j] = text.charAt(index++);
            }
        }
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < 3; j++) {
                decryptedText.append(matrix[i][j]);
            }
        }

        System.out.println("Расшифрованный текст: " + decryptedText.toString());
    }
}
