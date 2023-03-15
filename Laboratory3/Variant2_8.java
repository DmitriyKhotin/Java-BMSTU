/*
 * Текст задания
 * Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы setТип(), getТип(), toString().
 * Определить дополнительно методы в классе, создающем массив объектов. Задать критерий выбора данных и вывести эти данные на консоль.
 * 8. Car: id, Марка, Модель, Год выпуска, Цвет, Цена, Регистрационный номер. Создать массив объектов.
 * Вывести:
 * a) список автомобилей заданной марки;
 * b) список автомобилей заданной модели, которые эксплуатируются больше n лет;
 * c) список автомобилей заданного года выпуска, цена которых больше указанной.
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
