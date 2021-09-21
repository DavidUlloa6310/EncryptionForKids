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

        canvas.setHeight(16 * Main.getTileSize());
        canvas.setWidth(16 * Main.getTileSize());

        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, 16 * Main.getTileSize(), 16 * Main.getTileSize());

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
        gc.fillRect(0, 0, 16 * Main.getTileSize(), 16 * Main.getTileSize());

        if (textArea.getText().equals("")) {
            JOP.msg("Try inputting some text!");
            return;
        }

        String[] lines = textArea.getText().split("   ");

        int squareRow = 0;
        int squareCol = 0;

        for (int r = 0; r < lines.length; r++) {
            String line = lines[r];
            String[] nums = line.split("  ");

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
            paintCanvasPointTwoDigits(num.split(" ")[0], startRow, startCol);
            paintCanvasPointTwoDigits(num.split(" ")[1], startRow, startCol + 1);
            paintCanvasPointTwoDigits(num.split(" ")[2], startRow + 1, startCol + 1);
            paintCanvasPointTwoDigits(num.split(" ")[3], startRow + 1,  startCol);
        } else {
            try {
                paintCanvasPoint(num.split(" ")[0], startRow, startCol);
                paintCanvasPoint(num.split(" ")[1], startRow, startCol + 1);
                paintCanvasPoint(num.split(" ")[2], startRow + 1, startCol + 1);
                paintCanvasPoint(num.split(" ")[3], startRow + 1,  startCol);
            } catch (Exception ignored){

            }
        }
    }

    public void paintCanvasPoint(String num, int r, int c) {
        switch (num) {
            case "001":
            case "01":
                gc.setFill(SceneLibrary.encryptController.getColorTwo());
                break;
            case "010":
            case "10":
                gc.setFill(SceneLibrary.encryptController.getColorThree());
                break;
            case "011":
            case "11":
                gc.setFill(SceneLibrary.encryptController.getColorFour());
                break;
            case "100":
                gc.setFill(SceneLibrary.encryptController.getColorFive());
                break;
            case "101":
                gc.setFill(SceneLibrary.encryptController.getColorSix());
                break;
            case "110":
                gc.setFill(SceneLibrary.encryptController.getColorSeven());
                break;
            case "111":
                gc.setFill(SceneLibrary.encryptController.getColorEight());
                break;
            default:
                gc.setFill(SceneLibrary.encryptController.getColorOne());
                break;
        }

        gc.fillRect(c * 25, r * 25, 25, 25);
    }

        public void paintCanvasPointTwoDigits(String num, int r, int c) {
            switch (num) {
                case "01":
                    gc.setFill(SceneLibrary.encryptController.getColorTwo());
                    break;
                case "10":
                    gc.setFill(SceneLibrary.encryptController.getColorThree());
                    break;
                case "11":
                    gc.setFill(SceneLibrary.encryptController.getColorFour());
                    break;
                default:
                    gc.setFill(SceneLibrary.encryptController.getColorOne());
                    break;
            }

        gc.fillRect(c * 25, r * 25, 25, 25);
    }

    public void toMenu() {
        SceneLibrary.playMenu();
    }

}
