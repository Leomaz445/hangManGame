package com.example.demo;

import com.example.demo.enums.ErrorNumber;

import java.util.Arrays;

public class HangManImpl {
    private int errorNumber;
    private int numberOfRightGuesses;
    private String[] wordThatNeedToBeGuessedPattern;
    private String wordForTheGame;
    private String[] wordForTheGameSplit;
    private Dictionary dictionary;

    public HangManImpl(Dictionary dictionary) {
        this.dictionary = dictionary;

    }

    public void initNewWordForTheGame() {
        this.wordForTheGame = dictionary.getWordForTheGame();
        this.errorNumber = -1;
        this.numberOfRightGuesses = wordForTheGame.length();
        this.wordThatNeedToBeGuessedPattern = new String[numberOfRightGuesses];
        this.wordForTheGameSplit = wordForTheGame.split("");
        for (int i = 0; i < this.wordForTheGame.length(); i++) {
            wordThatNeedToBeGuessedPattern[i] = " _ ";
        }
    }

    public int getErrorNumber() {
        return errorNumber;
    }


    public int getNumberOfRightGuesses() {
        return numberOfRightGuesses;
    }


    public String getWordThatNeedToBeGuessedPattern() {
        return Arrays.toString(wordThatNeedToBeGuessedPattern);
    }


    public String getWordForTheGame() {
        return wordForTheGame;
    }

    public boolean theLetterExistsInTheWord(String userGuess) {
        int numberOfRightGuessBefore = numberOfRightGuesses;
        for (int i = 0; i < wordForTheGameSplit.length; i++) {
            if (userGuess.equals(wordForTheGameSplit[i])) {
                wordThatNeedToBeGuessedPattern[i] = userGuess;
                numberOfRightGuesses--;
            }
        }
        if (numberOfRightGuessBefore == this.numberOfRightGuesses) {
            errorNumber++;
            return false;
        }
        return true;
    }

    public boolean checkIfLostTheGame() {
        return errorNumber == ErrorNumber.ERROR_TEN_DRAWING_RIGHT_LEG.value;
    }

    public boolean checkIfWonTheGame() {
        return numberOfRightGuesses == 0;
    }

}


