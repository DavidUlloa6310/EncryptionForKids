package com.company;

import javafx.scene.paint.Color;

public class ColorChoices {
    private static Color colorOne = Color.WHITE;
    private static Color colorTwo = Color.RED;
    private static Color colorThree = Color.BLUE;
    private static Color colorFour = Color.GREEN;
    private static Color colorFive = Color.YELLOW;
    private static Color colorSix = Color.INDIGO;
    private static Color colorSeven = Color.BROWN;
    private static Color colorEight = Color.BLACK;

    public static Color getColorOne() {
        return colorOne;
    }

    public static void setColorOne(Color colorOne) {
        ColorChoices.colorOne = colorOne;
    }

    public static Color getColorTwo() {
        return colorTwo;
    }

    public static void setColorTwo(Color colorTwo) {
        ColorChoices.colorTwo = colorTwo;
    }

    public static Color getColorThree() {
        return colorThree;
    }

    public static void setColorThree(Color colorThree) {
        ColorChoices.colorThree = colorThree;
    }

    public static Color getColorFour() {
        return colorFour;
    }

    public static void setColorFour(Color colorFour) {
        ColorChoices.colorFour = colorFour;
    }

    public static Color getColorFive() {
        return colorFive;
    }

    public static void setColorFive(Color colorFive) {
        ColorChoices.colorFive = colorFive;
    }

    public static Color getColorSix() {
        return colorSix;
    }

    public static void setColorSix(Color colorSix) {
        ColorChoices.colorSix = colorSix;
    }

    public static Color getColorSeven() {
        return colorSeven;
    }

    public static void setColorSeven(Color colorSeven) {
        ColorChoices.colorSeven = colorSeven;
    }

    public static Color getColorEight() {
        return colorEight;
    }

    public static void setColorEight(Color colorEight) {
        ColorChoices.colorEight = colorEight;
    }

    public static Color getColor(String color) {
        switch(color) {
            case "Red":
                return Color.RED;
            case "White":
                return Color.WHITE;
            case "Maroon":
                return Color.MAROON;
            case "Pink":
                return Color.PINK;
            case "Orange":
                return Color.ORANGE;

            case "Orange Red":
                return Color.ORANGERED;

            case "Peach":
                return Color.PEACHPUFF;

            case "Green":
                return Color.GREEN;

            case "Lime":
                return Color.LIME;

            case "Forrest":
                return Color.FORESTGREEN;

            case "Blue":
                return Color.BLUE;

            case "Light Blue":
                return Color.LIGHTBLUE;

            case "Navy Blue":
                return Color.NAVY;

            case "Yellow":
                return Color.YELLOW;

            case "GOLD":
                return Color.GOLD;

            case "Indigo":
                return Color.INDIGO;

            case "Brown":
                return Color.BROWN;

            case "Saddlebrown":
                return Color.SADDLEBROWN;

            case "Grey":
                return Color.GREY;

            case "Black":
                return Color.BLACK;

        }
        return Color.WHITE;
    }
}
