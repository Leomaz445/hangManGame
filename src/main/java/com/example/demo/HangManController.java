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
    private void onClickExitGame(ActionEvent event) {
        if (confirmationMessagesAlert.getAlert(ConfirmationCode.DO_YOU_SURE_YOU_WANT_TO_EXIT)) {
            exit();
        }
    }

    @FXML
    private void onClickStartNewGame(ActionEvent event) {
        if (confirmationMessagesAlert.getAlert(ConfirmationCode.ARE_YOU_SURE_YOU_WANT_TO_START_A_NEW_GAME))
            init();
    }

    public void initialize() {
        gc = canv.getGraphicsContext2D();
        confirmationMessagesAlert = new ConfirmationMessagesAlert();
        informationMessagesAlert = new InformationMessagesAlert();
        drawPersonOnCanvs = new DrawPerson();
        Dictionary dictionary = new Dictionary();
        dictionary.setWordLibrary();
        hangMan = new HangManImpl(dictionary);
        textOfTheWord.setFill(Color.BLACK);
        textOfTheWord.setStyle(FX_FONT_20_ARIAL);
        btns = new Button[ABC.length];
        buildingTheButtons();
        init();

    }

    private void init() {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
        if (hangMan.initNewWordForTheGame()) {
            System.out.println(hangMan.getWordForTheGame());
            textOfTheWord.setText(hangMan.getWordThatNeedToBeGuessedPattern());
            for (Button btn : btns) {
                btn.setDisable(false);
            }
        } else {
            showErrorAndExit();
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
        button.setDisable(true);

        if (!hangMan.theLetterExistsInTheWord(button.getText())) {
            drawPersonOnCanvs.drawingSelector(ErrorNumber.values()[hangMan.getErrorNumber()], gc);
            didYouLoseTheGame();
        }
        textOfTheWord.setText(hangMan.getWordThatNeedToBeGuessedPattern());
        didYouWinTheGame();
    }

    private void didYouWinTheGame() {
        if (hangMan.checkIfWonTheGame()) {
            informationMessagesAlert.showResultOfTheGame(InformationCode.YOU_WIN_OR_LOSE,
                    YOU_WIN,
                    YOU_GUESSED_THE_WORD_GOOD_JOB,
                    THE_WORD_WAS + hangMan.getWordForTheGame());
            playAgainOrExitTheGame();
        }
    }

    private void didYouLoseTheGame() {
        if (hangMan.checkIfLostTheGame()) {
            informationMessagesAlert.showResultOfTheGame(InformationCode.YOU_WIN_OR_LOSE,
                    YOU_LOOSE,
                    YOU_DIDN_T_MANAGE_TO_GUESS_THE_WORD,
                    THE_WORD_WAS + hangMan.getWordForTheGame());
            playAgainOrExitTheGame();
        }
    }

    private void playAgainOrExitTheGame() {
        if (confirmationMessagesAlert.getAlert(ConfirmationCode.DO_YOU_WANT_TO_PLAY_AGAIN)) {
            init();
        } else {
            informationMessagesAlert.getAlert(InformationCode.THANK_YOU_FOR_PLAYING, GOOD_BYE);
            exit();
        }
    }

    private void showErrorAndExit() {
        informationMessagesAlert.getAlert(InformationCode.ERROR_STARTING_THE_GAME, ERROR_STARTING_GAME);
        exit();
    }


}