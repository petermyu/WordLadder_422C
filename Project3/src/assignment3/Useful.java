package assignment3;

public class Useful {
	
	public static boolean isRelated(String str1, String str2){
		
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
