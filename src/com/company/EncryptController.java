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
    private RadioButton brownButton;

    @FXML
    private RadioButton blackButton;

    @FXML
    private RadioButton indigoButton;

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

    final ToggleGroup group = new ToggleGroup();

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

        gc.setFill(Color.RED);

        redButton.setToggleGroup(group);
        blueButton.setToggleGroup(group);
        greenButton.setToggleGroup(group);
        yellowButton.setToggleGroup(group);
        whiteButton.setToggleGroup(group);
        blackButton.setToggleGroup(group);
        indigoButton.setToggleGroup(group);
        brownButton.setToggleGroup(group);

        redButton.setSelected(true);

        ObservableList<String> options = FXCollections.observableArrayList("2^2","2^3");
        binarySelector.setValue("2^2");
        binarySelector.setItems(options);

        vBox.getChildren().remove(extraColors);

        binarySelector.setOnAction(event -> changeBinary());


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
        } else if (Color.BLACK.equals(gc.getFill())) {
            paintingArray.fillSquare(yBox, xBox, "111");
        } else if (Color.BROWN.equals(gc.getFill())) {
            paintingArray.fillSquare(yBox, xBox, "110");
        } else if (Color.INDIGO.equals(gc.getFill())) {
            paintingArray.fillSquare(yBox, xBox, "101");
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

    public void blackClick() {
        gc.setFill(Color.BLACK);
    }

    public void brownClick() {
        gc.setFill(Color.BROWN);
    }

    public void indigoClick() {
        gc.setFill(Color.INDIGO);
    }

    public void toMenu() {
        SceneLibrary.playMenu();
    }

}
