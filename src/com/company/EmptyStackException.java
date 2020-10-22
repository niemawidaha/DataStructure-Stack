package com.company;

public class EmptyStackException extends RuntimeException {

    // default constructor:
    public EmptyStackException(){
        this("Stack is empty");
    }

    // one argument constructor:
    public EmptyStackException(String exception){
        super(exception);
    }
} // ends class FullStackException
