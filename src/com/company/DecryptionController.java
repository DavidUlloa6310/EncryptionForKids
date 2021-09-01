package com.company;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;

public class DecryptionController {

    @FXML
    private Canvas canvas;

    @FXML
    private TextArea textArea;

    @FXML
    private ChoiceBox binarySelector;

    private GraphicsContext gc;

    private PaintingArray paintingArray;

    private boolean hasClickedShowKeys = false;
    private boolean hasEncrypted = false;

    @FXML
    private void initialize() {
        paintingArray = new PaintingArray();

        gc = canvas.getGraphicsContext2D();

        canvas.setHeight(Main.getHEIGHT_TILES() * Main.getTileSize());
        canvas.setWidth(Main.getWIDTH_TILES() * Main.getTileSize());

        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, Main.getWIDTH_TILES() * Main.getTileSize(), Main.getHEIGHT_TILES() * Main.getTileSize());

        binarySelector.setItems(FXCollections.observableArrayList("2^2", "2^3"));

        binarySelector.setValue("2^2");
    }

    public void paintCanvas() {
        for (int r = 0; r < Main.getHEIGHT_TILES(); r++) {
            for (int c = 0; c < Main.getWIDTH_TILES(); c++) {
                if (c >= paintingArray.getArray()[0].length) break;
            }

            if (r >= paintingArray.getArray().length) break;

        }
    }

    public void decrypt() {

        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, Main.getWIDTH_TILES() * Main.getTileSize(), Main.getHEIGHT_TILES() * Main.getTileSize());

        String[] lines = textArea.getText().split("\\r?\\n");

        int squareRow = 0;
        int squareCol = 0;

        for (int r = 0; r < lines.length; r++) {
            String line = lines[r];
            String[] nums = line.split(" ");

            for (int c = 0; c < nums.length; c++) {
                String num = nums[c];
                paintSquare(num, squareRow, squareCol);
                squareCol += 2;
            }

            squareCol = 0;
            squareRow += 2;
        }
    }

    public void paintSquare(String num, int startRow, int startCol) {

        if (binarySelector.getValue().equals("2^2")) {
            paintCanvasPointTwoDigits(num.substring(0, 2), startRow, startCol);
            paintCanvasPointTwoDigits(num.substring(2, 4), startRow, startCol + 1);
            paintCanvasPointTwoDigits(num.substring(4, 6), startRow + 1, startCol + 1);
            paintCanvasPointTwoDigits(num.substring(6), startRow + 1,  startCol);
        } else {
            try {
                paintCanvasPoint(num.substring(0, 3), startRow, startCol);
                paintCanvasPoint(num.substring(3, 6), startRow, startCol + 1);
                paintCanvasPoint(num.substring(6, 9), startRow + 1, startCol + 1);
                paintCanvasPoint(num.substring(9), startRow + 1,  startCol);
            } catch (Exception ignored){

            }
        }
    }

    public void paintCanvasPoint(String num, int r, int c) {
        switch (num) {
            case "001":
            case "01":
                gc.setFill(ColorChoices.getColorTwo());
                break;
            case "010":
            case "10":
                gc.setFill(ColorChoices.getColorThree());
                break;
            case "011":
            case "11":
                gc.setFill(ColorChoices.getColorFour());
                break;
            case "100":
                gc.setFill(ColorChoices.getColorFive());
                break;
            case "101":
                gc.setFill(ColorChoices.getColorSix());
                break;
            case "110":
                gc.setFill(ColorChoices.getColorSeven());
                break;
            case "111":
                gc.setFill(ColorChoices.getColorEight());
                break;
            default:
                gc.setFill(ColorChoices.getColorOne());
                break;
        }

        gc.fillRect(c * 25, r * 25, 25, 25);
    }

        public void paintCanvasPointTwoDigits(String num, int r, int c) {
            switch (num) {
                case "01":
                    gc.setFill(ColorChoices.getColorTwo());
                    break;
                case "10":
                    gc.setFill(ColorChoices.getColorThree());
                    break;
                case "11":
                    gc.setFill(ColorChoices.getColorFour());
                    break;
                default:
                    gc.setFill(ColorChoices.getColorOne());
                    break;
            }

        gc.fillRect(c * 25, r * 25, 25, 25);
    }

    public void toMenu() {
        SceneLibrary.playMenu();
    }

}
