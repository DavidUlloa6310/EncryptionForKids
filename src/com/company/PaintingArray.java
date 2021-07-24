package com.company;

import com.company.Main;

public class PaintingArray {
    private String[][] array;

    public PaintingArray() {
        resetArray();
    }

    public void resetArray() {

        array = new String[Main.getHEIGHT_TILES()][Main.getWIDTH_TILES()];

        for (int r = 0; r < Main.getHEIGHT_TILES(); r++) {
            for (int c = 0; c < Main.getWIDTH_TILES(); c++) {
                array[r][c] = "000";
            }
        }
    }

    public void fillSquare(int r, int c, String value) {
        array[r][c] = value;
    }

    public String encrypt() {
        StringBuilder encryption = new StringBuilder();
        for (int r = 0; r < Main.getHEIGHT_TILES(); r++) {
            for (int c = 0; c < Main.getWIDTH_TILES(); c++) {
                encryption.append(array[r][c]);
                encryption.append(" ");
            }
            encryption.append("\n");
        }
        return encryption.toString();
    }

    public String[][] getArray() {
        return array;
    }

    public void printArray() {
        for (int r = 0; r < array.length; r++) {
            for (int c = 0; c < array[0].length; c++) {
                System.out.print(array[r][c]);
                System.out.print(" ");
            }
            System.out.println("\n");
        }
    }
}
