package com.company;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneLibrary {
    public static Stage primaryStage;

    private static Parent menuRoot;
    private static Parent encryptionRoot;
    private static Parent decryptionRoot;
    private static Parent puzzleRoot;

    public static void setPrimaryStage(Stage primaryStage) {
        SceneLibrary.primaryStage = primaryStage;
    }

    public static void setScene(Scene scene) {
        SceneLibrary.primaryStage.setScene(scene);
    }

    public static void setMenuRoot(Parent root) {
        menuRoot = root;
    }

    public static void setEncryptionRoot(Parent root) {
        encryptionRoot = root;
    }

    public static void setDecryptionRoot(Parent root) {
        decryptionRoot = root;
    }

    public static void setPuzzleRoot(Parent root) {
        puzzleRoot = root;
    }

    public static void playMenu() {
        primaryStage.setScene(new Scene(menuRoot));
    }

    public static void playEncryption() {
        primaryStage.setScene(new Scene(encryptionRoot));
    }

    public static void playDecryption() {
        primaryStage.setScene(new Scene(decryptionRoot));
    }

    public static void playPuzzle() {
        primaryStage.setScene(new Scene(puzzleRoot));
    }



}
