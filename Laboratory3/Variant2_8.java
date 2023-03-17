/*
 * Текст задания
 * Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы setТип(), getТип(), toString().
 * Определить дополнительно методы в классе, создающем массив объектов. Задать критерий выбора данных и вывести эти данные на консоль.
 * 8. Car: id, Марка, Модель, Год выпуска, Цвет, Цена, Регистрационный номер. Создать массив объектов.
 * Вывести:
 * a) список автомобилей заданной марки;
 * b) список автомобилей заданной модели, которые эксплуатируются больше n лет;
 * c) список автомобилей заданного года выпуска, цена которых больше указанной.
 * */
import java.util.*;
public class Main {
    public static int getRandomInt() {
        return 0 + (int)(Math.random() * 4);
    }

    public static String generateRandomBrand() {
        String[] carBrands = {"Toyota", "Honda", "Ford", "Chevrolet", "BMW"};
        return carBrands[getRandomInt()];
    }

    public static String generateRandomModel() {
        String[] carModels = {"Camry", "Civic", "Mustang", "Camaro", "X5"};
        return carModels[getRandomInt()];
    }


    public static String generateRandomColors() {
        String[] colors = {"red", "green", "blue", "yellow", "orange"};
        return colors[getRandomInt()];
    }

    public static String generateRandomNumbers() {
        String[] carNumbers = {"A123BC", "X789YZ", "K456LM", "P987QR", "G654TH"};
        return carNumbers[getRandomInt()];
    }

    public static int generateRandomYear() {
        int[] carYears = {2010, 2015, 2019, 2018, 2000};
        return carYears[getRandomInt()];
    }

    public static void main(String[] args) {
        Car[] cars = new Car[5];
        for (int i = 1; i < 6; i++) {
            cars[i-1] = new Car(i, generateRandomBrand(), generateRandomModel(), generateRandomYear(), generateRandomColors(), 2000 + (i-1), generateRandomNumbers());
        }

        CarList carList = new CarList(cars);

        System.out.println("getCarsByBrand");
        for (Car car:carList.getCarsByBrand(generateRandomBrand())) {
            System.out.println(car.toString());
        }

        System.out.println("getCarsByModelAndYears");
        for (Car car:carList.getCarsByModelAndYears(generateRandomModel(), generateRandomYear())) {
            System.out.println(car.toString());
        }

        System.out.println("getCarsByYearAndPrice");
        for (Car car:carList.getCarsByYearAndPrice(generateRandomYear(), 2000)) {
            System.out.println(car.toString());
        }
    }
}

public class Car {
    private int id;
    private String brand;
    private String model;
    private int year;
    private String color;
    private double price;
    private String registrationNumber;

    public Car(int id, String brand, String model, int year, String color, double price, String registrationNumber) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    // геттеры и сеттеры для всех полей класса Car
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", registrationNumber='" + registrationNumber + '\'' +
                '}';
    }
}

public class CarList {
    private Car[] cars;

    public CarList(Car[] cars) {
        this.cars = cars;
    }

    // методы для получения списка автомобилей заданной марки
    public Car[] getCarsByBrand(String brand) {
        List<Car> carsList = new ArrayList<>();
        for (Car car : cars) {
            if (car.getBrand().equals(brand)) {
                carsList.add(car);
            }
        }
        return carsList.toArray(new Car[carsList.size()]);
    }

    // методы для получения списка автомобилей заданной модели, которые эксплуатируются больше n лет
    public Car[] getCarsByModelAndYears(String model, int years) {
        List<Car> carsList = new ArrayList<>();
        for (Car car : cars) {
            if (car.getModel().equals(model) && (2023 - car.getYear()) > years) {
                carsList.add(car);
            }
        }
        return carsList.toArray(new Car[carsList.size()]);
    }

    // методы для получения списка автомобилей заданного года выпуска, цена которых больше указанной
    public Car[] getCarsByYearAndPrice(int year, double price) {
        List<Car> carsList = new ArrayList<>();
        for (Car car : cars) {
            if (car.getYear() == year && car.getPrice() > price) {
                carsList.add(car);
            }
        }
        return carsList.toArray(new Car[carsList.size()]);
    }
}
