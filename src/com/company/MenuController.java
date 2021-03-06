package com.company;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class MenuController {
    @FXML
    private BorderPane borderPane;

    @FXML
    private Button encryptButton;

    @FXML
    private Button decryptButton;

    @FXML
    private Button puzzleButton;

    public void playEncryption() {
        SceneLibrary.playEncryption();
    }

    public void playDecryption() {
        SceneLibrary.playDecryption();
    }

    public void playColorSelector() {
        SceneLibrary.playColorSelectorScene();
    }


}
