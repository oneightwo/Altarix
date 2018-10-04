package com.company.category_b;

import java.util.*;

public class Task1 {

    private static final char[] SYMBOL = {')', '(', '}', '{', ']', '['};

    public void runTask() {
        System.out.println(checkExpression(readData()) ? "SUCCESS" : "FAIL");
    }

    private char[] readData() {
        System.out.print("Введите скобочное выражение: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toCharArray();
    }

    /**
     * проверяет является ли скобочное выражение правильным
     * @param text скобочное выражение
     */
    private boolean checkExpression(char[] text) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < text.length; i++) {
            for (int j = 1; j < SYMBOL.length; j += 2) {
                if (text[i] == SYMBOL[j]) {
                    stack.push(text[i]);
                }
                if (text[i] == SYMBOL[j - 1]) {
                    if (!(stack.pop() == SYMBOL[j])) {
                        return false;
                    }
                }
            }
        }
        return stack.empty();
    }

}
