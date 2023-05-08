/*
* На клетчатом листе бумаги закрашена часть клеток.
* Выделить все различные фигуры, которые образовались при этом.
* Фигурой считается набор закрашенных клеток, достижимых друг из друга при движении в четырёх направлениях.
* Две фигуры являются различными, если их нельзя совместить поворотом на угол, кратный 90 градусам,
* и параллельным переносом. Используйте класс HashSet.
 * */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        boolean[][] grid = {{true, false, true, false},
                            {true, true, false, false},
                            {false, true, false, true},
                            {false, false, false, true}
        };
        Set<Set<FigureExtractor.Cell>> figures = FigureExtractor.extractFigures(grid);
        System.out.println("Found " + figures.size() + " figures:");
        for (Set<FigureExtractor.Cell> figure : figures) {
            System.out.print("Figure: ");
            for (FigureExtractor.Cell cell : figure) {
                System.out.print("(" + cell.i + "," + cell.j + ") ");
            }
            System.out.println();
        }
    }
}


public class FigureExtractor {

    // Описание направлений движения
    static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // Метод для поиска всех фигур на листе
    public static Set<Set<Cell>> extractFigures(boolean[][] grid) {
        Set<Set<Cell>> figures = new HashSet<>(); // Множество для хранения фигур
        boolean[][] visited = new boolean[grid.length][grid[0].length]; // Матрица для отметки посещенных клеток
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] && !visited[i][j]) { // Если клетка закрашена и не посещена ранее
                    Set<Cell> figure = new HashSet<>(); // Множество для хранения клеток фигуры
                    dfs(grid, visited, figure, i, j); // Обход в глубину для поиска клеток фигуры
                    figures.add(figure); // Добавление фигуры в множество
                }
            }
        }
        return figures;
    }

    // Метод для обхода в глубину
    private static void dfs(boolean[][] grid, boolean[][] visited, Set<Cell> figure, int i, int j) {
        visited[i][j] = true; // Отметка клетки как посещенной
        figure.add(new Cell(i, j)); // Добавление клетки в множество фигуры
        for (int[] direction : DIRECTIONS) { // Поиск соседних клеток в четырех направлениях
            int ni = i + direction[0];
            int nj = j + direction[1];
            if (ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length // Проверка выхода за границы листа
                    && grid[ni][nj] && !visited[ni][nj]) { // Проверка наличия закрашенной и не посещенной клетки
                dfs(grid, visited, figure, ni, nj); // Рекурсивный вызов для обработки соседней клетки
            }
        }
    }

    // Вспомогательный класс для хранения координат клетки
    static class Cell {
        int i;
        int j;
        Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Cell)) return false;
            Cell cell = (Cell) o;
            return i == cell.i && j == cell.j;
        }
        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }
}
