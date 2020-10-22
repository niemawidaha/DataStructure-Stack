package com.company;

import java.util.EmptyStackException;

public class Main {

    public static void main(String[] args) {

        // create string:
        String name = "Niema";

        // pass string to reverse string:
        String reverseName = reverseString(name);
        System.out.println("Unreversed: " + name + "\nReversed: " + reverseName);

        // create a stack + pass a string:
        // prints the string from bottom to top:
        MyStack test = new MyStack(10);

        for(int i = name.length()-1; i >= 0; i--){
            test.push(name.charAt(i));
        }

        test.display();

    }

    //-----------------------------------------------------------------
    // reverseString():
    public static String reverseString(String stringToReverse){
        int stackSize = stringToReverse.length(); // stores the size of the new stack

        MyStack reverseStack = new MyStack(stackSize); // makes the stack

        for(int i = 0; i < stackSize; i++){

            char ch = stringToReverse.charAt(i);
            reverseStack.push(ch);
        }

        String reversedString = ""; // to return the new string in reverse

        // add the items from the top of the stack to the bottom
        while(!reverseStack.isEmpty()){

            char reverseChar = reverseStack.pop();
            reversedString += reverseChar; // append to output
        }

        return reversedString;
    } // ends reverseString

} // ends Main()

class MyStack{

    // private members:
    private int     maxSize;     // max size of the stack
    private char[]  charStackArray; // array where we store the stack items
    private int     top;         // tells us where the top of the stack is:

    // constructor:
    //-----------------------------------------------------------------
    public MyStack(int size){
        maxSize = size;                 // max size of stack
        charStackArray = new char[maxSize]; // initialize stackArray
        top = -1;                       // currently nothing is in the stack
    }

    // methods:
    //-----------------------------------------------------------------
    // push()
    public void push(char newValue) throws FullStackException {

        if(isFull()){
            throw new FullStackException("Can't push to the stack");
        }

        // add an item to the top of the stack
        top += 1;
        charStackArray[top] = newValue;

    } // ends push()

    //-----------------------------------------------------------------
    // pop():
    public char pop() throws EmptyStackException {
        if(isEmpty()){
            throw new EmptyStackException();
        }

        // want to remove the item from the top of the stack
        // also want to return that item:
        char popValue = charStackArray[top];

        top -= 1;

        return popValue;
    }

    //-----------------------------------------------------------------
    // isEmpty():
    public boolean isEmpty(){
        if(top == -1){
            return true;  // stack is empty
        } else
            return false; // stack isnt empty
    } // ends isEmpty()

    //-----------------------------------------------------------------
    // isFull():
    // returns true if the stack is full
    // returns false otherwise
    public boolean isFull(){

        if(top == maxSize - 1){
            return true; // stack is full bc maxsize -1 is the last index
        } else {
            return false;
        }
    } // ends isFull()

    //-----------------------------------------------------------------
    // display():
    public void display(){

        // want to print the stack from top to bottom:
        System.out.println("The stack from top to bottom is: ");

        for(int i = top; i >= 0; i--){
            System.out.println(charStackArray[i] + " ");
        }

        System.out.println("");
    } // ends display()

}  // ends MyStack class

/**
 *  STACK:
 *
 *  A stack allows access to only one data item: the last item inserted.
 *  - Push(): Placing a data item on the op of the stack
 *  - Pop(): Removing it from the top of the stack
 *  - LAST-IN-FIRST-OUT
 *      -> the last one inserted is the first one to be removed
 *  - If the underlying mechanism which may be an array, becomes full, the array implementing it does.
 *
 *
 */

/*

Stacks:

1)
b) b)	Modifying the stack code, we wrote and used in class,
        write your own stack class based on an array of chars.
        Include methods to pop and push, as well as any others
        you find helpful:


e)

 // add elements to the stack first:
        char[] helper = new char[]{'h','a','p','p','y'};

        MyStack charStack = new MyStack(5);

        for(int i = 0; i < 5; i++ ){
            charStack.push(helper[i]);
        }

        charStack.display();

        // reverse the elements in the stack:
        String reverseInput = "";

        while(!charStack.isEmpty()){

            char ch = charStack.pop();          // pop char
            reverseInput += ch;    // append to output
        }

        System.out.println("Reverse string: " + reverseInput);
* */