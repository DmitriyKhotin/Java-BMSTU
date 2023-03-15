/*
 * Текст задания
 * 7.Определить класс Дробь в виде пары (m,n). Класс должен содержать несколько конструкторов.
 * Реализовать методы для сложения, вычитания, умножения и деления дробей. Объявить массив из k дробей, ввести/вывести значения для массива дробей.
 * Создать массив объектов и передать его в метод, который изменяет каждый элемент массива с четным индексом путем добавления следующего за ним элемента массива.
 * */
public class Main {
    public static void main(String[] args) {
        int multiply = 1;
        int summary = 0;

        for (int i = 0; i < args.length; i++) {
            int number = Integer.parseInt(args[i]);
            summary = summary + number;
            multiply = multiply * number;
        }
        System.out.println("Сумма " + summary + "\nПроизведение " + multiply);
    }
}

public class Decimal {
    private int _numerator;
    private int _denominator;

    public Decimal(int numerator, int denominator) {
        this._denominator = denominator;
        this._numerator = numerator;
    }

    public Decimal(int numerator) {
        this._numerator = numerator;
        this._denominator = 1;
    }

    public Decimal() {
        this._denominator = 1;
        this._numerator = 1;
    }

    public static addDecaimals(Decimal firstDecimal, Decimal secondDecimal) {

    }
}
