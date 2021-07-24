package com.company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class Main extends Application {

    public final static int TILE_SIZE = 25;

    private static int HEIGHT_TILES = 15;
    private static int WIDTH_TILES = 20;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent menuRoot = FXMLLoader.load(getClass().getResource("FXMLfiles/Menu.fxml"));
        Parent encryptionRoot = FXMLLoader.load(getClass().getResource("FXMLfiles/Encrypt.fxml"));
        Parent decryptionRoot = FXMLLoader.load(getClass().getResource("FXMLfiles/Decryption.fxml"));

        SceneLibrary.setPrimaryStage(primaryStage);

        SceneLibrary.setMenuRoot(menuRoot);
        SceneLibrary.setEncryptionRoot(encryptionRoot);
        SceneLibrary.setDecryptionRoot(decryptionRoot);

        SceneLibrary.playMenu();
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

    public static void main(String[] args) {
        launch(args);
    }
}