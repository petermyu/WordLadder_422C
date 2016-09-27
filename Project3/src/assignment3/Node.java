package assignment3;

public class Node {
	String word;
    int numSteps;
    boolean isVisited;
 
    public Node(String word, int numSteps){
        this.word = word;
        this.numSteps = numSteps;
        this.isVisited = false;
    }
}