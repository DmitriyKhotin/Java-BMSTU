/*
* 2.	Реализовать многопоточное приложение “Робот”. Надо написать робота, который умеет ходить. За движение каждой его ноги отвечает отдельный поток. Шаг выражается в выводе в консоль LEFT или RIGHT.
 * */
import java.lang.Runnable;
import java.lang.Thread;

public class Main {
    public static void main(String[] args) {
        LegMovement leftLeg = new LegMovement("LEFT");
        LegMovement rightLeg = new LegMovement("RIGHT");

        Thread leftLegThread = new Thread(leftLeg);
        Thread rightLegThread = new Thread(rightLeg);

        leftLegThread.start();
        rightLegThread.start();
    }
}

class LegMovement implements Runnable {
    private final String legName;

    public LegMovement(String legName) {
        this.legName = legName;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000); // ждем одну секунду между шагами
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(legName);
        }
    }
}
