package com.company;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneLibrary {
    public static Stage primaryStage;

    private static Scene menuScene;
    private static Scene encryptionScene;
    private static Scene decryptionScene;
    private static Scene colorSelectorScene;
    private static Scene puzzleScene;

    public static MenuController menuController;
    public static EncryptController encryptController;
    public static DecryptionController decryptionController;
    public static ColorSelectorController colorSelectorController;


    public static void setPrimaryStage(Stage primaryStage) {
        SceneLibrary.primaryStage = primaryStage;
    }

    public static void setScene(Scene scene) {
        SceneLibrary.primaryStage.setScene(scene);
    }

    public static void setMenuRoot(String path) throws IOException {
        FXMLLoader menuLoader = new FXMLLoader();
        menuLoader.setLocation(SceneLibrary.class.getResource(path));
        Parent menuParent = menuLoader.load();
        menuScene = new Scene(menuParent);

        menuController = menuLoader.getController();
    }

    public static void setEncryptionRoot(String path) throws IOException {
        FXMLLoader encryptionLoader = new FXMLLoader();
        encryptionLoader.setLocation(SceneLibrary.class.getResource(path));
        Parent encryptionParent = encryptionLoader.load();
        encryptionScene = new Scene(encryptionParent);

        encryptController = encryptionLoader.getController();
    }

    public static void setDecryptionRoot(String path) throws IOException {
        FXMLLoader decryptionLoader = new FXMLLoader();
        decryptionLoader.setLocation(SceneLibrary.class.getResource(path));
        Parent encryptionParent = decryptionLoader.load();
        decryptionScene = new Scene(encryptionParent);

        decryptionController = decryptionLoader.getController();
    }

    public static void setColorSelectorScene(String path) throws IOException {
        FXMLLoader colorLoader = new FXMLLoader();
        colorLoader.setLocation(SceneLibrary.class.getResource(path));
        Parent colorParent = colorLoader.load();
        colorSelectorScene = new Scene(colorParent);

        colorSelectorController = colorLoader.getController();
    }

    public static void setPuzzleRoot(String path) throws IOException {
        FXMLLoader menuLoader = new FXMLLoader();
        menuLoader.setLocation(SceneLibrary.class.getResource(path));
        Parent puzzleParent = menuLoader.load();
        puzzleScene = new Scene(puzzleParent);
    }

    public static void playMenu() {
        primaryStage.setScene(menuScene);
    }

    public static void playEncryption() {
        primaryStage.setScene(encryptionScene);
    }

    public static void playDecryption() {
        primaryStage.setScene(decryptionScene);
    }

    public static void playColorSelectorScene() {
        primaryStage.setScene(colorSelectorScene);
    }

    public static void playPuzzle() {
        primaryStage.setScene(puzzleScene);
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static Scene getMenuScene() {
        return menuScene;
    }

    public static Scene getEncryptionScene() {
        return encryptionScene;
    }

    public static Scene getDecryptionScene() {
        return decryptionScene;
    }

    public static Scene getColorSelectorScene() {
        return colorSelectorScene;
    }

    public static Scene getPuzzleScene() {
        return puzzleScene;
    }
}
