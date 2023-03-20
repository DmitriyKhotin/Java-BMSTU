/*
 * 8. Создать класс Computer (компьютер) с внутренним классом, с помощью объектов
 * которого можно хранить информацию об операционной системе, процессоре и оперативной памяти.
 */
import java.util.*;

public class Main
{
    public static void main(String[] args) {
        Computer asosComputer = new Computer("asos", 16, "windows", 10, "intel", 3200, 1000);
        System.out.println(asosComputer.getBrand());
    }
}

public class Computer {
    private String brand;
    private int storageSize;
    private OperatingSystem os;
    private Processor processor;
    private Memory memory;

    public Computer(String brand, int storageSize, String osName, int osVersion, String processorName, double processorSpeed, int memorySize) {
        this.brand = brand;
        this.storageSize = storageSize;
        this.os = new OperatingSystem(osName, osVersion);
        this.processor = new Processor(processorName, processorSpeed);
        this.memory = new Memory(memorySize);
    }

    public String getBrand() {
        return brand;
    }

    public int getStorageSize() {
        return storageSize;
    }

    public OperatingSystem getOs() {
        return os;
    }

    public Processor getProcessor() {
        return processor;
    }

    public Memory getMemory() {
        return memory;
    }

    public class OperatingSystem {
        private String name;
        private int version;

        public OperatingSystem(String name, int version) {
            this.name = name;
            this.version = version;
        }

        public String getName() {
            return name;
        }

        public int getVersion() {
            return version;
        }
    }

    public class Processor {
        private String name;
        private double speed;

        public Processor(String name, double speed) {
            this.name = name;
            this.speed = speed;
        }

        public String getName() {
            return name;
        }

        public double getSpeed() {
            return speed;
        }
    }

    public class Memory {
        private int size;

        public Memory(int size) {
            this.size = size;
        }

        public int getSize() {
            return size;
        }
    }
}
