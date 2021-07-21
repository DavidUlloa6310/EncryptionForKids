package com.company;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneLibrary {
    public static Stage primaryStage;

    public static void setPrimaryStage(Stage primaryStage) {
        SceneLibrary.primaryStage = primaryStage;
    }

    public static void setScene(Scene scene) {
        SceneLibrary.primaryStage.setScene(scene);
    }


}
