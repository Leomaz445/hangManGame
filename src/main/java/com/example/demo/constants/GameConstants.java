package com.example.demo.constants;

import com.example.demo.Messages;

public class GameConstants {
    public final static String[] ABC = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
            "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    public static final int SCENE_WIDTH = 600;
    public static final int SCENE_HEIGHT = 400;
    public static final String FX_FONT_20_ARIAL = "-fx-font: 20 arial;";
    public static final String HANG_MAN_GAME = "HangMan Game";
    public static final String DIDNT_FIND_THE_FILE_TO_GET_THE_WORDS_FOR_THE_GAME = "Didn't find the file to get the words for the game.";
    public static final String THEIR_WAS_AN_ERROR_TRYING_TO_READ_FROM_THE_FILE = "Their was an error trying to read from the file.";
    public static final String YOU_LOOSE = "You Loose";
    public static final String YOU_DIDN_T_MANAGE_TO_GUESS_THE_WORD = "You didn't manage to guess the word";
    public static final String THE_WORD_WAS = "The word was:  ";
    public static final String YOU_WIN = "You Win";
    public static final String YOU_GUESSED_THE_WORD_GOOD_JOB = "You guessed the word!! Good Job";
    public static final int NUMBER_OF_BUTTONS_IN_ROW = 13;
    public static final String THANK_YOU_FOR_PLAYING = "Thank you for playing";
    public static final String GOOD_BYE_MSG = "Good Bye";
    public static final String YOU_ARE_ABOUT_TO_LEAVE_THE_GAME = "You are about to leave the game";
    public static final String ARE_YOU_SURE = "Are you sure?";
    public static final String YOU_ARE_ABOUT_TO_START_A_NEW_GAME = "You are about to start a new game";
    public static final String AFTER_WINNING_DO_YOU_WANT_TO_PLAY_AGAIN = "Do you want to play again?";
    public static final String DO_YOU_WANT_TO_PLAY_AGAIN_MSG = "Do you want to play again?";
    public static final String WE_SORRY_BUT_WE_CANT_START_THE_GAME = "we sorry but we cant start the game";
    public static final String CONNECT_THE_DEVELOPER = "Connect the developer";
    public static final String ERROR_GETTING_QUESTION = "Error getting question";
    public static final Messages DO_YOU_WANT_TO_PLAY_AGAIN = new Messages.MessagesBuilder()
            .setTitle(HANG_MAN_GAME)
            .setHeader(AFTER_WINNING_DO_YOU_WANT_TO_PLAY_AGAIN)
            .setContent(DO_YOU_WANT_TO_PLAY_AGAIN_MSG).build();

    public static final Messages GOOD_BYE = new Messages.MessagesBuilder()
            .setTitle(HANG_MAN_GAME)
            .setHeader(THANK_YOU_FOR_PLAYING)
            .setContent(GOOD_BYE_MSG).build();

    public static final Messages EXIT_GAME = new Messages.MessagesBuilder()
            .setTitle(HANG_MAN_GAME)
            .setHeader(YOU_ARE_ABOUT_TO_LEAVE_THE_GAME)
            .setContent(ARE_YOU_SURE).build();

    public static final Messages NEW_GAME = new Messages.MessagesBuilder()
            .setTitle(HANG_MAN_GAME)
            .setHeader(YOU_ARE_ABOUT_TO_START_A_NEW_GAME)
            .setContent(ARE_YOU_SURE).build();

    public static final Messages ERROR_STARTING_GAME = new Messages.MessagesBuilder()
            .setTitle(HANG_MAN_GAME)
            .setHeader(WE_SORRY_BUT_WE_CANT_START_THE_GAME)
            .setContent(CONNECT_THE_DEVELOPER).build();


}

