package com.company.category_a;

import java.util.Scanner;

public class Task1 {

    private static final char[] TEXT = {'A', 'B', 'C', 'D'};

    public void runTask() {
        double[][] top = readData();
        double[][] vector = calculateTheVector(top);
        double[] area = calculateTheArea(vector);
        System.out.println(isInside(area) ? "IN" : "OUT");
    }

    private double[][] readData() {
        double[][] result = new double[4][2];
        Scanner read = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            printHint(i);
            for (int j = 0; j < 2; j++) {
                result[i][j] = read.nextDouble();
            }
        }
        return result;
    }

    private void printHint(int i) {
        System.out.print("Введите координаты точки " + TEXT[i] + ": ");
    }

    /**
     * по данным координатам точек находит попарно все вектора
     * @param top массив координат точек
     * @return массив векторов
     */
    private double[][] calculateTheVector(double[][] top) {
        double[][] result = new double[6][2];
        for (int i = 0; i < 2; i++) {
            result[i][0] = top[i + 1][0] - top[i][0];
            result[i][1] = top[i + 1][1] - top[i][1];
        }

        result[2][0] = top[0][0] - top[2][0];
        result[2][1] = top[0][1] - top[2][1];

        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 2; j++) {
                result[i][0] = top[i - 3][0] - top[3][0];
                result[i][1] = top[i - 3][1] - top[3][1];
            }
        }
        return result;
    }

    /**
     * по данному массиву векторов расчитывает площади фигур
     * @param vector массив векторов
     * @return массив площадей фигур
     */
    private double[] calculateTheArea(double[][] vector) {
        double[] result = new double[4];
        result[0] = Math.abs(vector[0][0] * vector[1][1] - vector[1][0] * vector[0][1]) / 2;
        for (int i = 0; i < 3; i++) {
            result[i + 1] = Math.abs(vector[i][0] * vector[i + 3][1] - vector[i + 3][0] * vector[i][1]) / 2;
        }
        return result;
    }

    /**
     * по данному массиву площадей фигур проверяет принадлежит ли точка фигуре
     * @param area массив площадей фигур
     */
    private boolean isInside(double[] area) {
        return area[0] == area[1] + area[2] + area[3];
    }
}
