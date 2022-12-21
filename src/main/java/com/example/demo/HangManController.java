package com.example.demo;

import com.example.demo.alert.ConfirmationMessagesAlert;
import com.example.demo.alert.InformationMessagesAlert;
import com.example.demo.enums.ConfirmationCode;
import com.example.demo.enums.ErrorNumber;
import com.example.demo.enums.InformationCode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.Arrays;

import static com.example.demo.constants.GameConstants.*;
import static javafx.application.Platform.exit;


public class HangManController {

    @FXML
    private Canvas canv;

    @FXML
    private GridPane grid;

    @FXML
    private Text textOfTheWord;


    private Button[] btns;
    private DrawPerson drawPersonOnCanvs;
    private HangManImpl hangMan;
    private GraphicsContext gc;
    private ConfirmationMessagesAlert confirmationMessagesAlert;
    private InformationMessagesAlert informationMessagesAlert;


    @FXML
    void onClickExitGame(ActionEvent event) {
        if (confirmationMessagesAlert.getAlert(ConfirmationCode.DO_YOU_SURE_YOU_WANT_TO_EXIT)) {
            exit();
        }
    }

    @FXML
    void onClickStartNewGame(ActionEvent event) {
        if (confirmationMessagesAlert.getAlert(ConfirmationCode.ARE_YOU_SURE_YOU_WANT_TO_START_A_NEW_GAME))
            init();
    }

    public void initialize() {
        gc = canv.getGraphicsContext2D();
        confirmationMessagesAlert = new ConfirmationMessagesAlert();
        informationMessagesAlert = new InformationMessagesAlert();
        drawPersonOnCanvs = new DrawPerson();
        Dictionary dictionary = new Dictionary();
        hangMan = new HangManImpl(dictionary);
        textOfTheWord.setFill(Color.BLACK);
        textOfTheWord.setStyle("-fx-font: 20 arial;");
        btns = new Button[ABC.length];
        buildingTheButtons();
        init();

    }

    private void init() {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
        hangMan.initNewWordForTheGame();
        System.out.println(hangMan.getWordForTheGame());
        textOfTheWord.setText(Arrays.toString(hangMan.getWordThatNeedToBeGuessedPattern()));
        for (Button btn : btns) {
            btn.setVisible(true);
        }
    }

    private void buildingTheButtons() {
        for (int i = 0; i < ABC.length; i++) {
            btns[i] = new Button(ABC[i]);
            btns[i].setPrefSize(grid.getPrefWidth() / NUMBER_OF_BUTTONS_IN_ROW,
                                grid.getPrefHeight() / NUMBER_OF_BUTTONS_IN_ROW);
            grid.add(btns[i], i % NUMBER_OF_BUTTONS_IN_ROW, i / NUMBER_OF_BUTTONS_IN_ROW);
            btns[i].setOnAction(this::handleClickedButton);

        }
    }

    private void handleClickedButton(ActionEvent event) {
        Button button = (Button) event.getSource();
        button.setVisible(false);

        if (!hangMan.theLetterExistsInTheWord(button.getText())) {
            drawPersonOnCanvs.drawingSelector(ErrorNumber.values()[hangMan.getErrorNumber()], gc);
            checkIfLostTheGame();
        }
        textOfTheWord.setText(Arrays.toString(hangMan.getWordThatNeedToBeGuessedPattern()));
        checkIfWonTheGame();

    }

    private void checkIfLostTheGame() {
        if (hangMan.getErrorNumber() == ErrorNumber.ERROR_TEN_DRAWING_RIGHT_LEG.value) {
            showResultOfTheGame(YOU_LOOSE,
                    YOU_DIDN_T_MANAGE_TO_GUESS_THE_WORD,
                    THE_WORD_WAS + hangMan.getWordForTheGame());
        }
    }

    private void checkIfWonTheGame() {
        if (hangMan.getNumberOfRightGuesses() == 0) {
            showResultOfTheGame(YOU_WIN,
                    YOU_GUESSED_THE_WORD_GOOD_JOB,
                    THE_WORD_WAS + hangMan.getWordForTheGame());
        }
    }


    private void showResultOfTheGame(String title, String header, String content) {
        informationMessagesAlert.getAlert(InformationCode.YOU_WIN_OR_LOSE, new Messages.MessagesBuilder()
                .setTitle(title)
                .setHeader(header)
                .setContent(content)
                .build());
        playAgainOrExitTheGame();
    }


    private void playAgainOrExitTheGame() {
        if (confirmationMessagesAlert.getAlert(ConfirmationCode.DO_YOU_WANT_TO_PLAY_AGAIN)) {
            init();
        } else {
            informationMessagesAlert.getAlert(InformationCode.THANK_YOU_FOR_PLAYING, GOOD_BYE);
            exit();
        }
    }


}