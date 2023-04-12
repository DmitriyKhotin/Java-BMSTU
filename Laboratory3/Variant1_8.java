/*
 * Текст задания
 * 8. Определить класс Комплекс. Класс должен содержать несколько конструкторов.
 * Реализовать методы для сложения, вычитания, умножения, деления, присваивания комплексных чисел.
 * Создать два вектора размерности n из комплексных координат. Передать их в метод, который выполнит их сложение.
 * */
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        Complex[] vector1 = new Complex[n];
        Complex[] vector2 = new Complex[n];

        for (int i = 0; i < n; i++) {
            vector1[i] = new Complex(i, 3 * i);
            vector2[i] = new Complex(4 * i, i);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(vector1[i].real + " + " + vector1[i].imaginary + "i" + " ");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print(vector2[i].real + " + " + vector2[i].imaginary + "i" + " ");
        }

        System.out.println();
        Complex[] sum = addVectors(vector1, vector2);

        for (int i = 0; i < n; i++) {
            System.out.println(sum[i].real + " + " + sum[i].imaginary + "i");
        }
    }

    public static Complex[] addVectors(Complex[] vector1, Complex[] vector2) {
        int n = vector1.length;
        Complex[] sum = new Complex[n];

        for (int i = 0; i < n; i++) {
            sum[i] = vector1[i].add(vector2[i]);
        }

        return sum;
    }
}

public class Complex {
    public double real;
    public double imaginary;

    public Complex() {
        this(0, 0);
    }

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex(Complex other) {
        this(other.real, other.imaginary);
    }

    public Complex add(Complex other) {
        return new Complex(this.real + other.real, this.imaginary + other.imaginary);
    }

    public Complex subtract(Complex other) {
        return new Complex(this.real - other.real, this.imaginary - other.imaginary);
    }

    public Complex multiply(Complex other) {
        double realPart = this.real * other.real - this.imaginary * other.imaginary;
        double imaginaryPart = this.real * other.imaginary + this.imaginary * other.real;
        return new Complex(realPart, imaginaryPart);
    }

    public Complex divide(Complex other) {
        try {
            double denominator = other.real * other.real + other.imaginary * other.imaginary;
            double realPart = (this.real * other.real + this.imaginary * other.imaginary) / denominator;
            double imaginaryPart = (this.imaginary * other.real - this.real * other.imaginary) / denominator;
            return new Complex(realPart, imaginaryPart);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: ошибка ввода");
            return new Complex();
        }
    }
}
