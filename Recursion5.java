/*
 * Move all 'x' to end of the String
 * 
 * TC --> O(N)
 * */
public class Recursion5 {
	public static void move(String str,int idx,int count,String newString) {
		
		if(idx==str.length()) {
			for(int i=0;i<count;i++) {
				newString += "x";
			}
			System.out.println(newString);
			return;
		}
		if(str.charAt(idx)!='x') {
			newString += str.charAt(idx);
			move(str,idx+1,count,newString);
		}
		else {
			count++ ;
			move(str,idx+1,count,newString);
		}
		
	}
	public static void main(String[] args) {
		String str = "axbxxcxxd";
		move(str,0,0,"");
	}
}
