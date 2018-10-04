package com.company.category_c;

import java.util.List;
import java.util.Scanner;

public class Calculator {

    private Helper helper = new Helper();
    private double oldNumber = 0;

    public void runCalculator() {
        System.out.println("Помощь 'help'");
        String in = "0.0";
        while (true) {
            saveHistory(print());
            in = readData();
            saveHistory(in);
        }
    }

    private double print() {
        System.out.print(oldNumber + " >> ");
        return oldNumber;
    }

    private void saveHistory(String in) {
        helper.saveHistory(in + "\n");
    }

    private void saveHistory(double old) {
        helper.saveHistory(String.valueOf(old) + " >> ");
    }

    private String readData() {
        Scanner scanner = new Scanner(System.in);
        String cmd = scanner.nextLine().trim().replaceAll(" ", "");
        if (!difficultOperations(cmd)) {
            easyOperations(cmd);
        }
        return (cmd.equals(Keys.CLR) || cmd.equals(Keys.HELP) ? "" : cmd);
    }

    /**
     * @param str command
     * @return true if {@param str} was executed
     */
    private boolean difficultOperations(String str) {
        switch (str) {
            case Keys.SIN:
                oldNumber = Math.sin(oldNumber);
                break;
            case Keys.COS:
                oldNumber = Math.cos(oldNumber);
                break;
            case Keys.TAN:
                oldNumber = Math.tan(oldNumber);
                break;
            case Keys.HELP:
                System.out.println("\n" + Keys.HELP_TEXT + "\n");
                break;
            case Keys.CLR:
                helper.clearHistory();
                break;
            case Keys.SAVE:
                System.out.println("SAVED: " + oldNumber);
                helper.saveMemory(oldNumber);
                break;
            case Keys.LOAD:
                double d = Double.parseDouble(helper.loadMemory());
                System.out.println("LOAD MEMORY: " + d);
                oldNumber = d;
                break;
            case Keys.LOAD_HISTORY:
                List<String> history = helper.loadHistory();
                System.out.print("\nLOAD HISTORY: ");
                for (String cmd : history) {
                    System.out.println(cmd);
                }
                System.out.println();
                break;
            default:
                return false;
        }
        return true;
    }

    private void easyOperations(String str) {
        char sign = str.charAt(0);
        double number;
        if (str.length() == 1) {
            number = Float.parseFloat(str);
        } else {
            number = Float.parseFloat(str.substring(1));
        }
        switch (sign) {
            case Keys.PLUS:
                oldNumber += number;
                break;
            case Keys.MINUS:
                oldNumber -= number;
                break;
            case Keys.MULTIPLY:
                oldNumber *= number;
                break;
            case Keys.DIVIDE:
                oldNumber /= number;
                break;
            case Keys.EXPONENTIATION:
                oldNumber = Math.pow(oldNumber, number);
                break;
            case Keys.REMAINDER_OF_DIVISION:
                oldNumber %= number;
                break;
            default:
                oldNumber = Float.parseFloat(str);
                break;
        }
    }
}
