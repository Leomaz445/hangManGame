package com.example.demo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static com.example.demo.constants.GameConstants.DIDNT_FIND_THE_FILE_TO_GET_THE_WORDS_FOR_THE_GAME;
import static com.example.demo.constants.GameConstants.THEIR_WAS_AN_ERROR_TRYING_TO_READ_FROM_THE_FILE;

public class Dictionary {

    private final ArrayList<String> wordLibrary;

    Dictionary() {
        this.wordLibrary = getWordsFromAFile();
    }

    private ArrayList<String> getWordsFromAFile() {
        ArrayList<String> randomWords = new ArrayList<String>();
        try {
            BufferedReader wordsForHangManGame =
                    new BufferedReader(new BufferedReader(new FileReader("wordsForHangManGame.txt")));
            String line;
            while ((line = wordsForHangManGame.readLine()) != null) {
                randomWords.add(line);
            }
            wordsForHangManGame.close();
        } catch (FileNotFoundException e) {
            System.out.println(DIDNT_FIND_THE_FILE_TO_GET_THE_WORDS_FOR_THE_GAME);
        } catch (IOException e) {
            System.out.println(THEIR_WAS_AN_ERROR_TRYING_TO_READ_FROM_THE_FILE);
        }

        return randomWords;
    }


    public String getWordForTheGame() {
        Random random = new Random();
        int randomNumber = random.nextInt(this.wordLibrary.size());
        return this.wordLibrary.get(randomNumber);
    }
}