/*
 * Текст задания
 * Создать приложение, удовлетворяющее требованиям, приведенным в задании.
 * Аргументировать принадлежность классу каждого создаваемого метода и корректно переопределить
 * для каждого класса методы equals(), hashCode(), toString().
 * 7. Создать объект класса Дерево, используя классы Лист. Методы: зацвести, опасть листьям, покрыться инеем, пожелтеть листьям.
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
