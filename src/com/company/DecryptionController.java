package com.company;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
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
        for (int r = 0; r < lines.length; r++) {
            String line = lines[r];
            String[] nums = line.split(" ");
            for (int c = 0; c < nums.length; c++) {
                String num = nums[c];
                paintCanvasPoint(num, r, c);
            }
        }
    }

    public void paintCanvasPoint(String num, int r, int c) {
        switch (num) {
            case "001":
                gc.setFill(Color.RED);
                break;
            case "010":
                gc.setFill(Color.BLUE);
                break;
            case "011":
                gc.setFill(Color.GREEN);
                break;
            case "100":
                gc.setFill(Color.YELLOW);
                break;
            default:
                gc.setFill(Color.WHITE);
                break;
        }

        gc.fillRect(c * 25, r * 25, 25, 25);
    }

}
