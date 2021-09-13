package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class EncryptController {

    @FXML
    private Canvas canvas;

    @FXML
    private RadioButton colorOneButton;

    @FXML
    private RadioButton colorTwoButton;

    @FXML
    private RadioButton colorThreeButton;

    @FXML
    private RadioButton colorFourButton;

    @FXML
    private RadioButton colorFiveButton;

    @FXML
    private RadioButton colorSixButton;

    @FXML
    private RadioButton colorSevenButton;

    @FXML
    private RadioButton colorEightButton;

    @FXML
    private CheckBox showKeysButton;

    @FXML
    private TextArea textArea;

    @FXML
    private VBox vBox;

    @FXML
    private HBox extraColors;

    @FXML
    private ChoiceBox binarySelector;

    @FXML
    private ChoiceBox canvasSizeChoiceBox;

    private Color colorOne = Color.WHITE;
    private Color colorTwo = Color.RED;
    private Color colorThree = Color.BLUE;
    private Color colorFour = Color.GREEN;
    private Color colorFive = Color.YELLOW;
    private Color colorSix = Color.INDIGO;
    private Color colorSeven = Color.BROWN;
    private Color colorEight = Color.BLACK;

    final ToggleGroup group = new ToggleGroup();

    private GraphicsContext gc;

    private PaintingArray paintingArray;

    private boolean hasClickedShowKeys = false;
    private boolean hasEncrypted = false;

    @FXML
    private void initialize() {

        gc = canvas.getGraphicsContext2D();

        canvas.setHeight(Main.getHEIGHT_TILES() * Main.getTileSize());
        canvas.setWidth(Main.getWIDTH_TILES() * Main.getTileSize());

        resetCanvas();

        colorOneButton.setToggleGroup(group);
        colorTwoButton.setToggleGroup(group);
        colorThreeButton.setToggleGroup(group);
        colorFourButton.setToggleGroup(group);
        colorFiveButton.setToggleGroup(group);
        colorSevenButton.setToggleGroup(group);
        colorEightButton.setToggleGroup(group);
        colorSixButton.setToggleGroup(group);


        colorOneButton.setSelected(true);

        ObservableList<String> options = FXCollections.observableArrayList("2^2","2^3");
        binarySelector.setValue("2^2");
        binarySelector.setItems(options);

        vBox.getChildren().remove(extraColors);

        binarySelector.setOnAction(event -> changeBinary());

        canvasSizeChoiceBox.setItems(FXCollections.observableArrayList("8*8", "12*12", "16*16"));
        canvasSizeChoiceBox.setValue("8*8");

        canvasSizeChoiceBox.setOnAction(e -> {
            switch ((String) canvasSizeChoiceBox.getValue()) {
                case "8*8":
                    Main.setHeightTiles(8);
                    Main.setWidthTiles(8);
                    break;
                case "12*12":
                    Main.setWidthTiles(12);
                    Main.setHeightTiles(12);
                    break;
                case "16*16":
                    Main.setWidthTiles(16);
                    Main.setHeightTiles(16);
                    break;
            }

            resetCanvas();
        });

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

        if (colorOne.equals(gc.getFill())) {
            paintingArray.fillSquare(yBox, xBox, "000");
        } else if (colorTwo.equals(gc.getFill())) {
            paintingArray.fillSquare(yBox, xBox, "001");
        } else if (colorThree.equals(gc.getFill())) {
            paintingArray.fillSquare(yBox, xBox, "010");
        } else if (colorFour.equals(gc.getFill())) {
            paintingArray.fillSquare(yBox, xBox, "011");
        } else if (colorFive.equals(gc.getFill())) {
            paintingArray.fillSquare(yBox, xBox, "100");
        } else if (colorSix.equals(gc.getFill())) {
            paintingArray.fillSquare(yBox, xBox, "101");
        } else if (colorSeven.equals(gc.getFill())) {
            paintingArray.fillSquare(yBox, xBox, "110");
        } else if (colorEight.equals(gc.getFill())) {
            paintingArray.fillSquare(yBox, xBox, "111");
        }

        Paint prevColor = gc.getFill();

        if (prevColor.equals(Color.BLACK)) {
            gc.setFill(Color.WHITE);
        } else {
            gc.setFill(Color.BLACK);
        }

        if (showKeysButton.isSelected()) {
            String number;
            if (binarySelector.getValue().equals("2^2")) {
                number = paintingArray.getArray()[yBox][xBox].substring(1);
            } else {
                number = paintingArray.getArray()[yBox][xBox];
            }
            gc.fillText(number, xBox * Main.getTileSize(), yBox * Main.getTileSize() + Main.getTileSize(), Main.getTileSize());
        }

        gc.setFill(prevColor);
    }

    public void onMouseDragged(MouseEvent e) {
        onMouseLeftClick(e.getX(), e.getY());
    }

    public void showKeys() {

        if (showKeysButton.isSelected()) {

            if (!hasClickedShowKeys) {
                hasClickedShowKeys = true;
                JOP.msg("Each color has a unique code! Try the different colors to see their codes.");
            }

            Paint prevColor = gc.getFill();

            gc.setFill(Color.BLACK);

            for (int r = 0; r < Main.getHEIGHT_TILES(); r++) {
                for (int c = 0; c < Main.getWIDTH_TILES(); c++) {
                    String number;
                    if (binarySelector.getValue().equals("2^2")) {
                        number = paintingArray.getArray()[r][c].substring(1);
                    } else {
                        number = paintingArray.getArray()[r][c];
                    }
                    gc.fillText(number, c * Main.getTileSize(), r * Main.getTileSize() + Main.getTileSize(), Main.getTileSize());
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
                        gc.setFill(colorOne);
                        break;
                    case "001":
                        gc.setFill(colorTwo);
                        break;
                    case "010":
                        gc.setFill(colorThree);
                        break;
                    case "011":
                        gc.setFill(colorFour);
                        break;
                }

                gc.fillRect(c * Main.getTileSize(), r * Main.getTileSize(), Main.getTileSize(), Main.getTileSize());
            }
        }

        gc.setFill(prevPaint);
    }

    public void encryptPainting() {
        if (!hasEncrypted) {
            hasEncrypted = true;
            JOP.msg("With each square have a coding, all the codes are put together to make a special encryption (or secret message)!" +
                    "\n" + "Only those that know the pattern and codes can turn this secret message back into the painting");
        }

        textArea.setText("The secret message (or encryption) for your painting is: \n\n" + paintingArray.encrypt(binarySelector.getValue().equals("2^2")));
    }

    public void changeBinary() {
        if (binarySelector.getValue().equals("2^2")) {
            if (vBox.getChildren().contains(extraColors)) {
                vBox.getChildren().remove(extraColors);
                gc.setFill(Color.WHITE);
                paintingArray = new PaintingArray();
                paintCanvas();
            }
        } else if (!vBox.getChildren().contains(extraColors)) {
                vBox.getChildren().add(1, extraColors);
                }
    }

    public void resetCanvas() {
        paintingArray = new PaintingArray();
        gc.setFill(colorOne);
        canvas.setWidth(Main.getTileSize() * Main.getWIDTH_TILES());
        canvas.setHeight(Main.getTileSize() * Main.getHEIGHT_TILES());
        gc.fillRect(0, 0, Main.getWIDTH_TILES() * Main.getTileSize(), Main.getHEIGHT_TILES() * Main.getTileSize());

    }

    public void colorOneClick() {
        gc.setFill(colorOne);
    }

    public void colorTwoClick() {
        gc.setFill(colorTwo);
    }

    public void colorThreeClick() {
        gc.setFill(colorThree);
    }

    public void colorFourClick() {
        gc.setFill(colorFour);
    }

    public void colorFiveClick() {
        gc.setFill(colorFive);
    }

    public void colorSixClick() {
        gc.setFill(colorSix);
    }

    public void colorSevenClick() {
        gc.setFill(colorSeven);
    }

    public void colorEightClick() {
        gc.setFill(colorEight);
    }

    public void toMenu() {
        SceneLibrary.playMenu();
    }

    public void changeRadioButtonOneName(String name) {
        colorOneButton.setText(name);
    }

    public void changeRadioButtonTwoName(String name) {
        colorTwoButton.setText(name);
    }

    public void changeRadioButtonThreeName(String name) {
        colorThreeButton.setText(name);
    }

    public void changeRadioButtonFourName(String name) {
        colorFourButton.setText(name);
    }

    public void changeRadioButtonFiveName(String name) {
        colorFiveButton.setText(name);
    }

    public void changeRadioButtonSixName(String name) {
        colorSixButton.setText(name);
    }

    public void changeRadioButtonSevenName(String name) {
        colorSevenButton.setText(name);
    }

    public void changeRadioButtonEightName(String name) {
        colorEightButton.setText(name);
    }

    public void setColorOne(Color colorOne) {
        this.colorOne = colorOne;
    }

    public void setColorTwo(Color colorTwo) {
        this.colorTwo = colorTwo;
    }

    public void setColorThree(Color colorThree) {
        this.colorThree = colorThree;
    }

    public void setColorFour(Color colorFour) {
        this.colorFour = colorFour;
    }

    public void setColorFive(Color colorFive) {
        this.colorFive = colorFive;
    }

    public void setColorSix(Color colorSix) {
        this.colorSix = colorSix;
    }

    public void setColorSeven(Color colorSeven) {
        this.colorSeven = colorSeven;
    }

    public void setColorEight(Color colorEight) {
        this.colorEight = colorEight;
    }

    public Color getColorOne() {
        return colorOne;
    }

    public Color getColorTwo() {
        return colorTwo;
    }

    public Color getColorThree() {
        return colorThree;
    }

    public Color getColorFour() {
        return colorFour;
    }

    public Color getColorFive() {
        return colorFive;
    }

    public Color getColorSix() {
        return colorSix;
    }

    public Color getColorSeven() {
        return colorSeven;
    }

    public Color getColorEight() {
        return colorEight;
    }
}
