/*
 * Текст задания
 * Создать приложение, удовлетворяющее требованиям, приведенным в задании.
 * Аргументировать принадлежность классу каждого создаваемого метода и корректно переопределить
 * для каждого класса методы equals(), hashCode(), toString().
 * 6. Создать объект класса Роза, используя классы Лепесток, Бутон. Методы: расцвести, завять, вывести на консоль цвет бутона.
 * */

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Petal[] petals = new Petal[5];
        for (int i = 0; i < 5; i++) {
            petals[i] = new Petal("red");
        }

        Bud bud = new Bud("green", false, petals);
        Rose rose = new Rose("Red rose", bud);
        System.out.println(rose);
        System.out.println(bud.hashCode());
        System.out.println(petals[0].hashCode());
        System.out.println(rose.hashCode());
        rose.bloom();
        System.out.println(rose);

        rose.wilt();
        System.out.println(rose);
    }
}

public class Rose {
    private String name;
    private Bud bud;

    public Rose(String name, Bud bud) {
        this.name = name;
        this.bud = bud;
    }

    public void bloom() {
        bud.setOpen(true);
    }

    public void wilt() {
        bud.setOpen(false);
    }

    public String getBudColor() {
        return bud.getColor();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rose)) return false;
        Rose rose = (Rose) o;
        return name.equals(rose.name) && bud.equals(rose.bud);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + bud.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Rose{" +
                "name='" + name + '\'' +
                ", bud=" + bud +
                '}';
    }
}

public class Petal {
    private String color;

    public Petal(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Petal)) return false;
        Petal petal = (Petal) o;
        return color.equals(petal.color);
    }

    @Override
    public int hashCode() {
        int result = color.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Petal{" +
                "color='" + color +
                '}';
    }
}

public class Bud {
    private String color;
    private boolean isOpen;
    private Petal[] petals;

    public Bud(String color, boolean isOpen, Petal[] petals) {
        this.color = color;
        this.isOpen = isOpen;
        this.petals = petals;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public void open() {
        isOpen = true;
    }

    public void close() {
        isOpen = false;
    }

    public Petal[] getPetals() {
        return petals;
    }

    public void setPetals(Petal[] petals) {
        this.petals = petals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bud)) return false;
        Bud bud = (Bud) o;
        return isOpen == bud.isOpen &&
                Objects.equals(color, bud.color) &&
                Arrays.equals(petals, bud.petals);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(color, isOpen);
        result = 31 * result + Arrays.hashCode(petals);
        return result;
    }

    @Override
    public String toString() {
        return "Bud{" +
                "color='" + color + '\'' +
                ", isOpen=" + isOpen +
                ", petals=" + Arrays.toString(petals) +
                '}';
    }
}
