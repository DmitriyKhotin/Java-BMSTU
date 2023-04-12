/*
 * Текст задания
 * 7.Определить класс Дробь в виде пары (_numerator,_denominator). Класс должен содержать несколько конструкторов.
 * Реализовать методы для сложения, вычитания, умножения и деления дробей. Объявить массив из k дробей, ввести/вывести значения для массива дробей.
 * Создать массив объектов и передать его в метод, который изменяет каждый элемент массива с четным индексом путем добавления следующего за ним элемента массива.
 * */

import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        int k = 5;
        Decimal[] decimals = new Decimal[k];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < k; i++) {
            System.out.println("Введите дробь " + (i+1) + " (в формате m/n):");
            String input = scanner.nextLine();
            String[] parts = input.split("/");
            int m = Integer.parseInt(parts[0]);
            int n = Integer.parseInt(parts[1]);

            try {
                decimals[i] = new Decimal(m, n);
            } catch (OutOfMemoryError e) {
                System.out.println("Ошибка: нехватка памяти");
            }
        }

        System.out.println("Массив дробей:");
        for (int i = 0; i < k; i++) {
            System.out.println(decimals[i]);
        }

        for (int i = 0; i < k-1; i += 2) {
            decimals[i] = decimals[i].add(decimals[i+1]);
        }

        System.out.println("Измененный массив дробей:");
        for (int i = 0; i < k; i++) {
            System.out.println(decimals[i]);
        }
    }
}

public class Decimal {
    private int _numerator;
    private int _denominator;

    public Decimal(int numerator, int denominator) {
        int nod = nod(numerator, denominator);
        this._numerator = numerator / nod;
        this._denominator = denominator / nod;
    }

    public Decimal(int numerator) {
        this._numerator = numerator;
        this._denominator = 1;
    }

    public Decimal() {
        this._denominator = 0;
        this._numerator = 1;
    }

    public Decimal add(Decimal newDecimal) {
        try {
            System.out.println("add" + newDecimal);
            int newNumerator = this._numerator * newDecimal._denominator + newDecimal._numerator * this._denominator;
            int newDenominator = this._denominator * newDecimal._denominator;
            return new Decimal(newNumerator, newDenominator);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: ошибка ввода");
            return new Decimal();
        }
    }

    public Decimal subtract(Decimal newDecimal) {
        int newNumerator = this._numerator * newDecimal._denominator - newDecimal._numerator * this._denominator;
        int newDenominator = this._denominator * newDecimal._denominator;
        return new Decimal(newNumerator, newDenominator);
    }

    public Decimal multiply(Decimal newDecimal) {
        int newNumerator = this._numerator * newDecimal._numerator;
        int newDenominator = this._denominator * newDecimal._denominator;
        return new Decimal(newNumerator, newDenominator);
    }

    public Decimal divide(Decimal newDecimal) {
        int newNumerator = this._numerator * newDecimal._denominator;
        int newDenominator = this._denominator * newDecimal._numerator;
        return new Decimal(newNumerator, newDenominator);
    }

    @Override
    public String toString() {
        return _numerator + "/" + _denominator;
    }

    private int nod(int a, int b) {
        if (b == 0) {
            return a;
        }
        return nod(b, a % b);
    }
}
