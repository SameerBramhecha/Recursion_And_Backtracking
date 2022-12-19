/*
 * Check if array is sorted(Strictly Increasing)
 * TC--> O(N)
 */
public class Recursion4 {
	public static boolean isSorted(int []arr,int idx)
	{
		if(idx == arr.length - 1) {
			return true;
		}
		if(arr[idx] < arr[idx+1]) {
			//array sorted till now
			return isSorted(arr,idx+1);
		}
		else {
			return false;
		}
	}
	public static void main(String[] args) {
		int arr[]=  {1,2,3,4,5};
		System.out.println(isSorted(arr,0));
	}
}
