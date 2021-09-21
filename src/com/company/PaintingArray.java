package com.company;

public class PaintingArray {
    private String[][] array;

    public PaintingArray() {
        resetArray();
    }

    public PaintingArray(String array) {
        resetArray();
        processArray(array);
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

    public String encrypt(boolean is2by2) {
        StringBuilder encryption = new StringBuilder();

        for (int r = 0; r < Main.getHEIGHT_TILES(); r += 2) {
            for (int c = 0; c < Main.getWIDTH_TILES(); c += 2) {
                if (is2by2) {
                    encryption.append(array[r][c].substring(1));
                    encryption.append(" ");
                    encryption.append(array[r][c + 1].substring(1));
                    encryption.append(" ");
                    encryption.append(array[r + 1][c + 1].substring(1));
                    encryption.append(" ");
                    encryption.append(array[r + 1][c].substring(1));
                } else {
                    encryption.append(array[r][c]);
                    encryption.append(" ");
                    encryption.append(array[r][c + 1]);
                    encryption.append(" ");
                    encryption.append(array[r + 1][c + 1]);
                    encryption.append(" ");
                    encryption.append(array[r + 1][c]);
                }
                encryption.append("  ");
            }
            encryption.append(" ");
        }
        return encryption.toString();
    }

    public void processArray(String array) {
        String[][] bigArray =  new String[array.split("\n").length][array.split("\n")[0].split(" ").length];
        int r = 0;
        for (String line : array.split("\n")) {
            int c = 0;
            for (String num : line.split(" ")) {
                bigArray[r][c] = num;
                c++;
            }
            r++;
        }

        this.array = bigArray;

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
