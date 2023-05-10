/*
* 7.	В зависимости от признака (0 или 1) в каждой строке текста удалить указанный символ везде, где он встречается, или вставить его после k-гo символа.
 */

import java.util.Scanner;
import java.lang.*;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите текст: ");
        String text = scanner.nextLine();
        System.out.print("Введите символ: ");
        char symbol = scanner.nextLine().charAt(0);
        System.out.print("Введите признак (0 или 1): ");
        int flag = scanner.nextInt();
        System.out.print("Введите значение k: ");
        int k = scanner.nextInt();

        if (flag == 0) {
            // удаление символа
            text = text.replace(Character.toString(symbol), "");
        } else if (flag == 1) {
            // вставка символа после k-го символа
            StringBuffer str = new StringBuffer(text);
            str.insert(k, symbol);

            text = str.toString();
        }

        System.out.println("Измененный текст: " + text);
    }
}
