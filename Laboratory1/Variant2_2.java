/*
 * Текст задания
 * Ввести с консоли n целых чисел и поместить их в массив. На консоль вывести:
 * 2. Наибольшее и наименьшее число.
 * */
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] words = in.nextLine().split(" ");
        int[] numbers = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            numbers[i] = Integer.parseInt(words[i]);
        }
        System.out.println(Arrays.toString(numbers));
        int min = numbers[0];
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }

            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        System.out.println("Max " + max);
        System.out.println("Min " + min);
    }
}
