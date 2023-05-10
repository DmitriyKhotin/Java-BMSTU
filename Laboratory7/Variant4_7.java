/*
* 7.	Подсчитать, сколько слов в заданном тексте начинается с прописной буквы.
 * */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите текст для расшифровки: ");
        String text = scanner.nextLine();
        String[] words = text.split("\\s+");
        int counter = 0;
        for (String word : words) {
            if (word.charAt(0) == Character.toUpperCase(word.charAt(0))) {
                counter++;
            }
        }

        System.out.print(counter);
    }
}
