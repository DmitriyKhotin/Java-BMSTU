/*
 * Текст задания
 * 8. Определить класс Комплекс. Класс должен содержать несколько конструкторов.
 * Реализовать методы для сложения, вычитания, умножения, деления, присваивания комплексных чисел.
 * Создать два вектора размерности n из комплексных координат. Передать их в метод, который выполнит их сложение.
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
