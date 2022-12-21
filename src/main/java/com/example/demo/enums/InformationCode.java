package com.example.demo.enums;

public enum InformationCode {
    YOU_WIN_OR_LOSE(1),
    THANK_YOU_FOR_PLAYING(2);

    private final int value;

    InformationCode(int value) { this.value = value;}
}
