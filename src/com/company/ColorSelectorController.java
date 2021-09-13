package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.paint.Color;

public class ColorSelectorController {

    @FXML
    private ChoiceBox choiceBoxOne;

    @FXML
    private ChoiceBox choiceBoxTwo;

    @FXML
    private ChoiceBox choiceBoxThree;

    @FXML
    private ChoiceBox choiceBoxFour;

    @FXML
    private ChoiceBox choiceBoxFive;

    @FXML
    private ChoiceBox choiceBoxSix;

    @FXML
    private ChoiceBox choiceBoxSeven;

    @FXML
    private ChoiceBox choiceBoxEight;

    @FXML
    private void initialize() {
        setChoiceBoxes();
    }

    public void setChoiceBoxes() {

        ObservableList<String> colors = FXCollections.observableArrayList("White", "Red", "Maroon", "Pink", "Orange", "Orange Red", "Peach", "Green",
                "Lime", "Forest", "Blue", "Light Blue", "Navy Blue", "Yellow", "Gold", "Indigo", "Brown", "Saddlebrown", "Grey", "Black");

        choiceBoxOne.setItems(colors);
        choiceBoxOne.setValue("White");

        choiceBoxTwo.setItems(colors);
        choiceBoxTwo.setValue("Red");

        choiceBoxThree.setItems(colors);
        choiceBoxThree.setValue("Blue");

        choiceBoxFour.setItems(colors);
        choiceBoxFour.setValue("Green");

        choiceBoxFive.setItems(colors);
        choiceBoxFive.setValue("Yellow");

        choiceBoxSix.setItems(colors);
        choiceBoxSix.setValue("Indigo");

        choiceBoxSeven.setItems(colors);
        choiceBoxSeven.setValue("Brown");

        choiceBoxEight.setItems(colors);
        choiceBoxEight.setValue("Black");


        choiceBoxOne.setOnAction(e -> {
            SceneLibrary.encryptController.changeRadioButtonOneName((String) choiceBoxOne.getValue());
            SceneLibrary.encryptController.setColorOne(getColor((String) choiceBoxOne.getValue()));
            SceneLibrary.encryptController.resetCanvas();
        });

        choiceBoxTwo.setOnAction(e -> {
            SceneLibrary.encryptController.changeRadioButtonTwoName((String) choiceBoxTwo.getValue());
            SceneLibrary.encryptController.setColorTwo(getColor((String) choiceBoxTwo.getValue()));
            SceneLibrary.encryptController.resetCanvas();
        });

        choiceBoxThree.setOnAction(e -> {
            SceneLibrary.encryptController.changeRadioButtonThreeName((String) choiceBoxThree.getValue());
            SceneLibrary.encryptController.setColorThree(getColor((String) choiceBoxThree.getValue()));
            SceneLibrary.encryptController.resetCanvas();
        });

        choiceBoxFour.setOnAction(e -> {
            SceneLibrary.encryptController.changeRadioButtonFourName((String) choiceBoxFour.getValue());
            SceneLibrary.encryptController.setColorFour(getColor((String) choiceBoxFour.getValue()));
            SceneLibrary.encryptController.resetCanvas();
        });

        choiceBoxFive.setOnAction(e -> {
            SceneLibrary.encryptController.changeRadioButtonFiveName((String) choiceBoxFive.getValue());
            SceneLibrary.encryptController.setColorFive(getColor((String) choiceBoxFive.getValue()));
            SceneLibrary.encryptController.resetCanvas();
        });

        choiceBoxSix.setOnAction(e -> {
            SceneLibrary.encryptController.changeRadioButtonSixName((String) choiceBoxSix.getValue());
            SceneLibrary.encryptController.setColorSix(getColor((String) choiceBoxSix.getValue()));
            SceneLibrary.encryptController.resetCanvas();
        });

        choiceBoxSeven.setOnAction(e -> {
            SceneLibrary.encryptController.changeRadioButtonSevenName((String) choiceBoxSeven.getValue());
            SceneLibrary.encryptController.setColorSeven(getColor((String) choiceBoxSeven.getValue()));
            SceneLibrary.encryptController.resetCanvas();
        });

        choiceBoxEight.setOnAction(e -> {
            SceneLibrary.encryptController.changeRadioButtonEightName((String) choiceBoxEight.getValue());
            SceneLibrary.encryptController.setColorEight(getColor((String) choiceBoxEight.getValue()));
            SceneLibrary.encryptController.resetCanvas();
        });



    }

    public static Color getColor(String color) {
        switch (color) {
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

    public void playEncryption() {
        SceneLibrary.playEncryption();
    }

    public void playDecryption() {
        SceneLibrary.playDecryption();
    }

    public void playMenu() {
        SceneLibrary.playMenu();
    }
}
