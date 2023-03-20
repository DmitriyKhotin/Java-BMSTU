/*
 * 7. Создать класс Cправочная Cлужба Oбщественного Tранспорта с внутренним классом,
 * с помощью объектов которого можно хранить информацию о времени, линиях маршрутов и стоимости проезда.
 */
import java.util.*;

public class Main
{
    public static void main(String[] args) {
        PublicTransportDirectory transportDirectory = new PublicTransportDirectory();
        transportDirectory.addRoute("Birulovo", "12:00", 55.50);
        transportDirectory.printRoutes();
    }
}

public class PublicTransportDirectory {

    private ArrayList<TransportRoute> routes;

    public PublicTransportDirectory() {
        routes = new ArrayList<>();
    }

    public void addRoute(String line, String time, double fare) {
        TransportRoute route = new TransportRoute(line, time, fare);
        routes.add(route);
    }

    public void printRoutes() {
        for (TransportRoute route : routes) {
            System.out.println(route);
        }
    }

    private class TransportRoute {

        private String line;
        private String time;
        private double fare;

        public TransportRoute(String line, String time, double fare) {
            this.line = line;
            this.time = time;
            this.fare = fare;
        }

        public String getLine() {
            return line;
        }

        public String getTime() {
            return time;
        }

        public double getFare() {
            return fare;
        }

        @Override
        public String toString() {
            return "Line: " + line + ", Time: " + time + ", Fare: " + fare;
        }
    }
}

