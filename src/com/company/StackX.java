package com.company;
// demonstrates stacks
// to run this program: C>java StackApp

//////////////////////////////////////////////////////////////////////////
class StackX {

    // private members:
    private int maxSize;        // size of stack array
    private long[] stackArray;
    private int top;            // for the top of the stack

    //-----------------------------------------------------------------
    // constructor:
    public StackX(int size){
        maxSize = size;                // set array size
        stackArray = new long[size];   // create the array
        top = -1; // no items in array -> stack is empty
    }

    //-----------------------------------------------------------------
    // push(): put item on top of stack
    //          - here: top is incremented before pushing to the stack
    public void push(long j){

        // increment top
        // insert the item
        stackArray[++top] = j;
    }

    //-----------------------------------------------------------------
    // pop(): take item from the top of the stack
    public long pop(){

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
class StackApp{

    public static void main(String[] args) {

        // make new stack:
        StackX firstStack = new StackX(10);

        // push items onto stack:
        firstStack.push(20);
        firstStack.push(40);
        firstStack.push(60);
        firstStack.push(80);



        // until its empty:
        // delete item from stack
        // and display it:

        System.out.println("Deleting all elements from the stack:");
        while(!firstStack.isEmpty()){

            long value = firstStack.pop(); // removes the value at the top of the stack
            System.out.println(value); // display
        } // end while

        System.out.println(" ");

    } // ends main()
} // ends StackApp class