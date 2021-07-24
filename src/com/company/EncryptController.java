package com.company;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class EncryptController {

    @FXML
    private Canvas canvas;

    @FXML
    private RadioButton redButton;

    @FXML
    private RadioButton blueButton;

    @FXML
    private RadioButton greenButton;

    @FXML
    private RadioButton yellowButton;

    @FXML
    private RadioButton whiteButton;

    @FXML
    private CheckBox showKeysButton;

    final ToggleGroup group = new ToggleGroup();

    private GraphicsContext gc;

    private PaintingArray paintingArray;

    @FXML
    private void initialize() {
        paintingArray = new PaintingArray();

        gc = canvas.getGraphicsContext2D();

        canvas.setHeight(Main.getHEIGHT_TILES() * Main.getTileSize());
        canvas.setWidth(Main.getWIDTH_TILES() * Main.getTileSize());

        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, Main.getWIDTH_TILES() * Main.getTileSize(), Main.getHEIGHT_TILES() * Main.getTileSize());

        gc.setFill(Color.RED);

        redButton.setToggleGroup(group);
        blueButton.setToggleGroup(group);
        greenButton.setToggleGroup(group);
        yellowButton.setToggleGroup(group);
        whiteButton.setToggleGroup(group);

        redButton.setSelected(true);

    }

    public void clickCanvas(MouseEvent e) {
        if (e.getButton() == MouseButton.PRIMARY) {
            onMouseLeftClick(e.getX(), e.getY());
        }
    }

    public void onMouseLeftClick(double pixelX, double pixelY) {
        int xBox = (int) pixelX / Main.getTileSize();
        int yBox = (int) pixelY / Main.getTileSize();

        if (xBox > Main.getWIDTH_TILES() - 1 || xBox < 0 || yBox < 0 || yBox > Main.getHEIGHT_TILES() - 1)
            return;

        int xPixel = xBox * Main.getTileSize();
        int yPixel = yBox * Main.getTileSize();

        gc.fillRect(xPixel, yPixel, Main.getTileSize(), Main.getTileSize());

        if (Color.RED.equals(gc.getFill())) {
            paintingArray.fillSquare(yBox, xBox, "001");
        } else if (Color.WHITE.equals(gc.getFill())) {
            paintingArray.fillSquare(yBox, xBox, "000");
        } else if (Color.GREEN.equals(gc.getFill())) {
            paintingArray.fillSquare(yBox, xBox, "011");
        } else if (Color.BLUE.equals(gc.getFill())) {
            paintingArray.fillSquare(yBox, xBox, "010");
        } else if (Color.YELLOW.equals(gc.getFill())) {
            paintingArray.fillSquare(yBox, xBox, "100");
        }

        Paint prevColor = gc.getFill();

        gc.setFill(Color.BLACK);

        if (showKeysButton.isSelected()) {
            gc.fillText(paintingArray.getArray()[yBox][xBox], xBox * Main.getTileSize(), yBox * Main.getTileSize() + Main.getTileSize(), Main.getTileSize());
        }

        gc.setFill(prevColor);
    }

    public void onMouseDragged(MouseEvent e) {
        onMouseLeftClick(e.getX(), e.getY());
    }

    public void showKeys() {

        if (showKeysButton.isSelected()) {
            Paint prevColor = gc.getFill();

            gc.setFill(Color.BLACK);

            for (int r = 0; r < Main.getHEIGHT_TILES(); r++) {
                for (int c = 0; c < Main.getWIDTH_TILES(); c++) {
                    gc.fillText(paintingArray.getArray()[r][c], c * Main.getTileSize(), r * Main.getTileSize() + Main.getTileSize(), Main.getTileSize());
                }
            }

            gc.setFill(prevColor);
        } else {
            paintCanvas();
        }
    }

    public void paintCanvas() {

        Paint prevPaint = gc.getFill();

        for (int r = 0; r < Main.getHEIGHT_TILES(); r++) {
            for (int c = 0; c < Main.getWIDTH_TILES(); c++) {
                String square = paintingArray.getArray()[r][c];
                switch (square) {
                    case "000":
                        gc.setFill(Color.WHITE);
                        break;
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
                }

                gc.fillRect(c * Main.getTileSize(), r * Main.getTileSize(), Main.getTileSize(), Main.getTileSize());
            }
        }

        gc.setFill(prevPaint);
    }

    public void redClick() {
        gc.setFill(Color.RED);
    }

    public void blueClick() {
        gc.setFill(Color.BLUE);
    }

    public void yellowClick() {
        gc.setFill(Color.YELLOW);
    }

    public void greenClick() {
        gc.setFill(Color.GREEN);
    }

    public void whiteClick() {
        gc.setFill(Color.WHITE);
    }

}
