package assignment3;

import java.util.ArrayList;
import java.util.List;

public class Node {
	String word;
	List<Node> nodes = new ArrayList<Node>();
	boolean isVisited;
	
	public Node(String str){
		this.word = str;
		this.isVisited = false;
	}

	// Returns a string of all the list of words related to this word.
	public String nodesToString(){
		String str = "";
		for(int i = 0; i < this.nodes.size(); i++){
			if (str.equals("")){
				str += this.nodes.get(i).word;
			}
			else{
				str += ", " + this.nodes.get(i).word;
			}
			
		}
		
		return str;
	}
}