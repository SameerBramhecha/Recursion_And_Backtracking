/*
 * Find 1st and last occurence of a character in a String
 * Ex -> "abaacdaefaah" 
 * 'a' -> first -> 0, last-> 10
 * 
 * */
public class Recursion3 {
	public static int first = -1;
	public static int last = -1;
	public static void findOccurence(String str,int idx, char ch) {
		if(idx == str.length()) {
			System.out.println("First :" + first);
			System.out.println("Last : " + last);
			return;
		}
		char currchar = str.charAt(idx);
		if(currchar == ch) {
			if(first == -1) {
				first = idx;
			}
			else {
				last = idx;
			}
		}
		findOccurence(str,idx+1,ch);
	}
	public static void main(String[] args) {
		String str = "abaacdaefaah";
		char ch = 'a';
		findOccurence(str,0,ch);
	}
}
