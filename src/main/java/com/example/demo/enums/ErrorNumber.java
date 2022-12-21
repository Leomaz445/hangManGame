package com.example.demo.enums;


public enum ErrorNumber {
    ERROR_ONE_DRAWING_THE_FLOOR(0),
    ERROR_TWO_DRAWING_THE_POLL(1),
    ERROR_THREE_DRAWING_THE_POLL_ROOF(2),
    ERROR_FOUR_DRAWING_THE_CABLE_OF_LOOP(3),
    ERROR_FIVE_DRAWING_THE_HEAD_OF_PERSON(4),
    ERROR_SIX_DRAWING_THE_BODY(5),
    ERROR_SEVEN_DRAWING_LEFT_HAND(6),
    ERROR_EIGHT_DRAWING_RIGHT_HAND(7),
    ERROR_NINE_DRAWING_LEFT_LEG(8),
    ERROR_TEN_DRAWING_RIGHT_LEG(9);

    public int value;

    ErrorNumber(int value) {
        this.value = value;
    }

}
