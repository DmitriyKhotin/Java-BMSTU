/*
 * Текст задания
 * 5. Создать программу ввода целых чисел как аргументов командной строки, подсчета их суммы (произведения) и вывода результата на консоль.
 * 6. Создать приложение, выводящее фамилию разработчика, дату и время получения задания, а также дату и время сдачи задания.
 *    Для получения последней даты и времени использовать класс Calendar из пакета java.util
 * */
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
public class Main {
    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar(2023, 1 , 17);
        Calendar calendar2 = new GregorianCalendar();
        System.out.println("Calendar: " + calendar.getTime());
        System.out.println("Calendar2: " + calendar2.getTime());
        Date taskGetDate = new Date(123, 1, 17);
        System.out.println("Khotin Dmitriy");
        System.out.println("Task get: " + taskGetDate);
        System.out.println("Task done: " + new Date());
    }
}
