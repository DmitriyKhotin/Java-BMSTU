/*
 * Текст задания
 * 5. Создать программу ввода целых чисел как аргументов командной строки, подсчета их суммы (произведения) и вывода результата на консоль.
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
