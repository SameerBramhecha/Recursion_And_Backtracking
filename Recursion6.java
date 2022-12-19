/*
 * Remove Duplicates from a String
 * 
 * */
public class Recursion6 {
	public static boolean map[] = new boolean[26];
	public static void removeDuplicates(String str,int idx,String newString) {
		if(idx==str.length()) {
			System.out.println(newString);
			return;
		}
		
		char currch = str.charAt(idx);
		int pos = currch - 'a';
		if(map[pos] == true) {
			removeDuplicates(str,idx+1,newString);
		}
		else {
			newString += currch;
			map[pos] = true;
			removeDuplicates(str,idx+1,newString);
		}
	}
	public static void main(String[] args) {
		String str ="abbccda";
		removeDuplicates(str,0,"");
	}
}
