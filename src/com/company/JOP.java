package com.company;

import javax.swing.*;

public class JOP {
    public static void msg(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public static String input(String message) {
        return JOptionPane.showInputDialog(message);
    }

    public static double getHeight() {
        return 25 * Double.parseDouble(input("Please enter the amount of tiles you would like the height of your pictures to be"));
    }

    public static double getWidth() {
        return 25 * Double.parseDouble(input("Please enter the amount of tiles you would like the width of your pictures to be"));
    }
}
