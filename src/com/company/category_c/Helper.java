package com.company.category_c;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * класс организующий сохренение и выгрузку истории операций и сохрененного числа
 */
public class Helper {

    public static final int HISTORY_SIZE = 100;

    public static final String HISTORY_TXT = "history.txt";
    public static final String HISTORY_M_TXT = "historyM.txt";

    public void saveHistory(String string) {
        try (FileWriter writer = new FileWriter(HISTORY_TXT, true)) {
            writer.write(string);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void saveMemory(double d) {
        try (FileWriter writer = new FileWriter(HISTORY_M_TXT, false)) {
            writer.write(d + "\n");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String loadMemory() {
        try (FileReader reader = new FileReader(HISTORY_M_TXT)) {
            Scanner scan = new Scanner(reader);
            return scan.nextLine();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return "";
    }

    public List<String> loadHistory() {
        List<String> histTmp = new ArrayList<>();

        try (FileReader reader = new FileReader(HISTORY_TXT)) {
            Scanner scan = new Scanner(reader);
            while (scan.hasNext()) {
                histTmp.add(scan.nextLine());
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        if (histTmp.size() > HISTORY_SIZE) {
            histTmp = histTmp.subList(histTmp.size() - HISTORY_SIZE, histTmp.size());
        }
        return histTmp;
    }

    public void clearHistory() {
        try (FileWriter writer = new FileWriter(HISTORY_TXT, false)) {
            writer.write("");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
