package com.company;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

//////////////////////////////////////////////////////////////////////////
class StackY {

    // private members:
    private int maxSize;        // size of stack array
    private char[] stackArray;
    private int top;            // for the top of the stack

    //-----------------------------------------------------------------
    // constructor:
    public StackY(int size){
        maxSize = size;                // set array size
        stackArray = new char[size];   // create the array
        top = -1; // no items in array -> stack is empty
    }

    //-----------------------------------------------------------------
    // push(): put item on top of stack
    //          - here: top is incremented before pushing to the stack
    public void push(char j){

        // increment top
        // insert the item
        stackArray[++top] = j;
    }

    //-----------------------------------------------------------------
    // pop(): take item from the top of the stack
    public char pop(){

        // to access the item: decrement top
        // this: removes the item from the stack
        return stackArray[top--];

    }

    //-----------------------------------------------------------------
    // peek(): peek at the top of the stack
    public long peek(){
        return stackArray[top];
    }

    //-----------------------------------------------------------------
    // isEmpty(): when top == -1 then it's pointing to the lowest cell.
    //            - true: if the stack is empty
    public boolean isEmpty(){
        return (top == -1);
    }

    //-----------------------------------------------------------------
    // isFull(): when top == -1 then it's pointing to the lowest cell.
    //            - true: if the stack is full
    public boolean isFull(){
        return (top == maxSize-1);
    }

} // end class StackX

//////////////////////////////////////////////////////////////////////////
class Reverser{

    // private members:
    private String input;
    private String output;

    //-----------------------------------------------------------------
    // constructor:
    public Reverser(String in){
        this.input = in;
    }

    //-----------------------------------------------------------------
    // doReverse(): outputs the reverse
    public String doReverse(){

        // get max stack size:
        // the size of the string is the size of the stack:
        int stackSize = input.length();

        // make stack with the size of the input element:
        StackY reverseStack = new StackY(stackSize);

        // get char from input string:
        for(int i = 0; i < input.length(); i++){

            // stores the char at i
            char singlechar = input.charAt(i);

            // push the char onto the stack:
            reverseStack.push(singlechar);
        }

        // initialize the output string to empty :
        // append the values from the top of the reverse stack with the pop() method
        output = "";

        while(!reverseStack.isEmpty()){

            char charAtTop = reverseStack.pop();
            output = output + charAtTop;

        }
        return output;
    } // ends doReverse()

} // ends Reverser class

//////////////////////////////////////////////////////////////////////////
class
ReverseApp {

    public static void main(String[] args) throws IOException {

        String  input,
                output;

        while(true){

            System.out.println("Enter a string: ");
            System.out.flush(); // ?
            input = getString(); // read a string from

            // this is if the user enters a null value
            if(input.equals("")){
                break;
            }

            Reverser theReverser = new Reverser(input);
            output = theReverser.doReverse(); // use it
            System.out.println("Reverse: " + output);


        } // ends while
    } // ends main()

    public static String getString() throws IOException{

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String string = bufferedReader.readLine();
        return string;
    } // ends getString()
} // ends ReverseApp
