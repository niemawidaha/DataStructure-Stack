package com.company;


///////////////////////////////////////////////////////////////////////////////
// My Stack Integer Class

class BusStack{

    // private fields:
    private int maxSize; // set size
    private int[] busStackArray; // initialize
    private int top; // tells us where the top of the stack is

    // -----------------------------------------------------------------------
    // constuctor:
    public BusStack(int size){
        maxSize = size;
        busStackArray = new int[maxSize];   // initialize
        top = -1;                           // currently nothing in it
    }

    // -----------------------------------------------------------------------
    // push():
    public void push(int newValue) throws FullStackException {

        if(isFull()){
            throw new FullStackException("Can't push to full stack");
        }

        // add an item to top of the stack:
        top += 1;
        busStackArray[top] = newValue;

    } // ends push

    // -----------------------------------------------------------------------
    // pop():
    public int pop(){

        if(isEmpty()){
            throw new EmptyStackException();
        }

        // remove the item from the top of the stack
        // and return it
        int popValue = busStackArray[top];
        top -= 1;

        return popValue;
    }


    // -----------------------------------------------------------------------
    // isEmpty():
    // returns true if the stacks empty + false otherwise
    public boolean isEmpty(){
        return (top == -1);
    }

    // -----------------------------------------------------------------------
    // isFull():
    // returns true if the stacks empty + false otherwise
    public boolean isFull(){
        return top == maxSize - 1;
    }

    // -----------------------------------------------------------------------
    // display():
    public void display(){

        System.out.println("Stack from bottop to top is: ");
        for(int i = top; i >= 0; i--){

            System.out.println(busStackArray[i] + " ");
        }
        System.out.println("");
    } // end display()

} // end BusStack


///////////////////////////////////////////////////////////////////////////////
public class BusRouteApp {

    public static void main(String[] args) {

        int[] helper = new int[]{1, 2, 3, 4, 5};

        BusStack firstStack = new BusStack(5);
        for (int i = 0; i < 5; i += 1) {
            firstStack.push(helper[i]);
        }
        firstStack.display(); //5 4 3 2 1


    }

}

/*
Depth - First Search:
*

To carry this out:
1. Pick a starting point
2. Visit the vertex
3. Push it onto a stack so you can remember it
4. Mark it so you don't visit it again


Rule 1:
- If possible, visit an adjacent unvisited vertex, mark it, and push it on the stack

Rule 2:
- If you can't follow Rule 1, then if possible, pop a vertex off the stack

Rule 3:
- If you can't follow Rule 1 or Rule 2, you're done!


**/