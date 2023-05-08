/*
* 7.	На плоскости задано N отрезков. Найти точку пересечения двух отрезков, имеющую минимальную абсциссу. Использовать класс TreeMap.
 * */

// формулы пересечения отрезков
// x = ((x2 - x1) * (x4 - x3) * (y3 - y1) + (y2 - y1) * (x4 - x3) * x1 - (y4 - y3) * (x2 - x1) * x3) / ((y2 - y1) * (x4 - x3) - (y4 - y3) * (x2 - x1))
//y = ((y4 - y3) * (x1 - x3) * (x2 - x1) + (x3 - x4) * (y2 - y1) * y3 + (x4 - x3) * (y2 - y1) * y4) / ((y2 - y1) * (x4 - x3) - (y4 - y3) * (x2 - x1))

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of line segments: ");
        double n = input.nextInt();

        Map<Double, List<LineSegment>> map = new TreeMap<>();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter the endpoints of line segment " + i + ": ");
            double x1 = input.nextInt();
            double y1 = input.nextInt();
            double x2 = input.nextInt();
            double y2 = input.nextInt();

            LineSegment segment = new LineSegment(x1, y1, x2, y2);

            if (map.containsKey(x1)) {
                map.get(x1).add(segment);
            } else {
                List<LineSegment> list = new ArrayList<>();
                list.add(segment);
                map.put(x1, list);
            }

            if (map.containsKey(x2)) {
                map.get(x2).add(segment);
            } else {
                List<LineSegment> list = new ArrayList<>();
                list.add(segment);
                map.put(x2, list);
            }
        }

        List<LineSegment> currentSegments = new ArrayList<>();
        double minX = Integer.MAX_VALUE;
        double minY = Integer.MAX_VALUE;

        for (Map.Entry<Double, List<LineSegment>> entry : map.entrySet()) {
            double x = entry.getKey();

            List<LineSegment> segments = entry.getValue();

            for (int i = 0; i < segments.size(); i++) {
                for (int j = i + 1; j < segments.size(); j++) {
                    LineSegment s1 = segments.get(i);
                    LineSegment s2 = segments.get(j);
                    Point intersection = s1.getIntersection(s2);
                    if ((intersection != null) && (intersection.x < minX)) {
                        minX = intersection.x;
                        minY = intersection.y;
                    }
                }
            }
        }

        if (minX == Integer.MAX_VALUE && minY == Integer.MAX_VALUE) {
            System.out.println("There are no intersecting line segments.");
        } else {
            System.out.println("The point of intersection with the smallest abscissa is (" + minX + ", " + minY + ").");
        }
    }
}

class Point {
    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class LineSegment {
    Point p1, p2;

    public LineSegment(double x1, double y1, double x2, double y2) {
        p1 = new Point(x1, y1);
        p2 = new Point(x2, y2);
    }

    public Point getIntersection(LineSegment other) {
        double x1 = p1.x;
        double y1 = p1.y;
        double x2 = p2.x;
        double y2 = p2.y;
        double x3 = other.p1.x;
        double y3 = other.p1.y;
        double x4 = other.p2.x;
        double y4 = other.p2.y;

        double a = y2 - y1;
        double b = x1 - x2;
        double c = y4 - y3;
        double d = x3 - x4;

        double det = a * d - b * c;
        if (det == 0) {
            System.out.println("det = 0");
            return null;
        }

        double e = x1 * y2 - y1 * x2;
        double f = x3 * y4 - y3 * x4;
        double x = (e * d - b * f) / det;
        double y = (a * f - e * c) / det;
        return new Point(x, y);
    }
}

