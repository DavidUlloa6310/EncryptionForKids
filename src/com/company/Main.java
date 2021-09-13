package com.company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class Main extends Application {

    public final static int TILE_SIZE = 25;

    private static int HEIGHT_TILES = 8;
    private static int WIDTH_TILES = 8;

    @Override
    public void start(Stage primaryStage) throws Exception {

        SceneLibrary.setPrimaryStage(primaryStage);

        SceneLibrary.setMenuRoot("FXMLfiles/Menu.fxml");
        SceneLibrary.setEncryptionRoot("FXMLfiles/Encrypt.fxml");
        SceneLibrary.setDecryptionRoot("FXMLfiles/Decryption.fxml");
        SceneLibrary.setColorSelectorScene("FXMLfiles/ColorSelector.fxml");

        SceneLibrary.playMenu();
        primaryStage.setHeight(500);
        primaryStage.setWidth(900);
        primaryStage.setResizable(true);
        primaryStage.show();
    }

    public static int getTileSize() {
        return TILE_SIZE;
    }

    public static int getHEIGHT_TILES() {
        return HEIGHT_TILES;
    }

    public static int getWIDTH_TILES() {
        return WIDTH_TILES;
    }

    public static void setHeightTiles(int heightTiles) {
        HEIGHT_TILES = heightTiles;
    }

    public static void setWidthTiles(int widthTiles) {
        WIDTH_TILES = widthTiles;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
