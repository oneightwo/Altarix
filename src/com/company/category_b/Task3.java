package com.company.category_b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task3 {

    private static final char DOWN = 'd';
    private static final char RIGHT = 'r';
    private static final int MARKER_STAR = -1;
    private static final int MARKER_A = -2;
    private static final int MARKER_B = -3;
    private List<List<Integer>> arrayList;
    private int bestSum = -1;
    private List<Character> variant;
    private List<Character> answer;

    public void runTask() {
        System.out.print("Введите размер матрицы: ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        initPathResults(size);
        arrayList = generateArray(size);
        int sum = arrayList.get(0).get(0);
        findMinWay(-1, 0, 0, sum, size);
        printTrace(size, arrayList, answer);
    }

    private void initPathResults(int size) {
        variant = Arrays.asList(new Character[2 * (size - 1)]);
        answer = Arrays.asList(new Character[2 * (size - 1)]);
    }

    /**
     * @param size размер списка
     * @return список из случайных чисел
     */
    private List<List<Integer>> generateArray(int size) {
        List<List<Integer>> arrayList = new ArrayList<>();
        for (int q = 0; q < size; q++) {
            arrayList.add(Arrays.asList(new Integer[size]));
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arrayList.get(i).set(j, (int) (Math.random() * 99));
            }
        }
        printMatrix(size, arrayList);
        return arrayList;
    }

    /**
     * выводит матрицу с кратчайшем путем
     * @param size размер матрицы
     * @param matrix матрица
     */
    private void printMatrix(int size, List<List<Integer>> matrix) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int num = matrix.get(i).get(j);
                String toPrint;
                switch (num) {
                    case MARKER_A:
                        toPrint = "A";
                        break;
                    case MARKER_B:
                        toPrint = "B";
                        break;
                    case MARKER_STAR:
                        toPrint = "*";
                        break;
                    default:
                        toPrint = "" + num;
                        break;
                }
                System.out.print(toPrint + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * находит мимимальной по сумме путь в матрице
     * @param stepNumber номер шага
     * @param x координата
     * @param y координата
     * @param sum сумма
     * @param size размер матрицы
     */
    private void findMinWay(int stepNumber, int x, int y, int sum, int size) {
        if (x == size - 1 && y == size - 1) {
            if (bestSum == -1 || sum < bestSum) {
                bestSum = sum;
                answer = new ArrayList<>(variant);
            }
        } else if (sum < bestSum || bestSum == -1) {
            stepNumber++;
            if (x < size - 1) {
                variant.set(stepNumber, DOWN);
                findMinWay(stepNumber, x + 1, y, sum + arrayList.get(x + 1).get(y), size);
            }
            if (y < size - 1) {
                variant.set(stepNumber, RIGHT);
                findMinWay(stepNumber, x, y + 1, sum + arrayList.get(x).get(y + 1), size);
            }
        }
    }

    /**
     * помечает элементы матрицы, по которым проходит кратчайший путь
     * @param path кратчайший путь
     */
    private void printTrace(int size, List<List<Integer>> matrix, List<Character> path) {
        int i = 0;
        int j = 0;
        for (char way : path) {
            matrix.get(i).set(j, MARKER_STAR);
            switch (way) {
                case RIGHT:
                    j++;
                    break;

                case DOWN:
                    i++;
                    break;
            }
        }
        matrix.get(0).set(0, MARKER_A);
        matrix.get(size - 1).set(size - 1, MARKER_B);
        printMatrix(size, matrix);
    }

}
