package com.company.category_a;

public class Task5 {

    private int n, m, k, f;
    private static final int[][] ARRAY = {
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 0},
            {2, 2, 2, 2, 1, 2, 1, 2, 3, 1},
            {2, 7, 7, 8, 1, 1, 2, 1, 1, 0},
            {6, 7, 7, 8, 1, 2, 3, 4, 6, 8}}; // массив
    private static final int[][] WINDOW = {
            {1, 2, 1},
            {1, 1, 2}}; // окно

    public void runTask() {
        readData();
        checkCoordinate();
    }

    private void readData() {
        n = ARRAY.length;
        m = ARRAY[0].length;
        k = WINDOW.length;
        f = WINDOW[0].length;
    }

    /**
     * перебирает координаты массива
     */
    private void checkCoordinate() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ARRAY[i][j] == WINDOW[0][0] && m - j >= f) {
                    if (findWindow(i, j)) {
                        return;
                    }
                }
            }
        }
        System.out.println("FAIL");
    }

    /**
     * по координатам проверяет наличие окна в массиве
     * @param x координата
     * @param y координата
     */
    private boolean findWindow(int x, int y) {
        int cX = x, cY = y;
        int counter = 0, counterMain = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < f; j++) {
                if (WINDOW[i][j] == ARRAY[cX][cY]) {
                    counterMain++;
                } else {
                    return false;
                }
                if (counter < f) {
                    cY++;
                    counter++;
                }
                if (counter == f) {
                    counter = 0;
                    cX++;
                    cY -= f;
                }
            }
            if (counterMain == k * f) {
                System.out.printf("(%d, %d)", x, y);
                return true;
            }
        }
        return false;
    }
}
