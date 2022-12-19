/*
 * Find All Subsequence of A string
 * Time Complexity -> O(2^N)
 * */
import java.util.*;  
public class Recursion7 {
	 
	public static void subsequences(String str, int idx, String newString) {
		if(idx==str.length()) {
			System.out.println(newString);
			return;
		}
		
		char currChar = str.charAt(idx);
		
		//to be
		subsequences(str,idx+1,newString+currChar);
		//not to be
		subsequences(str,idx+1,newString);
	}
	public static void uniqueSubsequences(String str, int idx, String newString,HashSet<String> set) {
		if(idx==str.length()) {
			if(set.contains(newString)) {
				return;
			}
			else {
				set.add(newString);
				System.out.println(newString);
				return;
			}
		}
		
		char currChar = str.charAt(idx);
		
		//to be
		uniqueSubsequences(str,idx+1,newString+currChar,set);
		//not to be
		uniqueSubsequences(str,idx+1,newString,set);
	}
	public static void main(String[] args) {
		String str = "abcd";
		subsequences(str,0,"");
		str = "aaa";
		HashSet<String>  set = new HashSet<>();
		uniqueSubsequences(str, 0, "", set);
		
	}
}
