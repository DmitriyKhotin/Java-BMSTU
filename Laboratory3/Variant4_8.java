/*
 * Текст задания
 * Построить модель программной системы.
 * 8. Система Автобаза. Диспетчер распределяет заявки на Рейсы между Водителями и назначает для этого Автомобиль.
 * Водитель может сделать заявку на ремонт. Диспетчер может отстранить Водителя от работы.
 * Водитель делает отметку о выполнении Рейса и состоянии Автомобиля.
 * */
import java.util.*;


public class Autobaza {
    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher();

        // create some drivers
        Driver driver1 = new Driver("John");
        Driver driver2 = new Driver("Sarah");
        Driver driver3 = new Driver("Bob");

        // add drivers to dispatcher
        dispatcher.addDriver(driver1);
        dispatcher.addDriver(driver2);
        dispatcher.addDriver(driver3);

        // create some cars
        Car car1 = new Car("Toyota", "Camry", 2010);
        Car car2 = new Car("Honda", "Accord", 2012);
        Car car3 = new Car("Nissan", "Altima", 2015);

        // add cars to dispatcher
        dispatcher.addCar(car1);
        dispatcher.addCar(car2);
        dispatcher.addCar(car3);

        // assign driver1 to car1
        dispatcher.assignDriverToCar(driver1, car1);

        // mark driver1's trip as complete
        dispatcher.markTripComplete(driver1);

        // mark driver1's car for repair
        dispatcher.markDriverForRepair(driver1);

        // suspend driver1
        dispatcher.suspendDriver(driver1);

        // assign driver2 to car2
        dispatcher.assignDriverToCar(driver2, car2);

        // mark driver2's trip as complete
        dispatcher.markTripComplete(driver2);

        // suspend driver2
        dispatcher.suspendDriver(driver2);

        // reinstate driver2
        dispatcher.reinstateDriver(driver2);

        System.out.println(dispatcher.getDrivers());
        System.out.println(dispatcher.getCars());
    }
}

class Driver {
    private String name;
    private boolean available;
    private boolean onDuty;
    private boolean needsRepair;
    private Car car;

    public Driver(String name) {
        this.name = name;
        this.available = true;
        this.onDuty = false;
        this.needsRepair = false;
        this.car = null;
    }

    public void setOnDuty(boolean onDuty) {
        this.onDuty = onDuty;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setNeedsRepair(boolean needsRepair) {
        this.needsRepair = needsRepair;
    }

    public void assignCar(Car car) {
        this.car = car;
    }

    public boolean isAvailable() {
        return available;
    }

    public boolean isOnDuty() {
        return onDuty;
    }

    public boolean needsRepair() {
        return needsRepair;
    }

    public Car getCar() {
        return car;
    }

    public String toString() {
        return "{ name: " + this.name + ", available: " + this.available + ", onDuty: " + this.onDuty + ", needsRepair: " + this.needsRepair + (this.car != null ? ", car: " + this.car.toString() : "") + "}";
    }
}

class Car {
    private String mark;
    private String model;
    private int year;
    private boolean needsRepair;

    public Car(String mark, String model, int year) {
        this.mark = mark;
        this.model = model;
        this.year = year;
        this.needsRepair = false;
    }

    public void setNeedsRepair(boolean needsRepair) {
        this.needsRepair = needsRepair;
    }

    public boolean needsRepair() {
        return needsRepair;
    }

    public String getMark() {
        return mark;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String toString() {
        return "{ mark: " + this.mark + ", model: " + this.model + ", year: " + this.year + ", needsRepair: " + this.needsRepair;
    }
}

class Dispatcher {
    private ArrayList<Driver> drivers;
    private ArrayList<Car> cars;
    private String result;

    public Dispatcher() {
        this.drivers = new ArrayList<>();
        this.cars = new ArrayList<>();
    }

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public void removeDriver(Driver driver) {
        drivers.remove(driver);
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }

    public void assignDriverToCar(Driver driver, Car car) {
        if (driver.getCar() != null) {
            driver.getCar().setNeedsRepair(true);
        }
        driver.assignCar(car);
        driver.setAvailable(false);
    }

    public void markTripComplete(Driver driver) {
        driver.setAvailable(true);
        driver.getCar().setNeedsRepair(false);
    }

    public void markDriverForRepair(Driver driver) {
        driver.setNeedsRepair(true);
        driver.setAvailable(false);
    }

    public void suspendDriver(Driver driver) {
        driver.setOnDuty(false);
        driver.setAvailable(false);
        driver.getCar().setNeedsRepair(false);
    }

    public void reinstateDriver(Driver driver) {
        driver.setOnDuty(true);
    }

    public String getDrivers() {
        result = "";
        this.drivers.forEach(driver -> result += driver.toString() + "\n");
        return result;
    }

    public String getCars() {
        result = "";
        this.cars.forEach(car -> result += car.toString() + "\n");
        return result;
    }
}

