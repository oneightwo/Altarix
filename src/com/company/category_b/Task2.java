package com.company.category_b;

import java.util.*;

public class Task2 {

    public void runTask() {
        int size = readData();
        List<Integer> data = generateArray(size);
        Collections.sort(data);
        List<List<Integer>> resultSpiraled = getSpiraled(data, size);
        List<List<Integer>> resultSnake = printSnake(data, size);
        System.out.println("Спираль: ");
        printResult(resultSpiraled);
        System.out.println("Змейка: ");
        printResult(resultSnake);
    }

    private int readData() {
        System.out.print("Введите размер матрицы N*N: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    /**
     * @param size размер списка
     * @return список случайных чисел
     */
    private List<Integer> generateArray(int size) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size * size; i++) {
            result.add(1 + (int) (Math.random() * 9));
        }
        for (int counter : result) {
            System.out.print(counter + " ");
        }
        System.out.println();
        return result;
    }

    /**
     * @param data сортированный список
     * @param size размер списка
     * @return матрица обхода по "змейке"
     */
    private List<List<Integer>> printSnake(List<Integer> data, int size) {
        List<List<Integer>> resultSnake = new ArrayList<>();
        int iStartNot = 0, jStartNot = 0, iStartEven = 0, jStartEven = 0, count = 1, iChange = 1, i = 0, c = 0;
        for (int q = 0; q < size; q++) {
            resultSnake.add(Arrays.asList(new Integer[size]));
        }

        int pos = 0;
        while (count <= size * 2 - 1) {
            if (count % 2 != 0) {
                iStartNot = iChange;
                jStartNot = 0;
                for (int j = 1; j <= iChange; j++) {
                    int iPos = iStartNot - j;
                    int jPos = jStartNot + j - 1;
                    if (iPos < size && jPos < size) {
                        resultSnake.get(iPos).set(jPos, data.get(pos++));
                    }
                }
            }
            if (count % 2 == 0) {
                iStartEven = 0;
                jStartEven = iChange;
                for (int j = 0; j < iChange; j++) {
                    int iPos = iStartEven + j;
                    int jPos = jStartEven - j - 1;
                    if (iPos < size && jPos < size) {
                        resultSnake.get(iPos).set(jPos, data.get(pos++));
                    }
                }
            }
            count++;
            iChange++;
        }
        return resultSnake;
    }

    /**
     * @param data сортированный список
     * @param size размер списка
     * @return матрица обхода по "спирали"
     */
    private List<List<Integer>> getSpiraled(List<Integer> data, int size) {
        int iStart = 0, jStart = 0, jEnd = size - 1, iEnd = size - 1;
        List<List<Integer>> result = new ArrayList<>();
        for (int q = 0; q < size; q++) {
            result.add(Arrays.asList(new Integer[size]));
        }
        int count = 0;
        do {
            for (int i = iStart; i <= iEnd; i++) {
                result.get(jStart).set(i, data.get(count++));
            }
            for (int j = jStart + 1; j <= jEnd; j++) {
                result.get(j).set(iEnd, data.get(count++));
            }
            for (int i = iEnd - 1; i >= iStart; i--) {
                result.get(jEnd).set(i, data.get(count++));
            }
            for (int j = jEnd - 1; j > jStart; j--) {
                result.get(j).set(iStart, data.get(count++));
            }
            iStart++;
            jStart++;
            iEnd--;
            jEnd--;
        } while (iStart <= iEnd);
        return result;
    }

    private void printResult(List<List<Integer>> result) {
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.size(); j++) {
                Integer num = result.get(i).get(j);
                System.out.print(num == null ? 0 : num);
            }
            System.out.println();
        }
    }
}
