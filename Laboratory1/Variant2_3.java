/*
 * Текст задания
 * Ввести с консоли n целых чисел и поместить их в массив. На консоль вывести:
 * 3. Числа, которые делятся на 3 или на 9.
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
        int[] mulThree = new int[numbers.length];
        int[] mulNine = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 3 == 0) {
                mulThree[i] = numbers[i];
            }

            if (numbers[i] % 9 == 0) {
                mulNine[i] = numbers[i];
            }
        }
        System.out.println(Arrays.toString(mulThree));
        System.out.println(Arrays.toString(mulNine));
    }
}
