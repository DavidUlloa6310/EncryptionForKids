package com.company;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneLibrary {
    public static Stage primaryStage;

    private static Scene menuScene;
    private static Scene encryptionScene;
    private static Scene decryptionScene;
    private static Scene puzzleScene;

    public static void setPrimaryStage(Stage primaryStage) {
        SceneLibrary.primaryStage = primaryStage;
    }

    public static void setScene(Scene scene) {
        SceneLibrary.primaryStage.setScene(scene);
    }

    public static void setMenuRoot(Parent root) {
        menuScene = new Scene(root);
    }

    public static void setEncryptionRoot(Parent root) {
        encryptionScene = new Scene(root);
    }

    public static void setDecryptionRoot(Parent root) {
        decryptionScene = new Scene(root);
    }

    public static void setPuzzleRoot(Parent root) {
        puzzleScene = new Scene(root);
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

    public static void playPuzzle() {
        primaryStage.setScene(puzzleScene);
    }



}
