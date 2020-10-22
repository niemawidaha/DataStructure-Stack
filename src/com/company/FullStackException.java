package com.company;

public class FullStackException extends RuntimeException {

    // constructor:
    public FullStackException(){
        this("Stack is Full");
    } // end no argument FullStackException constructor

    // one argument constructor:
    public FullStackException(String exception){
        super(exception);
    }

} // end class full stack exception

