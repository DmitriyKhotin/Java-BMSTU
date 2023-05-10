/*
* 8. Напечатать квитанцию об оплате телеграммы, если стоимость одного слова задана.
 * */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите текст телеграммы: ");
        String text = scanner.nextLine();

        System.out.print("Введите стоимость одного слова: ");
        double wordCost = scanner.nextDouble();

        int wordCount = text.trim().split("\\s+").length;
        double totalCost = wordCount * wordCost;

        // Вывод квитанции
        System.out.println("Квитанция:");
        System.out.println("---------------------------");
        System.out.println("Текст телеграммы: " + text);
        System.out.println("Количество слов: " + wordCount);
        System.out.println("Стоимость одного слова: " + wordCost);
        System.out.println("Общая стоимость: " + totalCost);
        System.out.println("---------------------------");
    }
}
