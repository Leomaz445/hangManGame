package com.example.demo;

import com.example.demo.exceptions.NoWordForTheGameException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static com.example.demo.constants.GameConstants.*;

public class Dictionary {

    private ArrayList<String> wordLibrary;

    Dictionary() {
        this.wordLibrary = new ArrayList<>();
    }

    public void setWordLibrary() {
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


    public String getWordForTheGame() throws NoWordForTheGameException {
        Random random = new Random();
        try {
            int randomNumber = random.nextInt(this.wordLibrary.size());
            return this.wordLibrary.get(randomNumber);
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            throw new NoWordForTheGameException(ERROR_GETTING_QUESTION);
        }
    }
}