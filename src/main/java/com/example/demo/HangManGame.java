package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.demo.constants.GameConstants.*;

public class HangManGame extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HangManGame.class.getResource("hangMan.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), SCENE_WIDTH, SCENE_HEIGHT);
        stage.setTitle(HANG_MAN_GAME);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}