package com.company.category_a;

import java.util.ArrayList;
import java.util.Scanner;

public class Task4 {

    private ArrayList<Integer> arrayList = new ArrayList<>();
    private int result = 0;

    public void runTask() {
        checkPair(readData());
        printResult();
    }

    private int readData() {
        int divider;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длину массива: ");
        int lenght = scanner.nextInt();
        System.out.print("Введите массив: ");
        for (int i = 0; i < lenght; i++){
            arrayList.add(scanner.nextInt());
        }
        System.out.print("Введите делитель: ");
        divider = scanner.nextInt();
        return divider;
    }

    /**
     * находит количесво пар сумм, делящихся на divider
     */
    private void checkPair(int divider) {
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j < i; j++) {
                if ((arrayList.get(i) + arrayList.get(j)) % divider == 0) {
                    result++;
                }
            }
        }
    }

    private void printResult() {
        System.out.print("Количество пар: " + result);
    }

}

