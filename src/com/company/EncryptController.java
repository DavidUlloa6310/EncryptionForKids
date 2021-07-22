package com.company;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

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

    final ToggleGroup group = new ToggleGroup();

    private GraphicsContext gc;

    private double WIDTH_PIXELS;
    private double HEIGHT_PIXELS;

    private int HEIGHT_TILES;
    private int WIDTH_TILES;



    @FXML
    private void initialize() {
        gc = canvas.getGraphicsContext2D();

        WIDTH_PIXELS = JOP.getWidth();
        HEIGHT_PIXELS = JOP.getHeight();

        HEIGHT_TILES =  (int) HEIGHT_PIXELS/ Main.getTileSize();
        WIDTH_TILES = (int) WIDTH_PIXELS / Main.getTileSize();

        canvas.setHeight(HEIGHT_PIXELS);
        canvas.setWidth(WIDTH_PIXELS);

        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, WIDTH_PIXELS, HEIGHT_PIXELS);

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

        if (xBox > WIDTH_TILES - 1 || xBox < 0 || yBox < 0 || yBox > HEIGHT_TILES - 1)
            return;

        int xPixel = xBox * 25;
        int yPixel = yBox * 25;

        gc.fillRect(xPixel, yPixel, Main.getTileSize(), Main.getTileSize());
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
