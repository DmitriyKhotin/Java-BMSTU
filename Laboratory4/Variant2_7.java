/*
 * Реализовать абстрактные классы или интерфейсы, а также наследование и полиморфизм для следующих классов
 * 7. interface Врач <- class Хирург <- class Нейрохирург.
 */
import java.util.*;

public class Main
{
    public static void main(String[] args) {
        NeuroSurgeon neuroSurgeon = new NeuroSurgeon("Andrteey");
        System.out.println(neuroSurgeon.getName());
        neuroSurgeon.sayHello();
    }
}

abstract class Doctor {
    private String _name;

    public Doctor(String name) {
        this._name = name;
    }

    public String getName() {
        return _name;
    }

    public void sayHello() {
        System.out.println("Hello. I am a doctor!");
    }
}

abstract class Surgeon extends Doctor {
    public Surgeon(String name) {
        super(name);
    }

    @Override
    public void sayHello() {
        System.out.println("Hello. I am a surgeon!");
    }
}

class NeuroSurgeon extends Surgeon {
    public NeuroSurgeon(String name) {
        super(name);
    }

    @Override
    public void sayHello() {
        System.out.println("Hello. I am a neuro surgeon!");
    }
}
