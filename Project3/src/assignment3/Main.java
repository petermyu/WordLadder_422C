/* WORD LADDER Main.java
 * EE422C Project 3 submission by
 * Replace <...> with your actual data.
 * <Student1 Name>
 * <Student1 EID>
 * <Student1 5-digit Unique No.>
 * <Student2 Name>
 * <Student2 EID>
 * <Student2 5-digit Unique No.>
 * Slip days used: <0>
 * Git URL:
 * Fall 2016
 */


package assignment3;
import java.util.*;
import java.io.*;

public class Main {
	public Scanner keyboardInput = new Scanner(System.in);
	// static variables and constants only here.
	
	
	public static void main(String[] args) throws Exception {
		
		Scanner kb;	// input Scanner for commands
		PrintStream ps;	// output file
		// If arguments are specified, read/write from/to files instead of Std IO.
		if (args.length != 0) {
			kb = new Scanner(new File(args[0]));
			ps = new PrintStream(new File(args[1]));
			System.setOut(ps);			// redirect output to ps
		} else {
			kb = new Scanner(System.in);// default from Stdin
			ps = System.out;			// default to Stdout
		}
		initialize();
		
		// TODO methods to read in words, output ladder
		ArrayList<String> p = parse(kb);
		printLadder(getWordLadderBFS(p.get(0), p.get(1)));
	}
	
	public static void initialize() {
		// initialize your static variables or constants here.
		// We will call this method before running our JUNIT tests.  So call it 
		// only once at the start of main.
		
		Scanner keyboard = new Scanner(System.in);
	}
	
	/**
	 * @param keyboard Scanner connected to System.in
	 * @return ArrayList of 2 Strings containing start word and end word. 
	 * If command is /quit, return empty ArrayList. 
	 */
	public static ArrayList<String> parse(Scanner keyboard) {
		// TO DO
		ArrayList<String> inputWords = new ArrayList<String>();
		// System.out.println("Enter words: ");
		String input = keyboard.nextLine();
		
		if(input.equals("/quit")){
			return null;
		}
		else{
			char[] words = new char[input.length()];
			char[] word1 = new char[input.length()/2];
			char[] word2 = new char[input.length()/2];
			int i = 0;
			int k = 0;
			input.getChars(0, input.length(), words, 0);
			while(words[i] != ' '){
				word1[i] = words[i];
				i++;
			}
			while(words[i] == ' '){i++;}
			while(i<words.length){
				word2[k] = words[i];
				i++;
				k++;
			}
			String string1 = new String(word1);
			String string2 = new String(word2);
			inputWords.add(string1);
			inputWords.add(string2);
			return inputWords;
		}
	}

	
	public static ArrayList<String> getWordLadderDFS(String start, String end) {
		
		// Returned list should be ordered start to end.  Include start and end.
		// Return empty list if no ladder.
		// TODO some code
		Set<String> dict = makeDictionary();
		
		
		return null; // replace this line later with real return
	}
	
    public static ArrayList<String> getWordLadderBFS(String start, String end) {
    	Set<String> dict = makeDictionary();
		
    	LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(new Node(start, 1));
        dict.remove(start);
        dict.add(end);
 
        if (isRelated(start, end)){
        	ArrayList<String> n = new ArrayList<String>();
        	n.add(start);
        	n.add(end);
        	return n;
        }
        
        ArrayList<String> s = new ArrayList<String>();
        
        while(!queue.isEmpty()){
            Node top = queue.remove();
            String word = top.word;
            s.add(word);
            
            System.out.println("Removed: " + word);
            
            if(word.equals(end)){
                System.out.println(top.numSteps);
                
                ArrayList<String> ret = new ArrayList<String>();
                ret.add(end);
                
                while(!ret.get(ret.size() - 1).equals(start)){
                	int i = 0;
                    while(!isRelated(s.get(i), ret.get(ret.size() - 1))){
                    	i++;
                    }
                    ret.add(s.get(i));
                }
                
                Collections.reverse(ret);
                
                return ret;
            }
 
            char[] arr = word.toCharArray();
            for(int i=0; i<arr.length; i++){
                for(char c='A'; c<='Z'; c++){
                    char temp = arr[i];
                    if(arr[i]!=c){
                        arr[i]=c;
                    }
 
                    String newWord = new String(arr);
                    
                    if(dict.contains(newWord)){
                        queue.add(new Node(newWord, top.numSteps+1));
                        // System.out.println("New word: " + newWord);
                        dict.remove(newWord);
                    }
 
                    arr[i]=temp;
                }
            }
        }
        
    	ArrayList<String> r = new ArrayList<String>();
    	r.add("");
    	r.add(start);
    	r.add(end);
    	
		return r; 
	}
    
	public static Set<String>  makeDictionary () {
		Set<String> words = new HashSet<String>();
		Scanner infile = null;
		try {
			infile = new Scanner (new File("short_dict2.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Dictionary File not Found!");
			e.printStackTrace();
			System.exit(1);
		}
		while (infile.hasNext()) {
			words.add(infile.next().toUpperCase());
		}
		return words;
	}
	
	public static void printLadder(ArrayList<String> ladder) {
		if (!ladder.get(0).equals("")){
			
			System.out.println("a " + (ladder.size() - 2) +  "-rung word ladder exists between " + ladder.get(0) + " and " + ladder.get(ladder.size() - 1) + ".");
			
			for(int i = 0; i < ladder.size(); i++){
				System.out.println(ladder.get(i));
			}
		}
		else{
			System.out.println("no word ladder can be found between " + ladder.get(1) + " and " + ladder.get(2) + ".");
		}
	}
	// TODO
	// Other private static methods here
	/**
	 * Checks if two string are related by one letter
	 * @param str1 is the first string
	 * @param str2 is the second string
	 * @return true if they are related, false if they are not
	 */
	private static boolean isRelated(String str1, String str2){
		
		int count = 0;
		
		for(int i = 0; i < str1.length(); i ++){
			if (str1.charAt(i) == str2.charAt(i)){
				count++;
			}
		}
		
		if (count == str1.length() - 1){
			return true;
		}
		
		return false;
	}
}
