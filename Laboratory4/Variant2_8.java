/*
 * Реализовать абстрактные классы или интерфейсы, а также наследование и полиморфизм для следующих классов
 * 8. interface Корабль <- class Грузовой Корабль <- class Танкер.
 */
import java.util.*;

public class Main
{
    public static void main(String[] args) {
        Tanker tanker = new Tanker("Saint Maria", 10000, 5000);
        tanker.loadOil();
    }
}

public interface Ship {
    void sail();
}

public class CargoShip implements Ship {
    private String name;
    private int cargoCapacity;

    public CargoShip(String name, int cargoCapacity) {
        this.name = name;
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public void sail() {
        System.out.println("Ship " + name + " sail in trip!");
    }

    public void loadCargo() {
        System.out.println("Ship " + name + " loaded with cargo is " + cargoCapacity + " tons.");
    }

    public String getName() {
        return name;
    }
}

public class Tanker extends CargoShip {
    private int oilCapacity;

    public Tanker(String name, int cargoCapacity, int oilCapacity) {
        super(name, cargoCapacity);
        this.oilCapacity = oilCapacity;
    }

    public void loadOil() {
        System.out.println("Tanker " + getName() + " loaded with oil is " + oilCapacity + " tons.");
    }

    public int getOilCapacity() {
        return oilCapacity;
    }
}
