/*
* Текст задания
* 5. Создать программу ввода целых чисел как аргументов командной строки, подсчета их суммы (произведения) и вывода результата на консоль.
* 6. Создать приложение, выводящее фамилию разработчика, дату и время получения задания, а также дату и время сдачи задания.
*    Для получения последней даты и времени использовать класс Calendar из пакета java.util
 * */
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
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

        System.out.println("Второе задание: приложение");
        Developer developer = new Developer("Дмитрий");
        System.out.println("Для того, чтобы дать задание разработчику нажмите Enter");
        Scanner in = new Scanner(System.in);
        String enter = in.nextLine();
        in.close();
        if (enter == "") {
            developer.addTask();
            System.out.println("Дата создания задачи: " + developer.getTask(0).receiptDate);
            System.out.println(Calendar.getInstance().getTime());
        }
    }
}

class Task {
    Date receiptDate;
    Date closeDate;
    public void Task() {
        System.out.println("Здесь");
        this.receiptDate = new Date();
        System.out.println(this.receiptDate);
        Calendar.getInstance().setTime(this.receiptDate);
    }

    public void closeTask() {
        this.closeDate = new Date();
    }
}

class Developer {
    String name;
    ArrayList<Task> tasks;
    public Developer(String name) {
        this.name = name;
        this.tasks = new ArrayList();
    }

    public void addTask() {
        System.out.println("Здесь1");
        this.tasks.add(new Task());
    }

    public Task getTask(int num) {
        if (num >= 0) {
            return this.tasks.get(num);
        }

        return this.tasks.get(this.tasks.size() - 1);
    }

    public void closeTask(int num) {
        this.getTask(num).closeTask();
    }
}
