/*
 * Текст задания
 * Создать приложение, удовлетворяющее требованиям, приведенным в задании.
 * Аргументировать принадлежность классу каждого создаваемого метода и корректно переопределить
 * для каждого класса методы equals(), hashCode(), toString().
 * 6. Создать объект класса Роза, используя классы Лепесток, Бутон. Методы: расцвести, завять, вывести на консоль цвет бутона.
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
