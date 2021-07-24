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


    @FXML
    private void initialize() {
        gc = canvas.getGraphicsContext2D();

        canvas.setHeight(Main.getHEIGHT_TILES() * 25);
        canvas.setWidth(Main.getWIDTH_TILES() * 25);

        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, Main.getWIDTH_TILES() * 25, Main.getHEIGHT_TILES() * 25);

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

        int xPixel = xBox * 25;
        int yPixel = yBox * 25;

        gc.fillRect(xPixel, yPixel, Main.getTileSize(), Main.getTileSize());
    }

    public void onMouseDragged(MouseEvent e) {
        onMouseLeftClick(e.getX(), e.getY());
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
