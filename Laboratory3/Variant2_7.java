/*
 * Текст задания
 * Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы setТип(), getТип(), toString().
 * Определить дополнительно методы в классе, создающем массив объектов. Задать критерий выбора данных и вывести эти данные на консоль.
 * 7. Phone: id, Фамилия, Имя, Отчество, Адрес, Номер кредитной карточки, Дебет, Кредит, Время городских и междугородных разговоров.
 * Создать массив объектов. Вывести:
 * a) сведения об абонентах, у которых время внутригородских разговоров превышает заданное;
 * b) сведения об абонентах, которые пользовались междугородной связью;
 * c) сведения об абонентах в алфавитном порядке.
 * */

import java.util.*;
public class Main {
    public static int getRandomInt() {
        return 0 + (int)(Math.random() * 4);
    }

    public static String generateRandomName() {
        String[] names = {"Alice", "Bob", "Charlie", "David", "Emma"};
        return names[getRandomInt()];
    }

    public static String generateRandomSecondName() {
        String[] surnames = {"Smith", "Johnson", "Williams", "Jones", "Brown"};
        return surnames[getRandomInt()];
    }

    public static String generateRandomThirdName() {
        String[] patronymics = {"James", "William", "Thomas", "Michael", "David"};
        return patronymics[getRandomInt()];
    }

    public static String generateRandomStreet() {
        String[] streets = {"Main Street", "Elm Street", "Park Avenue", "Broadway", "Maple Street"};
        return streets[getRandomInt()];
    }

    public static void main(String[] args) {
        Phone[] phoneArray = new Phone[5];
        for (int i = 1; i < 6; i++) {
            phoneArray[i-1] = new Phone(i, generateRandomSecondName(), generateRandomName(), generateRandomThirdName(), generateRandomStreet(), i*1000 + i*100 + i*11, i*500, i*200, i % 2 == 0 ? 0 : i, i % 2 != 0 ? 0 : i);
        }

        PhoneBook phoneBook = new PhoneBook(phoneArray);

        System.out.println("getInternationalCalls");
        for (Phone phone:phoneBook.getInternationalCalls()) {
            System.out.println(phone.toString());
        }

        System.out.println("getLocalCallsAboveDuration");
        for (Phone phone:phoneBook.getLocalCallsAboveDuration(4)) {
            System.out.println(phone.toString());
        }

        System.out.println("sortByName");
        for (Phone phone:phoneBook.sortByName()) {
            System.out.println(phone.toString());
        }
    }
}

public class Phone {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String address;
    private int creditCardNumber;
    private double debit;
    private double credit;
    private double localCallDuration;
    private double internationalCallDuration;

    public Phone(int id, String lastName, String firstName, String middleName, String address,
                 int creditCardNumber, double debit, double credit, double localCallDuration, double internationalCallDuration) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.debit = debit;
        this.credit = credit;
        this.localCallDuration = localCallDuration;
        this.internationalCallDuration = internationalCallDuration;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setCreditCardNumber(int creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getDebit() {
        return debit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getCredit() {
        return credit;
    }

    public void setLocalCallDuration(double localCallDuration) {
        this.localCallDuration = localCallDuration;
    }

    public double getLocalCallDuration() {
        return localCallDuration;
    }

    public void setInternationalCallDuration(double internationalCallDuration) {
        this.internationalCallDuration = internationalCallDuration;
    }

    public double getInternationalCallDuration() {
        return internationalCallDuration;
    }

    public String toString() {
        return "ID: " + id + ", FIO: " + lastName + " " + firstName + " " + middleName + ", Address: " + address
                + ", Credit card number: " + creditCardNumber + ", Debet: " + debit + ", Credit: " + credit
                + ", Local call duration: " + localCallDuration + ", International call duration: " + internationalCallDuration;
    }
}

public class PhoneBook {
    private Phone[] phoneArray;

    public PhoneBook() {};
    public PhoneBook(Phone[] phoneArray) {
        this.phoneArray = phoneArray;
    }

    public void setPhoneArray(Phone[] phoneArray) {
        this.phoneArray = phoneArray;
    }

    public Phone[] getPhoneArray() {
        return phoneArray;
    }

    public Phone[] getLocalCallsAboveDuration(double duration) {
        Phone[] result = new Phone[phoneArray.length];
        int count = 0;
        for (Phone phone : phoneArray) {
            if (phone.getLocalCallDuration() > duration) {
                result[count] = phone;
                count++;
            }
        }
        return Arrays.copyOfRange(result, 0, count);
    }

    public Phone[] getInternationalCalls() {
        Phone[] result = new Phone[phoneArray.length];
        int count = 0;
        for (Phone phone : phoneArray) {
            if (phone.getInternationalCallDuration() > 0) {
                result[count] = phone;
                count++;
            }
        }
        return Arrays.copyOfRange(result, 0, count);
    }

    public Phone[] sortByName() {
        Phone[] result = Arrays.copyOf(phoneArray, phoneArray.length);
        Arrays.sort(result, Comparator.comparing(Phone::getLastName).thenComparing(Phone::getFirstName).thenComparing(Phone::getMiddleName));
        return result;
    }
}
