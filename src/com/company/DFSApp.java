package com.company;
///////////////////////////////////////////////////////////////////////////////

class DFSStack{

    // private fields:
    private final int maxSize = 20; // set size
    private int[] dfsStackArray; // initialize
    private int top; // tells us where the top of the stack is

    // -----------------------------------------------------------------------
    // constructor:
    public DFSStack(){
        dfsStackArray = new int[maxSize];   // initialize
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
        dfsStackArray[top] = newValue;

    } // ends push

    // -----------------------------------------------------------------------
    // pop():
    public int pop(){

        if(isEmpty()){
            throw new EmptyStackException();
        }

        // remove the item from the top of the stack
        // and return it
        int popValue = dfsStackArray[top];
        top -= 1;

        return popValue;
    }


    // -----------------------------------------------------------------------
    // peek(): returns the most recent value
    public int peek(){
        return dfsStackArray[top];
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

            System.out.println(dfsStackArray[i] + " ");
        }
        System.out.println("");
    } // end display()

} // end DFSStack

///////////////////////////////////////////////////////////////////////////////
// Vertex -> Singular Point
// *** THIS WILL BE AN INTEGER VALUE FOR THE BUS ROUTE *

class Vertex{

    // public fields:
    public char label; // label ex: 'A; (This would be an int for the BusRouteApp)
    public boolean wasVisited;

    // -----------------------------------------------------------------------
    // constructor:
    public Vertex(char lab){
        label = lab;
        wasVisited = false;
    }
} // end class: Vertex

///////////////////////////////////////////////////////////////////////////////
class Graph{

    // private fields:
    private final int MAX_VERTICES = 20;
    private Vertex vertexList[];                // list of vertices
    private int adjacencyMatrix[][];            // adjacency matrix
    private int currentVertices;                // current # of vertices
    public DFSStack dfsStack;

    // -----------------------------------------------------------------------
    // constructor:
    public Graph(){

        vertexList = new Vertex[MAX_VERTICES];

        // ADJACENCY MATRIX
        adjacencyMatrix = new int[MAX_VERTICES][MAX_VERTICES];
        currentVertices = 0;

        // set adjacency matrix values to 0 (basically false)
        for(int i = 0; i < MAX_VERTICES; i++){
            for(int k = 0; k < MAX_VERTICES; k++){
                adjacencyMatrix[i][k] = 0;
            }
        }

        // create a new DFS Stack:
        dfsStack = new DFSStack();
    } // ends graph constructor

    // -----------------------------------------------------------------------
    // addVertex(char label)
    public void addVertex(char label){

        vertexList[currentVertices++] = new Vertex(label);
    }

    // -----------------------------------------------------------------------
    // addEdge(int start, int end)
    public void addEdge(int start, int end){
        adjacencyMatrix[start][end] = 1;
        adjacencyMatrix[end][start] = 1;
    }

    // -----------------------------------------------------------------------
    // displayVertex(int value)
    public void displayVertex(int vertex){
        System.out.println(vertexList[vertex].label);
    }

    // -----------------------------------------------------------------------
    // dfs() - depth first search
    public void dfs(){
                                                // begin at vertex 0
        vertexList[0].wasVisited = true;        // mark it visited
        displayVertex(0);                       // display it
        dfsStack.push(0);               // add it to the stack

        // until the stack is empty:
        // traverse through the vertexList:
        while (!dfsStack.isEmpty()) {

            // get an unvisited vertex adjacent to stack top:
            int adjVertex = getAdjUnvisitedVertex(dfsStack.peek()); // gathers the upper most value in the stack


            if (adjVertex == -1) {
                dfsStack.pop();                      // if no vertex exists adjacent to the first vertex
            } else {
                // if it exists add the vertex to the stack :
                vertexList[adjVertex].wasVisited = true;     // mark as visited:
                displayVertex(adjVertex);                    //display it:
                dfsStack.push(adjVertex);                    // push it:
            }
        } // ends while

        // the stack is now empty so we're done:
        // reset your flags in the adjacency matrix to 0
        for(int j = 0; j < currentVertices; j++){
            vertexList[j].wasVisited = false;
        }
    } // ends dfs()

    // -----------------------------------------------------------------------
    // getAdjUnvisitedVertex(int value) - depth first search
    // - returns an unvisited vertex adj to v
    public int getAdjUnvisitedVertex(int value){

        for(int j = 0; j < currentVertices; j++){

            if(adjacencyMatrix[value][j] == 1 && !vertexList[j].wasVisited){
                return j;
            }
        }
        return -1;
    } // ends getAdjUnvisitedVertex()

} // ends class: Graph

///////////////////////////////////////////////////////////////////////////////
class DFSApp {

    public static void main(String[] args) {

        Graph theGraph  = new Graph();

        // add vertex:
        theGraph.addVertex('A');    // 0 -> start for DFS
        theGraph.addVertex('B');    // 1
        theGraph.addVertex('F');    // 2
        theGraph.addVertex('H');    // 3
        theGraph.addVertex('C');    // 4
        theGraph.addVertex('D');    // 5
        theGraph.addVertex('G');    // 6
        theGraph.addVertex('I');    // 7
        theGraph.addVertex('E');    // 8


        // add edges:
        theGraph.addEdge(0,1);    // AB   -> AB
        theGraph.addEdge(1,2);    // BF      -> F
        theGraph.addEdge(2,3);    // FH          -> H
        theGraph.addEdge(0,4);    // AC             -> C
        theGraph.addEdge(0,5);    // AD                 -> D
        theGraph.addEdge(5,6);    // DG                     -> G
        theGraph.addEdge(6,7);    // GI                         -> I
        theGraph.addEdge(0,8);    // AE                             -> E



        // print:
        System.out.println("Visits: ");
        theGraph.dfs();                     // depth-first search
        System.out.println();

    } // ends main()
} // ends DFSApp

///////////////////////////////////////////////////////////////////////////////



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