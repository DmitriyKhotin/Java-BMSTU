/*
 * Текст задания
 * Создать приложение, удовлетворяющее требованиям, приведенным в задании.
 * Аргументировать принадлежность классу каждого создаваемого метода и корректно переопределить
 * для каждого класса методы equals(), hashCode(), toString().
 * 7. Создать объект класса Дерево, используя классы Лист. Методы: зацвести, опасть листьям, покрыться инеем, пожелтеть листьям.
 * */

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Leaf greenLeaf = new Leaf("green");
        Leaf redLeaf = new Leaf("red");
        Leaf yellowLeaf = new Leaf("yellow");

        Tree tree = new Tree();
        tree.addLeaf(greenLeaf);
        tree.addLeaf(redLeaf);
        tree.addLeaf(yellowLeaf);

        System.out.println("Initial state: " + tree);

        tree.bloom();
        System.out.println("After blooming: " + tree);

        tree.turnLeavesYellow();
        System.out.println("After turning leaves yellow: " + tree);

        tree.fall();
        System.out.println("After falling: " + tree);

        tree.coverLeavesWithFrost();
        System.out.println("After covering frost: " + tree);
    }
}

public class Leaf {
    private String color;
    private boolean isFalling;
    private boolean isCoveredByFrost;

    public Leaf(String color) {
        this.color = color;
        this.isFalling = false;
        this.isCoveredByFrost = false;
    }

    public void bloom() {
        this.isFalling = false;
    }

    public void fall() {
        this.isFalling = true;
        this.isCoveredByFrost = false;
    }

    public void coverWithFrost() {
        this.isCoveredByFrost = true;
    }

    public void turnYellow() {
        this.color = "yellow";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Leaf)) return false;

        Leaf leaf = (Leaf) o;

        if (isFalling != leaf.isFalling) return false;
        if (isCoveredByFrost != leaf.isCoveredByFrost) return false;
        return color.equals(leaf.color);
    }

    @Override
    public int hashCode() {
        int result = color.hashCode();
        result = 31 * result + (isFalling ? 1 : 0);
        result = 31 * result + (isCoveredByFrost ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Leaf{" +
                "color='" + color + '\'' +
                ", isFalling=" + isFalling +
                ", isCoveredByFrost=" + isCoveredByFrost +
                '}';
    }
}

public class Tree {
    private List<Leaf> leaves;

    public Tree() {
        this.leaves = new ArrayList<>();
    }

    public void addLeaf(Leaf leaf) {
        this.leaves.add(leaf);
    }

    public void bloom() {
        for (Leaf leaf : leaves) {
            leaf.bloom();
        }
    }

    public void fall() {
        for (Leaf leaf : leaves) {
            leaf.fall();
        }
    }

    public void coverLeavesWithFrost() {
        for (Leaf leaf : leaves) {
            leaf.coverWithFrost();
        }
    }

    public void turnLeavesYellow() {
        for (Leaf leaf : leaves) {
            leaf.turnYellow();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tree)) return false;

        Tree tree = (Tree) o;

        return leaves.equals(tree.leaves);
    }

    @Override
    public int hashCode() {
        return leaves.hashCode();
    }

    @Override
    public String toString() {
        return "Tree{" +
                "leaves=" + leaves +
                '}';
    }
}

