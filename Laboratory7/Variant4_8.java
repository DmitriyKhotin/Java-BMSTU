/*
* 8.	Подсчитать, сколько раз заданное слово входит в текст.
 * */
import java.util.Scanner;
import java.util.Objects;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите текст для расшифровки: ");
        String text = scanner.nextLine();

        System.out.print("Введите слово: ");
        String scannedWord = scanner.nextLine();

        String[] words = text.split("\\s+");
        int counter = 0;
        for (String word : words) {
            if (Objects.equals(word, scannedWord)) {
                counter++;
            }
        }

        System.out.print(counter);
    }
}
