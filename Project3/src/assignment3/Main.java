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
	public static List<Node> NodeList = new ArrayList<Node>();
	
	
	public static void main(String[] args) throws Exception {
		/*
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
		}*/
		initialize();
		
		// TODO methods to read in words, output ladder
	}
	
	public static void initialize() {
		// initialize your static variables or constants here.
		// We will call this method before running our JUNIT tests.  So call it 
		// only once at the start of main.
		
		Scanner keyboard = new Scanner(System.in);
		
		Set<String> dict = makeDictionary();
		
		String[] words = new String[dict.size()];
		words = dict.toArray(words);
		
		for(int i = 0; i < words.length; i++){
			NodeList.add(new Node(words[i]));
			for (int j = 0; j < i; j++){
				// If current word is related to...
				if (isRelated(words[i], words[j])){
					NodeList.get(i).nodes.add(NodeList.get(j));
					NodeList.get(j).nodes.add(NodeList.get(i));					
				}
			}
		}
		

	}
	
	/**
	 * @param keyboard Scanner connected to System.in
	 * @return ArrayList of 2 Strings containing start word and end word. 
	 * If command is /quit, return empty ArrayList. 
	 */

	public static ArrayList<String> parse(Scanner keyboard) {
		// TO DO
		ArrayList<String> inputWords = new ArrayList<String>();
		System.out.println("Enter words: ");
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

		
		return null; // replace this line later with real return
	}
	
    public static ArrayList<String> getWordLadderBFS(String start, String end) {
		
		// TODO some code

		
		return null; // replace this line later with real return
	}
    
	public static Set<String>  makeDictionary () {
		Set<String> words = new HashSet<String>();
		Scanner infile = null;
		try {
			infile = new Scanner (new File("five_letter_words.txt"));
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
	
	/**
	 * TESTING ONLY. Prints out all the other words that are related under each word.
	 */
	private static void printAllRelated(){
		for(int i = 0; i < NodeList.size(); i++){
			if (NodeList.get(i).nodes.size() > 0){
				System.out.println(NodeList.get(i).word + ": " + NodeList.get(i).nodesToString());
			}
		}
	}
}
