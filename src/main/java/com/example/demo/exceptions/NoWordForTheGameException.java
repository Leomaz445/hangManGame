package com.example.demo.exceptions;

public class NoWordForTheGameException extends Exception{
    public NoWordForTheGameException(){
        super();
    }
    public NoWordForTheGameException(String message){
        super(message);
    }

}
