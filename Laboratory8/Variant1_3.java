/*
* 3.	Реализовать многопоточное приложение “Магазин”. Вся цепочка: производитель-магазин-покупатель. Пока производитель не поставит на склад продукт, покупатель не может его забрать. Реализовать приход товара от производителя в магазин случайным числом. В том случае, если товара в магазине не хватает– вывести сообщение.
* */

import java.util.concurrent.*;

public class Shop {
    private int stock = 0;
    private final int maxStock = 10;

    public synchronized void produce() throws InterruptedException {
        while (stock == maxStock) {
            wait();
        }

        int randomAmount = (int) (Math.random() * 10) + 1;
        stock += randomAmount;
        System.out.println("The producer has stocked " + randomAmount + " products. Amount: " + stock);

        notifyAll();
    }

    public synchronized void consume() throws InterruptedException {
        while (stock == 0) {
            wait();
        }

        int randomAmount = (int) (Math.random() * 10) + 1;
        if (stock >= randomAmount) {
            stock -= randomAmount;
            System.out.println("Consumer buy " + randomAmount + " products. Stock: " + stock);
        } else {
            System.out.println("Not enough products in stock!");
        }

        notifyAll();
    }

    public static void main(String[] args) {
        Shop shop = new Shop();

        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(new Producer(shop));
        executor.submit(new Consumer(shop));
        executor.submit(new Consumer(shop));

        executor.shutdown();
    }
}

class Producer implements Runnable {
    private final Shop shop;

    public Producer(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        try {
            while (true) {
                shop.produce();
                Thread.sleep(1000); // ждем одну секунду перед следующей поставкой
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {
    private final Shop shop;

    public Consumer(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        try {
            while (true) {
                shop.consume();
                Thread.sleep(2000); // ждем две секунды перед следующей покупкой
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
