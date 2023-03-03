/*
* ����� �������
* 5. ������� ��������� ����� ����� ����� ��� ���������� ��������� ������, �������� �� ����� (������������) � ������ ���������� �� �������.
* 6. ������� ����������, ��������� ������� ������������, ���� � ����� ��������� �������, � ����� ���� � ����� ����� �������.
*    ��� ��������� ��������� ���� � ������� ������������ ����� Calendar �� ������ java.util
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
        System.out.println("����� " + summary + "\n������������ " + multiply);

        System.out.println("������ �������: ����������");
        Developer developer = new Developer("�������");
        System.out.println("��� ����, ����� ���� ������� ������������ ������� Enter");
        Scanner in = new Scanner(System.in);
        String enter = in.nextLine();
        in.close();
        if (enter == "") {
            developer.addTask();
            System.out.println("���� �������� ������: " + developer.getTask(0).receiptDate);
            System.out.println(Calendar.getInstance().getTime());
        }
    }
}

class Task {
    Date receiptDate;
    Date closeDate;
    public void Task() {
        System.out.println("�����");
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
        System.out.println("�����1");
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
