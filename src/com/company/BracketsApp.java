package com.company;
import java.io.*;

/////////////////////////////////////////////////////////////////////////////////

class StackBone{

    // private members:
    private int     maxSize;
    private char[]  stackArray;
    private int     top;

    //-----------------------------------------------------------------
    // constructor:
    public StackBone(int size){

        maxSize = size;
        stackArray = new char[maxSize];
        top = -1; // initialize empty stack
    }

    //-----------------------------------------------------------------
    // push(): put item on top of stack
    public void push(char insertChar){
        stackArray[++top] = insertChar;
    }

    //-----------------------------------------------------------------
    // pop(): take item from top of the stack
    public char pop(){
        return stackArray[top--];
    }

    //-----------------------------------------------------------------
    // peek(): peek at the top of the stack
    public char peek(){
        return stackArray[top];
    }

    //-----------------------------------------------------------------
    // isEmpty(): check if top = -1
    //           - true if the stack is empty
    public boolean isEmpty(){
        return (top == - 1);
    }
} // ends stackbone class

/////////////////////////////////////////////////////////////////////////////////
class BracketChecker {

    private String input; // input string

    //-----------------------------------------------------------------
    // constructor:
    public BracketChecker(String in){
        input = in;
    }

    //-----------------------------------------------------------------
    // check():
    public void check(){

        // get max size:
        int stackSize = input.length();

        // make stack:
        StackBone theStack = new StackBone(stackSize);

        // get chars in turn:
        // get char:
        for(int j = 0; j < input.length(); j++){

            char checkDelimChar = input.charAt(j); // get char:

            switch(checkDelimChar){
                case '{':
                case '[':
                case '(':
                    theStack.push(checkDelimChar); // opening symbols
                    break;
                case '}':
                case ']':
                case ')':                          // closing symbols
                    if(!theStack.isEmpty()){

                        // if stack isn't empty:
                        char checkChar = theStack.pop(); // pop and check the first

                        if((checkDelimChar == '}' && checkChar != '{' ) ||
                                (checkDelimChar == ']' && checkChar != '[' ) ||
                                (checkDelimChar == ')' && checkChar != '(' )){
                            System.out.println("Error: " + checkDelimChar + " at " + j);
                        } else
                            System.out.println("Correct number of open + close braces");
                    } else
                        System.out.println("Error: " + checkDelimChar + " at " + j);
                    break;
                default: // no action on other characters:
                    break;
            } // ends switch
        } // ends for

        // at this point all characters have been processed:
        if(!theStack.isEmpty()){
            System.out.println("Error: missing right delimiter");
        }
    } // ends check()
    //-----------------------------------------------------------------
} // ends BracketChecker

/////////////////////////////////////////////////////////////////////////////////
public class BracketsApp {

    public static void main(String[] args) throws IOException {

        String input;

        while(true){
            System.out.println("Enter string containing delimiters: ");
            System.out.flush();

            input = getString(); // read a string from the Buffered Reader

            // if its empty stop:
            if(input.equals("")){
                break;
            }

            BracketChecker bracketChecker = new BracketChecker(input);
            bracketChecker.check(); // check brackets
        } // ends while
    } // ends main()

    //-----------------------------------------------------------------
    // getString():
    public static String getString() throws IOException {

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String str = bufferedReader.readLine();
        return str;
    }
} // ends BracketsApp
