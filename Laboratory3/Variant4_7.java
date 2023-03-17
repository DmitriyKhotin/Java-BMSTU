/*
 * Текст задания
 * Построить модель программной системы.
 * 7. Система Телефонная станция. Абонент оплачивает Счет за разговоры и Услуги, может попросить Администратора сменить номер и отказаться от услуг.
 * Администратор изменяет номер, Услуги и временно отключает Абонента за неуплату.
 * */
public class Main {
    public static void main(String[] args) {
    }
}

public class TelephoneExchange {
    private List<Subscriber> subscribers; // список абонентов

    public TelephoneExchange() {
        this.subscribers = new ArrayList<>();
    }

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public List<Subscriber> getSubscribers() {
        return subscribers;
    }
}

public class Subscriber {
    private String name;
    private String phoneNumber;
    private double account; // баланс абонента
    private boolean isBlocked; // заблокирован ли абонент
    private List<Service> services; // список подключенных услуг

    public Subscriber(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.account = 0;
        this.isBlocked = false;
        this.services = new ArrayList<>();
    }

    public void addService(Service service) {
        services.add(service);
    }

    public void removeService(Service service) {
        services.remove(service);
    }

    public void changePhoneNumber(String newNumber) {
        this.phoneNumber = newNumber;
    }

    public void payBill(double amount) {
        account -= amount;
    }

    public void requestDisconnect() {
        isBlocked = true;
    }

    public void requestReconnect() {
        isBlocked = false;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getAccount() {
        return account;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public List<Service> getServices() {
        return services;
    }
}

public class Service {
    private String name;
    private double cost;

    public Service(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }
}

public class Administrator {
    public void changePhoneNumber(Subscriber subscriber, String newNumber) {
        subscriber.changePhoneNumber(newNumber);
    }

    public void addService(Subscriber subscriber, Service service) {
        subscriber.addService(service);
    }

    public void removeService(Subscriber subscriber, Service service) {
        subscriber.removeService(service);
    }

    public void blockSubscriber(Subscriber subscriber) {
        subscriber.requestDisconnect();
    }

    public void unblockSubscriber(Subscriber subscriber) {
        subscriber.requestReconnect();
    }

    public void updateAccount(Subscriber subscriber, double amount) {
        subscriber.payBill(amount);
    }
}
