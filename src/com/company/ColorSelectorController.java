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
            ColorChoices.setColorOne(ColorChoices.getColor((String) choiceBoxOne.getValue()));
        });

        choiceBoxTwo.setOnAction(e -> {
            ColorChoices.setColorTwo(ColorChoices.getColor((String) choiceBoxTwo.getValue()));
        });

        choiceBoxThree.setOnAction(e -> {
            ColorChoices.setColorThree(ColorChoices.getColor((String) choiceBoxThree.getValue()));
        });

        choiceBoxFour.setOnAction(e -> {
            ColorChoices.setColorFour(ColorChoices.getColor((String) choiceBoxFour.getValue()));
        });

        choiceBoxFive.setOnAction(e -> {
            ColorChoices.setColorFive(ColorChoices.getColor((String) choiceBoxFive.getValue()));
        });

        choiceBoxSix.setOnAction(e -> {
            ColorChoices.setColorSix(ColorChoices.getColor((String) choiceBoxSix.getValue()));
        });

        choiceBoxSeven.setOnAction(e -> {
            ColorChoices.setColorSeven(ColorChoices.getColor((String) choiceBoxSeven.getValue()));
        });

        choiceBoxEight.setOnAction(e -> {
            ColorChoices.setColorEight(ColorChoices.getColor((String) choiceBoxEight.getValue()));
        });



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
