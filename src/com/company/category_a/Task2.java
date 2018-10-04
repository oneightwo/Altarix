package com.company.category_a;

import java.util.Scanner;

public class Task2 {

    public void runTask() {
        System.out.println("Разница между суммами диагоналей: " +  getDifference(readData()));
    }

    private double[] readData() {
        double[] result = new double[9];
        System.out.println("Введите квадратную матрицу 3x3: ");
        Scanner read = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            result[i] = read.nextDouble();
        }
        return result;
    }

    /**
     * по данному массиву рассчитывает разницу между диагоналями матрицы
     * @return абсолютная величина разницы между суммами диагоналей матрицы
     */
    private double getDifference(double[] matrix) {
        double diagonalOne = 0, diagonalTwo = 0;
        for (int i = 0; i < 9; i += 4) {
            diagonalOne += matrix[i];
        }
        for (int i = 2; i < 7; i += 2) {
            diagonalTwo += matrix[i];
        }
        return Math.abs(diagonalOne - diagonalTwo);
    }
}
