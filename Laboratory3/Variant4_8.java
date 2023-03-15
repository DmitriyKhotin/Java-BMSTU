/*
 * Текст задания
 * Построить модель программной системы.
 * 8. Система Автобаза. Диспетчер распределяет заявки на Рейсы между Водителями и назначает для этого Автомобиль.
 * Водитель может сделать заявку на ремонт. Диспетчер может отстранить Водителя от работы.
 * Водитель делает отметку о выполнении Рейса и состоянии Автомобиля.
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
