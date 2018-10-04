package com.company.category_a;

import java.util.Scanner;

public class Task3 {

    public void runTask() {
        printStairs(readCount());
    }

    private int readCount() {
        System.out.print("Введите количество ступенек: ");
        Scanner read = new Scanner(System.in);
        return read.nextInt();
    }


    private void printStairs(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append('#');
        }
        String s = sb.toString();
        for (int i = 1; i <= count; i++) {
            String st = "%" + count + "." + i + "s%n";
            System.out.printf(st, s);
        }
    }
}
