package assignment3;

import java.util.ArrayList;
import java.util.List;

public class Node {
	String word;
	List<Node> nodes = new ArrayList<Node>();

	public Node(String str){
		this.word = str;
	}

	public String toString(){
		String str = "";
		for(int i = 0; i < this.nodes.size(); i++){
			str += ", " + this.nodes.get(i).word;
		}
		
		return str;
	}
}