/*
* 3.	Задана коллекция чисел. Вернуть сумму нечетных чисел.
* */

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int sumOfOddNumbers = numbers.stream()
                .filter(number -> number % 2 != 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("The sum of odd numbers is: " + sumOfOddNumbers);
    }
}

